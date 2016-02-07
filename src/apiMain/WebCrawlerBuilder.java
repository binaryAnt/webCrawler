package apiMain;

import apiConfiguration.WebCrawlerConfiguration;

public abstract class WebCrawlerBuilder {
	
	public abstract WebCrawler buildWebCrawler(WebCrawlerConfiguration webCrawlerConf);
	
}
