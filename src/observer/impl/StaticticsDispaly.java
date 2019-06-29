package observer.impl;

import display.DisplayElement;
import observer.Observer;
import subject.impl.WeatherData;

public class StaticticsDispaly implements Observer, DisplayElement {


    private WeatherData weatherData;
    private float temp;
    private float humidity;
    private float presure;

    public StaticticsDispaly(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("*****StaticticsDispaly start*****");
        System.out.println("temp"+temp);
        System.out.println("humidity"+humidity);
        System.out.println("presure"+presure);
        System.out.println("*****StaticticsDispaly end*****");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.presure = pressure;
        display();
    }
}
