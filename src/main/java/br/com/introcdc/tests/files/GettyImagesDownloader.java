package br.com.introcdc.tests.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GettyImagesDownloader {

	public static void main(String[] args) throws Exception {
		int current = 0;
		for (String url : new String[] {
				"https://www.gettyimages.com.br/fotos/melanie-martinez?events=775418978&family=editorial&phrase=melanie%20martinez&sort=best#license",
				"https://www.gettyimages.com.br/fotos/melanie-martinez?events=775418978&family=editorial&page=2&phrase=melanie%20martinez&sort=best#license" }) {

			if (url != "") {
				downloadAllBase(url, String.valueOf(current++));
			}

		}
		System.out.println("PRONTO!");
	}

	public static void downloadAllBase(String url, String folder) throws Exception {
		String infoLine = null;

		System.out
				.println("#" + folder + " Pesquisando linha principal do GettyImages a partir do URL '" + url + "'...");

		URLConnection connection = new URL(url).openConnection();
		connection.addRequestProperty("User-Agent", System.getProperty("userAgent", "Kindome/StaffUser"));
		InputStreamReader input = new InputStreamReader(connection.getInputStream());

		Scanner scanner = new Scanner(input);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			if (line.contains("</gix-custom-date-parameter>")) {
				infoLine = line;
				break;
			}

		}

		scanner.close();

		System.out.println("#" + folder + " linha principal adquirida!");

		if(infoLine == null) {
			System.out.println("Ocorreu um erro ao adquirir a linha principal!");
			return;
		}
		
		boolean first = true;
		for (String line : infoLine.split("/detail/")) {
			if (first) {
				first = false;
				continue;
			}
			String target = line.split("target=")[1].split("\"")[1];

			String urlTarget = "https://www.gettyimages.com.br/detail/" + target + "/";

			File folderFile = new File("C:/Users/intro/Desktop/getty/" + folder + "/");
			if (!folderFile.exists()) {
				folderFile.mkdirs();
			}
			File imageFile = new File(folderFile, target + ".jpg");

			if (imageFile.exists()) {
				continue;
			}

			new Thread(() -> download(urlTarget, target, folder, imageFile)).start();
		}
	}

	public static void download(String url, String file, String folder, File imageFile) {
		try {
			System.out.println("#" + folder + " Processando imagem '" + url + "' com target '" + file + "'...");

			URLConnection connection = new URL(url).openConnection();
			connection.addRequestProperty("User-Agent", System.getProperty("userAgent", "Kindome/StaffUser"));
			InputStreamReader input = new InputStreamReader(connection.getInputStream());

			Scanner scanner = new Scanner(input);

			String imageLine = null;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains("2048x2048")) {
					imageLine = line;
					break;
				}

			}

			scanner.close();

			String imageBase = imageLine
					.split("style=\"background-image: url\\(&#39;https://media.gettyimages.com/photos/")[1];
			String imageUrl = "https://media.gettyimages.com/photos/" + imageBase.split("2048x2048")[0] + "2048x2048";
			System.out.println("#" + folder + " Baixando imagem de URL '" + imageUrl + "'...");

			downloadFile(imageUrl, imageFile);
		} catch (Exception exception) {
			System.out.println("#" + folder + " Ocorreu um erro ao baixar a imagem '" + file + "'...");
		}
	}

	/**
	 * Download file with API Access and Signature
	 */
	static void downloadFile(String URL, File destiny) throws Exception {
		destiny.getParentFile().mkdirs();
		if (!destiny.exists()) {
			destiny.createNewFile();
		}
		URLConnection connection = new URL(URL).openConnection();
		connection.addRequestProperty("User-Agent", System.getProperty("userAgent", "Kindome/IntroCDC"));
		try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
				FileOutputStream fout = new FileOutputStream(destiny)) {
			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}
			fout.flush();
		}
	}

}
