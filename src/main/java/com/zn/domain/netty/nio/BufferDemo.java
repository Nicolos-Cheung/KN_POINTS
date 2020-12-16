package com.zn.domain.netty.nio;

import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/03
 */
public class BufferDemo {


    public static void main(String[] args) throws Exception {

        IntBuffer allocate = IntBuffer.allocate(10);


        //切换读写
        allocate.flip();

        //只读buffer
        IntBuffer readOnlyBuffer = allocate.asReadOnlyBuffer();


        RandomAccessFile accessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = accessFile.getChannel();

        // param1 读写模式，param2:可以直接修改的起始位置，param3映射到内存的大小->最大将1.txt的5个字节映射到内存，可以直接修改的范围[0-5）
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        //修改第0个位置
        map.put(0,(byte)'H');


    }
}
