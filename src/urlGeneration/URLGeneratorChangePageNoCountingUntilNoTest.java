package urlGeneration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import apConfiguration.URLGeneratorConfigurationCounterUntilNumber;

public class URLGeneratorChangePageNoCountingUntilNoTest {

	@Test
	public void test() throws MalformedURLException {

		String urlToFirstCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		String urlPraefixNextCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		int startingPageNo = -1;
		int lastPageNo = -12;

		URLGeneratorConfigurationCounterUntilNumber conf = new URLGeneratorConfigurationCounterUntilNumber(
				urlToFirstCrawlpage, urlPraefixNextCrawlpage, startingPageNo, lastPageNo);

		URLGeneratorChangePageNoCountingUntilNo gen = new URLGeneratorChangePageNoCountingUntilNo(conf);

		List<URL> urls = gen.generateURLs();

		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i).toString());
		}
	}

}
