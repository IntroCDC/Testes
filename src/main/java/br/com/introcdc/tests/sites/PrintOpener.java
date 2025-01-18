package br.com.introcdc.tests.sites;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class PrintOpener {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		Robot robot = new Robot();

		String[] chars = new String[] { "0-0", "1-1", "2-2", "3-3", "4-4", "5-5", "6-6", "7-7", "8-8", "9-9", "a-10",
				"b-11", "c-12", "d-13", "e-14", "f-15", "g-16", "h-17", "i-18", "j-19", "k-20", "l-21", "m-22", "n-23",
				"o-24", "p-25", "q-26", "r-27", "s-28", "t-29", "u-30", "v-31", "w-32", "x-33", "y-34", "z-35" };

		boolean order = false;
		int aStart = 5;
		int bStart = 29;
		int cStart = 33;
		int dStart = 34;
		int eStart = 17;
		int fStart = 15;

		for (int a = aStart; (order ? a > chars.length : a < chars.length);) {
			for (int b = bStart; (order ? b > chars.length : b < chars.length);) {
				for (int c = cStart; (order ? c > chars.length : c < chars.length);) {
					for (int d = dStart; (order ? d > chars.length : d < chars.length);) {
						for (int e = eStart; (order ? e > chars.length : e < chars.length);) {
							for (int f = fStart; (order ? f > chars.length : f < chars.length);) {

								String id = chars[a].split("-")[0] + chars[b].split("-")[0] + chars[c].split("-")[0]
										+ chars[d].split("-")[0] + chars[e].split("-")[0] + chars[f].split("-")[0];

								System.out.println("Trocando para: https://prnt.sc/" + id);
								try {
									Toolkit.getDefaultToolkit().getSystemClipboard()
											.setContents(new StringSelection("https://prnt.sc/" + id), null);

									robot.mousePress(InputEvent.BUTTON1_MASK);
									robot.mouseRelease(InputEvent.BUTTON1_MASK);
									Thread.sleep(50);

									robot.keyPress(KeyEvent.VK_CONTROL);
									robot.keyPress(KeyEvent.VK_V);
									robot.keyRelease(KeyEvent.VK_V);
									robot.keyRelease(KeyEvent.VK_CONTROL);

									Thread.sleep(50);

									robot.keyPress(KeyEvent.VK_ENTER);
									robot.keyRelease(KeyEvent.VK_ENTER);

								} catch (Exception error) {
									System.out.println("error");
								}

								Thread.sleep(1500);

								if (order)
									f++;
								else
									f--;

								if (f < 0) {
									f = 0;
									break;
								}

							}
							if (order)
								e++;
							else
								e--;

							if (e < 0)
								e = 0;
						}
						if (order)
							d++;
						else
							d--;

						if (d < 0)
							d = 0;
					}
					if (order)
						c++;
					else
						c--;

					if (c < 0)
						c = 0;
				}
				if (order)
					b++;
				else
					b--;

				if (b < 0)
					b = 0;
			}
			if (order)
				a++;
			else
				a--;

			if (a < 0)
				a = 0;
		}

		scanner.close();

	}

}
