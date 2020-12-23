package com.zn.domain.netty.netty.dubbo_rpc.provider;

import com.zn.domain.netty.netty.utils.BootstrapFactory;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class Server {

    public static void main(String[] args) {

        BootstrapFactory.buildServerAndStartup(7000, new StringDecoder(), new StringEncoder(), new DubboProviderHandler());

    }
}
