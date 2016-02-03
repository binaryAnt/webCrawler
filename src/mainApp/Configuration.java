package mainApp;

import java.util.List;

public class Configuration {

	private ConfigurationDatabase dbConfiguration;
	private List<ConfigurationTVSeriesCrawling> tvSeriesCrawlingConfigurations;
	
	public Configuration(ConfigurationDatabase dbconf, List<ConfigurationTVSeriesCrawling> tvSeriesCrawlingConfigurations){
		this.dbConfiguration = dbconf;
		this.tvSeriesCrawlingConfigurations = tvSeriesCrawlingConfigurations;
	}
	
	public ConfigurationDatabase getDbConfiguration() {
		return dbConfiguration;
	}
	public List<ConfigurationTVSeriesCrawling> getTvSeriesCrawlingConfigurations() {
		return tvSeriesCrawlingConfigurations;
	}

	
	
}
