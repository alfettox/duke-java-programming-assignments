package caesar_cipher;

import edu.duke.FileResource;

public class CaesarCipher {
	
	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;
	
	public CaesarCipher(){}
	
	public CaesarCipher(int key){
		mainKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
	}
	
	//OO Version
	public String encrypt(String input) {
	
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
				char newChar = shiftedAlphabet.charAt(idx);
				if(lowerCase){
					newChar = Character.toLowerCase(newChar);
				}            	
				encrypted.setCharAt(i, newChar);
			}    
		}
    
    	return encrypted.toString();
	}
	
	public String decrypt(String input){
		CaesarCipher cc = new CaesarCipher(26-mainKey);
		return cc.encrypt(input);
	}
	
	//old version
	public String encrypt(String input, int key) {
		
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        
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
            	char newChar = shiftedAlphabet.charAt(idx);
            	if(lowerCase){
            		newChar = Character.toLowerCase(newChar);
            	}            	
            	encrypted.setCharAt(i, newChar);
            }    
        }
        
        return encrypted.toString();
    }
	
	public String encryptTwoKeys(String input, int key1, int key2) {

		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
		String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);

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
	
    public void testCaesar() {
//        int key = 17;
//        FileResource fr = new FileResource();
//        String message = fr.asString();
//        String encrypted = encrypt(message, key);
//        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key);
//        System.out.println(decrypted);
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8, 21));
    }
    
}
