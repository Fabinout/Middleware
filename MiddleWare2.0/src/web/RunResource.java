package web;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RunResource extends ServerResource {
	@Get
	public String run() {
		return "";
	}

}
