package br.com.introcdc.tests.phrase;

import java.util.Arrays;
import java.util.List;

public enum VerbType {
	OBJECTS(true, "um", "computador", "teclado", "casa", "sorvete", "lampada", "monitor", "mouse", "mesa", "escada", "tijolo", "bola", "pedra", "celular", "carro", "cama", "rede", "len�ol", "arm�rio", "espelho"),
	FOOD(false, null, "tapioca", "morango", "ma��", "pipoca", "batata frita", "feij�o", "carne", "frango", "porco"),
	DRINK(false, null, "�gua", "refrigerante", "coca-cola", "guaran�", "suco de laranja", "suco de ma��", "suco de manga", "cerveja", "cacha�a"),
	PLACES(true, "pr", "brasil", "nova iorque", "s�o paulo", "rio de janeiro", "china", "estados unidos", "jap�o"),
	;

	private List<String> objects;
	private boolean object;
	private String type;

	VerbType(boolean object, String type, String... objects) {
		this.object = object;
		this.type = type;
		this.objects = Arrays.asList(objects);
	}

	public List<String> getObjects() {
		return objects;
	}

	public boolean isObject() {
		return object;
	}

	public boolean isMale(String object) {
		return object.endsWith("l") || object.endsWith("o")|| object.endsWith("e");
	}
	
	public String getType() {
		return type;
	}

	public String getString(String type) {
		String object = getObjects().get(TextCreator.random.nextInt(getObjects().size()));
		String string = " ";
		if (isObject()) {
			string += type + (isMale(object) ? type.equalsIgnoreCase("um") ? " " : "o " : "a ");
		}
		return string + object;
	}

}
