package zn.leave.domain.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 零拷贝案例
 *
 * @author ning
 * @date 2020/12/05
 */
public class ZeroCopyDemo {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 2222));

        FileChannel channel = new FileInputStream("").getChannel();

        /**
         * This method is potentially much more efficient than a simple loop
         *      * that reads from this channel and writes to the target channel.  Many
         *      * operating systems can transfer bytes directly from the filesystem cache
         *      * to the target channel without actually copying them.
         */
        channel.transferTo(0, channel.size(), socketChannel);


    }
}
