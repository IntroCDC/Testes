package br.com.introcdc.tests.random;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.common.io.Files;

import javazoom.jl.player.Player;

public class AutoCopy {

	public static List<String> copied = new ArrayList<>();
	public static long tests = 0;

	public static void main(String[] args) throws Exception {
		if(Boolean.TRUE) {
			check();
		} else {
			copy();
		}
	}

	public static void check() throws Exception {
		System.out.println("Iniciando...");

		List<String> check = new ArrayList<>();
		Scanner checkScanner = new Scanner(new File("C:/Users/intro/Desktop/check.txt"));

		System.out.println("Carregando base...");
		String base = Files.asCharSource(new File("C:/Users/intro/Desktop/base.sql"), StandardCharsets.UTF_8).read();

		System.out.println("Carregando check...");
		while (checkScanner.hasNextLine()) {
			check.add(checkScanner.nextLine());
		}

		checkScanner.close();

		System.out.println("Verificando linhas...");
		// List<String> fault = new ArrayList<>();
		Set<String> found = new HashSet<>();

		for (String url : check) {
			tests++;
			if (tests % 1000 == 0) {
				System.out.println("Testes efetuados: " + tests);
			}

			if (base.contains(url)) {
				found.add(url);
			}
		}

		System.out.println("Verificação finalizada!");

		for (String url : check) {
			if (!found.contains(url)) {
				System.out.println("Faltando: http://youtu.be/" + url);				
			}
		}

	}

	public static void copy() throws Exception {
		File destiny = new File("C:/Users/intro/Desktop/copy.txt");
		PrintWriter writer = new PrintWriter(destiny);
		File mp3File = new File("F:\\Musicas\\teste.mp3");
		while (Boolean.TRUE) {
			Thread.sleep(100);
			String message = "ERROR";
			try {
				message = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			} catch (Exception ignored) {
			}
			if (!copied.contains(message)) {
				copied.add(message);
				writer.println(message);
				writer.flush();
				System.out.println("Copiado: " + message);
				MP3Musica musica = new MP3Musica();
				musica.tocar(mp3File);
				musica.start();
			}
		}
		writer.close();
	}

	public static class MP3Musica extends Thread {

		private File mp3;
		private Player player;

		public void tocar(File mp3) {
			this.mp3 = mp3;
		}

		public void run() {
			try {
				FileInputStream fis = new FileInputStream(mp3);
				BufferedInputStream bis = new BufferedInputStream(fis);
				this.player = new Player(bis);
				this.player.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
