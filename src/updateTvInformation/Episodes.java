package updateTvInformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Episodes {

	private List<Episode> episodes = new ArrayList<Episode>();
	
	public void addEpisode(Episode e){
		episodes.add(e);
	}
	
	public void addEpisodes(Episodes e){
		Iterator<Episode> it = e.getIterator();
		
		while(it.hasNext()){
			episodes.add(it.next());
		}
		
	}
	
	public Iterator<Episode> getIterator(){
		return new EpisodeIterator(episodes);
	}
	
}
