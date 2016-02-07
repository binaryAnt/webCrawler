package informationFinding;

import apiMain.Result;
import apiMain.Results;

public abstract class InformationFinder {

	public abstract void setText(String text);
	public abstract Result findNextInformation();
	public abstract Results findAllInformation();

}
