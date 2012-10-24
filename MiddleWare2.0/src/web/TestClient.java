package web;

import java.io.File;
import java.io.FileReader;
import java.nio.CharBuffer;

import model.SourceFile;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import Compilation.Main;

public class TestClient {

    /**
     * @param args
     * @throws ResourceException
     */
    public static void main(String[] args) throws Exception {

        ClientResource cr = new ClientResource("http://localhost:8182/source");

        // Add a source file
        SourceFile s = new SourceFile();
        s.setName("exemple");
        FileReader rs = new FileReader(new File(Main.dir, "/src/Compilation/Exercice.java)"));
        char[] bs = new char[8];
        
        
        // Retrieve a representation
        Customer customer = cr.get(Customer.class);
        System.out.println(customer);

        // Update the target resource
        customer.setName("John");
        cr.put(customer);

        // Retrieve the updated version
        customer = cr.get(Customer.class);
        System.out.println(customer);
    }

}
