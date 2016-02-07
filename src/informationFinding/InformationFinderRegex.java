package informationFinding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import apConfiguration.InformationFinderConfigurationRegex;
import apiMain.Result;
import apiMain.Results;

public class InformationFinderRegex extends InformationFinder {

	private InformationFinderConfigurationRegex conf;
	private Pattern p;
	private Matcher m;

	public InformationFinderRegex(InformationFinderConfigurationRegex conf) {
		this.conf = conf;
		p = Pattern.compile(conf.regexAsText);
	}

	public void setText(String text) {
		m = p.matcher(text);
	}

	public Result findNextInformation() {
		List<String> information = new ArrayList<String>();

		if (m.find()) {
			for (int i = 1; i <= conf.regexGroupCount; i++) {
				information.add(m.group(i));
			}

			Result result = new Result(information);
			return result;
		} else
			return null;
	}

	public Results findAllInformation() {
		Results results = new Results();
		Result result;

		do {
			result = findNextInformation();
			if (result != null) {
				results.addResult(result);
			}
		} while (result != null);

		return results;
	}

}
