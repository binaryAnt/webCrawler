package apiMain;

import java.util.Iterator;
import java.util.List;

public class ResultsIterator implements Iterator<Result> {

	private List<Result> results;
	private int currentIndex = 0;
	
	protected ResultsIterator(List<Result> results){
		this.results = results;
	}

	@Override
	public boolean hasNext() {
		if( results.size() == currentIndex)
		return false;
		return true;
	}

	@Override
	public Result next() {
		currentIndex ++;
		return results.get(currentIndex - 1);
	}
	
}
