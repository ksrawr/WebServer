package configurationReader;

import java.io.IOException;
import java.util.HashMap;

public class MimeTypes extends ConfigurationReader{
	
	private static HashMap<String, String> types;
	
	public MimeTypes( String fileName ) {
		super(fileName);
		types = new HashMap<String, String>();
		try {
			this.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() throws IOException {
		
		while(this.hasMoreLines()) {
			if((this.nextLine() != "") || (this.nextLine().charAt(0) != '#')) {
				String lines[] = this.nextLine().replaceAll("\\s+", " ").split(" ");

				String mime = lines[0];
				for(int i = 1; i < lines.length; i++) {
					MimeTypes.types.put(lines[i], mime); 
				}
			}
		}
	}
	
	public String lookup( String extension ) {
		if( MimeTypes.types.containsKey(extension)) {
			return MimeTypes.types.get(extension);
		}
		else {
			return "text/text";
		}
	}
}
