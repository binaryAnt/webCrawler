package webCrawlerInformationFinding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import webCrawlerConfiguration.InformationFinderConfigurationRegex;

public class InformationFinderRegex extends InformationFinder {

	private InformationFinderConfigurationRegex conf;
	private Pattern p;
	private Matcher m;

	public InformationFinderRegex(InformationFinderConfigurationRegex conf) {
		this.conf = conf;
		p = Pattern.compile(conf.regexAsText);
	}

	protected void setText(String text) {
		m = p.matcher(text);
	}

	protected List<String> findNextInformation() {
		List<String> information = new ArrayList<String>();

		m.find();
		for (int i = 1; i <= conf.regexGroupCount; i++) {
			information.add(m.group(i));
		}

		return information;
	}

}
