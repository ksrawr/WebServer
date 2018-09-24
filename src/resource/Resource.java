package resource;

import configurationReader.HttpdConf;

public class Resource {
	
	private HttpdConf configuration;
	private String uri;
	private String absolutePath;
	private boolean isScript = false; 
	
	public Resource( String uri, HttpdConf config ) {
		this.uri = uri;
		this.configuration = config;
		
		String[] alias = uri.split("/");

		checkUriAlias( alias, this.configuration );
		checkUriScriptAlias( alias, this.configuration);

		if( isScript() != false ) {
			absolutePath = HttpdConf.scriptAliases.get("DocumentRoot") + alias;	
		} 
		
	}
	
	public String getUri() {
		return this.uri;
	}
	
	public String absolutePath() {
		return this.absolutePath;
	}
	
	public boolean isScript() {
		return this.isScript;
	}
	
	public boolean isProtected() {
		return false; 
	}

	public void checkUriAlias( String[] alias, HttpdConf config ) {
		
		for( String temp : alias ) {
			if( HttpdConf.configOptions.containsKey( "/" + temp + "/" ) ) {
				absolutePath = HttpdConf.aliases.get( "/" + temp + "/");
			}
		}
	}
	
	public void checkUriScriptAlias( String[] alias, HttpdConf config ) {

		for( String temp : alias ) {
			if( HttpdConf.configOptions.containsKey( "/" + temp + "/") ) {
				absolutePath = HttpdConf.scriptAliases.get( "/" + temp + "/");
				this.isScript = true;
			}
		}
	}
}
