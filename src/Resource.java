
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
			absolutePath = this.config.scriptAliases.get("DocumentRoot") + alias;	
		} 
		
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
		
		for( string temp : alias ) {
			if( this.config.configOptions.containsKey( "/" + alias + "/" ) ) {
				absolutePath = this.config.aliases.get( "/" + alias + "/");
			}
		}
	}
	
	public void checkUriScriptAlias( String[] alias, HttpdConf config ) {

		for( string temp : alias ) {
			if( this.config.configtOptions.containsKey( "/" + alias + "/") ) {
				absolutePath = this.config.scriptAliases.get( "/" + alias + "/");
				this.isScript = true;
			}
		}
	}
}
