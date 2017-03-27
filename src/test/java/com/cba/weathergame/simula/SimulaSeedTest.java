package com.cba.weathergame.simula;

import static org.junit.Assert.assertTrue;

/**
 * @author Rasna Joseph
 * 
 *         Weather Game Junit
 * 
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cba.weathergame.files.SeedFileReader;

public class SimulaSeedTest {

	public SimulaSeedTest() {
	}

	@Before
	public void setUp() {
		System.out.println("\nSETUP IS RUNNING -- Nothing to do though");
	}

	@After
	public void tearDown() {
		System.out.println("TEARDOWN IS RUNNING -- Nothing to do though");
	}

	@Test
	public void testReadSeedFile() {
		SeedFileReader fRead = new SeedFileReader();
		WeatherSeed weatherSeed = new WeatherSeed(
				fRead.readSeedFile(WeatherConstants.INFILE));
		assertTrue(weatherSeed.simulaRecordList.size() > 0);
	}

	@Test
	public void testGenerateNSimulatedRecords() throws Exception {

		SeedFileReader fRead = new SeedFileReader();
		WeatherSeed weatherSeed = new WeatherSeed(
				fRead.readSeedFile(WeatherConstants.INFILE));
		WeatherSimulator simulator = new WeatherSimulator(weatherSeed);
		int weatherDataSize = simulator.generateSimulatedRecords(5);

		assertTrue(weatherDataSize > 0);

	}

}
