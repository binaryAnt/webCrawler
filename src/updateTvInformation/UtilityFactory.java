package updateTvInformation;

import mainApp.ConfigurationTVSeriesCrawling;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLReceiver.URLReceiver;

public abstract class UtilityFactory {

	protected ConfigurationTVSeriesCrawling confTVSeriesCrawling;

	public UtilityFactory(ConfigurationTVSeriesCrawling confTVSeriesCrawling) {
		this.confTVSeriesCrawling = confTVSeriesCrawling;
	}

	public abstract EpisodeRetriever createEpisodeRetriever();

	public abstract URLReceiver createURLReceiver();

	public abstract URLGenerator createURLGenerator();
}