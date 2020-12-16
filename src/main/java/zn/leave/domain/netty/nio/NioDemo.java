package zn.leave.domain.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/04
 */
public class NioDemo {


    /**
     *  telnet 127.0.0.1 7030 启动和客户端
     */

    public static void main(String[] args) throws IOException {



        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7030);

        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];

        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等待客户端连接

        while(true) {
            //生成SocketChannel
            SocketChannel accept = serverSocketChannel.accept();

            //读取的字节数 -->支持对数组buffer的读写
            long read = accept.read(byteBuffers);

            Arrays.asList(byteBuffers).stream().map(buffer -> buffer.position() + "-" + buffer.limit()).forEach(System.out::println);
        }

    }
}
