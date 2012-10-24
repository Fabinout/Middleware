package web;

import model.SourceFiles;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Server {   
	public static volatile SourceFiles sourcefiles = new SourceFiles();


	public static void main(String[] args) throws Exception {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8182);
		component.getDefaultHost().attach("/source", SourceFilesResource.class);
		component.getDefaultHost().attach("/source/{name}", SourceFileResource.class);
		component.getDefaultHost().attach("/source/{name}/compile", CompileResource.class);
		component.getDefaultHost().attach("/source/{name}/run", RunResource.class);
		component.start();
	}

}
