package com.zn.domain.designpattern.strategy;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/26
 */
public class Squeak implements QuackBehavior {


    @Override
    public void quack() {
        System.out.println("Squeak~（鸭子的一种叫声）");
    }
}
