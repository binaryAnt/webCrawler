package updateTvInformation;

import mainApp.ConfigurationTVSeriesCrawling;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLGeneration.URLGeneratorChangePageNoCountingUntilNoNewPage;
import webCrawlerURLReceiver.URLReceiver;
import webCrawlerURLReceiver.URLReceiverSimple;

public class UtilityFactorySimple extends UtilityFactory{

	private ConfigurationTVSeriesCrawling confTVSeriesCrawling;

	public UtilityFactorySimple(ConfigurationTVSeriesCrawling confTVSeriesCrawling) {
		super(confTVSeriesCrawling);
	}

	public EpisodeRetriever createEpisodeRetriever() {
		return new EpisodeRetrieverRegex(confTVSeriesCrawling);
	}

	public URLReceiver createURLReceiver() {
		return new URLReceiverSimple();
	}

	public URLGenerator createURLGenerator() {
		return new URLGeneratorChangePageNoCountingUntilNoNewPage(confTVSeriesCrawling.urlToFirstCrawlpage,
				confTVSeriesCrawling.urlPraefixNextCrawlpage, confTVSeriesCrawling.startingPageNo,
				confTVSeriesCrawling.countBackwards);
	}
}