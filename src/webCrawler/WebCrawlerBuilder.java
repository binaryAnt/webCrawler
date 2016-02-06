package webCrawler;

import webCrawlerConfiguration.WebCrawlerConfiguration;
import webCrawlerInformationFinding.InformationFinder;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLReceiver.URLReceiver;

public abstract class WebCrawlerBuilder {
	
	public abstract WebCrawler buildWebCrawler(WebCrawlerConfiguration webCrawlerConf);
	
}
