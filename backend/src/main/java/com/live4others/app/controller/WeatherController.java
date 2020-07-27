package com.live4others.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.live4others.app.service.WeatherService;
import com.live4others.dto.Weather;

@CrossOrigin(origins = "*")
@RestController
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@GetMapping("/weather/{city_name}")
	public Weather sentimentAnalysis(@PathVariable("city_name") String cityName) {
		Weather weather = weatherService.getWeather(cityName);
		System.out.println("WeatherController called for city :: " + cityName + " is :: " + weather.getTemp());
		return weather;
	}

	@GetMapping("/ping")
	public String testHealth() {
		return "<h1>Application is running....<h1>";
	}
}
