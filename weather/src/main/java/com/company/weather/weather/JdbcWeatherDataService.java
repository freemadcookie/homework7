package com.company.weather.weather;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JdbcWeatherDataService implements WeatherDataService {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWeatherDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String weatherText) {
        //вставляем необходимые данные в таблицу
        jdbcTemplate.update("insert into weathers (weather) values (?)", weatherText);
    }

    @Override
    public List<String> getAll() {
        //получаем все записи из таблицы БД
        return jdbcTemplate.query("select weather from weathers",
                (rs, rowNum) -> rs.getString("weather"));
    }
}