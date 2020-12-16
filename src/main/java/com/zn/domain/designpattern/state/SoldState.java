package com.zn.domain.designpattern.state;

/**
 * 售出糖果状态
 *
 * @author ning
 * @date 2020/03/08
 */
public class SoldState implements State{

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin(int coinNum) {
        System.out.println("Please wait , we are already giving you a gumball");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry ,you already turned the Crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice can not get more gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseGumball();
        if (gumballMachine.count > 0) {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }

    }
}
