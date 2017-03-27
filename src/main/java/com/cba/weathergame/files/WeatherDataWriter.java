package com.cba.weathergame.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cba.weathergame.exception.WeatherGameRuntimeException;
import com.cba.weathergame.simula.WeatherConstants;

/**
 * @author Rasna Joseph
 * 
 *         Class to Write Weather Data to Destination
 * 
 */
public class WeatherDataWriter {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(WeatherDataWriter.class);

	public void fileWriteUtil(List<String> fileContent) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {

			fw = new FileWriter(WeatherConstants.OUTFILE);
			bw = new BufferedWriter(fw);
			for (String content : fileContent) {
				bw.write(content);
				bw.newLine();
			}

		} catch (IOException e) {

			LOGGER.error("Failed to Write Weather Data File");
			throw new WeatherGameRuntimeException(e);

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {
				LOGGER.error("Failed to Close File Write Resources");
				throw new WeatherGameRuntimeException(ex);
			}

		}

	}

}
