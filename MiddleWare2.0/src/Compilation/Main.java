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
import model.SourceFiles;





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
	
	
	

	private static String printLines(InputStream ins) throws Exception {
		String line = null;
		String toReturn= new String("");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			toReturn += (" " + line+"\n");
		}
		
		return toReturn;
	}


	private static Result runProcess(String command) throws Exception {
		Result myResult = new Result();
		File dir = new File(SourceFiles.uploadDir);
		Process pro = Runtime.getRuntime().exec(command, null, dir);
		myResult.setOut(printLines(pro.getInputStream()));
		myResult.setErr(printLines(pro.getErrorStream()));
		pro.waitFor();
		myResult.setRc(pro.exitValue());
		
		return myResult;
	}
	
	
	
	

	public static void main(String[] args) {
		
		
		
		
		try {			
			
			//runProcess("cd "+dossierURI);
			System.out.println(runProcess("ls"));
			System.out.println(runProcess("javac Exercice.java"));
			System.out.println(runProcess("java Exercice"));
			
			//runProcess("java "+classe);
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Result compile(String string) {
		Result myResult=null;
		
		try {
			myResult=runProcess("javac "+string+".java");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return myResult;
		
	}

	public static Result run(String string) {

		Result myResult=null;
		
		try {
			myResult=runProcess("java "+string);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return myResult;
		
	}


}
