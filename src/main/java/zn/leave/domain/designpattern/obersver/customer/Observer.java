package zn.leave.domain.designpattern.obersver.customer;

/**
 * 观察者
 *
 * @author ning
 * @date 2020/01/26
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
