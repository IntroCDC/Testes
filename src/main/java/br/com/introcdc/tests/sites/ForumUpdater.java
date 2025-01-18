package br.com.introcdc.tests.sites;

import java.awt.Desktop;
import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ForumUpdater {

	public static int topicsAmount = 2315;
	public static Random random = new Random();
	public static List<Integer> hasDone = new ArrayList<>();
	public static String fileName = "hasDone.txt";

	public static void main(String[] args) throws Exception {
		System.out.println("Carregando tópicos já atualizados...");
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			try {
				hasDone.add(Integer.parseInt(scanner.nextLine()));
			} catch (Exception ignored) {
			}
		}
		scanner.close();

		System.out.println("Iniciando programa...");
		PrintWriter writer = new PrintWriter(file);
		Scanner console = new Scanner(System.in);
		
		for(int done : hasDone) {
			writer.println(done);
			writer.flush();
		}

		while (hasDone.size() != topicsAmount) {
			System.out.println("Selecionando novo tópico...");
			int topicNumber = (random.nextInt(topicsAmount) + 1);
			int times = 1;

			while (hasDone.contains(topicNumber)) {
				if (random.nextBoolean()) {
					topicNumber += times;
				} else {
					topicNumber -= times;
				}
				times++;
				if (topicNumber <= 0) {
					topicNumber = topicsAmount;
				}
				if (topicNumber >= (topicsAmount + 1)) {
					topicNumber = 1;
				}
			}

			System.out.println("Tópico Selecionado: " + topicNumber);
			Desktop.getDesktop().browse(new URI("http://forum.introcdc.com.br:8080/topic/" + topicNumber + "-topico/?do=edit"));
			
			System.out.print("Atualizado? (Digite OK): ");
			String result = console.nextLine();
			if(result.equalsIgnoreCase("OK") || result.equalsIgnoreCase("O")) {
				hasDone.add(topicNumber);
				writer.println(topicNumber);
				writer.flush();
				System.out.println("Tópico atualizado!\n");
			}
			// Runtime.getRuntime().exec("cmd /c taskkill /f /IM chrome.exe");
			// Thread.sleep(500);
		}

		writer.close();
		console.close();
		System.out.println("PRONTO! VOCÊ TERMINOU DE ATUALIZAR O FÓRUM!");

	}

}
