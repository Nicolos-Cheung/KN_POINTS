package com.zn.domain.designpattern.obersver.jdk;

import java.util.Observable;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/27
 */
public class WeatherData extends Observable {

    private float temperature;

    private float humidity;

    private float pressure;


    public WeatherData(){

    }

    public void measurementsChanged(){

        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature =temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
