package com.zn.domain.netty.netty.handler_chain;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 若数据类型不为Long会被自动跳过
 *
 * @author ning
 * @date 2020/12/17
 */
public class CusByteToLongDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        //需要判断是否为8个字节才能读成一个Long
        if (in.readableBytes() > 8) {
            out.add(in.readLong());
        }
    }
}
