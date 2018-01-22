package strings_first_assignments;

public class Part1 {
	
	public String findSimpleGene(String dna){
		String gene;
		int startIndex = dna.indexOf("ATG");
		int stopIndex = dna.indexOf("TAA");
		if(startIndex == -1 | stopIndex == -1 | stopIndex < startIndex){
			return "";
		}
		if((stopIndex - startIndex) % 3 != 0){
			return "";
		}
		gene = dna.substring(startIndex, stopIndex+3);
		return gene;
	}
	
	public void testSimpleGene(){
		String[] tests = { 
		"CACGAAGTAA", //NO ATG
		"TTGACATGGATTA", //NO TAA
		"CTATGGACACCTCATAAATC", //ATG TAA MULT 3
		"TATCGGACTACGAGTTAGAA", //NO ATG NO TAA
		"AGATGATATTGCTAAGA" //ATG TAA NOT MULT 3
		};
		for(String test : tests){
			System.out.println("DNA sequence: "+test);
			System.out.println("Gene found: " + findSimpleGene(test));
		}
	}

}
