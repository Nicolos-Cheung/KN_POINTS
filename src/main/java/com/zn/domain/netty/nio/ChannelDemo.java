package com.zn.domain.netty.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/03
 */
public class ChannelDemo {

    public static void main(String[] args) throws IOException {


        String str = "输出一段文本到文件中";
        FileOutputStream out = new FileOutputStream("/Users/ning/xx.txt");

        FileChannel channel = out.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(1024);

        allocate.put(str.getBytes());

        allocate.flip();

        channel.write(allocate);

        out.close();


    }
}
