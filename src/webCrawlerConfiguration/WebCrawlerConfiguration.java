package webCrawlerConfiguration;

public class WebCrawlerConfiguration {

	public final URLGeneratorConfiguration urlGeneratorConf;
	public final InformationFinderConfiguration informationFinderConf;

	public WebCrawlerConfiguration(URLGeneratorConfiguration urlGeneratorConf,
			InformationFinderConfiguration informationFinderConf) {
		this.urlGeneratorConf = urlGeneratorConf;
		this.informationFinderConf = informationFinderConf;
	}

}
