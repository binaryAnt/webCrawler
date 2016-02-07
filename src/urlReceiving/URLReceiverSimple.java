package urlReceiving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReceiverSimple implements URLReceiver{

	public String getResponseAsText(URL url) throws IOException {
		URLConnection con = url.openConnection();

		InputStream inputStream = con.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
	    BufferedReader bReader = new BufferedReader(inputStreamReader);

	    String inputLine;
	    StringBuilder response = new StringBuilder();
	    while ((inputLine = bReader.readLine()) != null){
	    	response.append(inputLine);
	    }
	    bReader.close();
	    return response.toString();
	}

}
