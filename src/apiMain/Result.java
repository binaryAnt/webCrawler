package apiMain;

import java.util.List;

public class Result {

	private List<String> values;
	private String sourceURL;

	public Result(List<String> values) {
		this.values = values;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public List<String> getValuesAsStringList() {
		return values;
	}

	public String getSourceURLAsString() {
		return sourceURL;
	}
}
