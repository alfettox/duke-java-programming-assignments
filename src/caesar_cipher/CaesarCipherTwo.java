package caesar_cipher;

public class CaesarCipherTwo {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int key1;
	private int key2;
	
	public CaesarCipherTwo(int key1, int key2){
		this.key1 = key1;
		this.key2 = key2;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
		shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
	}
	
	public String encrypt(String input){
		
		StringBuilder encrypted = new StringBuilder(input);
		
		for(int i = 0; i < encrypted.length(); i++) {	
			Character currChar = encrypted.charAt(i);
			boolean lowerCase = false;
			int idx = -1;
			if(Character.isLowerCase(currChar)){
				lowerCase = true;
				idx = alphabet.indexOf(Character.toUpperCase(currChar));
			} else {
				idx = alphabet.indexOf(currChar);
			}

			if(idx != -1){
				char newChar = 'a';
				if(i %2 == 0){
					newChar = shiftedAlphabet1.charAt(idx);
				} else {
					newChar = shiftedAlphabet2.charAt(idx);
				}
				if(lowerCase){
					newChar = Character.toLowerCase(newChar);
				}            	
				encrypted.setCharAt(i, newChar);
			}    
		}

		return encrypted.toString();
	}
	
	public String decrypt(String input){
		
		CaesarCipherTwo cc = new CaesarCipherTwo(26-key1, 26-key2);
		return cc.encrypt(input);
		
	}
	
}
