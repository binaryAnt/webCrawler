package apiMain;

import apConfiguration.InformationFinderConfigurationRegex;
import apConfiguration.URLGeneratorConfigurationCounterUntilNumber;
import apConfiguration.URLGeneratorConfigurationCounterUntilNoNewPage;
import apConfiguration.WebCrawlerConfiguration;
import concreteWebCrawlers.WebCrawlerSimple;
import informationFinding.InformationFinder;
import informationFinding.InformationFinderRegex;
import urlGeneration.URLGenerator;
import urlGeneration.URLGeneratorChangePageNoCountingUntilNo;
import urlGeneration.URLGeneratorChangePageNoCountingUntilNoNewPage;
import urlReceiving.URLReceiver;
import urlReceiving.URLReceiverSimple;

public class WebCrawlerBuilderSimple extends WebCrawlerBuilder {	
	
	@Override
	public WebCrawler buildWebCrawler(WebCrawlerConfiguration webCrawlerConf) {
		
		
		WebCrawler webCrawler = new WebCrawlerSimple();
		
		URLGenerator urlGenerator = getURLGenerator(webCrawlerConf);
		URLReceiver urlReceiver = getURLReceiver();
		InformationFinder informationFinder = getInformationFinder(webCrawlerConf);
		
		webCrawler.setUrlGenerator(urlGenerator);
		webCrawler.setUrlReceiver(urlReceiver);
		webCrawler.setInformationFinder(informationFinder);
		
		return webCrawler;
	}

	protected URLGenerator getURLGenerator(WebCrawlerConfiguration webCrawlerConf) {
		if (webCrawlerConf.urlGeneratorConf instanceof URLGeneratorConfigurationCounterUntilNoNewPage)
			return new URLGeneratorChangePageNoCountingUntilNoNewPage(
					(URLGeneratorConfigurationCounterUntilNoNewPage) webCrawlerConf.urlGeneratorConf);
		else if (webCrawlerConf.urlGeneratorConf instanceof URLGeneratorConfigurationCounterUntilNumber)
			return new URLGeneratorChangePageNoCountingUntilNo(
					(URLGeneratorConfigurationCounterUntilNumber) webCrawlerConf.urlGeneratorConf);
		else
			return null;
	}

	protected URLReceiver getURLReceiver() {
		return new URLReceiverSimple();
	}

	protected InformationFinder getInformationFinder(WebCrawlerConfiguration webCrawlerConf) {

		if (webCrawlerConf.informationFinderConf instanceof InformationFinderConfigurationRegex) {
			return new InformationFinderRegex(
					(InformationFinderConfigurationRegex) webCrawlerConf.informationFinderConf);
		} else
			return null;
	}



}
