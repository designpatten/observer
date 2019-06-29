package observer.impl;

import display.DisplayElement;
import observer.Observer;
import subject.Subject;
import subject.impl.WeatherData;

public class ForecasDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float temp;
    private float humidity;
    private float pressure;

    public ForecasDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("*****ForecasDisplay start*****");
        System.out.println("temp"+temp);
        System.out.println("humidity"+humidity);
        System.out.println("presure"+pressure);
        System.out.println("*****ForecasDisplay end*****");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
