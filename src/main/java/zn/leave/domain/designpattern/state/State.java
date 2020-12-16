package zn.leave.domain.designpattern.state;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/03/08
 */
public interface State {


    /**
     * 投币
     */
    void insertCoin(int coinNum);

    /**
     * 退币
     */
    void ejectCoin();


    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();

}
