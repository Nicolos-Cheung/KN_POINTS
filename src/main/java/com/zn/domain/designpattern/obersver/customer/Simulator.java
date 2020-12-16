package com.zn.domain.designpattern.obersver.customer;

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

        //气象站更新气象数据
        weatherData.setMeasurements(22.1f, 22.2f, 22.3f);

    }
}
