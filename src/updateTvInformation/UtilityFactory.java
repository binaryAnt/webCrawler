package updateTvInformation;

import mainApp.ConfigurationTVSeriesCrawling;
import webCrawler.URLGenerator;
import webCrawler.URLGeneratorChangePageNo;

public class UtilityFactory {

	private ConfigurationTVSeriesCrawling confTVSeriesCrawling;

	public UtilityFactory(ConfigurationTVSeriesCrawling confTVSeriesCrawling) {
		this.confTVSeriesCrawling = confTVSeriesCrawling;
	}

	public EpisodeRetriever createEpisodeRetriever() {
		return new EpisodeRetrieverRegex(confTVSeriesCrawling);
	}

	public URLReceiver createURLReceiver() {
		return new URLReceiverSimple();
	}

	public URLGenerator createURLGenerator() {
		return new URLGeneratorChangePageNo(confTVSeriesCrawling.urlToFirstCrawlpage,
				confTVSeriesCrawling.urlPraefixNextCrawlpage, confTVSeriesCrawling.startingPageNo,
				confTVSeriesCrawling.countBackwards);
	}
}