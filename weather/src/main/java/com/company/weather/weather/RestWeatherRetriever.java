package com.company.weather.weather;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service
public class RestWeatherRetriever implements WeatherRetriever {

    private static final String host = "community-open-weather-map.p.rapidapi.com";
    private static final String apiKey = "b76c131aa4msh861b05768650d7ap163401jsn9ce105d42c36";
    private static final String url = "https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q=";
    private final Logger logger = LoggerFactory.getLogger(RestWeatherRetriever.class);

    private final RestTemplate restTemplate;

    public RestWeatherRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Непосредственно получаем погоду
    @Override
    public WeatherModel getWeather(String param){
        logger.debug(String.format("Погода в %s",param));

        //Добавляем заголовки
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("x-rapidapi-host", host);
        headers.add("x-rapidapi-key", apiKey);

        WeatherJson response;

        //Отправляем запрос
        response = restTemplate.exchange(URI.create(url + param), HttpMethod.GET, new HttpEntity<>(headers), WeatherJson.class).getBody();

        //System.out.println(response.getName() + response.getMain().getTemp());
        return new WeatherModel(response.getName(), response.getMain().getTemp());
    }
}