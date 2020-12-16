package zn.leave.domain.netty.netty.heart_beat;

import zn.leave.domain.netty.netty.utils.BootstrapFactory;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {

        /**
         * IdleStateHandler 空闲状态处理器
         *
         * 3s未读 发送心跳检测包检测是否连接
         * 5s未写 发送心跳检测包检测是否连接
         * 7s未读写 发送心跳检测包检测是否连接
         *
         * 防止异常断连 server无法感知。客户端和服务端通过心跳检测，准确感知连接状态
         *
         * 当IdleStateEvent触发后，会传递给下一个handler去处理，通过调用userEventTrigger
         */
        BootstrapFactory.buildServerAndStartup(7000,
                new IdleStateHandler(3, 5, 7, TimeUnit.SECONDS),
                new IdleHandler()
        );


    }
}
