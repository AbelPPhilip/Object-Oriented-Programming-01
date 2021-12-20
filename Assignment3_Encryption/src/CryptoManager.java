/**
 * 
 * @author abelp
 * @Date 10/11/2021
 * @Instructor Ahmed Tarek
 * @Class CMSC 203 
 * @Descrip This is a cipher creating program that encrypts and decrypts various string literals. Once used in the military, ciphering various 
 * are a great coding practice to understand the methods and algorithms. In this assignment we also included GUI and JUNIt testing to understand how 
 * the code runs. 
 *
 */
public class CryptoManager {//Beginning of DataManager Class
	//Final Variables
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {//Method to make sure that the string is within the bounds. 
		for (int i = 0;i<plainText.length();i++) {
			if(plainText.charAt(i)<LOWER_BOUND || plainText.charAt(i)>UPPER_BOUND) {
				return false;//returns false if the string does not fall within the boundaries
			}
		}
		return true;
	}//end of stringinBounds Method

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		if (stringInBounds(plainText)) {
			while (key>UPPER_BOUND) {//As long as Key is higher than the range, it will decrease 
				key-=RANGE; 
			}
			String encryption = "";//The main string to hold encrypted message
			char [] letters = plainText.toCharArray();//converts string into an array of Char
			for (int i = 0; i<letters.length; i++) {//for loop to iterate through the array
				int sum = letters[i]+key;
				while (sum>UPPER_BOUND) {
					sum-=RANGE;
				}
				System.out.println(sum);
				letters[i]=(char)sum;
				
			}
			
			for (char i : letters) {//for each loop to fill the encryption string literal 
				encryption+=String.valueOf(i);
			}
			return encryption; 
			
		}
		throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		if (stringInBounds(plainText)&&stringInBounds(bellasoStr)) {
			char[] bellasoLetters = bellasoStr.toCharArray();//Array of bellaso word used as an offset 
			char[] encryptLetters = plainText.toCharArray();//array of provided string array
			String encryption= "";
			int bellasoCounter = 0;//control variable 
			for (int i = 0; i<encryptLetters.length;i++) {//controls the iteration through the both arrays
				int sum = encryptLetters[i] + bellasoLetters[bellasoCounter];//shifts the char position according to the offset
				while (sum>UPPER_BOUND) {//while the sum of the char is greater than the range the sum will be decreased. 
					sum-=RANGE;
				}
				bellasoCounter++;
				if (bellasoCounter ==bellasoLetters.length ) {
					bellasoCounter=0;
				}
				encryptLetters[i]= (char) sum;
			}
			for (char i : encryptLetters) {
				encryption+=String.valueOf(i);
			}
	        return encryption;
		}
		throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		if (stringInBounds(encryptedText)) {//received the encrypted text to make sure it is within the range
			while (key>UPPER_BOUND) {
				key-=RANGE; 
			}
			String encryption = "";
			char [] letters = encryptedText.toCharArray();
			for (int i = 0; i<letters.length; i++) {
				int sum = letters[i]-key;
				while (sum<LOWER_BOUND) {//as long as the sum is lower than the lower bound the sum will be increased
					sum+=RANGE;
				}
				System.out.println(sum);
				letters[i]=(char)sum;
				
			}
			
			for (char i : letters) {//for each loop to fill the decrypted message
				encryption+=String.valueOf(i);
			}
			return encryption; 
			
		}
		
		throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		if (stringInBounds(encryptedText)&&stringInBounds(bellasoStr)) {
			char[] bellasoLetters = bellasoStr.toCharArray();//char array of bellaso word
			char[] encryptLetters = encryptedText.toCharArray();//char array of encrypted provided word 
			String encryption= "";
			int bellasoCounter = 0; //control variable
			for (int i = 0; i<encryptLetters.length;i++) {//iterative loop through both arrays
				int sum = encryptLetters[i] - bellasoLetters[bellasoCounter];
				while (sum<LOWER_BOUND) {
					sum+=RANGE;//as long as the sum is lower than the lower boundary, the sum will be increased 
				}
				bellasoCounter++;
				if (bellasoCounter ==bellasoLetters.length ) {
					bellasoCounter=0;//resets the bellaso index
				}
				encryptLetters[i]= (char) sum;
			}
			for (char i : encryptLetters) {//for each loop 
				encryption+=String.valueOf(i);
			}
	        return encryption;
		}
		throw new RuntimeException("method not implemented");
	}//end of decrypt bellaso method
}//end of class 