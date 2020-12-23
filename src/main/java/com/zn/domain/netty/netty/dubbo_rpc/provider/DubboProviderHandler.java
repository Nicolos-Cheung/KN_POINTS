package com.zn.domain.netty.netty.dubbo_rpc.provider;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class DubboProviderHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //获取客户端发送的消息并调用服务。

        //客户端调用服务器api需要定义协议 如： 类全限定名#方法名#参数

        if (msg.toString().startsWith("TestService#upperString")) {

            TestServiceImpl service = new TestServiceImpl();

            String callResult = service.upperString(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));

            ctx.writeAndFlush(callResult);
        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        ctx.close();
    }
}
