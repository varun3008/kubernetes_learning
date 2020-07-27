package com.live4others.app.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.live4others.dto.Weather;

@Component
public class WeatherUtil {

	@Value("${weather.api.url}")
	public String weatherApiUrl;

	public static final String WEATHER_API_KEY = "&appid=f8353ae92c5ac4ee6d5b04095a868cb7&units=metric";

	public Weather getWeather(String cityName) {
		String data = this.getCall(weatherApiUrl + cityName + WEATHER_API_KEY);
		JSONObject main = data == null ? new JSONObject()
				: (JSONObject) ((JSONObject) JSONValue.parse(data)).get("main");
		return new Weather(cityName, main.get("temp") + "", main.get("temp_max") + "",
				main.get("temp_min") + "", main.get("humidity") + "", main.get("pressure") + "");
	}

	public String getCall(String url) {
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				return response.toString();
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}