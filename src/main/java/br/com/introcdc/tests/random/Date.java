package br.com.introcdc.tests.random;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Date {

	public static Random random = new Random();

	public static void main(String[] args) throws Exception {
		String myDate = "22/01/2019-23:22" + ":" + random.nextInt(60);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		java.util.Date date = sdf.parse(myDate);
		long millis = date.getTime();
		System.out.println(millis);
	}

}
