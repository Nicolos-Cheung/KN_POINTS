package com.zn.domain.netty.netty.handler_chain;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 若数据类型不为Long会被自动跳过
 *
 * @author ning
 * @date 2020/12/17
 */
public class CusLongToByteEncoder extends MessageToByteEncoder<Long> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {

        out.writeLong(msg);
    }
}
