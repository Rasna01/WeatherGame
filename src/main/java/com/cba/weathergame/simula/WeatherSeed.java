package com.cba.weathergame.simula;

import java.util.List;

/**
 * @author Rasna Joseph
 * 
 *         Weather Seed Class
 * 
 */
public class WeatherSeed {

	public List<SimulaRecord> simulaRecordList;

	public int seedRecordCount() {
		return simulaRecordList.size();
	}

	public WeatherSeed(List<SimulaRecord> simulaRecordList) {
		this.simulaRecordList = simulaRecordList;
	}

}