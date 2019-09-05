package com.company.weather.weather;

import java.util.List;

public interface WeatherDataService {

    void save(String weatherText);

    List<String> getAll();
}