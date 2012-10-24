package Compilation;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;





/**
 * 
 * @author Fabien
 *
 */
public class Main {

	
	
	
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
	
	
	

	public static void main(String[] args) {
		
		String dossierURI = "C:\\Users\\Fabien\\Documents\\Cours\\GS2\\Spring\\Middleware2.0\\src\\Compilation\\";
		String dossierURIBin="C:\\Users\\Fabien\\Documents\\Cours\\GS2\\Spring\\Middleware2.0\\bin\\Compilation\\";
		String nomClasse = "Exercice";

		String[] envp = null;
		File dir = new File("C:\\Users\\Fabien\\Documents\\Cours\\GS2\\Spring\\Middleware2.0");
		
		try {			
			
			//runProcess("cd "+dossierURI);
			System.out.println(dir);
			//runProcess("ls");
			//runProcess("javac "+"Exercice.java");
			runProcess("ls",dir);
			runProcess("javac "+"Exercice.java",dir);
			System.out.println("compilation fonctionne");
			
			
			
			runProcess("java "+"Exercice", dir);
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
