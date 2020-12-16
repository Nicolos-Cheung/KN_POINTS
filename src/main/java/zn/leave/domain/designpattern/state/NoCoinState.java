package zn.leave.domain.designpattern.state;

/**
 * 未投币状态
 *
 * @author ning
 * @date 2020/03/08
 */
public class NoCoinState implements State {

    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin(int coinNum) {

        System.out.println("You insert " + coinNum + " Coin");
        gumballMachine.coinNum += coinNum;
        gumballMachine.setState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("You have not inserted any Coin");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no Coin");
    }

    @Override
    public void dispense() {
        System.out.println("You need to insert some quarter first");
    }
}
