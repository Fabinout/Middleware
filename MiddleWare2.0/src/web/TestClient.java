package web;

import java.io.File;
import java.io.FileReader;

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
		FileReader rs = new FileReader(new File(Main.dir,"Exercice.java)"));
		char[] bs = new char[8];

	}

}
