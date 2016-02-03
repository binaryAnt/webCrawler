package webCrawler;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

public class URLGeneratorChangePageNoTest {

	@Test
	public void generateURLs_countToLastPageMinus_OK() {
		String urlStartingPage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		String urlPraefixNextPage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		String urlSuffixNextBage = "";
		int startingPageNo = -1;
		int lastPageNo = -2;

		int counter = 0;

		URLGeneratorChangePageNo gen = new URLGeneratorChangePageNo(urlStartingPage, urlPraefixNextPage,
				urlSuffixNextBage, startingPageNo, lastPageNo);
		try {
			List<URL> urls = gen.generateURLs();
			for (int i = 0; i < urls.size(); i++) {
				System.out.println(urls.get(i).toString());
				counter++;
			}
		} catch (MalformedURLException e) {
			fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(3, counter);

	}
	
	@Test
	public void generateURLs_countUntilNoPageExisting_OK() {
		String urlStartingPage = "http://www.fernsehserien.de/die-dinos/sendetermine";
		String urlPraefixNextPage = "http://www.fernsehserien.de/die-dinos/sendetermine/";
		String urlSuffixNextBage = "";
		int startingPageNo = -1;

		URLGeneratorChangePageNo gen = new URLGeneratorChangePageNo(urlStartingPage, urlPraefixNextPage,
				urlSuffixNextBage, startingPageNo, true);
		try {
			List<URL> urls = gen.generateURLs();
			for (int i = 0; i < urls.size(); i++) {
				System.out.println(urls.get(i).toString());
			}
		} catch (MalformedURLException e) {
			fail();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}	

}
