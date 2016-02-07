package apiMain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Results {

	private List<Result> results;

	public Results() {
		results = new ArrayList<Result>();
	}

	public void addResult(Result result) {
		results.add(result);
	}

	public void addResults(Results results) {
		Iterator<Result> it = results.getIterator();

		while (it.hasNext()) {
			this.results.add(it.next());
		}
	}

	public Iterator<Result> getIterator() {
		return new ResultsIterator(results);
	}
}
