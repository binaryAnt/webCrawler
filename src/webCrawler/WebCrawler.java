package webCrawler;

import webCrawlerInformationFinding.InformationFinder;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLReceiver.URLReceiver;

public abstract class WebCrawler {

	protected URLGenerator urlGenerator;
	protected URLReceiver urlReceiver;
	protected InformationFinder informationFinder;
	
	protected void setUrlGenerator(URLGenerator urlGenerator) {
		this.urlGenerator = urlGenerator;
	}
	protected void setUrlReceiver(URLReceiver urlReceiver) {
		this.urlReceiver = urlReceiver;
	}
	protected void setInformationFinder(InformationFinder informationFinder) {
		this.informationFinder = informationFinder;
	}
}
