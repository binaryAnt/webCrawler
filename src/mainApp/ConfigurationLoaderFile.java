package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class ConfigurationLoaderFile implements ConfigurationLoader {

	private File confFile;

	public ConfigurationLoaderFile(String filepath) {
		confFile = new File("tvepisodesCrawler.conf");

	}

	@Override
	public Configuration getConfiguration() throws ConfigurationLoaderException {
		Gson gson = new Gson();
		String configurationAsJson;

		try {
			configurationAsJson = getConfigurationAsJsonFromFile();
		} catch (IOException e) {
			throw new ConfigurationLoaderException(e.getMessage());
		}

		return gson.fromJson(configurationAsJson, Configuration.class);
	}

	private String getConfigurationAsJsonFromFile() throws IOException {
		String configurationAsJson = "";
		String line;

		InputStream in = new FileInputStream(confFile);
		
		InputStreamReader reader = new InputStreamReader(in);
		
		BufferedReader bufReader = new BufferedReader(reader);
		while ((line = bufReader.readLine()) != null) {
			configurationAsJson += line;			
		}

		bufReader.close();
		return configurationAsJson;
	}

}
