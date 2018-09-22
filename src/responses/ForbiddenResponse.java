package responses;

import resource.*;

public class ForbiddenResponse extends Response {

	public ForbiddenResponse( Resource resource ) {
		super( resource, 403 );
		reasonPhrase = "Forbidden";
	}
}