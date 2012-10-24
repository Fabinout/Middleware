package web;

import model.SourceFile;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class Client {

    /**
     * @param args
     * @throws ResourceException
     */
    public static void main(String[] args) throws Exception {

        ClientResource cr = new ClientResource("http://localhost:8182/source");

        // Add a source file
        SourceFile s = new SourceFile();
        s.setName("exemple");
        s.setContent("class Exemple {" +
        		"public void main (String[] args) {" +
        		"System.out.println(\"test\");" +
        		"}" +
        		"}");
        cr.post(s);
        
        
       
    }

}
