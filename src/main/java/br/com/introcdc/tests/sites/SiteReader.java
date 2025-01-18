package br.com.introcdc.tests.sites;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SiteReader {

	public static int prontos = 0;

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando...");
		for (int i = 126; i <= 126; i++) {
			System.out.println("Processando imagem #" + i);
			URLConnection connection = new URL(
					"http://melaniemartinez.com.br/galeria/displayimage.php?pid=" + i + "&fullsize=1").openConnection();
			connection.addRequestProperty("User-Agent", System.getProperty("userAgent", "Kindome/IntroCDC"));
			Scanner scanner = new Scanner(connection.getInputStream());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
				if (line.contains("<img src=\"")) {
					line = line.replace("<a href=\"javascript: window.close()\"><img src=\"", "");
					line = line.split("\"")[0];
					String URL = "http://melaniemartinez.com.br/galeria/" + line;
					int I = i;
					new Thread(() -> {
						System.out.println("Baixando imagem #" + I);
						try {
							download(URL, "download-" + I + ".png");
							System.out.println("Download da imagem #" + I + " concluido!");
							prontos++;
							if (prontos == 125) {
								System.err.println("PRONTO!");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}).start();
				}
			}
			scanner.close();
		}
	}

	public static void download(String URL, String fileName) throws Exception {
		File destiny = new File("C:/Users/intro/Desktop/fotos/" + fileName);
		destiny.getParentFile().mkdirs();
		if (!destiny.exists()) {
			destiny.createNewFile();
		}
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try {
			URLConnection connection = new URL(URL).openConnection();
			connection.addRequestProperty("User-Agent", System.getProperty("userAgent", "Kindome/IntroCDC"));
			in = new BufferedInputStream(connection.getInputStream());
			fout = new FileOutputStream(destiny);

			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
			fout.flush();
		} finally {
			if (in != null) {
				in.close();
			}
			if (fout != null) {
				fout.close();
			}
		}
	}

}
