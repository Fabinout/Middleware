package web;

import model.SourceFile;
import model.SourceFiles;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SourceFilesResource extends ServerResource {

    @Get
    public SourceFiles retrieve() {
        return Server.sourcefiles;
    }

    @Post
    public void store(SourceFile sourcefile) {
    	Server.sourcefiles.set(sourcefile);
    }

}
