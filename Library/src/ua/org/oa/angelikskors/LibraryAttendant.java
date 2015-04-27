package ua.org.oa.angelikskors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryAttendant {

	public static void main(String[] args) {
		File tmpFile = new File("libBase1.txt");

		try {
			FileWriter writer = new FileWriter(tmpFile, true);
			System.out.println(tmpFile.getAbsolutePath());
			readFileReader(tmpFile);
			writeIntoFile(tmpFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readFileReader(File f) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(f));
		String str = null;
		String[] massiveStr;
		while ((str = bf.readLine()) != null) {
			int k = 0;
			k++;
			massiveStr = str.trim().split("\\;");
			if (k < massiveStr.length) {
				String author = massiveStr[0];
				String name = massiveStr[1];
				int year = Integer.valueOf(massiveStr[2].trim());
				LibraryString listStr = new LibraryString(author, name, year);
				ArrayList<LibraryString> newList = new ArrayList<>();
				newList.add(listStr);
				for (LibraryString string : newList) {
					System.out.println("АВТОР: " + string.getAuthor()
							+ " НАЗВАНИЕ: " + string.getName() + " ГОД:  "
							+ string.getYear());
				}

			}
		}

		bf.close();
	}

	public static void writeIntoFile(File f) {
		Pattern p = Pattern.compile("[0-9]");

		try {

			String str;
			String str1;
			String str2;
			String str3;
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					System.in));
			FileWriter writer = new FileWriter(f, true);
			BufferedWriter df = new BufferedWriter(writer);

			System.out.println("Введите Фамилию имя автора");

			str1 = bf.readLine();

			df.newLine();
			df.write(str1 + ";");
			System.out.println("Введите название произведения");
			str2 = bf.readLine();

			df.write(str2 + ";");
			System.out.println("Введите год");
			str3 = bf.readLine();

			df.write(str3 + ";");

			df.flush();
			df.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
