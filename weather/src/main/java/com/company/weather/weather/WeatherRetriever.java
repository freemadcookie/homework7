package com.company.weather.weather;

public interface WeatherRetriever {
    WeatherModel getWeather(String city);
}