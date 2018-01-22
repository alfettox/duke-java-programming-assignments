package strings_first_assignments;

public class Part2 {
	
	public String findSimpleGene(String dna, String startCodon, String stopCodon){
		String gene;
		
		if(dna.toLowerCase().equals(dna)){
			startCodon = startCodon.toLowerCase();
			stopCodon = stopCodon.toLowerCase();
		} else {
			dna = dna.toUpperCase(); //handle mixed aGCtTaT...
			startCodon = startCodon.toUpperCase();
			stopCodon = stopCodon.toUpperCase();
		}
		
		
		int startIndex = dna.indexOf(startCodon);
		int stopIndex = dna.indexOf(stopCodon);
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
		"ctatggacacctcataaatc", //ATG TAA MULT 3 lowercase
		"ctatGgaCaccgAgtaAATc", //ATG TAA MULT 3 mixed
		"TATCGGACTACGAGTTAGAA", //NO ATG NO TAA
		"AGATGATATTGCTAAGA", //ATG TAA NOT MULT 3
		"AAATGCCCTAACTAGATTAAGAAACC" //quiz 1
		};
		System.out.println("Start and end codons: "+"ATG,TAA");
		for(String test : tests){
			System.out.println("DNA sequence: "+test);
			System.out.println("Gene found: " + findSimpleGene(test, "ATG", "TAA"));
		}
	}

}
