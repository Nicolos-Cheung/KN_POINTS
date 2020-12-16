package zn.leave.domain.netty.netty.im_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class GroupChatServer {

    private int port;


    public GroupChatServer(int port) {
        this.port = port;
    }

    //处理客户端请求
    public void run(){

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {

            //设置线程组
            bootstrap.group(bossGroup, workerGroup)

                    //定义使用NioSocketChannel
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)

                    //对应WorkerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //向与WorkerGroup关联的PipleLine中增加Handler（给Pipeline设置处理器 ）
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            //加入解码器
                            sc.pipeline().addLast("decoder", new StringDecoder());
                            //加入编码器
                            sc.pipeline().addLast("encoder", new StringEncoder());

                            //加入业务处理 自定义handler
                            sc.pipeline().addLast(new GroupChatServerHandler());
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


    public static void main(String[] args) {
        new GroupChatServer(7000).run();
    }
}
