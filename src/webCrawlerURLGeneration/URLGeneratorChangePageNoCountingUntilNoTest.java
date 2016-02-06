package webCrawlerURLGeneration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import webCrawlerConfiguration.URLGeneratorConfigurationCounterUntilNo;

public class URLGeneratorChangePageNoCountingUntilNoTest {

	@Test
	public void test() throws MalformedURLException {
		URLGeneratorConfigurationCounterUntilNo conf = new URLGeneratorConfigurationCounterUntilNo();
		
		conf.urlToFirstCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		conf.urlPraefixNextCrawlpage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		conf.startingPageNo = -1;
		conf.lastPageNo = -12;
		
		URLGeneratorChangePageNoCountingUntilNo gen = new URLGeneratorChangePageNoCountingUntilNo(conf);
	
		List<URL> urls = gen.generateURLs();
		
		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i).toString());
		}
	}

}
