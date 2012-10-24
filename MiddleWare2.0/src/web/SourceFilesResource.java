package web;

import java.util.List;

import model.SourceFile;
import model.SourceFiles;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SourceFilesResource extends ServerResource {
    private static volatile SourceFiles sourcefiles = new SourceFiles();

    @Get
    public List<SourceFile> retrieve() {
        return sourcefiles;
    }

    @Post
    public void store(SourceFile sourcefile) {
    	sourcefiles.add(sourcefile);
    }

}
