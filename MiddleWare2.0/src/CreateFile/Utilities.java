package CreateFile;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utilities {
	
	
	
	
	private static void writeJavaFile(String fileContent, String filePathOutput) {
		try {

			FileWriter fileWriter = new FileWriter(filePathOutput+".java", false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(fileContent);

			bufferedWriter.flush();
			bufferedWriter.close();
			System.out.println("Fichier créé");
		} catch (IOException ioe) {
			System.err
			.println("Erreur levée de type IOException au niveau de la méthode "
					+ "writeFile(...) : ");
			ioe.printStackTrace();
		}
	}

	public static void readFile(String filePathInput, String filePathOutput) {

		Scanner scanner = null;
		String line = null;
		StringBuffer str = new StringBuffer();
		try {
			scanner = new Scanner(new File(filePathInput));

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();

				if (line != null)
					str.append(line + "\r\n");
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Erreur levée de type FileNotFoundException"
					+ " au niveau de la méthode " + "readFile(...) : ");
			e.printStackTrace();
		}

		Utilities.writeJavaFile(str.toString(), filePathOutput);
	}

	public static void formatSQLFileContentToIntegrateThisInTheJAVACode(
			String filePathInput, String filePathOutput) {

		Scanner scanner = null;
		String line = null;
		StringBuffer str = new StringBuffer();
		try {
			scanner = new Scanner(new File(filePathInput));

			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();

				if (line != null)
					str.append(".append(\"" + line + " \")\r\n");
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.err
			.println("Erreur levée de type FileNotFoundException"
					+ " au niveau de la méthode "
					+ "formatSQLFileContentToIntegrateThisInTheJAVACode(...) : ");
			e.printStackTrace();
		}

		Utilities.writeJavaFile(str.toString(), filePathOutput);
	}
}