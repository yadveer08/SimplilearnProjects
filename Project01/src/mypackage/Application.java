package mypackage;

import java.util.Scanner;

/* 
 * Application Name: Sasta-Explorer
 * 
 * Developed by: Yadveer Singh
 * 
 */

/*
 * Note: don't remember to give extension with given file name.
 */

public class Application {
	
	private static FileExplorer fileExplorer;
	private static Scanner sc = new Scanner(System.in);
	
	// Methods
	
	// Welcome Heading
	public static void welcomeHead() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|Application: Sasta-Explorer |                     | Developed by: Yadveer |");
		System.out.println("----------------------------------------------------------------------------\n");
	}
	// Main Menu
	public static void printMainMenu() {
		System.out.println("1. Display Files");
		System.out.println("2. Sort Files");
		System.out.println("3. File Operations");
		System.out.println("4. Change Path");
		System.out.println("5. Exit\n");
	}
	// Menu for file operations
	public static void printFileOperationsMenu() {
		System.out.println("1. Create a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		System.out.println("4. Back To Main Menu");
		System.out.println("5. Quit\n");
	}
	
	public static void setPath() {
		System.out.print("Enter Path: ");
		String path = sc.nextLine();
		System.out.println(); // next line
		if( path != null && !path.equals(""))
			fileExplorer.setPath(path);
	}
	public static void changePath() {
		System.out.print("Enter Path: ");
		sc.nextLine(); // to clear stream.
		String path = sc.nextLine();
		System.out.println(); // next line
		if( path != null && !path.equals(""))
			fileExplorer.setPath(path);
		System.out.println("Current Path: "+ path + "\n");
	}
	
	public static void main(String[] args) {
		welcomeHead(); // showing the welcome header
		
		fileExplorer = new FileExplorer();
	    setPath(); // setting path
		
		// Main-Menu.
		label1: while(true) {
			printMainMenu(); // printing Main-menu
			
			System.out.print("Enter Option: ");
			char choice = sc.next().charAt(0);
			System.out.println(); // next line
			switch(choice) {
			case '1': {
				// print all files name
				fileExplorer.printFileNames();
				break;
			}
			case '2': {
				// sort all files
				fileExplorer.sortFiles();
				System.out.println("Sorted.\n");
				break;
			}
			case '3': {
				label2: while (true) {
					printFileOperationsMenu(); // printing operation menu
					System.out.print("Enter Operation: ");
					char ch = sc.next().charAt(0);
					System.out.println(); // next line
					switch (ch) {
					case '1': {
						// create File
						System.out.print("Enter File Name: ");
						sc.nextLine();
						fileExplorer.createFile(sc.nextLine()); // taking input
						break;
					}
					case '2': {
						// Delete File
						System.out.print("Enter File Name: ");
						sc.nextLine();
						fileExplorer.deleteFile(sc.nextLine()); // taking input
						break;
					}
					case '3': {
						//	Search File
						System.out.print("Enter File Name: ");
						sc.nextLine();
						fileExplorer.searchFile(sc.nextLine()); // taking input.
						break;
					}
					case '4': {
						// Back to Main-Menu
						break label2;
					}
					case '5': {
						// Quit
						break label1;
					}
					default:
						System.err.println("Invalid Input!!!");
					}
				}

				break;
			}
			case '4': {
				// change current directory or path
				changePath();
				break;
			}
			case '5': {
				// closing
				System.out.println("Have a Nice Day.\n");
				break label1;
			}
			default:
				System.err.println("Invalid Input!!!");
			}
		}
		sc.close();
	}
}
