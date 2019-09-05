package com.company.weather.cli;

import com.company.weather.weather.WeatherDataService;
import com.company.weather.weather.WeatherRetriever;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Objects;
import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {
    private final WeatherRetriever weatherService;
    private final WeatherDataService weatherDataService;

    public ShellCommands(WeatherRetriever jokeService, WeatherDataService jokeDataService) {
        this.weatherService = jokeService;
        this.weatherDataService = jokeDataService;
    }

    private String actualWeather;

    // Запрос на текущую погоду
    @ShellMethod("Tokyo")
    public String weather(@ShellOption(defaultValue = "Tokyo") String city) {
        actualWeather = weatherService.getWeather(city).toString();
        if (actualWeather == null) {
            return String.format("Город %s не найден!", city);
        }
        return actualWeather;
    }

    //Сохраняем
    @ShellMethod("That's good, save it!")
    public String save() {
        if (Objects.nonNull(actualWeather)) {
            weatherDataService.save(actualWeather);
        }

        return "Сохранено";
    }

    // Показывае сохраненное
    @ShellMethod("Show all saved")
    public String show() {
        return weatherDataService.getAll().stream().collect(Collectors.joining("\n"));
    }
}
