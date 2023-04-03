package mypackage;

import java.io.File;
import java.io.IOException;

public class FileExplorer {
	private String path;
	private int numberOfFiles;
	private File[] files;
	private FileHandler fileHandler;
	
	// Constructors
	public FileExplorer() {// default or non-parameterized constructor
		this.path = "C:\\"; // default path
		this.fileHandler = new FileHandler(); // creating object
	}

	public FileExplorer(String path) { // parameterized constructor
		this.path = path; // setting path
		this.fileHandler = new FileHandler(); // creating object
	}

	// Setter And Getter for path 
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path; // setting path

		this.files = fileHandler.getFiles(path); // setting files
		if (files != null)
			numberOfFiles = this.files.length; // setting number of files
	}

	// Methods
	
	// Printing File Names 
	public void printFileNames() {
		
		this.files = fileHandler.getFiles(path); // updating files
		numberOfFiles = this.files.length; // setting global
		System.out.println("______________________Files________________________");
		if (this.files != null) {
			for (File file : this.files) {
				System.out.println("* "+ file.getName());
			}
			System.out.println("\nTotal Files: " + numberOfFiles);
			System.out.println("___________________________________________________\n");
		}
	}
	
	// Sort Files
	public void sortFiles() {
		fileHandler.sort(files);
	}
	
	// Create File
	public void createFile(String fileName) {
		try {
			fileHandler.createFile(this.path, fileName);
			this.files = fileHandler.getFiles(path); // updating files
			System.out.println("\nFile Created.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Delete File
	public void deleteFile(String fileName) {
		try {
			boolean check = fileHandler.deleteFile(path, fileName);
			if(check) {  //returns Boolean value  
				this.files = fileHandler.getFiles(path); // updating files
				System.out.println("\nFile deleted.\n");   //getting and printing the file name  
			}  
			else  {  
				System.out.println("\nFailed.\n");  
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Search File
	public void searchFile(String fileName) {
		String[] filesName = fileHandler.getFilesName(files);
		int result = fileHandler.binarySearch(filesName, fileName);
		if (result != -1) System.out.println("\nFile Found at: "+path + fileName+".\n");
		else System.out.println("\nFile Not Found.\n");
	}
}
