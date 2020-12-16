package com.zn.domain.netty.netty.heart_beat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class IdleHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventType;

            switch (event.state()) {

                case READER_IDLE:
                    eventType = "读空闲";
                    break;

                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;

                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;

                default:
                    eventType = "未知空闲";
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + eventType + "...心跳检测...");

//                做相应处理: 如直接关闭通道
//            ctx.channel().close();
        }

    }
}
