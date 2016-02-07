package urlGeneration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import apiConfiguration.URLGeneratorConfigurationCounterUntilNumber;

public class URLGeneratorChangePageNoCountingUntilNo extends URLGenerator {

	private URLGeneratorConfigurationCounterUntilNumber conf;

	public URLGeneratorChangePageNoCountingUntilNo(URLGeneratorConfigurationCounterUntilNumber conf) {
		this.conf = conf;
	}

	@Override
	public List<URL> generateURLs() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		URL url;

		url = new URL(conf.urlToFirstCrawlpage);
		urls.add(url);

		urls.addAll(generateURLsByCountingToLastPage());
		return urls;
	}

	private List<URL> generateURLsByCountingToLastPage() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		URL url;

		int i = conf.startingPageNo;

		if (conf.startingPageNo <= conf.lastPageNo) {
			for (; i <= conf.lastPageNo; i++) {
				url = new URL(conf.urlPraefixNextCrawlpage + Integer.toString(i) + conf.urlSuffixNextCrawlpage);
				urls.add(url);
			}
		} else {
			for (; i >= conf.lastPageNo; i--) {
				url = new URL(conf.urlPraefixNextCrawlpage + Integer.toString(i) + conf.urlSuffixNextCrawlpage);
				urls.add(url);
			}
		}

		return urls;
	}
}
