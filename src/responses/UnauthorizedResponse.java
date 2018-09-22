package responses;

import resource.*;

public class UnauthorizedResponse extends Response {

	public UnauthorizedResponse( Resource resource ) {
		super( resource, 401 );
		reasonPhrase = "Unauthorized access";
	}
}