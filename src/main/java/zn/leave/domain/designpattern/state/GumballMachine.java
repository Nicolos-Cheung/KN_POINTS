package zn.leave.domain.designpattern.state;

/**
 * 糖果机
 *
 * @author ning
 * @date 2020/03/08
 */
public class GumballMachine {


    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State state;
    int count;
    int coinNum = 0;
    int cost = 2;


    public GumballMachine(int numberGumballs) {
        this.count = numberGumballs;
        this.soldOutState = new SoldOutState(this);
        this.noCoinState = new NoCoinState(this);
        this.hasCoinState = new HasCoinState(this);
        this.soldState = new SoldState(this);

        if (count > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }


    public void insertCoin(int coinNum) {
        state.insertCoin(coinNum);
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }


    public void releaseGumball() {
        int i = coinNum / cost;
        int j = coinNum % cost;

        int soldNum = 0;
        int surplusCoin = 0;
        if (count > i) {
            count -= i;
            soldNum = i;
            surplusCoin = j;
        } else {
            soldNum = count;
            surplusCoin = coinNum - count * cost;
        }

        System.out.println("售出糖果数:" + soldNum);
        System.out.println("找零:" + surplusCoin);

    }

    public void setState(State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
}
