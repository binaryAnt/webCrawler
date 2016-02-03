package updateTvInformation;

import java.util.Iterator;
import java.util.List;

public class EpisodeIterator implements Iterator<Episode> {

	private List<Episode> episodes;
	private int counter = 0;
	
	public EpisodeIterator(List<Episode> episodes) {
		this.episodes = episodes;
	}
	
	@Override
	public boolean hasNext() {
		if( episodes.size() == counter)
		return false;
		return true;
	}

	@Override
	public Episode next() {
		counter ++;
		return episodes.get(counter - 1);
	}

}
