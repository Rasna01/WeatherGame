package com.cba.weathergame.simula;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cba.weathergame.bootstrap.WeatherGame;
import com.cba.weathergame.files.WeatherDataWriter;

/**
 * @author Rasna Joseph
 * 
 * 
 *         Class to Simulate Weather Data
 * 
 */
public class WeatherSimulator {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(WeatherGame.class);

	private WeatherSeed weatherSeed;

	public WeatherSimulator(WeatherSeed weatherSeed) {
		this.weatherSeed = weatherSeed;

	}

	/**
	 * This Method is used to generate Simulated Records
	 * 
	 * @param minOutRecords
	 * @return Simulated Record Size
	 */
	public int generateSimulatedRecords(int minOutRecords) {

		List<String> weatherDataList = new ArrayList<String>();
		WeatherDataWriter writeUtil = new WeatherDataWriter();

		List<SimulaRecord> simulaRecordList = weatherSeed.simulaRecordList;

		if (minOutRecords <= weatherSeed.seedRecordCount()) {
			LOGGER.info("Weather Seed is used as Weather Data");
			for (SimulaRecord simuRec : simulaRecordList) {
				weatherDataList.add(toDelimitedString(simuRec));
			}
		} else {
			LOGGER.info("Generating Weather Data");
			int seedSize = simulaRecordList.size();
			int indiCityRecSize = minOutRecords / seedSize;
			double temperature;
			WeatherCondition weatheCondition;

			for (SimulaRecord simuRec : simulaRecordList) {
				weatherDataList.add(toDelimitedString(simuRec));
				int count = 0;
				while (count != indiCityRecSize) {
					temperature = RandomRange.getRandomDecimal(
							WeatherConstants.MIN_TEMP,
							WeatherConstants.MAX_TEMP);
					weatheCondition = getConditions(temperature);
					StringBuilder weatherData = new StringBuilder();
					weatherData.append(simuRec.cityName);
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(simuRec.location_lat);
					weatherData.append(WeatherConstants.COMMA_DELIMITER);
					weatherData.append(simuRec.location_long);
					weatherData.append(WeatherConstants.COMMA_DELIMITER);
					weatherData.append(simuRec.location_elevation);
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(getLocalTime(simuRec.day));
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(weatheCondition.condition());
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(temperature);
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(getPressure(weatheCondition));
					weatherData.append(WeatherConstants.PIPE_DELIMITER);
					weatherData.append(getHumidity(weatheCondition));
					weatherDataList.add(weatherData.toString());
					++count;
				}
			}
		}
		writeUtil.fileWriteUtil(weatherDataList);
		LOGGER.info("Weather Data Generated Successfully");
		if (weatherDataList.isEmpty()) {
			return 0;
		} else {
			return weatherDataList.size();
		}
	}

	/**
	 * This Method is used to format weather data records in the required format
	 * 
	 * @param simuRec
	 * @return delimited weather data String
	 */
	private String toDelimitedString(SimulaRecord simuRec) {
		StringBuilder weatherData = new StringBuilder();
		weatherData.append(simuRec.cityName)
				.append(WeatherConstants.PIPE_DELIMITER)
				.append(simuRec.location_lat)
				.append(WeatherConstants.COMMA_DELIMITER)
				.append(simuRec.location_long)
				.append(WeatherConstants.COMMA_DELIMITER)
				.append(simuRec.location_elevation)
				.append(WeatherConstants.PIPE_DELIMITER).append(simuRec.day)
				.append(WeatherConstants.PIPE_DELIMITER)
				.append(simuRec.conditions)
				.append(WeatherConstants.PIPE_DELIMITER)
				.append(simuRec.temperature)
				.append(WeatherConstants.PIPE_DELIMITER)
				.append(simuRec.pressure)
				.append(WeatherConstants.PIPE_DELIMITER)
				.append(simuRec.humidity);
		return weatherData.toString();
	}

	/**
	 * This method is used to get the weather Condition based on temperature
	 * 
	 * @param temperature
	 * @return WeatherCondition
	 */
	private WeatherCondition getConditions(double temperature) {
		if (temperature <= WeatherConstants.RAIN_MAX_TEMP
				&& temperature >= WeatherConstants.RAIN_MIN_TEMP) {
			return WeatherCondition.RAIN;
		} else if (temperature <= WeatherConstants.SNOW_MAX_TEMP
				&& temperature >= WeatherConstants.SNOW_MIN_TEMP) {
			return WeatherCondition.SNOW;
		} else if (temperature <= WeatherConstants.WIND_MAX_TEMP
				&& temperature >= WeatherConstants.WIND_MIN_TEMP) {
			return WeatherCondition.WIND;
		} else {
			return WeatherCondition.SUNNY;
		}
	}

	/**
	 * This method is used to get pressure based on weather condition
	 * 
	 * @param condition
	 * @return
	 */
	private double getPressure(WeatherCondition condition) {
		if (WeatherCondition.RAIN.equals(condition)) {
			return RandomRange.getRandomDecimal(
					WeatherConstants.RAIN_MIN_PRESSURE,
					WeatherConstants.RAIN_MAX_PRESSURE);
		} else if (WeatherCondition.SNOW.equals(condition)) {
			return RandomRange.getRandomDecimal(
					WeatherConstants.SNOW_MIN_PRESSURE,
					WeatherConstants.SNOW_MAX_PRESSURE);
		} else if (WeatherCondition.WIND.equals(condition)) {
			return RandomRange.getRandomDecimal(
					WeatherConstants.WIND_MIN_PRESSURE,
					WeatherConstants.WIND_MAX_PRESSURE);
		} else {
			return RandomRange.getRandomDecimal(
					WeatherConstants.SUNNY_MIN_PRESSURE,
					WeatherConstants.SUNNY_MAX_PRESSURE);
		}
	}

	/**
	 * This method is used to get humidity based on weather condition
	 * 
	 * @param condition
	 * @return
	 */
	private int getHumidity(WeatherCondition condition) {
		Random random = new Random();
		if (WeatherCondition.RAIN.equals(condition)) {
			return RandomRange.getRandomInteger(
					WeatherConstants.RAIN_MIN_HUMIDITY,
					WeatherConstants.RAIN_MAX_HUMIDITY, random);
		} else if (WeatherCondition.SNOW.equals(condition)) {
			return RandomRange.getRandomInteger(
					WeatherConstants.SNOW_MIN_HUMIDITY,
					WeatherConstants.SNOW_MAX_HUMIDITY, random);
		} else if (WeatherCondition.WIND.equals(condition)) {
			return RandomRange.getRandomInteger(
					WeatherConstants.WIND_MIN_HUMIDITY,
					WeatherConstants.WIND_MAX_HUMIDITY, random);
		} else {
			return RandomRange.getRandomInteger(
					WeatherConstants.SUNNY_MIN_HUMIDITY,
					WeatherConstants.SUNNY_MAX_HUMIDITY, random);
		}
	}

	/**
	 * This method is used to generate Random periods
	 * 
	 * @param day
	 * @return
	 */
	private String getLocalTime(String day) {
		DateTimeFormatter isoFormatter = DateTimeFormat
				.forPattern(WeatherConstants.ISO_FORMAT);
		DateFormat randFormatter = new SimpleDateFormat(
				WeatherConstants.STD_FORMAT);
		DateTime inputDay = isoFormatter.parseDateTime(day);
		long offset = Timestamp
				.valueOf(randFormatter.format(inputDay.toDate())).getTime();
		long end = Timestamp
				.valueOf(randFormatter.format(new java.util.Date())).getTime();
		long diff = end - offset + 1;
		Timestamp randTime = new Timestamp(offset
				+ (long) (Math.random() * diff));
		return new SimpleDateFormat(WeatherConstants.ISO_FORMAT)
				.format(randTime);
	}

}
