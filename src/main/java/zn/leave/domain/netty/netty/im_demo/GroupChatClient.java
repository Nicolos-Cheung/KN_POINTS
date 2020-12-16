package zn.leave.domain.netty.netty.im_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/07
 */
public class GroupChatClient {


    private String hostAddr;

    private int port;


    public GroupChatClient(String hostAddr, int port) {
        this.hostAddr = hostAddr;
        this.port = port;
    }

    public void run() {

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

                            //加入解码器
                            sc.pipeline().addLast("decoder", new StringDecoder());
                            //加入编码器
                            sc.pipeline().addLast("encoder", new StringEncoder());

                            sc.pipeline().addLast(new GroupChatClientHandler());
                        }
                    });


            ChannelFuture channelFuture = bootstrap.connect(hostAddr, port).sync();


            //Future - Listener机制
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("服务器连接成功");
                } else {
                    System.out.println("服务器连接失败");
                }
            });


            Channel channel = channelFuture.channel();

            Scanner sc = new Scanner(System.in);

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                channel.writeAndFlush(s);
            }

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {


        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new GroupChatClient("127.0.0.1",7000).run();
    }
}
