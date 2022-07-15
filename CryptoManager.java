/*
 * Class: CMSC203-46519
 * Instructor: Professor Eivazi
 * Assignment #3
 * Description: This application will receive a String from the user and a key of type integer or a word
 * of type string based on the type of encryption and decryption, and will encrypt and decrypt the string
 * Due: 07/14/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Fakhreya Mohammadi
*/


// The CryptoManager class starts here. This class is responsible for several method implementation
// including the stringInBounds, encryptCaesar, encryptBellaso, decryptCaesar, and decryptBellaso.
public class CryptoManager {
	
	
	// Variables are declared and initialized
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	// This method tests whether a string is within bound or not. If it is 
	// within bound, it will return true, otherwise, it will return false
	// It takes a parameter of type String and checks every character in the
	// String.
	
	public static boolean stringInBounds (String plainText) {
		for(int k = 0; k < plainText.length(); k++) {
			if(plainText.charAt(k) < LOWER_BOUND || plainText.charAt(k) > UPPER_BOUND )
				
				// returns false if even one character is not within bound
				return false;
			}
		//Return true, if all characters are within the range
		return true;
		}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	
	// This method will encrypt a string according to the Caesar method. This method 
	// will receive a string and a key from the calling method.
	public static String encryptCaesar(String plainText, int key) {
		
		// declares string variable c
		String c = "";
		for (int j = 0; j < plainText.length(); j++) {
			
			//This operation will shift the character by the given key from the user
			int encryptChar = (int) plainText.charAt(j) + key;
			
			// Tests and makes sure that the string that is encrypted is within bound
			while (encryptChar > (int) UPPER_BOUND) {
				encryptChar -= RANGE;
				}
			c += (char) encryptChar;
			}
		return c; // returns the encrypted string if it is within bound
		}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	// This method will encrypt a string using the Bellaso method. It takes two
	// parameters of type string. 
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		// Variables are declared
		String k = "";
		String encrypt = "";
		int j = 0;
		
		while(k.length()!= plainText.length()) {
			k = k + bellasoStr.charAt(j);
			j++;
			if(j == bellasoStr.length())
				j = 0;
			}
		//Encrypt each character in the plain text
		
		// This for loop will encrypt each character in the text
		for(int i = 0; i < plainText.length(); i++) {
			
			int conclusion = plainText.charAt(i) + k.charAt(i);
			//If the conclusion is not within the bound,
			//the if statement will subtract the RANGE from the conclusion until
			//the conclusion is in the permitted bound
			if(conclusion > UPPER_BOUND) {
				while(conclusion > UPPER_BOUND)
					conclusion = conclusion - RANGE;
				}
			//Add the encrypted character to the encrypted text
			encrypt = encrypt + (char)conclusion;
			}
		// It will return the encrypted text.
		return encrypt;
		}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	// This method takes two parameters one is from the type of string and other from the type of integer
	// it will decrypt a string using the Caesar method
	public static String decryptCaesar(String encryptedText, int key) {
		// variable dC is declared
		String dC = "";
		
		// The for loop will make the changes according to the given value of key
		for (int f = 0; f < encryptedText.length(); f++) {
			//This operation will shift the character by the given key from the user
			int decryptChar = (int) encryptedText.charAt(f) - key;
			// The while loop will make sure that the encryptedChar is with in the bounds.
			// It wil; check every character
			while (decryptChar < (int) LOWER_BOUND) {
				decryptChar += RANGE;
				}
			dC += (char) decryptChar;
			}
		return dC; // returns the decrypted string
		}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	// This method will decrypt a string using the Bellaso method. It takes two parameters of type string
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		// Variables are declared
		String k = "";
		String decrypt = "";
		int m = 0;
		
		while(k.length()!= encryptedText.length())
		{
			k = k + bellasoStr.charAt(m);
			m++;
			
			if(m == bellasoStr.length())
				m = 0;
			}
		//In here the for loop will do the inverse of the encryptBellaso
		for(int n = 0;n < encryptedText.length(); n++)
		{
			int calculation = encryptedText.charAt(n) - k.charAt(n);
			//If the conclusion is not within the bound,
			//the if statement will add the RANGE and the conclusion until
			//the conclusion is in the permitted bound
			if(calculation < LOWER_BOUND)
			{
				while(calculation < LOWER_BOUND)
					
					calculation = calculation + RANGE;
				}
			decrypt = decrypt + (char)calculation;
			}
		//It will return the decrypted string
		return decrypt;
		}
	}
