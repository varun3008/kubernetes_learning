package com.live4others.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live4others.dto.Weather;

@Service
public class WeatherService {

	@Autowired
	WeatherUtil weatherUtil;

	public Weather getWeather(String cityName) {
		return weatherUtil.getWeather(cityName);
	}
}
