package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import Compilation.Main;

public class SourceFiles extends HashMap<String, SourceFile> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SourceFile set(SourceFile s) {
		File javafile = new File(Main.dir, s.getName() + ".java");
		try {
			FileWriter writer = new FileWriter(javafile);
			writer.write(s.getContent());
			writer.close();
		} catch (IOException e) {
		}
		return super.put(s.getName(), s);
	}
	
	public SourceFile remove(String name) {
		File javafile = new File(Main.dir, name + ".java");
		File classfile = new File(Main.dir, name + ".class");
		javafile.delete();
		classfile.delete();
		return super.remove(name);
	}

}
