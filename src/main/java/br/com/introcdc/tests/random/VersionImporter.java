package br.com.introcdc.tests.random;

import java.io.File;

public class VersionImporter {

	public static void main(String[] args) {
		for (File file : new File("C:\\Users\\intro\\Desktop\\versions").listFiles()) {
			System.out.println(file.getName());
			if (!file.getName().contains("w")) {
				continue;
			}
			String name = file.getName().split("\\.")[0];
			File folder = new File("C:\\Users\\intro\\AppData\\Roaming\\.minecraft\\versions\\" + name);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			file.renameTo(new File(folder, file.getName()));
			System.out.println("Pronto! " + file.getName());
		}
		System.out.println("Pronto total!");
	}

}
