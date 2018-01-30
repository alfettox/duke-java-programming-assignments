package caesar_cipher;

import edu.duke.FileResource;

public class CaesarBreaker {
	
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
	
	public String decrypt(String encrypted){
		CaesarCipher cc = new CaesarCipher();
		int key = getKey(encrypted);
//		System.out.println(key);
		return cc.encrypt(encrypted, 26-key);
	}
	
	public String halfOfString(String message, int start){
		String newMessage = "";
		for(int i = start; i < message.length(); i+=2){
			newMessage += message.charAt(i);
		}
		return newMessage;
	}
	
	public int getKey(String s){
		int freqs[] = countLetters(s);
		int maxIndex = maxIndex(freqs);
		int key = maxIndex - 4; //assuming max freq is letter 'E' (4th index)
		if(maxIndex < 4){
			key = 26 - (4-maxIndex);
		}
		return key;
	}
	
	public String decryptTwoKeys(String encrypted){
		CaesarCipher cc = new CaesarCipher();
		String firstHalf = halfOfString(encrypted, 0);
		String secondHalf = halfOfString(encrypted, 1);
		int firstKey = getKey(firstHalf);
		int secondKey = getKey(secondHalf);
		System.out.println(firstKey + " " + secondKey);
		return cc.encryptTwoKeys(encrypted, 26-firstKey, 26-secondKey);
	}
	
	public void testDecrypt(){
		FileResource fr = new FileResource();
		CaesarCipher cc = new CaesarCipher();
		
		String message = fr.asString();
//		String encrypted = cc.encrypt(message, 15);
//		System.out.println(message);
//		System.out.println(encrypted);
//		System.out.println(decrypt(encrypted));
		
//		String encryptedTwoKeys = cc.encryptTwoKeys(message, 8, 9);
//		System.out.println(message);
//		System.out.println(encryptedTwoKeys);
//		System.out.println(decryptTwoKeys(encryptedTwoKeys));
		
//		System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
//		System.out.println(cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 26-2, 26-20));
		System.out.println(decryptTwoKeys(message));
		
	}
	
	public void testHalfString(){
		FileResource fr = new FileResource();
		String message = fr.asString();
		System.out.println(halfOfString(message, 0));
		System.out.println(halfOfString(message, 1));
		
	}
}
