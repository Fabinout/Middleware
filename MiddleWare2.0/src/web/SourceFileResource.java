package web;

import model.SourceFile;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class SourceFileResource extends ServerResource {
	@Get
	public SourceFile retrieve() {
		String name = (String) getRequest().getAttributes().get("name");
		return Server.sourcefiles.get(name);
	}
	
	@Put
	public void update(SourceFile sourcefile) {
		String name = (String) getRequest().getAttributes().get("name");
		Server.sourcefiles.remove(name);
		Server.sourcefiles.set(sourcefile);
	}
	
	@Delete
	public void remove() {
		String name = (String) getRequest().getAttributes().get("name");
		Server.sourcefiles.remove(name);
	}

}
