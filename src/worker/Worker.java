import java.net.Socket;

public class Worker extends Thread {
	
	private Socket client;
	private MimeTypes mimes;
	private HttpdConf config;
	
	public Worker( Socket socket, HttpdConf config, MimeTypes mimes) {
		this.client = socket;
		this.config = config;
		this.mimes = mimes;
	}
	
	public void run() {
		
	}
	
	public void parseRequest() {
		
	}
	
}