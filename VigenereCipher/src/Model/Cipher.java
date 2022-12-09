package Model;

/**
 * This class is where all encoding and decoding is done
 * @author Anmol Verma
 */
public class Cipher {
	
	/**
	 * This method encodes a word using the key 
	 * @param word To be encoded
	 * @param key That will be used to encode the word
	 * @return Encrypted word using the formula
	 */
	public String encode(String word, String key) {
		String encryptedText = "";
		for (int i = 0, j = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c < 'a' || c > 'z') {
				encryptedText += c;
			}
			else {
				char enc = (char) ((c + key.charAt(j) - (2 * 'a')) % 26 + 'a');
				encryptedText += enc;
				j = ++j % key.length();
			}
		}
		return encryptedText;
	}

	/**
	 * This method decodes a word using the same that was used for encoding
	 * @param word To be decoded
	 * @param key That was used to encode the word
	 * @return Decoded word using the formulas
 	 */
	public String decode(String word, String key) {
		String decryptedText = "";
	    for (int i = 0, j = 0; i < word.length(); i++) {
	    	char c = word.charAt(i);
	        if (c < 'a' || c > 'z') {
	        	decryptedText += c;
	        }
	        else {
	        	char dec = (char)((c - key.charAt(j) + 26 ) % 26 + 'a');
	            decryptedText += dec;
	            j = ++j % key.length();
	        }
        }
	    return decryptedText;
	}
}
