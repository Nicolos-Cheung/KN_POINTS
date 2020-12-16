package zn.leave.domain.designpattern.obersver.customer;

/**
 * 布告板
 *
 * @author ning
 * @date 2020/01/27
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    public Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {

        System.out.println(String.format("Current conditions : \n" +
                "temperature；%f , humidity %f ", temperature, humidity));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temperature = temp;

        this.humidity = humidity;

        display();
    }
}
