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

				}

				if ( verb == "HEAD" ) {

				}

				if ( verb == "POST" ) {

				}

				if ( verb == "PUT" ) {

				}

				if ( verb == "DELETE" ) {
					
				}
			}

		}
	}
}
