package com.zn.domain.netty.netty.dubbo_rpc.customer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zn.domain.netty.netty.dubbo_rpc.service.TestService;
import com.zn.domain.netty.netty.utils.BootstrapFactory;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/23
 */
public class Client {


    private static ExecutorService executor = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

    private static DubboConsumerHandler client;


    public static void main(String[] args) {

        TestService service = (TestService) getBean(TestService.class, "TestService#upperString");
        String result = service.upperString("upperString rpc call ....");
        System.out.println();
    }


    public static Object getBean(final Class<?> serviceClass, final String providerName) {

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),

                new Class<?>[]{serviceClass},

                //代理对象，方法，参数
                (proxy, method, args) -> {

                    if (client == null) {
                        initHandler();
                    }
                    client.setParam(providerName + "#" + args[0]);

                    return executor.submit(client).get();
                });

    }

    private static void initHandler() {

        client = new DubboConsumerHandler();

        BootstrapFactory.buildClientAndConnect(7000, new StringDecoder(), new StringEncoder(), client);
    }
}
