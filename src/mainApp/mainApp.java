package mainApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import updateTvInformation.EpisodesPersistantMySql;
import updateTvInformation.EpisodeRetriever;
import updateTvInformation.Episodes;
import updateTvInformation.EpisodesPersistant;
import updateTvInformation.UtilityFactory;
import webCrawlerURLGeneration.URLGenerator;
import webCrawlerURLReceiver.URLReceiver;

public class mainApp {

	public static void main(String[] args) {
		// TODO Logger einbinden
		// TODO URLGeneratorLinkNavigation
		// TODO für alle 3 Generatoren (Zählen mit Ende, Zählen bis nix neues, 
		// eine Konfigurationsdateimöglichkeit bieten und diese auswerten
		
		
		updateNewEpisodes();
	}

	private static void updateNewEpisodes() {
		ConfigurationLoader confLoader = new ConfigurationLoaderFile("tvepisodesCrawler.conf");

		Configuration configuration;
		try {
			configuration = confLoader.getConfiguration();
		} catch (ConfigurationLoaderException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return;
		}

//		ConfigurationDatabase dbConf = configuration.getDbConfiguration();
//
//		List<ConfigurationTVSeriesCrawling> tvSeriesCrawlingConfigurations = configuration
//				.getTvSeriesCrawlingConfigurations();
//
//		Episodes allEpisodes = new Episodes();
//
//		for (int i = 0; i < tvSeriesCrawlingConfigurations.size(); i++) {
//			ConfigurationTVSeriesCrawling tvSeriesCrawlingconf = tvSeriesCrawlingConfigurations.get(i);
//
//			UtilityFactory factory = new UtilityFactory(tvSeriesCrawlingconf);
//
//			URLGenerator urlGenerator = factory.createURLGenerator();
//			URLReceiver urlReceiver = factory.createURLReceiver();
//			EpisodeRetriever retriever = factory.createEpisodeRetriever();
//
//			List<URL> urls = new ArrayList<URL>();
//
//			try {
//				urls = urlGenerator.generateURLs();
//			} catch (MalformedURLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			for (int j = 0; j < urls.size(); j++) {
//				System.out.println(urls.get(j).toString());
//				try {
//					String response = urlReceiver.getResponseAsText(urls.get(j));
//					Episodes episodes = retriever.retrieveEpisodesFromText(response);
//					allEpisodes.addEpisodes(episodes);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}
//
//		EpisodesPersistant persistant = new EpisodesPersistantMySql(configuration.getDbConfiguration());
//		persistant.persistEpisodes(allEpisodes);
	}

}
