import java.net.ServerSocket;
import java.util.HashMap;

public class Server {

	private HttpdConf configuration;
	private MimeTypes mimeTypes;
	private ServerSocket socket;
	private HashMap<String, String> accessFiles;
	
	public void start() {
		configuration = new HttpdConf("conf/httpd.conf");
		mimeTypes = new MimeTypes("conf/mime.types");

		socket = new ServerSocket(Integer.parseInt(this.configuration.configOptions.get("Listen"));
		Socket connection = null;

		while( true ) {
			connection = socket.accept();
			//Worker worker = new Worker();
			connection.close();
		}
	}

	public static void main( String[] args ) {
		Server server = new Server();
		server.start();
	}

}
