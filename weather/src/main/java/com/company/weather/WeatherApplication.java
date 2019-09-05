package com.company.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class WeatherApplication {

	private final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);
	public WeatherApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@PostConstruct
	@Transactional
	public void onPostConstruct() {
		logger.debug("Update DB Scheme");
		//создаем БД если не создана
		jdbcTemplate.update("CREATE TABLE IF NOT EXISTS weathers (weather text);");
		logger.debug("Updated successfully");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
