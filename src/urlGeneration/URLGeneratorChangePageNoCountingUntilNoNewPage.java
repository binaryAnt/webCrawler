package urlGeneration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import apConfiguration.URLGeneratorConfigurationCounterUntilNoNewPage;
import urlReceiving.URLReceiver;
import urlReceiving.URLReceiverSimple;

public class URLGeneratorChangePageNoCountingUntilNoNewPage extends URLGenerator {

	private URLGeneratorConfigurationCounterUntilNoNewPage conf;

	public URLGeneratorChangePageNoCountingUntilNoNewPage(URLGeneratorConfigurationCounterUntilNoNewPage conf) {
		this.conf = conf;
	}

	@Override
	public List<URL> generateURLs() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		URL url;

		url = new URL(conf.urlToFirstCrawlpage);
		urls.add(url);

		urls.addAll(generateURLsUntilPageIsNotValidOrNotNew());
		return urls;
	}

	private List<URL> generateURLsUntilPageIsNotValidOrNotNew() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		String urlResponseLastPage = "";
		String urlResponseCurrentPage = "";
		URLReceiver urlReceiver = new URLReceiverSimple();

		boolean urlOK = true;

		int i = conf.startingPageNo;

		do {

			URL url = new URL(conf.urlPraefixNextCrawlpage + Integer.toString(i) + conf.urlSuffixNextCrawlpage);

			try {
				urlResponseCurrentPage = urlReceiver.getResponseAsText(url);
				if (!urlResponseCurrentPage.equals(urlResponseLastPage))
					urls.add(url);
				else
					urlOK = false;
			} catch (IOException e) {
				urlOK = false;
			}

			urlResponseLastPage = urlResponseCurrentPage;

			if (conf.countBackwards)
				i--;
			else
				i++;
		} while (urlOK);

		return urls;
	}

}
