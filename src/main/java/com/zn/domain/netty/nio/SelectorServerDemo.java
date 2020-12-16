package com.zn.domain.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/04
 */
public class SelectorServerDemo {


    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7030));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            //获取事件
            if (selector.select(1000) == 0) {
                continue;
            }
            //获取有事件发生的selection集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //使用迭代器，为了list元素删除
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                //反向获取通道
                SelectableChannel channel = selectionKey.channel();

                if (selectionKey.isAcceptable()) {
                    //有新的连接事件，给该客户端生成socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //IllegalBlockingModeException
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector,可以为通道绑定buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                if (selectionKey.isReadable()) {
                    //发生读事件
                    //通过selectkey反向获取channel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();

                    //把channel数据读入buffer
                    socketChannel.read(buffer);

                    System.out.println("from客户端");

                }

                //移除selectorKey，防止重复操作。
                iterator.remove();
            }


        }


    }
}
