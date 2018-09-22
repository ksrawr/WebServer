package responses;

import resource.*;

public class NotModified extends Response {

	public NotModified ( Resource resource ) {
		super( resource , 304 );
		reasonPhrase = "Not Modified";
	}
}