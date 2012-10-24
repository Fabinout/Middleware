/*
 * Copyright 2012 Lionel Bécuwe, Paul Blouët, Fabien Lamarque, Frédéric Lucas
 *
 * This file is part of aca-middleware.
 *
 * aca-middleware is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aca-middleware is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with aca-middleware.  If not, see <http://www.gnu.org/licenses/>.
 */
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
