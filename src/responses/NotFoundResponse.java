package responses;

import resource.*;

public class NotFoundResponse extends Response {

	public NotFoundResponse( Resource resource ) {
		super( resource, 404);
		reasonPhrase = "Not Found";
	}
}