package mypackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

	// Methods

	// File Operations

	// to get the array of files
	public File[] getFiles(String path) {
		File file = new File(path);
		return file.listFiles();
	}
	// to getFile
	public File getFile(File[] files, String fileName) {
		for (File file : files) {
			if (file.getName() == fileName)
				return file;
		}
		return null;
	}
	// get file names in a array
	public String[] getFilesName(File[] files) {
		String[] filesName = new String[files.length];
		// storing all files name
		for (int i = 0; i < filesName.length; i++) {
			filesName[i] = files[i].getName(); // storing name
		}
		return filesName;
	}

	// create file
	public void createFile(String path, String fileName) throws IOException {
		Path filePath = Paths.get(path + "\\" + fileName); // creates Path instance
		Files.createFile(filePath); // creates file at specified location
	}

	// delete file
	public boolean deleteFile(String path, String fileName) throws Exception{
		File f= new File(path + "\\" + fileName);           //file to be delete  
		return f.delete();
	}

	// Search Operation
	
	// Binary Search
    public int binarySearch(String[] fileNames, String targetFile)
    {
        int l = 0, r = fileNames.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
 
            int res = targetFile.compareTo(fileNames[mid]);
 
            // Check if targetFile is present at mid
            if (res == 0)
                return mid;
 
            // If targetFile greater, ignore left half
            if (res > 0)
                l = mid + 1;
 
            // If targetFile is smaller, ignore right half
            else
                r = mid - 1;
        }
        // returns -1 if fileName not found.
        return -1;
    }

	// Sort Operation

	// using quick sort to sort the files
	void sort(File[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		// calling quick sort
		quickSort(array, 0, array.length - 1);
	}

	// main Quick sort method
	void quickSort(File[] array, int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		// take pivot, here we need the name of the file so, using .getName() method
		String pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2].getName();
		while (i <= j) {
			// comparing the names using .getName() method
			// and compareToIngoreCase method we are comparing file with file at pivot
			while (array[i].getName().compareTo(pivot) < 0) {
				i++;
			}
			while (array[j].getName().compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {
				// swap files with respect to i and j
				swap(array, i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			// sorting left half
			quickSort(array, lowerIndex, j);
		}
		if (i < higherIndex) {
			// sorting right half
			quickSort(array, i, higherIndex);
		}
	}

	// Swapping the files
	void swap(File[] array, int i, int j) {
		File temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
