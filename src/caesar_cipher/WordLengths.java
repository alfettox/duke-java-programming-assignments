package caesar_cipher;

import edu.duke.FileResource;

public class WordLengths {
	
	private void countWordLengths(FileResource resource, int[] counts){
		for(String word: resource.words()){
			int count = 0;
			for(int j = 0; j < word.length(); j++){
				char currentChar = word.charAt(j);
				if(Character.isLetter(currentChar) || currentChar=='-' || currentChar=='\''){
					count++;
				}
			}
			if(count<30){
				counts[count]++;
			} else {
				counts[30]++;
			}
		}
	}
	
	public int indexOfMax(int[] values){
		int max = 0;
		int pos = 0;
		for(int i = 0; i < values.length; i++){
			if(values[i] > max){
				max = values[i];
				pos = i;
			}
		}
		return pos;
	}
	
	public void testCountWordLengths(){
		FileResource fr = new FileResource();
		int counts[] = new int[31];
		countWordLengths(fr, counts);
		for(int i = 1; i < counts.length; i++){
			System.out.println(i + ": " + counts[i]);
		}
		System.out.println("Most common length: " + indexOfMax(counts));
	}
}
