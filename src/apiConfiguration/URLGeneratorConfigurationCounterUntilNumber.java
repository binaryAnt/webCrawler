package apiConfiguration;

public class URLGeneratorConfigurationCounterUntilNumber extends URLGeneratorConfiguration {

	public final String urlToFirstCrawlpage;
	public final String urlPraefixNextCrawlpage;
	public final String urlSuffixNextCrawlpage;
	public final int startingPageNo;
	public final int lastPageNo;

	public URLGeneratorConfigurationCounterUntilNumber(String urlToFirstCrawlpage, String urlPraefixNextCrawlpage,
			String urlSuffixNextCrawlpage, int startingPageNo, int lastPageNo) {

		this.urlToFirstCrawlpage = urlToFirstCrawlpage;
		this.urlPraefixNextCrawlpage = urlPraefixNextCrawlpage;
		this.urlSuffixNextCrawlpage = urlSuffixNextCrawlpage;
		this.startingPageNo = startingPageNo;
		this.lastPageNo = lastPageNo;
	}

	public URLGeneratorConfigurationCounterUntilNumber(String urlToFirstCrawlpage, String urlPraefixNextCrawlpage,
			int startingPageNo, int lastPageNo) {

		this.urlToFirstCrawlpage = urlToFirstCrawlpage;
		this.urlPraefixNextCrawlpage = urlPraefixNextCrawlpage;
		this.urlSuffixNextCrawlpage = "";
		this.startingPageNo = startingPageNo;
		this.lastPageNo = lastPageNo;
	}
}
