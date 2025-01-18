package br.com.introcdc.tests.phrase;

import java.util.ArrayList;
import java.util.List;

public enum Verb {
	VIAJAR("viajei", "viajando", "viajou", VerbType.PLACES, null),
	ANDAR("andei", "andando", "andou", null, null),
	COMER("comi", "comendo", "comeu", VerbType.FOOD, null),
	BEBER("bebi", "bebendo", "bebeu", VerbType.DRINK, null),
	CORRER("corri", "correndo", "correu", null, null),
	RASTEJAR("rastejei", "rastejando", "rastejou", VerbType.PLACES, null),
	CHEIRAR("cheirei", "cheirando", "cheirou", VerbType.OBJECTS, null),
	SENTIR("senti", "sentindo", "sentiu", VerbType.OBJECTS, null),
	PEDIR("pedi", "pedindo", "pediu", VerbType.OBJECTS, null),
	COMPRAR("comprei", "comprando", "comprou", VerbType.OBJECTS, null),
	RESERVAR("reservei", "reservando", "reservou", VerbType.OBJECTS, null),
	ALUGAR("aluguei", "alugando", "alugou", VerbType.OBJECTS, null),
	FINANCIAR("financiei", "financiando", "financiei", VerbType.OBJECTS, null),
	ESMAGAR("esmaguei", "esmagando", "esmagou", VerbType.OBJECTS, null),
	CONSERTAR("consertei", "consertando", "consertou", VerbType.OBJECTS, null),
	QUEBRAR("quebrei", "quebrando", "quebrou", VerbType.OBJECTS, null),
	BRINCAR("brinquei", "brincando", "brincou", VerbType.OBJECTS, " com "),
	JOGAR("joguei", "jogando", "jogou", null, null),
	DEITAR("deitei", "deitando", "deitou", null, null),
	SENTAR("sentei", "sentando", "sentou", null, null),
	TECLAR("teclei", "teclando", "teclou", null, null),
	MORDER("mordi", "mordendo", "mordeu", VerbType.FOOD, "um"),
	AMASSAR("amassei", "amassando", "amassou", VerbType.FOOD, "um"),
	CONFIGURAR("configurei", "configurando", "configurou", null, null),
	PROGRAMAR("programei", "programando", "programou", null, null),
	LAVAR("lavei", "lavando", "lavou", null, null),
	LEVAR("levei", "levando", "levou", null, null),
	DIRIGIR("dirigi", "dirigindo", "dirigiu", null, null),
	DORMIR("dormi", "dormindo", "dormiu", null, null),
	ACORDAR("acordei", "acordando", "acordou", null, null),
	SONHAR("sonhei", "sonhando", "sonhou", null, null),;

	private String mePast, current, future, youPast;
	private VerbType verbType;
	private String customType;

	Verb(String mePast, String current, String youPast, VerbType verbType, String customType) {
		this.mePast = mePast;
		this.current = current;
		this.future = toString().toLowerCase();
		this.youPast = youPast;
		this.verbType = verbType;
		this.customType = customType;
	}

	public String getMePast() {
		return mePast;
	}

	public String getCurrent() {
		return current;
	}

	public String getFuture() {
		return future;
	}

	public String getYouPast() {
		return youPast;
	}

	public VerbType getVerbType() {
		return verbType;
	}

	public String getCustomType() {
		return customType;
	}

	public static Verb getRandomVerb() {
		List<Verb> verbs = new ArrayList<>();
		for (Verb verb : values()) {
			verbs.add(verb);
		}
		return verbs.get(TextCreator.random.nextInt(verbs.size()));
	}

}
