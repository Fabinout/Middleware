package web;

import model.SourceFile;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SourceFileResource extends ServerResource {
	@Get
	public SourceFile retrieve() {
		return null;
	}

}
