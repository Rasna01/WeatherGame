package com.cba.weathergame.simula;

/**
 * @author Rasna Joseph
 * 
 *         Weather Constant Class
 * 
 */
public final class WeatherConstants {

	// Delimiters
	public static final String PIPE_DELIMITER = "|";
	public static final String COMMA_DELIMITER = ",";

	// Input and Output Files
	public static final String OUTFILE = "C:\\Users\\cherdi02\\Documents\\weather_data.txt";
	public static final String INFILE = "weather_seed.txt";

	// Date Formats
	public static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String STD_FORMAT = "yyyy-MM-dd hh:mm:ss";

	// Temperature Minimum and Maximum values in Australia
	public static final double MIN_TEMP = -5;
	public static final double MAX_TEMP = 40;

	// Temperature Variations
	public static final double RAIN_MIN_TEMP = 11;
	public static final double RAIN_MAX_TEMP = 22;
	public static final double SUNNY_MIN_TEMP = 23;
	public static final double SUNNY_MAX_TEMP = 40;
	public static final double SNOW_MIN_TEMP = -5;
	public static final double SNOW_MAX_TEMP = 3;
	public static final double WIND_MIN_TEMP = 4;
	public static final double WIND_MAX_TEMP = 10;

	// Pressure Variations
	public static final double RAIN_MIN_PRESSURE = 1050;
	public static final double RAIN_MAX_PRESSURE = 1099;
	public static final double SUNNY_MIN_PRESSURE = 1100;
	public static final double SUNNY_MAX_PRESSURE = 1199;
	public static final double SNOW_MIN_PRESSURE = 950;
	public static final double SNOW_MAX_PRESSURE = 999;
	public static final double WIND_MIN_PRESSURE = 1000;
	public static final double WIND_MAX_PRESSURE = 1049;

	// Temperature Humidity
	public static final int RAIN_MIN_HUMIDITY = 80;
	public static final int RAIN_MAX_HUMIDITY = 100;
	public static final int SUNNY_MIN_HUMIDITY = 10;
	public static final int SUNNY_MAX_HUMIDITY = 30;
	public static final int SNOW_MIN_HUMIDITY = 31;
	public static final int SNOW_MAX_HUMIDITY = 60;
	public static final int WIND_MIN_HUMIDITY = 61;
	public static final int WIND_MAX_HUMIDITY = 80;

}
