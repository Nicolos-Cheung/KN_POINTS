package com.zn.domain.designpattern.obersver.jdk;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/01/27
 */
public class Simulator {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        conditionsDisplay.display();

        weatherData.setMeasurements(22.1f, 22.2f, 22.3f);
        weatherData.setMeasurements(12.1f, 12.2f, 12.3f);

    }
}
