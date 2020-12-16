package com.zn.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am flying with a rocket~");
    }
}
