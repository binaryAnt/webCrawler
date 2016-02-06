package webCrawlerURLReceiver;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Test;

public class URLReceiverSimpleTest {
	
	@Test
	public void getResponseAsText_validUrl_noException() throws Exception {
		URL sampleUrl = new URL("http://www.fernsehserien.de/full-house-1987/sendetermine/-1");

		new URLReceiverSimple().getResponseAsText(sampleUrl);
	}
	
	@Test
	public void getResponseAsText_validUrl_stringNotNull() throws Exception {
		URL sampleUrl = new URL("http://www.fernsehserien.de/full-house-1987/sendetermine/-1");

		URLReceiverSimple urlReceiverSimple = new URLReceiverSimple();
		String response = urlReceiverSimple.getResponseAsText(sampleUrl);
		assertNotNull(response);
	}
	
	@Test
	public void getResponseAsText_validUrl_stringNotEmpty() throws Exception {
		URL sampleUrl = new URL("http://www.fernsehserien.de/full-house-1987/sendetermine/-1");
		String emptyString = "";
		URLReceiverSimple urlReceiverSimple = new URLReceiverSimple();
		String response = urlReceiverSimple.getResponseAsText(sampleUrl);
		assertNotEquals(emptyString, response);
		System.out.println(response);
	}	
	
}
