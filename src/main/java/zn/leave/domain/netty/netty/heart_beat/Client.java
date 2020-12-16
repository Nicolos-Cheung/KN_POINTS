package zn.leave.domain.netty.netty.heart_beat;

import zn.leave.domain.netty.netty.utils.BootstrapFactory;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/12/16
 */
public class Client {

    public static void main(String[] args) {
        BootstrapFactory.buildClientAndConnect(7000,null);
    }
}
