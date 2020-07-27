package com.live4others.dto;

public class Weather {
	String cityName;
	String temp;
	String maxTemp;
	String minTemp;

	String humidity;
	String pressure;
	String seaLevel;

	public Weather() {

	}

	public Weather(String cityName, String temp, String maxTemp, String minTemp, String humidity, String pressure) {
		super();
		this.cityName = cityName;
		this.temp = temp;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	public String getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return "Weather [cityName=" + cityName + ", temp=" + temp + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp
				+ ", humidity=" + humidity + ", pressure=" + pressure + ", seaLevel=" + seaLevel + "]";
	}

}
