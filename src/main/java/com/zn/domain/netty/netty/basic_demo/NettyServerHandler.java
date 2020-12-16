package com.zn.domain.netty.netty.basic_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义Handler
 *
 * @author ning
 * @date 2020/12/07
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * ChannelHandlerContext ,上下文，可以获取Pipeline ,通道，地址
     * Object 客户端发送的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //读取客户端发送的消息
        System.out.println("thread name：" + Thread.currentThread().getName());
        System.out.println("server ctx：" + ctx);

        //将msg转ByteBuf,
        ByteBuf byteBuf = (ByteBuf) msg;

        System.out.println("收到客户端消息: " + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址: " + ctx.channel().remoteAddress());

    }


    /**
     * 数据读取完毕
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //数据写入buffer并flush
        ctx.writeAndFlush(Unpooled.copiedBuffer("got it", CharsetUtil.UTF_8));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();
        //获取异常，关闭channel
        ctx.channel().close();
    }
}
