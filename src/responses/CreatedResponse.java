package responses;

import resource.*;

public class CreatedResponse extends Response {

	public CreatedResponse ( Resource resource ) {
		super( resource, 201 );
		reasonPhrase = "Created"; 
	}
}