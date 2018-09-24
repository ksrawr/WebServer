package configurationReader;

public class Htaccess extends ConfigurationReader {
	Htpassword userFile;
	String authFile;
	String authName;
	String require;
	String fileName;
	
	public Htaccess( String fileName ) {
		super( fileName );
		this.load();
	}
	
	public void load() {
		
	}
	
	public boolean isAuthorized( String username, String password ) {
		return false;
	}
}
