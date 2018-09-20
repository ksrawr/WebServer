import java.util.HashMap;
import java.util.stream.Stream;

public class Request {

	private String uri = "";
	private String body = "";
	private String verb = "";
	private String httpVersion = "";
	private HashMap<String,String> headers;
	private String requestString = "";
	private boolean RequestParseValid = true;

	public Request( String test ) {
		this.requestString = test;
	}

	public Request( Stream client) {
		while ( client.iterator().hasNext() ) {
			requestString += client.iterator().toString();
		}
	}

	public void parse() {
		String[] lines = requestString.split("(\r\n|\r|\n)", -1);
		
		String[] requestLine = lines[0].split("\\s+");
		
		if( (requestLine.length == 3) && ((requestLine[0] == "GET") || (requestLine[0] == "HEAD") || (requestLine[0] == "POST") || (requestLine[0] == "PUT") || (requestLine[0] == "DELETE"))) {
			verb = requestLine[0];
			uri = requestLine[1];
			httpVersion = requestLine[2];
			
			for (int i = 1; i < (lines.length - 1); i++) {
				String[] requestHeaders = lines[i].split(": ");
				headers.put(requestHeaders[0], requestHeaders[1]);
			}
		}
		else {
			this.RequestParseValid = false;
		}	
	}
	
	public String getURI() {
		return this.uri;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public String getHttpVersion() {
		return this.httpVersion;
	}
	
	public HashMap<String, String> getHeaders() {
		return this.headers;
	}
	
	public boolean getRequestParseStatus() {
		return this.RequestParseValid;
	}
}