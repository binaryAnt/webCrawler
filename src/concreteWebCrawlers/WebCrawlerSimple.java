package concreteWebCrawlers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import apiMain.Results;
import apiMain.WebCrawler;

public class WebCrawlerSimple extends WebCrawler {

	@Override
	public Results crawlAll() throws MalformedURLException {
		Results allResults = new Results();

		List<URL> urls = urlGenerator.generateURLs();
		String response;
		Results results;

		for (int i = 0; i < urls.size(); i++) {
			try {
				response = urlReceiver.getResponseAsText(urls.get(i));
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
			informationFinder.setText(response);
			results = informationFinder.findAllInformation();
			allResults.addResults(results);
		}

		return allResults;
	}

}
