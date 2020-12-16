package com.zn.domain.designpattern.state;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/09
 */
public class Simulator {

    public static void main(String[] args) {

        GumballMachine machine = new GumballMachine(10);

        machine.turnCrank();

        machine.ejectCoin();

        machine.insertCoin(100);

        machine.turnCrank();

    }
}
