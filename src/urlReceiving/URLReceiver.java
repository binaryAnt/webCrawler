package urlReceiving;

import java.io.IOException;
import java.net.URL;

public interface URLReceiver {

	public String getResponseAsText(URL url) throws IOException;
	
}
