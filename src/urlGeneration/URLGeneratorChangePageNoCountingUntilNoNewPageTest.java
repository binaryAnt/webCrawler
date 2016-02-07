package urlGeneration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import apConfiguration.URLGeneratorConfigurationCounterUntilNoNewPage;

public class URLGeneratorChangePageNoCountingUntilNoNewPageTest {

	@Test
	public void test() throws MalformedURLException {

		String urlToFirstCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		String urlPraefixNextCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		int startingPageNo = -1;
		boolean countBackwards = true;

		URLGeneratorConfigurationCounterUntilNoNewPage conf = new URLGeneratorConfigurationCounterUntilNoNewPage(
				urlToFirstCrawlpage, urlPraefixNextCrawlpage, startingPageNo, countBackwards);

		URLGeneratorChangePageNoCountingUntilNoNewPage gen = new URLGeneratorChangePageNoCountingUntilNoNewPage(conf);

		List<URL> urls = gen.generateURLs();

		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i).toString());
		}
	}

}
