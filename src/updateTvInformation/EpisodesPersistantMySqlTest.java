package updateTvInformation;

import org.junit.Test;

import mainApp.ConfigurationLoader;
import mainApp.ConfigurationLoaderException;
import mainApp.ConfigurationLoaderFile;

public class EpisodesPersistantMySqlTest {

	@Test
	public void persistEpisodes_1Episode_NoExc() throws ConfigurationLoaderException {
		ConfigurationLoader confLoader = new ConfigurationLoaderFile("tvepisodesCrawler.conf");
		EpisodesPersistant ep = new EpisodesPersistantMySql(confLoader.getConfiguration().getDbConfiguration());
		
		ep.persistEpisodes(getTestEpisodes1());
		
	}
	
	private Episodes getTestEpisodes1(){
		Episodes episodes = new Episodes();
		
		Episode e = new Episode();
		e.tvSeriesId = 99;
		e.title = "Titel: Hallo!";
		e.season = 1;
		e.episode = 2;
		e.description = "meine Beschreibung...blabla...";
		
		episodes.addEpisode(e);
		
		return episodes;
	}

}
