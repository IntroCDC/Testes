package br.com.introcdc.tests.phrase;

import java.util.Random;

public class TextCreator {

	public static void main(String[] args) {
		TextCreator textCreator = new TextCreator();
		System.out.println(textCreator.create());
	}

	public static final Random random = new Random(System.currentTimeMillis());

	private static String[] starterPhrases = new String[] { "Você", "Eu" };

	private String getStarterPhrase() {
		return starterPhrases[random.nextInt(starterPhrases.length)];
	}

	public String create() {
		String starter = getStarterPhrase();
		String phrase = starter;
		Verb verb = Verb.getRandomVerb();

		switch (starter) {
		case "Você":
			switch (random.nextInt(3)) {
			case 0:
				phrase += " já " + verb.getYouPast()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			case 1:
				phrase += " está " + verb.getCurrent()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			case 2:
				phrase += " vai " + verb.getFuture()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			default:
				break;
			}
			if (random.nextBoolean()) {
				phrase += "?";
			} else if (random.nextBoolean()) {
				phrase += "!";
			}
			break;

		case "Eu":
			switch (random.nextInt(3)) {
			case 0:
				phrase += " já " + verb.getMePast()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			case 1:
				phrase += " estou " + verb.getCurrent()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			case 2:
				phrase += " vou " + verb.getFuture()
						+ (verb.getVerbType() != null ? verb.getVerbType().getString((verb.getCustomType() != null ? verb.getCustomType(): "") + verb.getVerbType().getType()) : "");
				break;

			default:
				break;
			}

		default:
			break;
		}

		return phrase;
	}

}
