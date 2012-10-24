package web;

import java.util.List;

import model.SourceFile;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SourceFilesResource extends ServerResource {

    @Get
    public List<SourceFile> retrieve() {
        return Server.sourcefiles;
    }

    @Post
    public void store(SourceFile sourcefile) {
    	Server.sourcefiles.add(sourcefile);
    }

}
