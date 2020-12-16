package com.zn.domain.netty.netty.basic_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/07
 */
public class NettyServer {

    public static void main(String[] args) {

        //NioEventLoopGroup中默认的NioEventLoop个数：cpu核数*2
        //处理连接请求
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //处理客户端业务请求
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //创建服务器启动对象,配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        try {

            //设置线程组
            bootstrap.group(bossGroup, workerGroup)

                    //定义使用NioSocketChannel
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)

                    //对应BossGroup,没有可以不写
                    .handler(null)

                    //对应WorkerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //向与WorkerGroup关联的PipleLine中增加Handler（给Pipeline设置处理器 ）
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            //绑定端口并启动,,channelFuture->netty异步模型
            ChannelFuture channelFuture = bootstrap.bind(7030).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
