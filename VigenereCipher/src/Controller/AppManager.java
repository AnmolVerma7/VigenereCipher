package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Cipher;
import Model.FileHandler;

/**
 * This class gives the user prompts and does the desired action as given by the user
 * @author Anmol Verma
 */
public class AppManager {
	
	// Scanner takes in user input
	private Scanner input;
	
	// Array List that stores data from text file
	private ArrayList<String> data;
	
	// File Handler object responsible for reading, writing...etc
	private FileHandler fileHandler;
	
	// Choice that the user makes(e or d)
	private String choice = null;
	
	// Name of file to be read
	private String fileName = null;
	
	// Name of new file containing encrypted/decrypted contents
	private String fileOut = null;
	
	// Key needed to encrypt and decrypt content
	private String key = null;
	
	/**
	 * Constructor that instantiates the Scanner and Array List and launches the application
	 * @throws IOException Input/Output Exception
	 */
	public AppManager() throws IOException {
		input = new Scanner(System.in);
		data = new ArrayList<String>();
		launchApplication();
	}
	
	/**
	 * Asks user for choice while doing error handling
	 * @return The choice the user made, "e" or "d"
	 */
	public String askChoice() {
       System.out.print("Welcome to Vigenere Cipher!" + "\n" + "Would you like to encrypt or decrypt? (e/d): ");
       String userInput = input.nextLine().toLowerCase();
       while ((!userInput.equals("e")) && (!userInput.equals("d"))) {
           System.out.print("Invalid choice, try again.\n" + "Would you like to encrypt or decrypt? (e/d): ");
           userInput = input.next();
           input.nextLine();
       }
       return userInput;
	}
	
	/**
	 * Asks user for the name of the file to be read in the "res" folder
	 * @return FileName Name of file put in by user that is going to be scanned
	 */
	public String askFilePath() {
		String fileName  = "res/";
		System.out.print("\nPlease enter filename as \"filename.txt\": ");
		fileName += input.next();
		return fileName;
	}
	
	/**
	 * Asks user for the name of the new file containing new contents
	 * @return FileOut Name of file that will have new content
	 */
	public String askFileNameOut() {
		String fileOut  = "res/";
		System.out.print("\nFile will be saved in res folder, enter file name as \"filename.txt\": ");
		fileOut += input.next();
		return fileOut;
	}
	
	/**
	 * Asks user for the key that is going to be used to encrypt the words
	 * @return Key A key containing one word
	 */
	public String askKey() {
		String key = "";
		System.out.print("\nEnter key: ");
		key = input.next();
		return key;
	}
	
	/**
	 * Is called when AppManager Constructor is called, takes in choice and performs corresponding operation
	 * @throws IOException
	 */
	public void launchApplication() throws IOException {
		choice = askChoice();
		fileName = askFilePath();
		fileOut = askFileNameOut();
		key = askKey();
		fileHandler = new FileHandler(fileName);
		
		switch (choice) {
		case "e":
			encoder(key);
			break;
		case "d":
			decoder(key);
			break;
		}
		
	}
	
	/**
	 * Encodes content in file using key provided by user
	 * @param key Will be used to encrypt file contents
	 * @throws IOException
	 */
	public void encoder(String key) throws IOException {
		// Create encoder object
		Cipher encoder = new Cipher();
		
		// Store file content in ArrayList
		data = fileHandler.getList();
		
		// New list containing encrypted content
		ArrayList<String> encryptedContent = new ArrayList<String>();
		
		// Encrypted word to be added to new list
		String encryptedWord = "";

		// Loop through original ArrayList, encode word, add to new list
		for (String data : data) {
			encryptedWord = encoder.encode(data, key);
			encryptedContent.add(encryptedWord);
		}
		
		// Write to new file provided by user
		fileHandler.writeFile(fileOut, encryptedContent);

	}
	
	public void decoder(String key) throws IOException {
		// Create encoder object
		Cipher decoder = new Cipher();
		
		// Store file content in ArrayList
		data = fileHandler.getList();
		
		// New list containing decrypted content
		ArrayList<String> decryptedContent = new ArrayList<String>();
		
		// Decrypted word to be added to new list
		String decryptedWord = "";

		// Loop through original ArrayList, decode word, add to new list
		for (String data : data) {
			decryptedWord = decoder.decode(data, key);
			decryptedContent.add(decryptedWord);
		}
		
		// Write to new file provided by user
		fileHandler.writeFile(fileOut, decryptedContent);
	}
}
