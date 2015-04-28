package ua.org.oa.angelikskors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LibraryAttendant {

	public static void main(String[] args) {
		File tmpFile = new File("libBase1.txt");
		try {
			System.out.println(tmpFile.getAbsolutePath());
			readFile(tmpFile);
			writeIntoFile(tmpFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readFile(File f) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(f));
		LibraryStringFormatter formatter = new LibraryStringFormatter();
		ArrayList<LibraryString> books = new ArrayList<LibraryString>();

		String str = null;
		while ((str = bf.readLine()) != null) {
			LibraryString libraryString = formatter.parse(str);
			if (libraryString != null) {
				books.add(libraryString);
			}
		}

		bf.close();

		for (LibraryString string : books) {
			System.out.println("�����: " + string.getAuthor()
					+ " ��������: " + string.getName() + " ���:  "
					+ string.getYear());
		}
	}

    public static void writeIntoFile(File f) throws IOException{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			FileWriter writer = new FileWriter(f, true);
			BufferedWriter df = new BufferedWriter(writer);

            LibraryStringFormatter formatter = new LibraryStringFormatter();
            String line = null;
			while ((line = bf.readLine())!= null){
                LibraryString libraryString = formatter.parse(line);
                if(libraryString != null){
                    System.out.println("parsed " + libraryString);
                    df.write(formatter.format(libraryString));
                    df.flush();
                }else {
                    System.out.println("input finished");
                    break;
                }
            }
			df.close();

	}
}
