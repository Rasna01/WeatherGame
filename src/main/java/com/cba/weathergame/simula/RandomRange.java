package com.cba.weathergame.simula;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rasna Joseph
 * 
 *         Class to Generate Random Range Facts
 * 
 */
public final class RandomRange {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(RandomRange.class);

	public static int getRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			LOGGER.error("Start cannot exceed End.");
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * aRandom.nextDouble());
		return (int) (fraction + aStart);
	}

	public static double getRandomDecimal(double min, double max) {
		if (min > max) {
			LOGGER.error("Start cannot exceed End.");
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		Random r = new Random();
		return (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0;
	}

}
