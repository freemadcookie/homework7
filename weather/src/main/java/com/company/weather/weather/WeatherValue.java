package com.company.weather.weather;

public class WeatherValue {
    String temp;

    public String getTemp() {
        return this.temp;
    }

    //получаем температуру
    @Override public String toString() {
        return "Temp(temp=" + this.getTemp() + ")";
    }
}
