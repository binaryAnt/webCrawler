package webCrawlerInformationFinding;

import java.util.List;

public abstract class InformationFinder {

	protected abstract void setText(String text);
	protected abstract List<String> findNextInformation();

}
