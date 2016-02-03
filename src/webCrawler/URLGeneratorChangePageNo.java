package webCrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import updateTvInformation.URLReceiver;
import updateTvInformation.URLReceiverSimple;

public class URLGeneratorChangePageNo extends URLGenerator {

	private String urlStartingPage;

	private String urlPraefixNextPage = "";
	private String urlSuffixNextPage = "";
	private int startingPageNo;
	private int lastPageNo;
	private boolean countBackwards = false;

	private boolean generateUntilLastPage = false;

	/**
	 * Creates an URLGenerator which creates URLs until the lastPageNo is
	 * reached.
	 * 
	 * @param urlStartingPage
	 * @param urlPraefixNextPage
	 * @param urlSuffixNextBage
	 * @param startingPageNo
	 * @param lastPageNo
	 */
	public URLGeneratorChangePageNo(String urlStartingPage, String urlPraefixNextPage, String urlSuffixNextBage,
			int startingPageNo, int lastPageNo) {

		this.urlStartingPage = urlStartingPage;
		this.urlPraefixNextPage = urlPraefixNextPage;
		this.urlSuffixNextPage = urlSuffixNextBage;
		this.startingPageNo = startingPageNo;
		this.lastPageNo = lastPageNo;

		generateUntilLastPage = true;
	}

	/**
	 * Creates an URLGenerator which creates URLs until the lastPageNo is
	 * reached.
	 * 
	 * @param urlStartingPage
	 * @param urlPraefixNextPage
	 * @param urlSuffixNextBage
	 * @param startingPageNo
	 * @param lastPageNo
	 */
	public URLGeneratorChangePageNo(String urlStartingPage, String urlPraefixNextPage,
			int startingPageNo, int lastPageNo) {

		this.urlStartingPage = urlStartingPage;
		this.urlPraefixNextPage = urlPraefixNextPage;
		this.startingPageNo = startingPageNo;
		this.lastPageNo = lastPageNo;

		generateUntilLastPage = true;
	}
	
	/**
	 * Creates an URLGenerator which counts backwards or forwards until the
	 * Page behind the URL cannot received or is the same like the page before.
	 * 
	 * @param urlStartingPage
	 * @param urlPraefixNextPage
	 * @param urlSuffixNextBage
	 * @param startingPageNo
	 * @param countBackwards
	 */
	public URLGeneratorChangePageNo(String urlStartingPage, String urlPraefixNextPage, String urlSuffixNextBage,
			int startingPageNo, boolean countBackwards) {

		this.urlStartingPage = urlStartingPage;
		this.urlPraefixNextPage = urlPraefixNextPage;
		this.urlSuffixNextPage = urlSuffixNextBage;
		this.startingPageNo = startingPageNo;
		this.countBackwards = countBackwards;
	}

	/**
	 * Creates an URLGenerator which counts backwards or forwards until the
	 * Page behind the URL cannot received or is the same like the page before.
	 * 
	 * @param urlStartingPage
	 * @param urlPraefixNextPage
	 * @param urlSuffixNextBage
	 * @param startingPageNo
	 * @param countBackwards
	 */
	public URLGeneratorChangePageNo(String urlStartingPage, String urlPraefixNextPage,
			int startingPageNo, boolean countBackwards) {

		this.urlStartingPage = urlStartingPage;
		this.urlPraefixNextPage = urlPraefixNextPage;
		this.startingPageNo = startingPageNo;
		this.countBackwards = countBackwards;
	}
	
	@Override
	public List<URL> generateURLs() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		URL url;

		url = new URL(urlStartingPage);
		urls.add(url);

		if (generateUntilLastPage)
			urls.addAll(generateURLsByCountingToLastPage());
		else
			urls.addAll(generateURLsUntilPageIsNotValidOrNotNew());
		return urls;
	}

	private List<URL> generateURLsByCountingToLastPage() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		URL url;

		int i = startingPageNo;

		if (startingPageNo <= lastPageNo) {
			for (; i <= lastPageNo; i++) {
				url = new URL(urlPraefixNextPage + Integer.toString(i) + urlSuffixNextPage);
				urls.add(url);
			}
		} else {
			for (; i >= lastPageNo; i--) {
				url = new URL(urlPraefixNextPage + Integer.toString(i) + urlSuffixNextPage);
				urls.add(url);
			}
		}

		return urls;
	}

	private List<URL> generateURLsUntilPageIsNotValidOrNotNew() throws MalformedURLException {
		List<URL> urls = new ArrayList<URL>();
		String urlResponseLastPage = "";
		String urlResponseCurrentPage = "";
		URLReceiver urlReceiver = new URLReceiverSimple();

		boolean urlOK = true;

		int i = startingPageNo;

		do {

			URL url = new URL(urlPraefixNextPage + Integer.toString(i) + urlSuffixNextPage);

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

			if (countBackwards)
				i--;
			else
				i++;
		} while (urlOK);

		return urls;
	}

}
