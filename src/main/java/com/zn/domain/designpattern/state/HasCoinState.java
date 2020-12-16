package com.zn.domain.designpattern.state;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/08
 */
public class HasCoinState implements State {

    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin(int coinNum) {
        gumballMachine.coinNum += coinNum;
        System.out.println(coinNum+" coins inserted");
    }

    @Override
    public void ejectCoin() {
        System.out.println( gumballMachine.coinNum+" Coins Returned");
        gumballMachine.coinNum = 0;
    }

    @Override
    public void turnCrank() {
        System.out.println("You returned... Please wait");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
