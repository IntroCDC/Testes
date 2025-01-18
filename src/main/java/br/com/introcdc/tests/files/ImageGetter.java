package br.com.introcdc.tests.files;

import java.io.File;

public class ImageGetter {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando...");
		for (File image : new File("F:\\Imagens\\Samsung J8").listFiles()) {
			if (image.isFile() && image.getName().contains("IMG_")) {
				image.renameTo(new File(image.getParentFile(), image.getName().replace("IMG_", "")));
			}
		}
		System.out.println("Pronto!");
	}

}
