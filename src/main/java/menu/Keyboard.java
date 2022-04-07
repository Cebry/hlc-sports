package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {
	private static Scanner sc = null;

	private static Scanner getScanner() {
		if (sc == null)
			sc = new Scanner(System.in);
		return sc;
	}

	public static int getInt(String label) {
		System.out.printf("write the %s:\t", label);
		int integer = 0;
		do {
			try {
				integer = Keyboard.getScanner().nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERROR. Introduce un entero.");
			}
			Keyboard.getScanner().nextLine();
			return integer;
		} while (true);
	}

	public static String getString(String label) {
		System.out.printf("write the %s:\t", label);
		return Keyboard.getScanner().nextLine();
	}

	public static float getFloat(String label) {
		System.out.printf("write the %s:\t", label);
		while (true) {
			try {
				return sc.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("ERROR. Write a float number.");
				Keyboard.getScanner().nextLine();
			}
		}
	}

	public static boolean getBoolean(String label) {
		System.out.printf("%s[Y/n]:\t", label);
		char c = Keyboard.getScanner().next().charAt(0);
		Keyboard.getScanner().nextLine();
		if (c == 'n')
			return false;
		else
			return true;
	}

	public static Date getDate(String label) {

		System.out.printf("write the %s (dd/mm/yyyy):\n", label);

		while (true) {
			try {
				return new SimpleDateFormat("dd/MM/yyyy").parse(Keyboard.getScanner().next());
			} catch (ParseException e) {
				System.err.println("ERROR. Write a date with dd/MM/yyyy format.");
				Keyboard.getScanner().nextLine();
			}
		}
	}

	public static void close() {
		Keyboard.getScanner().close();
	}
}
