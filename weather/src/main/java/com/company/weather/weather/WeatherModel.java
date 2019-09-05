package com.company.weather.weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherModel {
    private String city;
    private String temp;

    public WeatherModel(String city, String temp){
        this.city = city;
        this.temp = temp;
    }

    // Выводим и сохраняем в базу в следующем виде
    @Override
    public String toString() {

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " "
                + city + " +"
                + temp;
    }
}
