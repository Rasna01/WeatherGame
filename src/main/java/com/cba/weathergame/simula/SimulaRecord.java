package com.cba.weathergame.simula;

/**
 * @author Rasna Joseph
 * 
 *         Weather Simula Record
 * 
 */
public class SimulaRecord {
	public String cityName;
	public String location_lat;
	public String location_long;
	public String location_elevation;
	public String day;
	public String conditions;
	public String temperature;
	public String pressure;
	public String humidity;

	public SimulaRecord(String[] seeds) {
		int index = 0;
		this.cityName = seeds[index++];
		this.location_lat = seeds[index++];
		this.location_long = seeds[index++];
		this.location_elevation = seeds[index++];
		this.day = seeds[index++];
		this.conditions = seeds[index++];
		this.temperature = seeds[index++];
		this.pressure = seeds[index++];
		this.humidity = seeds[index++];
	}

}
