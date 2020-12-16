package zn.leave.domain.designpattern.state;

/**
 * 售罄状态
 *
 * @author ning
 * @date 2020/03/08
 */
public class SoldOutState implements State {

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
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
        System.out.println("The machine is sold out,please eject Coins");
    }

    @Override
    public void dispense() {
        System.out.println("");
    }
}
