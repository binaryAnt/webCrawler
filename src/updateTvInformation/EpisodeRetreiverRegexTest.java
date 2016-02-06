package updateTvInformation;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.junit.Test;

import mainApp.ConfigurationLoader;
import mainApp.ConfigurationLoaderException;
import mainApp.ConfigurationLoaderFile;
import webCrawlerURLReceiver.URLReceiverSimple;

public class EpisodeRetreiverRegexTest {

	@Test
	public void retrieveEpisodesFromText_complexTest_consoleOK() throws IOException, ConfigurationLoaderException {
		URL sampleURL = new URL("http://www.fernsehserien.de/full-house-1987/sendetermine/-1");
		URLReceiverSimple urlReceiver = new URLReceiverSimple();
		String htmlCode;

		ConfigurationLoader confLoader = new ConfigurationLoaderFile("tvepisodesCrawler.conf");

		EpisodeRetrieverRegex retriever = new EpisodeRetrieverRegex(
				confLoader.getConfiguration().getTvSeriesCrawlingConfigurations().get(0));
		htmlCode = urlReceiver.getResponseAsText(sampleURL);

		Episodes e = retriever.retrieveEpisodesFromText(htmlCode);
		Iterator<Episode> iterator = e.getIterator();

		while (iterator.hasNext()) {
			Episode episode = iterator.next();
			System.out.println("Staffel: " + episode.season + " Episode: " + episode.episode + " Titel: "
					+ episode.title + " Beschreibung: " + episode.description);

		}
	}

}
