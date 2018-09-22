package responses;

import resource.*;

public class BadRequestResponse extends Response {

	public BadRequestResponse ( Resource resource ) {
		super( resource, 400 );
		reasonPhrase = "Bad Request";
	}
}