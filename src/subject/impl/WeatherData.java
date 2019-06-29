package subject.impl;

import observer.Observer;
import subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherData 实现了Subject接口
 * */
public class WeatherData implements Subject {

    /*
    * ArrayList 来记录观察者，此ArrayList是在构造器中建立的
    * */
    private List<Observer> observerList;

    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observerList = new ArrayList<>();
    }

    /*
    * 注册观察者
    * */
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    /*
    * 移除观察者
    * */
    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    /*
    * 有趣的地方来了～
    * 在这里把状态告诉每个观察者，因为观察者都实现了update()，所以知道如何通知它们
    * */
    @Override
    public void notifyObservers() {
        for (Observer observer : observerList){
            observer.update(this.temp,this.humidity,this.pressure);
        }
    }

    /*
    * 当气象站得到更新观测值时，我们通知观察者
    * */
    public void measurementsChanged(){
        this.notifyObservers();
    }

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.measurementsChanged();
    }

}
