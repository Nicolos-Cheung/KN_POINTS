package zn.leave.domain.netty.netty.task_queue;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 任务提交到 ScheduledTaskQueue
 *
 * @author ning
 * @date 2020/12/07
 */
public class NettyClientHandler2 extends ChannelInboundHandlerAdapter {

    /**
     * 通道就绪时触发
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush(Unpooled.copiedBuffer("连接就绪，hello server", CharsetUtil.UTF_8));
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        //将任务提交到与channel关联的eventLoop中的ScheduledTaskQueue里，而不是NettyClientHandler1 中的 taskQueue
        ctx.channel().eventLoop().schedule(() -> {
            //task1
        }, 5, TimeUnit.MINUTES);

        ctx.channel().eventLoop().schedule(() -> {
            //task2
        }, 2, TimeUnit.MINUTES);


    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        //获取异常，关闭channel
        ctx.channel().close();
    }

}
