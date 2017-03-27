package com.cba.weathergame.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cba.weathergame.files.SeedFileReader;
import com.cba.weathergame.simula.WeatherConstants;
import com.cba.weathergame.simula.WeatherSeed;
import com.cba.weathergame.simula.WeatherSimulator;

/**
 * @author Rasna Joseph
 * 
 *         Weather Game Main Class
 * 
 */
public class WeatherGame {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(WeatherGame.class);

	public static void main(String args[]) {

		int minOutRecords = Integer.parseInt(args[0].trim());
		LOGGER.info("Minimum Weather Data units requested:" + minOutRecords);

		SeedFileReader fRead = new SeedFileReader();
		WeatherSeed weatherSeed = new WeatherSeed(
				fRead.readSeedFile(WeatherConstants.INFILE));

		WeatherSimulator simulator = new WeatherSimulator(weatherSeed);
		simulator.generateSimulatedRecords(minOutRecords);
		LOGGER.info("Weather Game Completed Successfully");
	}
}
