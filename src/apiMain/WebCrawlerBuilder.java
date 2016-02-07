package apiMain;

import apConfiguration.WebCrawlerConfiguration;

public abstract class WebCrawlerBuilder {
	
	public abstract WebCrawler buildWebCrawler(WebCrawlerConfiguration webCrawlerConf);
	
}
