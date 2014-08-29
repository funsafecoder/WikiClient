package userInterface;

<<<<<<< HEAD
import java.util.Scanner;

import dataLayer.Querying;

public class Main {
=======
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import dataLayer.LinkQuerier;
import dataLayer.Page;
import dataLayer.Querying;

public class Main {
	
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
	public static void main(String[] args) {
		menu();
	}

<<<<<<< HEAD
	public static void menu() {
		Querying query = new Querying();
=======

	private static LinkQuerier linkQuerier =  new LinkQuerier();
	private static Querying query = new Querying();
	
	public static void menu() {
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
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
<<<<<<< HEAD
				System.out.println(query.getPageByTitle(title));
=======
//				Page page = query.getPageByTitle(title);
				Page page = new Page("Battle of Waterloo", "This is leet hax to test");
				System.out.println(page);
				PageMenu(page, scan);
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
			} else if (choice == 2) {
				System.out.println("Enter keyword");
				String keyword = scan.nextLine();
				query.getPagesByKeyword(keyword);
<<<<<<< HEAD
			} else {
				System.out.println("Please chose a valid number");
			}
		}
=======
			} else if (choice != 0){
				System.out.println("Please chose a valid number");
			}
		}
		
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
		scan.close();
		quit();
	}

	public static void quit() {
		System.out.println("Goodbye");
	}
<<<<<<< HEAD
}
=======
	
	public static void PageMenu(Page page, Scanner scan){
		int choice = 0;
		String pageTitle = page.getPageTitle().replaceAll(" ", "_");
//		System.out.println(pageTitle);
		
		System.out.println("0: Go to Main menu");
		System.out.println("1: Get links on this page");
		System.out.println("2: Get pages that link to this page");
		
		choice = scan.nextInt();
		
		if (choice == 1){
			ArrayList<String> links = linkQuerier.getLinksOnPage(pageTitle);
			
			for (int i = 0; i < links.size(); i++){
				System.out.println(i + 1 + ": " + links.get(i));
			}
			
			System.out.println("\nChoose a page to go to or enter 0 to go back to the current page.");
			choice = scan.nextInt();
			
			if(choice > 0 && choice < links.size())
			{
//				page = query.getPageByTitle(links.get(choice - 1));
				page = new Page("Hello", "Page intended for testing");
				System.out.println(page);
			}
			
			PageMenu(page, scan);
		} else if (choice == 2){
			ArrayList<String> pages = linkQuerier.getLinksToPage(pageTitle);
			
			for (int i = 0; i < pages.size(); i++){
				System.out.println(i + 1 + ": " + pages.get(i));
			}
			
			System.out.println("\nChoose a page to go to or enter 0 to go back to the current page.");
			choice = scan.nextInt();
			
			if(choice > 0 && choice < pages.size())
			{
//				page = query.getPageByTitle(links.get(choice - 1));
				page = new Page("Hello", "Page intended for testing");
				System.out.println(page);
			}
			
			PageMenu(page, scan);
		}
	}
}
 
>>>>>>> 33d03b1fab5366170f49a71068a7fbcc5acccb65
