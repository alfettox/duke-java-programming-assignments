package caesar_cipher;

public class WordPlay {
	
	private boolean isVowel(Character ch){
		ch = Character.toLowerCase(ch);
		return (ch.equals('a')||
				ch.equals('e')||
				ch.equals('i')||
				ch.equals('o')||
				ch.equals('u'));
	}
	
	private String replaceVowels(String phrase, Character ch){
		String newPhrase = "";
		for(int i = 0; i < phrase.length(); i++){
			Character currentChar = phrase.charAt(i);
			if(isVowel(currentChar)){
				newPhrase += ch;
			} else {
				newPhrase += currentChar;
			}
		}
		return newPhrase;
	}
	
	private String emphasize(String phrase, Character ch){
		String newPhrase = "";
		for(int i = 0; i < phrase.length(); i++){
			Character currentChar = phrase.charAt(i);
			if(Character.toLowerCase(currentChar) == ch || Character.toUpperCase(currentChar) == ch){
				if(i%2 == 0){
					newPhrase += '*';
				} else {
					newPhrase += '+';
				}
			} else {
				newPhrase += currentChar;
			}
		}
		return newPhrase;
	}
	
	public void testIsVowel(){
		Character[] chars = {'a','e','i','o','u','A','O','y','z'};
		for(Character c : chars){
			System.out.println(isVowel(c));
		}
	}
	
	public void testReplaceVowels(){
		String testStr = "Hello World!";
		String testStr2 = "Hail Wu!";
		System.out.println(replaceVowels(testStr, '*'));
		System.out.println(replaceVowels(testStr2, '?'));
	}
	
	public void testEmphasize(){
		String testStr = "Hello World!";
		String testStr2 = "Abracadabra";
		System.out.println(emphasize(testStr, 'l'));
		System.out.println(emphasize(testStr2, 'a'));
	}
}

