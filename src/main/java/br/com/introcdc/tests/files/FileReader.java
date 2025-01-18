package br.com.introcdc.tests.files;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) throws Exception {

		System.out.println("Lendo...");
		File from = new File("C:/Users/intro/Desktop/proxys.txt");
		List<String> lines = new ArrayList<>();
		
		List<String> already = new ArrayList<>();
		Scanner scanner = new Scanner(from);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String IP;
			if (line.split(":").length > 1) {
				IP = line.split(":")[0];
			} else {
				IP = line;
			}
			if(!already.contains(IP)) {
				already.add(IP);
				lines.add(IP);
			}
		}
		scanner.close();

		System.out.println("Registrando...");

		File to = new File("C:/Users/intro/Desktop/proxys-formatted.txt");

		PrintWriter writer = new PrintWriter(to);
		for (String line : lines) {
			writer.println(line);
		}
		writer.close();

		System.out.println("Pronto!");

	}

}
