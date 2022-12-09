package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class manages all file related functions, existence, reading, writing, and printing data
 * @author Anmol Verma
 */
public class FileHandler {

	// Scanner Object
	private Scanner fileReader;
	
	// File to be read from
	private File file;
	
	// Stores data in ArrayList
	private ArrayList<String> dataList;
	
	/**
	 * Constructor for FileHandler Object
	 * @param FILE_PATH Name of file to be scanned
	 * @throws FileNotFoundException If file is not Found
	 */
	public FileHandler(String FILE_PATH) throws FileNotFoundException {
		file = new File(FILE_PATH);
		dataList = new ArrayList<String>();
		checkIfFileExists();
		readFile();
	}
	
	/**
	 * Checks if file exists, if it doesn't prints error message and exists program
	 */
	private void checkIfFileExists() {
		try {
			fileReader = new Scanner(file);
		}
		catch (Exception e) {
			System.out.println("File does not exist.");
			System.exit(0);
		}
	}

	/**
	 * Reads words from file into Array List
	 */
	public void readFile() {
		dataList.clear();
		String word = null;
		while(fileReader.hasNext()) {
			word = fileReader.next().replaceAll("\\p{Punct}", "").toLowerCase().trim();
			dataList.add(word);
		}
		fileReader.close();
	}
	
	/**
	 * Write file into the file given by the user, when line limit is reached, a new line is made
	 * @throws IOException 
	 */
	public void writeFile(String newFile , ArrayList<String> E_D_List) throws IOException {
     	FileWriter fw = new FileWriter(newFile);
        ArrayList<String> temp = E_D_List;
        int lineLimit = 0;
        for (String data : temp) {
        	if (lineLimit <= 8) {
        		fw.write(data + " ");
            	++lineLimit;
        	}
        	else {
        		fw.write("\n");
        		fw.write(data + " ");
            	lineLimit = 0;
        	}
        	
        }            
        fw.close();
	}
	
	/**
	 * Gets the list from this object
	 * @return ArrayList that contains words from file
	 */
	public ArrayList<String> getList() {
		return dataList;
	}
	
	/**
	 * Prints ArrayList containing words that were read from the file
	 */
	public void printList() {
		for (Object data : dataList) {
			System.out.print(data + " ");
		}
	}
}
