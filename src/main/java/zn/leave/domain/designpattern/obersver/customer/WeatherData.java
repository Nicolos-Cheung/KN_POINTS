package zn.leave.domain.designpattern.obersver.customer;

import java.util.ArrayList;

/**
 * 气象站
 *
 * @author ning
 * @date 2020/01/27
 */
public class WeatherData implements Subject {

    private ArrayList<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;


    public WeatherData() {
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        observers.stream().forEach(e -> {

            e.update(temperature, humidity, pressure);
        });

    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
