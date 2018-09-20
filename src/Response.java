import java.io.OutputStream;

public class Response {
	
	int code;
	String reasonPhrase = "";
	Resource resource;
	
	public Response( Resource resource ) {
		this.resource = resource;
	}
	
	public void send ( OutputStream out ) {
		PrintWriter printWriter = new PrintWriter(out, true);
		printWriter.println("HTTP/1.1" + " "  + this.code " " + this.reasonPhrase);
		printWriter.println("Date: "  + new Date());
		printWriter.println("Server: Kenny");
		printWriter.println("Content-Type: " + ); // Need to return resource ContentType
		printWriter.println("Content-Length: " + ); // Need to Return body length
		printWriter.println();
	}
	
}
