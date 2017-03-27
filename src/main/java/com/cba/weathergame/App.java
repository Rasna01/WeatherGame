package com.cba.weathergame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cba.weathergame.bootstrap.WeatherGame;

/**
 * @author Rasna Joseph
 * 
 *         Weather Game App
 * 
 */
public class App {

	public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOGGER.info("Start Weather Game");
		App appTest = new App();
		appTest.getWeatherData();
		LOGGER.info("Ends Weather Game");
	}

	void getWeatherData() {
		String[] args = { "2000" };
		WeatherGame.main(args);
	}

}
