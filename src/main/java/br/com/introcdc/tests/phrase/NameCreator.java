package br.com.introcdc.tests.phrase;

import java.util.Random;

public class NameCreator {

	public static Random random = new Random();

	public static String[] vogais = new String[] { "a", "e", "i", "o", "u", "ão" };
	public static String[] consoantes = new String[] { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "qu",
			"r", "s", "t", "v", "x", "z" };

	public static void main(String[] args) {
		StringBuilder name = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			name.append(consoantes[random.nextInt(consoantes.length)]).append(vogais[random.nextInt(vogais.length)]);
		}
		System.out.println(name.toString());
	}

}
