package webCrawler;

import webCrawlerConfiguration.InformationFinderConfigurationRegex;
import webCrawlerConfiguration.URLGeneratorConfigurationCounterUntilNo;
import webCrawlerConfiguration.URLGeneratorConfigurationCounterUntilNoNewPage;
import webCrawlerConfiguration.WebCrawlerConfiguration;
import webCrawlerInformationFinding.InformationFinder;
import webCrawlerInformationFinding.InformationFinderRegex;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLGeneration.URLGeneratorChangePageNoCountingUntilNo;
import webCrawlerURLGeneration.URLGeneratorChangePageNoCountingUntilNoNewPage;
import webCrawlerURLReceiver.URLReceiver;
import webCrawlerURLReceiver.URLReceiverSimple;

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
		else if (webCrawlerConf.urlGeneratorConf instanceof URLGeneratorConfigurationCounterUntilNo)
			return new URLGeneratorChangePageNoCountingUntilNo(
					(URLGeneratorConfigurationCounterUntilNo) webCrawlerConf.urlGeneratorConf);
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
