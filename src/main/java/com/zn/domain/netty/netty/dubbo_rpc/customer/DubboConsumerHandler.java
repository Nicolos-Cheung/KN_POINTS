package com.zn.domain.netty.netty.dubbo_rpc.customer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class DubboConsumerHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext ctx;

    /**
     * 调用返回结果
     */
    private String result;

    /**
     * 客户端调用api入参
     */
    private String param;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        this.ctx = ctx;
    }


    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        result = msg.toString();

        //唤醒等待线程
        notify();


    }


    @Override
    public synchronized Object call() throws Exception {

        //被代理对象调用，发送数据给服务器并等待被唤醒

        ctx.writeAndFlush(param);

        wait();

        return result;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }


    public  void setParam(String param){

        this.param = param;
    }
}
