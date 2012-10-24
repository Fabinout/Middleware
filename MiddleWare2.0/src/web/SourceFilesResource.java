package web;

import java.util.List;

import model.SourceFile;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import util.Factory;

public class SourceFilesResource extends ServerResource {
    private static volatile List<SourceFile> sourcefiles = Factory.createList();

    @Get
    public List<SourceFile> retrieve() {
        return sourcefiles;
    }

    @Post
    public void store(SourceFile sourcefile) {
    	sourcefiles.add(sourcefile);
    }

}
