package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public int option = -1;
	public Scanner sc = new Scanner(System.in);

	public ArrayList<Option> options = new ArrayList<Option>();

	public Menu(ArrayList<Option> options) {
		this.options = options;
		options.add(new Option("Exit", Menu::exit));
	}

	public void exec() {
		while (true) {
			this.printMenu();
			this.getOption();
			System.out.println();
			System.out.println();
			System.out.println(options.get(option - 1).getName());
			System.out.println();
			options.get(option - 1).getMethod().run();
			System.out.println();
			System.out.println();
		}
	}

	public void printMenu() {
		System.out.println("MENÚ");

		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ". " + options.get(i).getName());
		}
	}

	public void getOption() {
		do {
			option = Keyboard.getInt("option");
		} while (option > options.size() || option < 1);
	}

	public static void exit() {
		Keyboard.close();
		System.exit(0);
	}
}