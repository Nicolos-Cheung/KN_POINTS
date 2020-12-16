package com.zn.domain.designpattern.obersver.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/27
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {


    Observable observable;

    private float temperature;

    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;

            this.temperature = weatherData.getTemperature();

            this.humidity = weatherData.getHumidity();

            display();
        }

    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions : \n" +
                "temperature；%f , humidity %f ", temperature, humidity));
    }
}
