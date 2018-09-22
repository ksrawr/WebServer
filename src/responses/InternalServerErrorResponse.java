package responses;

import resource.*;

public class InternalServerErrorResponse extends Response {

	public InternalServerErrorResponse( Resource resource ) {
		super( resource, 500 );
		reasonPhrase = "Internal Server Error"; 
	}
}