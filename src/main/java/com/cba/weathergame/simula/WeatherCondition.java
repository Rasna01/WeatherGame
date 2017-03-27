package com.cba.weathergame.simula;

/**
 * @author Rasna Joseph
 * 
 *         Weather Condition Enum
 * 
 */
public enum WeatherCondition {

	SNOW("Snow"), SUNNY("Sunny"), RAIN("Rain"), WIND("Windy");

	private String condition;

	WeatherCondition(String condition) {
		this.condition = condition;
	}

	public String condition() {
		return condition;
	}

}
