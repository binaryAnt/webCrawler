package webCrawlerURLGeneration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class URLGenerator {
	
	public abstract List<URL> generateURLs() throws MalformedURLException;
}
