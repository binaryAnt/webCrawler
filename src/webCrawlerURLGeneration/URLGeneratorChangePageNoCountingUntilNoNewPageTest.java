package webCrawlerURLGeneration;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import webCrawlerConfiguration.URLGeneratorConfigurationCounterUntilNoNewPage;

public class URLGeneratorChangePageNoCountingUntilNoNewPageTest {

	@Test
	public void test() throws MalformedURLException {
		URLGeneratorConfigurationCounterUntilNoNewPage conf = new URLGeneratorConfigurationCounterUntilNoNewPage();

		conf.urlToFirstCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		conf.urlPraefixNextCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		conf.startingPageNo = -1;
		conf.countBackwards = true;
		
		URLGeneratorChangePageNoCountingUntilNoNewPage gen = new URLGeneratorChangePageNoCountingUntilNoNewPage(conf);

		List<URL> urls = gen.generateURLs();

		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i).toString());
		}
	}

}