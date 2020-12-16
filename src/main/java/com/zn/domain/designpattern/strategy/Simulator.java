package com.zn.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Simulator {

    public static void main(String[] args) {


        Duck duck = new RockDuck();

        duck.fly();
        duck.quack();
    }
}
