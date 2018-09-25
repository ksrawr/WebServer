package configurationReader;

import java.io.IOException;
import java.util.HashMap;

public class HttpdConf extends ConfigurationReader {
	
	static HashMap<String, String> aliases;
	static HashMap<String, String> scriptAliases;
	static HashMap<String, String> configOptions;
	
	
	public HttpdConf( String fileName ) throws IOException {
		super(fileName);
		aliases = new HashMap<String, String>();
		scriptAliases = new HashMap<String, String>();
		configOptions = new HashMap<String, String>();
		this.load();
	}
	
	public void load() throws IOException { 
		
		while(this.hasMoreLines()) {
			//System.out.println("line: " + this.nextLine());
			if((this.nextLine() != "") && ( this.nextLine().charAt(0) != '#' )) {
				String[] lines = this.nextLine().split(" ");
								
				String key = lines[0];
				String value = lines[1];
				
				if(key == "Alias") {
					key = lines[1];
					value = lines[2];
					HttpdConf.aliases.put(key, value);
				} else if(key == "ScriptAlias") {
					key = lines[1];
					value = lines[2];
					HttpdConf.scriptAliases.put(key, value);
				} else {
					HttpdConf.configOptions.put(key, value);
				}
			}

			this.loadDefault();

		}
		
	}

	public void loadDefault() {
		if( HttpdConf.configOptions.get("Listen") == null ) {
			HttpdConf.configOptions.put("Listen", "8080");
		}
		if( HttpdConf.configOptions.get("LogFile") == null ) {
			HttpdConf.configOptions.put("LogFile", "");
		} 
		if( HttpdConf.configOptions.get("AccessFile") == null ) {
			HttpdConf.configOptions.put("AccessFile", ".htacess");
		}
		if( HttpdConf.configOptions.get("DirectoryIndex") == null ) {
			HttpdConf.configOptions.put("DirectoryIndex", "index.html");
		}
	}
	
	public static HashMap<String, String> getAliases() {
		return HttpdConf.aliases;
	}
	
	public static HashMap<String, String> getScriptAliases() {
		return HttpdConf.scriptAliases;
	}
	
	public static HashMap<String, String> getConfigOptions() {
		return HttpdConf.configOptions;
	}
}
