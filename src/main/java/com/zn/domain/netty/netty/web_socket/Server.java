package com.zn.domain.netty.netty.web_socket;

import com.zn.domain.netty.netty.utils.BootstrapFactory;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * websocket 全双工长连接
 *
 * @author ning
 * @date 2020/12/17
 */
public class Server {

    public static void main(String[] args) {

        BootstrapFactory.buildServerAndStartup(7000,

                new HttpServerCodec(),

                //http以块的方式写
                new ChunkedWriteHandler(),

                //http传输分段，该handler用于将多个端聚合
                new HttpObjectAggregator(8192),

                //webSocket数据以帧frame的形式传递 （WebSocketFrame 及子类）,  WebSocketServerProtocolHandler核心功能将http协议升级为websocket协议(保持长连接)
                new WebSocketServerProtocolHandler("/hello"),

                //自定义handler处理业务逻辑
                new WebSocketFrameHandler()

        );

    }
}
