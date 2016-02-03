package updateTvInformation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mainApp.ConfigurationTVSeriesCrawling;

public class EpisodeRetrieverRegex extends EpisodeRetriever {

	public EpisodeRetrieverRegex(ConfigurationTVSeriesCrawling confEpisodeRetrieving) {
		super(confEpisodeRetrieving);
	}

	private final String regex = confEpisodeRetrieving.regexAsText;

	@Override
	public Episodes retrieveEpisodesFromText(String text) {
		Episodes episodes = new Episodes();

		// specify that we want to search for two groups in the string
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);

		// if our pattern matches the string, we can try to extract our groups
		while (m.find()) {
			// get the two groups we were looking for
			Episode e = new Episode();
			e.tvSeriesId = confEpisodeRetrieving.tvSeriesId;
			e.title = m.group(confEpisodeRetrieving.regexgGroupOfTitle);
			e.season = Integer.parseInt(m.group(confEpisodeRetrieving.regexGroupOfSeason));
			e.episode = Integer.parseInt(m.group(confEpisodeRetrieving.regexGroupOfEpisode));
			e.description = m.group(confEpisodeRetrieving.regexGroupOfDescription);
			episodes.addEpisode(e);
		}

		return episodes;
	}

}
