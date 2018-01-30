package caesar_cipher;

import edu.duke.FileResource;

public class TestCaesarCipher {
	
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
	
	public void simpleTests(){
		FileResource fr = new FileResource();
		String input = fr.asString();
		CaesarCipher cc = new CaesarCipher(18);
		String encrypted = cc.encrypt(input);
		System.out.println("Encrypted text: \n" + encrypted);
		System.out.println("Decrypted text: \n" + cc.decrypt(encrypted));
		
		System.out.println("Break Cipher output: \n" + breakCaesarCipher(encrypted));
	}
	
	private String breakCaesarCipher(String input){
		int freqs[] = countLetters(input);
		int maxIndex = maxIndex(freqs);
		int key = maxIndex - 4; //assuming max freq is letter 'E' (4th index)
		if(maxIndex < 4){
			key = 26 - (4-maxIndex);
		}
		CaesarCipher cc = new CaesarCipher(key);
		return cc.decrypt(input);
	}
	
	
}
