package com.zn.domain.netty.netty.task_queue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * TaskQueue自定义任务
 *
 * @author ning
 * @date 2020/12/07
 */
public class NettyClientHandler1 extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


        //将任务提交到与channel关联的eventLoop中的taskQueue里。
        //理解: eventLoop 是线程，taskQueue是它的任务队列。
        ctx.channel().eventLoop().execute(() -> {
            //task1
        });

        ctx.channel().eventLoop().execute(() -> {
            //task2 ，因为是任务队列，因此task2要等task1执行结束在执行。
        });

        //将msg转ByteBuf,
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("收到服务器消息: " + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器地址: " + ctx.channel().remoteAddress());

    }


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
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        //获取异常，关闭channel
        ctx.channel().close();
    }

}
