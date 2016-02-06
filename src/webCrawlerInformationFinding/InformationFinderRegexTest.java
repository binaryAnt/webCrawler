package webCrawlerInformationFinding;

import java.util.List;

import org.junit.Test;

import webCrawlerConfiguration.InformationFinderConfigurationRegex;

public class InformationFinderRegexTest {

	@Test
	public void test() {
		InformationFinderConfigurationRegex conf = new InformationFinderConfigurationRegex();

		String text = "$(function() {document.getElementById('termin-0-0').innerHTML='<'+'div ";

		text = text + "class=sendetermine-box-titel>Aktion Fernseher<'+'span style=font-wei";
		text = text + "ght:normal;display:block;margin-top:4px;>Staffel 2, Folge 3<'+'/sp";
		text = text + "an><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Die Fami";
		text = text + "lie hängt nur noch vor dem Fernseher. Um das zu ändern, zerstört Fran vor laute";
		text = text + "r Wut das TV-Gerät. Als der zweite Apparat von einem Meteor zerstört ";
		text = text + "wird, will Earl bei einem Familienquiz …<'+'/p><'+'/div>';docu";

		conf.regexAsText = "titel>(.*?)<.*?:4px;>Staffel.([0-9]+)..Folge.([0-9]+?)<.*?<'\\+'p>(.*?)<'\\+'\\/p>";
		conf.regexGroupCount = 4;

		InformationFinderRegex finderRegex = new InformationFinderRegex(conf);
		finderRegex.setText(text);

		List<String> results = finderRegex.findNextInformation();

		System.out.println(results.get(0));
		System.out.println(results.get(1));
		System.out.println(results.get(2));
		System.out.println(results.get(3));
	}

}
