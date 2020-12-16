package zn.leave.domain.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 客户端
 *
 * @author ning
 * @date 2020/12/04
 */
public class SelectorClientDemo {

    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open();

        channel.configureBlocking(false);

        //非阻塞
        channel.connect(new InetSocketAddress("127.0.0.1", 7030));

        String str = "send content";

        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

        while (!channel.finishConnect()) {
            System.out.println("尝试连接");
        }

        if (channel.finishConnect()) {

            channel.write(buffer);
        }

    }
}
