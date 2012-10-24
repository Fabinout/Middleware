package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Compilation.Main;

public class SourceFiles extends ArrayList<SourceFile> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(SourceFile s) {
		File javafile = new File(Main.dir, s.getName() + ".java");
		try {
			FileWriter writer = new FileWriter(javafile);
			writer.write(s.getContent());
			writer.close();
		} catch (IOException e) {
		}
		return super.add(s);
	}
	
	public boolean remove(SourceFile s) {
		File javafile = new File(Main.dir, s.getName() + ".java");
		File classfile = new File(Main.dir, s.getName() + ".class");
		javafile.delete();
		classfile.delete();
		return super.remove(s);
	}

}
