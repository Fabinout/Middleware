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

package Compilation;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.Result;
import model.SourceFile;





/**
 * 
 * @author Fabien
 *
 */
public class Main {

	//public static final File dir = new File("/home/paul/Documents/code/aca-middleware/MiddleWare2.0/");
	public static final File dir = new File("C:\\Users\\Fabien\\Documents\\Cours\\GS2\\Spring\\Middleware2.0");
	//public static final File dir = new File("C:\\Users\\Lionel\\Desktop\\GS2\\CESSA\\workspace\\Middleware\\MiddleWare2.0");
	
	public static final String classe = "Exercice";
	
	
	
	
	private static void printLines(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(
				new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(name + " " + line);
		}
	}

	private static void runProcess(String command, File dir) throws Exception {
		Process pro = Runtime.getRuntime().exec(command, null, dir );
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}
	
	
	
	

	public static void main(String[] args) {
		
		
		
		
		try {			
			
			//runProcess("cd "+dossierURI);
			System.out.println(dir);
			runProcess("ls");
			//runProcess("javac "+"Exercice.java");
			//runProcess("ls",dir);
			runProcess("javac "+classe+".java");
			System.out.println("compile");
			
			
			
			runProcess("java "+classe);
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Result compile(SourceFile sourceFile) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Result run(SourceFile sourceFile) {
		// TODO Auto-generated method stub
		return null;
	}


}
