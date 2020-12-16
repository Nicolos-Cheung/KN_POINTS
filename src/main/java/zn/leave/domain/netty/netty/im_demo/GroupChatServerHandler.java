package zn.leave.domain.netty.netty.im_demo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 定义Channel组管理所有channel
     */
    private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    /**
     * 读取数据
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        Channel channel = ctx.channel();

        group.forEach(e -> {
            if (e != channel) {
                //信息转发到各个客户端
                e.writeAndFlush("【" + channel.remoteAddress() + "】:" + msg);
            } else {
                e.writeAndFlush("【自己】:" + msg);
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        //连接建立加入group
        group.add(channel);

        //将该用户加入聊天室信息推送到其他客户端
        group.writeAndFlush("客户端" + channel.remoteAddress() + "加入聊天室\n");

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        group.writeAndFlush("客户端" + ctx.channel().remoteAddress() + "离开聊天室\n");
        group.writeAndFlush("剩余人数" + group.size());

    }

    /**
     * 表示channel处于活动状态
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        group.writeAndFlush("客户端" + ctx.channel().remoteAddress() + "上线了\n");

    }


    /**
     * 表示channel处于非活动状态
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        group.writeAndFlush("客户端" + ctx.channel().remoteAddress() + "下线了\n");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
