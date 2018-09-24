package responses;

import request.*;
import resource.*;
import java.io.File;

public class ResponseFactory {
	
	public Response getResponse( Request request, Resource resource) {
		
		File file = new File(resource.absolutePath());

		if( file.exists() ) {

			if( resource.isScript() ) {

			}

			else {

				String verb = request.getVerb();

				if( verb == "GET" )  { 
					return new OKResponse( resource );
				}

				else if ( verb == "HEAD" ) {
					return new OKResponse( resource );
				}

				else if ( verb == "POST" ) {
					return new OKResponse( resource );
				}

				else if ( verb == "PUT" ) {
					return new CreatedResponse( resource );
				}

				else if ( verb == "DELETE" ) {
					return new NoContentResponse( resource );
				}

				else {
					return new BadRequestResponse( resource );
				}
			}

		}
		return new BadRequestResponse( resource );
	}
}
