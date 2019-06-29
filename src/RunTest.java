import observer.impl.CurrentConditionsDisplay;

import observer.impl.ForecasDisplay;
import observer.impl.StaticticsDispaly;
import subject.impl.WeatherData;

public class RunTest {

    public static void main(String[] argv){

        /*
        * 首先构造一个WeatherData对象
        * */
        WeatherData weatherData = new WeatherData();

        /*
        * 建立三个布告板并把WeatherData对象传给它们
        * */
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StaticticsDispaly staticticsDispaly = new StaticticsDispaly(weatherData);
        ForecasDisplay forecasDisplay = new ForecasDisplay(weatherData);

        weatherData.setMeasurements(10,11.11f,12.12f);
        weatherData.removeObserver(currentDisplay);
        weatherData.setMeasurements(20,22.22f,222.222f);
        weatherData.removeObserver(staticticsDispaly);
        weatherData.setMeasurements(30,33.33f,333.333f);


    }

}
