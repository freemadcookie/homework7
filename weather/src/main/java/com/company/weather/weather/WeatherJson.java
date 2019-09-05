package com.company.weather.weather;

public class WeatherJson {
    String name;
    WeatherValue main;
    public String getName() {
        return this.name;
    }
    public WeatherValue getMain() {
        return this.main;
    }

    //поулчаем данные: город и температуру
    @Override public String toString() {
        return "AllData(name=" + this.getName() +"main=" + this.getMain() + ")";
    }
}


