package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for (int i = 0; i < base64Chars.length; i++) {
			if (base64Chars[i] == c) {
				return ((byte) i);
			}
		}
		return -1;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		int [] fourChars = {convertBase64Char(s.charAt(0)), convertBase64Char(s.charAt(1)), convertBase64Char(s.charAt(2)), convertBase64Char(s.charAt(3))};
		int baseTenTotal = 0;
		for (int i = 0; i < fourChars.length; i++) {
			baseTenTotal += (fourChars[3-i]*(Math.pow(64, i)));
		}
		
		String binaryVersion = convertDecimalToBinary(baseTenTotal);
		for (int i = 0; i < binaryVersion.length()%24 ; i++) {
			binaryVersion = "0" + binaryVersion;
		}
		byte [] finalBytes = new byte [3];
		int index = 0;
		for (int i = 0; i < binaryVersion.length() ; i+=8) {
			String subString = binaryVersion.substring(i, i+8);
			System.out.println(subString);
			int totalForIndex = 0;
			for (int j = 0; j < 8; j++) {
				totalForIndex += (Integer.parseInt(subString.substring(7-j, 8-j))*(Math.pow(2, j)));
			}
			finalBytes[index] = (byte) totalForIndex;
			//if (subString.charAt(0) == '1') {
			//	finalBytes[index] += 256;
			//}
			index++;
		}
		System.out.println(binaryVersion);
		System.out.println(finalBytes[0]);
		System.out.println(finalBytes[1]);
		System.out.println(finalBytes[2]);
		System.out.println("");
		return finalBytes;
	}
	public static String convertDecimalToBinary(int decimalNum) {
        String binaryStr = "";
    
        do {
            // 1. Logical right shift by 1
            int quotient = decimalNum >> 1;
            // 2. Check remainder and add '1' or '0'
            if( decimalNum % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            decimalNum = quotient;
            
        // 3. Repeat until number is 0
        } while( decimalNum != 0 );
         
        return binaryStr;
    }
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		return null;
	}
	public static void main(String[] args) {
		convert4CharsTo24Bits("////");
	}
}
