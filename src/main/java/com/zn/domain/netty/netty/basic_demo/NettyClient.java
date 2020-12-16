package com.zn.domain.netty.netty.basic_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/07
 */
public class NettyClient {


    public static void main(String[] args) throws InterruptedException {

        //仅需一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();


        //创建服务器启动对象,配置参数
        Bootstrap bootstrap = new Bootstrap();

        try {
            //设置线程组
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        //向与WorkerGroup关联的PipleLine中增加Handler（给Pipeline设置处理器 ）
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline().addLast(new NettyClientHandler());
                        }
                    });


            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7030).sync();


            //Future - Listener机制
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("服务器连接成功");
                }else{
                    System.out.println("服务器连接失败");
                }
            });


            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
