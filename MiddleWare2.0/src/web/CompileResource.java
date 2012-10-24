package web;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class CompileResource extends ServerResource {
	@Get
	public String compile() {
		return "";
	}

}
