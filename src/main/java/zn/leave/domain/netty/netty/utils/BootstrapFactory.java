package zn.leave.domain.netty.netty.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class BootstrapFactory {


    public static void buildServerAndStartup(Integer port, ChannelInboundHandlerAdapter... handlerAdapter) {

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
                    .handler(new LoggingHandler(LogLevel.INFO))

                    //对应WorkerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //向与WorkerGroup关联的PipleLine中增加Handler（给Pipeline设置处理器 ）
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline().addLast(handlerAdapter);
                        }
                    });

            //绑定端口并启动,,channelFuture->netty异步模型
            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public static void buildClientAndConnect(int port, ChannelInboundHandlerAdapter... handlerAdapter) {

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

                            if (handlerAdapter != null ) {
                                sc.pipeline().addLast(handlerAdapter);
                            }

                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", port).sync();

            //Future - Listener机制
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("服务器连接成功");
                } else {
                    System.out.println("服务器连接失败");
                }
            });

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
