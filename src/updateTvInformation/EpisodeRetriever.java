package updateTvInformation;

import mainApp.ConfigurationTVSeriesCrawling;

public abstract class EpisodeRetriever {

	protected ConfigurationTVSeriesCrawling confEpisodeRetrieving;
	
	public EpisodeRetriever(ConfigurationTVSeriesCrawling confEpisodeRetrieving){
		this.confEpisodeRetrieving = confEpisodeRetrieving;
	}
	
	public abstract Episodes retrieveEpisodesFromText(String text);
	
}
