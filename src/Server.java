import configurationReader.HttpdConf;
import configurationReader.MimeTypes;
import worker.Worker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

	private HttpdConf configuration;
	private MimeTypes mimeTypes;
	private ServerSocket socket;
	private HashMap<String, String> accessFiles;
	private Socket connection = null;
	
	public void start() {
		try {
			configuration = new HttpdConf("conf/httpd.conf");
			mimeTypes = new MimeTypes("conf/mime.types");

			socket = new ServerSocket(Integer.parseInt(HttpdConf.getConfigOptions().get("Listen")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		while( true ) {
			try {
				connection = socket.accept();
				Worker worker = new Worker( this.connection, this.configuration, this.mimeTypes );
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main( String[] args ) {
		Server server = new Server();
		server.start();
	}

}
