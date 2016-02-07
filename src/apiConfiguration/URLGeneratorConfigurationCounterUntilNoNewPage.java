package apiConfiguration;

public class URLGeneratorConfigurationCounterUntilNoNewPage extends URLGeneratorConfiguration {

	public final String urlToFirstCrawlpage;
	public final String urlPraefixNextCrawlpage;
	public final String urlSuffixNextCrawlpage;
	public final int startingPageNo;
	public final boolean countBackwards;

	public URLGeneratorConfigurationCounterUntilNoNewPage(String urlToFirstCrawlpage, String urlPraefixNextCrawlpage,
			String urlSuffixNextCrawlpage, int startingPageNo, boolean countBackwards) {

		this.urlToFirstCrawlpage = urlToFirstCrawlpage;
		this.urlPraefixNextCrawlpage = urlPraefixNextCrawlpage;
		this.urlSuffixNextCrawlpage = urlSuffixNextCrawlpage;
		this.startingPageNo = startingPageNo;
		this.countBackwards = countBackwards;

	}

	public URLGeneratorConfigurationCounterUntilNoNewPage(String urlToFirstCrawlpage, String urlPraefixNextCrawlpage,
			int startingPageNo, boolean countBackwards) {

		this.urlToFirstCrawlpage = urlToFirstCrawlpage;
		this.urlPraefixNextCrawlpage = urlPraefixNextCrawlpage;
		this.urlSuffixNextCrawlpage = "";
		this.startingPageNo = startingPageNo;
		this.countBackwards = countBackwards;

	}
}
