package caesar_cipher;

import edu.duke.FileResource;

public class TestCaesarCipherTwo {
	
	private int[] countLetters(String message){
		String alph = "abcdefghijklmnopqrstuvwxyz";
		int[] counts = new int[26];
		for(int k = 0; k < message.length(); k++){
			char ch = Character.toLowerCase(message.charAt(k));
			int dex = alph.indexOf(ch);
			if(dex != -1){
				counts[dex]++;
			}
		}
		return counts;
	}
	
	private int maxIndex(int[] freqs){
		int max = 0;
		int pos = 0;
		for(int i = 0; i < freqs.length; i++){
			if(freqs[i] > max){
				max = freqs[i];
				pos = i;
			}
		}
		return pos;
	}
	
	private String halfOfString(String message, int start){
		String newMessage = "";
		for(int i = start; i < message.length(); i+=2){
			newMessage += message.charAt(i);
		}
		return newMessage;
	}
	
	private String breakCaesarCipher(String input){
		String firstHalf = halfOfString(input, 0);
		String secondHalf = halfOfString(input, 1);
		int[] freqs1 = countLetters(firstHalf);
		int[] freqs2 = countLetters(secondHalf);
		int maxIndex1 = maxIndex(freqs1);
		int maxIndex2 = maxIndex(freqs2);
		int key1 = maxIndex1-4;
		int key2 = maxIndex2-4;
		if(maxIndex1 < 4){
			key1 = 26 - (4-maxIndex1);
		}
		if(maxIndex2 < 4){
			key2 = 26 - (4-maxIndex2);
		}
		
		System.out.println(key1 + " " + key2);
		CaesarCipherTwo cc2 = new CaesarCipherTwo(key1, key2);
		return cc2.decrypt(input);
	}
	
	public void simpleTests(){
		FileResource fr = new FileResource();
		String input = fr.asString();
		CaesarCipherTwo cc2 = new CaesarCipherTwo(17, 3);
		String encrypted = cc2.encrypt(input);
		System.out.println("Encrypted text: \n" + encrypted);
		System.out.println("Decrypted text: \n" + cc2.decrypt(encrypted));
		
		System.out.println("Break Cipher output: \n" + breakCaesarCipher(encrypted));
		
	}
}
