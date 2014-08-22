package userInterface;

import java.util.Scanner;

import dataLayer.Querying;

public class Main {
	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		Querying query = new Querying();
		Scanner scan = new Scanner(System.in);
		int choice = 1;
		while (choice != 0) {
			System.out.println("Please select an option");
			System.out.println("0) Quit");
			System.out.println("1) Get Page By Title");
			System.out.println("2) get Pages By Keyword");
			choice = scan.nextInt();
			scan.nextLine();
			if (choice == 1) {
				System.out.println("Enter title");
				String title = scan.nextLine();
				System.out.println(query.getPageByTitle(title));
			} else if (choice == 2) {
				System.out.println("Enter keyword");
				String keyword = scan.nextLine();
				query.getPagesByKeyword(keyword);
			} else {
				System.out.println("Please chose a valid number");
			}
		}
		scan.close();
		quit();
	}

	public static void quit() {
		System.out.println("Goodbye");
	}
}
