package br.com.introcdc.tests.random;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import br.com.introcdc.tests.database.FileComponents;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.Mp3File;

public class OtherTestes {

	public static int total = 0;

	public static Random random = new Random();

	public static String folder = "F:/Musicas/Músicas Locais/Carreta Treme Treme/";
	public static File folderDestiny = new File(folder);

	public static void main(String[] args) throws Exception {
		System.out.println("Deletando músicas...");
		for (File file : folderDestiny.listFiles()) {
			FileComponents.deleteFile(file.toPath());
		}
		System.out.println("Deletadas!");
		for (File file : new File("F:/Musicas/Carreta Treme Treme/").listFiles()) {
			if (!file.getName().toLowerCase().endsWith(".mp3")) {
				continue;
			}
			try {
				prepareToChangeProperties(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i : amount.keySet()) {
			System.out.println(i + " kbps: " + amount.get(i));
		}
		System.exit(0);
	}

	public static void prepareToChangeProperties(File file) throws Exception {
		System.out.println("Editando '" + file.getName() + "'");

		String name = file.getName().replace(".mp3", "");
		
		String author = "Unknown";
		String title = "";
		String ft = "";

		if (name.contains(" -")) {
			author = name.split(" -")[0];
		}
		while(author.endsWith(" ")) {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < (author.length() - 1); i++) {
				builder.append(author.toCharArray()[i]);
			}
			author = builder.toString();
		}

		if (name.contains("- ") && name.split("- ").length > 1) {
			title = name.split("- ")[1];
		} else {
			title = name;
		}
		while(title.endsWith(" ")) {
			StringBuilder builder = new StringBuilder();
			for(int i = 0; i < (title.length() - 1); i++) {
				builder.append(title.toCharArray()[i]);
			}
			title = builder.toString();
		}

		if (title.contains("(") && title.split("\\(").length > 1) {
			ft = title.split("\\(")[1];
			ft = ft.replace(")", "");
			ft = ft.replace("ft. ", "");
			ft = ft.replace("ft.", "");
			
			title = title.split(" \\(")[0];
		}

		changePropeties(file, folderDestiny, author, ft, title, null, 0);
	}

	public static HashMap<Integer, Integer> amount = new HashMap<>();

	public static void info(File file) throws Exception {
		Mp3File mp3file = new Mp3File(file.getAbsolutePath());
		if (file.getName().contains("Melanie")) {
			System.out.println(file.getName() + " - " + mp3file.getBitrate());
		}
		if (!amount.containsKey(mp3file.getBitrate())) {
			amount.put(mp3file.getBitrate(), 0);
		}
		amount.replace(mp3file.getBitrate(), amount.get(mp3file.getBitrate()) + 1);
	}

	public static void changePropeties(File file, File folderDestiny, String author, String ft, String title, String album, int year)
			throws Exception {
		System.out.println("Alterando propriedades de '" + file.getName() + "'");
		total++;
		Mp3File mp3file = new Mp3File(file.getAbsolutePath());
		ID3v1 id3v1Tag;
		if (mp3file.hasId3v1Tag()) {
			id3v1Tag = mp3file.getId3v1Tag();
		} else {
			id3v1Tag = new ID3v1Tag();
			mp3file.setId3v1Tag(id3v1Tag);
		}
		id3v1Tag.setTrack(String.valueOf(total));
		String totalAuthor = author;
		if (!ft.isEmpty()) {
			for (String ftt : ft.split(";")) {
				totalAuthor += ";" + ftt;
			}
		}
		id3v1Tag.setArtist(totalAuthor);
		id3v1Tag.setTitle(title);
		id3v1Tag.setAlbum(album);
		id3v1Tag.setYear(year != 0 ? String.valueOf(year)
				: id3v1Tag.getYear() != null ? String.valueOf(random.nextInt(2019) + 1)
						: String.valueOf(random.nextInt(2019) + 1));
		id3v1Tag.setGenre(id3v1Tag.getGenre() != 0 ? random.nextInt(30) : id3v1Tag.getGenre());
		id3v1Tag.setComment("IntroCDC render");
		System.out.println(id3v1Tag.getTrack() + " - '" + id3v1Tag.getArtist() + "' - '" + id3v1Tag.getTitle() + "' - '"
				+ (author + " - " + title + (ft.isEmpty() ? "" : " (ft. " + ft.replace(";", ", ") + ")")) + "' - '"
				+ id3v1Tag.getAlbum() + "' - '" + id3v1Tag.getYear() + "' - '" + id3v1Tag.getGenre() + "' - '"
				+ id3v1Tag.getComment() + "'");
		mp3file.save(folderDestiny.getAbsolutePath() + "/" + author + " - " + title + (ft.isEmpty() ? "" : " (ft. " + ft.replace(";", ", ") + ")") + ".mp3");
	}

}
