package responses;

import resource.*;

public class OKResponse extends Response {

	public OKResponse( Resource resource ) {
		super( resource, 200 );
		reasonPhrase = "OK";
	}
}