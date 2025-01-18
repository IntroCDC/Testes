package br.com.introcdc.tests.files;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

public class FileCreator {

	public static DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(DAY_OF_MONTH, 2)
			.appendLiteral('/').appendValue(MONTH_OF_YEAR, 2).appendLiteral('/')
			.appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD).appendLiteral(" - ").appendValue(HOUR_OF_DAY, 2)
			.appendLiteral(':').appendValue(MINUTE_OF_HOUR, 2).appendLiteral(':').appendValue(SECOND_OF_MINUTE, 2)
			.toFormatter();

	public static String convertToDate(long number) {
		return TIME_FORMATTER.format(Instant.ofEpochMilli(number).atZone(ZoneId.systemDefault()).toLocalDateTime());
	}

	public static void main(String[] args) throws Exception {
		System.out.println(convertToDate(Long.MAX_VALUE));
	}

	public static String convertToBarProgress(long max, long use, int size) {
		double currentHealth = Math.max(use, 0);
		double healthPercentage = currentHealth / max * 100.0D;
		String onSpacer = "*";
		String offSpacer = "-";
		int coloredDisplay = (int) Math.ceil(size * (healthPercentage / 100.0D));
		StringBuilder healthbar = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (coloredDisplay > 0) {
				healthbar.append(onSpacer);
				coloredDisplay--;
			} else {
				healthbar.append(offSpacer);
			}
		}
		healthbar = new StringBuilder("[" + healthbar + "]");
		return healthbar.toString();
	}

	public static int convertToPercent(int current, int max) {
		return max <= 0 ? 0 : current * 100 / max;
	}

}
