package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryFileIO {
	private static File myFile = new File("student.txt");
	
	public static void writeStudent(String name) throws IOException {
		try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(myFile, true))){
			dOut.writeUTF(name);
		} 
	}
	
	public static Object[] readStudents() throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		try(DataInputStream dIn = new DataInputStream(new FileInputStream(myFile))) {
			while(dIn.available() > 0)
				names.add(dIn.readUTF());
		}
		return names.toArray();
	}
}
