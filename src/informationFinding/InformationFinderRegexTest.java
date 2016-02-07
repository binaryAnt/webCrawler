package informationFinding;

import java.util.Iterator;

import org.junit.Test;

import apConfiguration.InformationFinderConfigurationRegex;
import apiMain.Result;
import apiMain.Results;

public class InformationFinderRegexTest {

	@Test
	public void findNextInformation_validInput_InformationFound() {
		String regexAsText = "titel>(.*?)<.*?:4px;>Staffel.([0-9]+)..Folge.([0-9]+?)<.*?<'\\+'p>(.*?)<'\\+'\\/p>";
		int regexGroupCount = 4;

		InformationFinderConfigurationRegex conf = new InformationFinderConfigurationRegex(regexAsText,
				regexGroupCount);

		String text = "$(function() {document.getElementById('termin-0-0').innerHTML='<'+'div ";

		text = "$(function() {document.getElementById('termin-0-0').innerHTML='<'+'div class=sendetermine-box-titel>Karrieretr�ume<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 8<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat eine Verabredung mit dem Zauberer der Berufe. Der Magier wird ihm sagen, welche Art von Arbeit er ergreifen wird. Robbie erlebt eine Entt�uschung: Statt zum Popstar, wie er es sich �<'+'/p><'+'/div>';document.getElementById('termin-1-0').innerHTML='<'+'div class=sendetermine-box-titel>Der Ehe-T�V<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 9<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Earls und Frans Ehelizenz lief aus, ohne dass die beiden es merkten. Um eine Erneuerung zu bekommen, m�ssen die beiden einen Ehe-Test bestehen. Earl scheitert kl�glich und wird von Fran vor die T�r �<'+'/p><'+'/div>';document.getElementById('termin-2-0').innerHTML='<'+'div class=sendetermine-box-titel>Karrieretr�ume<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 8<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat eine Verabredung mit dem Zauberer der Berufe. Der Magier wird ihm sagen, welche Art von Arbeit er ergreifen wird. Robbie erlebt eine Entt�uschung: Statt zum Popstar, wie er es sich �<'+'/p><'+'/div>';document.getElementById('termin-3-0').innerHTML='<'+'div class=sendetermine-box-titel>Der Ehe-T�V<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 9<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Earls und Frans Ehelizenz lief aus, ohne dass die beiden es merkten. Um eine Erneuerung zu bekommen, m�ssen die beiden einen Ehe-Test bestehen. Earl scheitert kl�glich und wird von Fran vor die T�r �<'+'/p><'+'/div>';document.getElementById('termin-4-0').innerHTML='<'+'div class=sendetermine-box-titel>Die erste Anmache<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 10<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat sich ungl�cklich verliebt. Caroline Foxworth, seine Angebete, scheint seine Gef�hle nicht zu erwidern. Alle Ann�herungsversuche scheitern. Und dann scheint sich auch noch Robbies Freund �<'+'/p><'+'/div>';document.getElementById('termin-5-0').innerHTML='<'+'div class=sendetermine-box-titel>Umtausch ausgeschlossen<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 11<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Einen Tag vor Babys erstem Geburtstag entdeckt Charlene, dass auf seinem Nest der Name Molehill, nicht Sinclair steht. Ein Treffen mit den Molehills scheint zu best�tigen, dass die Spr�sslinge der �<'+'/p><'+'/div>';document.getElementById('termin-6-0').innerHTML='<'+'div class=sendetermine-box-titel>Die erste Anmache<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 10<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat sich ungl�cklich verliebt. Caroline Foxworth, seine Angebete, scheint seine Gef�hle nicht zu erwidern. Alle Ann�herungsversuche scheitern. Und dann scheint sich auch noch Robbies Freund �<'+'/p><'+'/div>';document.getElementById('termin-7-0').innerHTML='<'+'div class=sendetermine-box-titel>Umtausch ausgeschlossen<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 11<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Einen Tag vor Babys erstem Geburtstag entdeckt Charlene, dass auf seinem Nest der Name Molehill, nicht Sinclair steht. Ein Treffen mit den Molehills scheint zu best�tigen, dass die Spr�sslinge der �<'+'/p><'+'/div>';document.getElementById('termin-8-0').innerHTML='<'+'div class=sendetermine-box-titel>Das Fest der Liebe<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 12<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Der Feiertag des K�hlschranks steht bevor. Earl hat in Erwartung einer Gratifikation durch die Firma schon Geschenke eingekauft. Aber Richfield streicht das Geld. Die Katastrophe ist perfekt: Der �<'+'/p><'+'/div>';document.getElementById('termin-9-0').innerHTML='<'+'div class=sendetermine-box-titel>Beruf: Baumschubserin<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 13<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Monica wird in Earls Firma als Baumschubserin eingestellt. Sie verursacht dort allerhand Wirbel. Als sie sich weigert, mit dem Vorarbeiter auszugehen, wird sie gefeuert. Monica beruft eine Anh�rung �<'+'/p><'+'/div>';document.getElementById('termin-10-0').innerHTML='<'+'div class=sendetermine-box-titel>Das Fest der Liebe<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 12<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Der Feiertag des K�hlschranks steht bevor. Earl hat in Erwartung einer Gratifikation durch die Firma schon Geschenke eingekauft. Aber Richfield streicht das Geld. Die Katastrophe ist perfekt: Der �<'+'/p><'+'/div>';document.getElementById('termin-11-0').innerHTML='<'+'div class=sendetermine-box-titel>Beruf: Baumschubserin<'+'span style=font-weight:normal;display:block";

		InformationFinderRegex finderRegex = new InformationFinderRegex(conf);
		finderRegex.setText(text);

		Result result = finderRegex.findNextInformation();

		System.out.println(result.getValuesAsStringList().get(0));
		System.out.println(result.getValuesAsStringList().get(1));
		System.out.println(result.getValuesAsStringList().get(2));
		System.out.println(result.getValuesAsStringList().get(3));

		result = finderRegex.findNextInformation();
	}

	@Test
	public void findAllInformation_validInput_InformationFound() {
		String regexAsText = "titel>(.*?)<.*?:4px;>Staffel.([0-9]+)..Folge.([0-9]+?)<.*?<'\\+'p>(.*?)<'\\+'\\/p>";
		int regexGroupCount = 4;

		InformationFinderConfigurationRegex conf = new InformationFinderConfigurationRegex(regexAsText,
				regexGroupCount);

		String text = "$(function() {document.getElementById('termin-0-0').innerHTML='<'+'div ";

		text = "$(function() {document.getElementById('termin-0-0').innerHTML='<'+'div class=sendetermine-box-titel>Karrieretr�ume<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 8<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat eine Verabredung mit dem Zauberer der Berufe. Der Magier wird ihm sagen, welche Art von Arbeit er ergreifen wird. Robbie erlebt eine Entt�uschung: Statt zum Popstar, wie er es sich �<'+'/p><'+'/div>';document.getElementById('termin-1-0').innerHTML='<'+'div class=sendetermine-box-titel>Der Ehe-T�V<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 9<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Earls und Frans Ehelizenz lief aus, ohne dass die beiden es merkten. Um eine Erneuerung zu bekommen, m�ssen die beiden einen Ehe-Test bestehen. Earl scheitert kl�glich und wird von Fran vor die T�r �<'+'/p><'+'/div>';document.getElementById('termin-2-0').innerHTML='<'+'div class=sendetermine-box-titel>Karrieretr�ume<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 8<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat eine Verabredung mit dem Zauberer der Berufe. Der Magier wird ihm sagen, welche Art von Arbeit er ergreifen wird. Robbie erlebt eine Entt�uschung: Statt zum Popstar, wie er es sich �<'+'/p><'+'/div>';document.getElementById('termin-3-0').innerHTML='<'+'div class=sendetermine-box-titel>Der Ehe-T�V<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 9<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Earls und Frans Ehelizenz lief aus, ohne dass die beiden es merkten. Um eine Erneuerung zu bekommen, m�ssen die beiden einen Ehe-Test bestehen. Earl scheitert kl�glich und wird von Fran vor die T�r �<'+'/p><'+'/div>';document.getElementById('termin-4-0').innerHTML='<'+'div class=sendetermine-box-titel>Die erste Anmache<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 10<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat sich ungl�cklich verliebt. Caroline Foxworth, seine Angebete, scheint seine Gef�hle nicht zu erwidern. Alle Ann�herungsversuche scheitern. Und dann scheint sich auch noch Robbies Freund �<'+'/p><'+'/div>';document.getElementById('termin-5-0').innerHTML='<'+'div class=sendetermine-box-titel>Umtausch ausgeschlossen<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 11<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Einen Tag vor Babys erstem Geburtstag entdeckt Charlene, dass auf seinem Nest der Name Molehill, nicht Sinclair steht. Ein Treffen mit den Molehills scheint zu best�tigen, dass die Spr�sslinge der �<'+'/p><'+'/div>';document.getElementById('termin-6-0').innerHTML='<'+'div class=sendetermine-box-titel>Die erste Anmache<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 10<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Robbie hat sich ungl�cklich verliebt. Caroline Foxworth, seine Angebete, scheint seine Gef�hle nicht zu erwidern. Alle Ann�herungsversuche scheitern. Und dann scheint sich auch noch Robbies Freund �<'+'/p><'+'/div>';document.getElementById('termin-7-0').innerHTML='<'+'div class=sendetermine-box-titel>Umtausch ausgeschlossen<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 11<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Einen Tag vor Babys erstem Geburtstag entdeckt Charlene, dass auf seinem Nest der Name Molehill, nicht Sinclair steht. Ein Treffen mit den Molehills scheint zu best�tigen, dass die Spr�sslinge der �<'+'/p><'+'/div>';document.getElementById('termin-8-0').innerHTML='<'+'div class=sendetermine-box-titel>Das Fest der Liebe<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 12<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Der Feiertag des K�hlschranks steht bevor. Earl hat in Erwartung einer Gratifikation durch die Firma schon Geschenke eingekauft. Aber Richfield streicht das Geld. Die Katastrophe ist perfekt: Der �<'+'/p><'+'/div>';document.getElementById('termin-9-0').innerHTML='<'+'div class=sendetermine-box-titel>Beruf: Baumschubserin<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 13<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Monica wird in Earls Firma als Baumschubserin eingestellt. Sie verursacht dort allerhand Wirbel. Als sie sich weigert, mit dem Vorarbeiter auszugehen, wird sie gefeuert. Monica beruft eine Anh�rung �<'+'/p><'+'/div>';document.getElementById('termin-10-0').innerHTML='<'+'div class=sendetermine-box-titel>Das Fest der Liebe<'+'span style=font-weight:normal;display:block;margin-top:4px;>Staffel 2, Folge 12<'+'/span><'+'/div><'+'div class=sendetermine-box-inhalt><'+'p>Der Feiertag des K�hlschranks steht bevor. Earl hat in Erwartung einer Gratifikation durch die Firma schon Geschenke eingekauft. Aber Richfield streicht das Geld. Die Katastrophe ist perfekt: Der �<'+'/p><'+'/div>';document.getElementById('termin-11-0').innerHTML='<'+'div class=sendetermine-box-titel>Beruf: Baumschubserin<'+'span style=font-weight:normal;display:block";

		InformationFinderRegex finderRegex = new InformationFinderRegex(conf);
		finderRegex.setText(text);

		Results results = finderRegex.findAllInformation();

		Iterator<Result> it = results.getIterator();

		int counter = 0;

		while (it.hasNext()) {
			counter++;
			if (counter == 12)
				System.out.println();
			Result result = it.next();
			System.out.println(result.getValuesAsStringList().get(0));
			System.out.println(result.getValuesAsStringList().get(1));
			System.out.println(result.getValuesAsStringList().get(2));
			System.out.println(result.getValuesAsStringList().get(3));
			System.out.println("=========================================================");
		}

	}

}
