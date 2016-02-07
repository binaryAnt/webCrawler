package apiConfiguration;

public class InformationFinderConfigurationRegex extends InformationFinderConfiguration {
	public final String regexAsText;
	public final int regexGroupCount;
	
	public InformationFinderConfigurationRegex(String regexAsText, int regexGroupCount){
		this.regexAsText = regexAsText;
		this.regexGroupCount = regexGroupCount;
	}
}
