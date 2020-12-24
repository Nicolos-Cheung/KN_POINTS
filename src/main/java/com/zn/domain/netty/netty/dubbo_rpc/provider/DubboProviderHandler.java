package com.zn.domain.netty.netty.dubbo_rpc.provider;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.util.Arrays;

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

        //com.zn.domain.netty.netty.dubbo_rpc.service.TestService#upperString#upperString rpc call ....
        try {
            if (msg.toString().contains("#")) {

                String[] split = msg.toString().split("#");

                if (split.length >= 2) {
                    Class clz = Class.forName(split[0]);

                    //TODO: 获取实现类抽象化
                    TestServiceImpl impl = new TestServiceImpl();

                    for (Method declaredMethod : clz.getDeclaredMethods()) {

                        if (declaredMethod.getName().equals(split[1])) {
                            Object invoke;
                            if (split.length > 2) {

                                String[] params = Arrays.copyOfRange(split, 2, split.length);

                                invoke = declaredMethod.invoke(impl, params);
                            } else {
                                invoke = declaredMethod.invoke(impl, null);
                            }

                            ctx.writeAndFlush(invoke);
                            return;
                        }
                    }
                }
                ctx.writeAndFlush("未找到需要调用的方法");
            }

        } catch (Exception e) {
            ctx.writeAndFlush("方法调用异常..." + e.getMessage());
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
