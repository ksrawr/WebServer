package responses;

import resource.*;

public class NoContentResponse extends Response {

	public NoContentResponse ( Resource resource ) {
		super( resource, 204 );
		reasonPhrase = "No Content"; 
	}
}