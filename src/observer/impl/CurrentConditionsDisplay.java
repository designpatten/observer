package observer.impl;

import display.DisplayElement;
import observer.Observer;
import subject.Subject;

/**
 * 布告板实现了Observer接口，所以可以从WeatherData对象中获得改变
 * */
public class CurrentConditionsDisplay implements Observer , DisplayElement {


    private float temp;
    private float humidity;
    private float presure;

    /*
    * 构造器需要weatherData对象，作为注册之用
    * */
    public CurrentConditionsDisplay(Subject weatherData){
        weatherData.registerObserver(this);
    }

    /*
    * 当update()被调用时，把温度等保存起来，然后调用display展示
    * */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.presure = pressure;
        display();
    }


    @Override
    public void display() {
        System.out.println("*****CurrentConditionsDisplay start*****");
        System.out.println("temp"+temp);
        System.out.println("humidity"+humidity);
        System.out.println("presure"+presure);
        System.out.println("*****CurrentConditionsDisplay end*****");
    }
}

