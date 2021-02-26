package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileIO {
	private static File myFile = new File("student.txt");
	
	public static void writeStudent(String name) throws IOException {
		//Open the file
		try (PrintWriter writer = new PrintWriter(new FileWriter(myFile, true))){
			writer.println(name);
		} 
	}
	
	public static Object[] readStudents() throws IOException {
		Scanner scanner = new Scanner(myFile);
		//String[] names = new String[10];
		ArrayList<String> names = new ArrayList<String>();

		while(scanner.hasNext()) {
			String name = scanner.nextLine();
			names.add(name);
		}
		scanner.close();
		return names.toArray();
	}
}
