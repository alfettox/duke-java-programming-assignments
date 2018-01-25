package strings_third_assignment;

public class Part2 {
	
	public double cgRatio(String dna){
		int cCount = 0;
		int gCount = 0;
		int i = 0;
		while(i < dna.length()){
			char protein = dna.charAt(i);
			if(protein == 'C'){
				cCount++;
			}
			if(protein == 'G'){
				gCount++;
			}
			i++;
		}
		if(gCount == 0){
			return (double)cCount;
		}
		return ((double)cCount)/gCount;
	}
	
	public int countCTG(String dna){
		int count = 0;
		int index = 0;
		while(true){
			index = dna.indexOf("CTG", index); 
			if(index == -1){
				break;
			}
			index += 3;
			count++;
		}
		return count;
	}
	
	public void testCGRatio(){
		String[] testCases = {
				"GGGGCCCCGGCCGCGC",
				"GGGGGGGGGGGGGGG",
				"CCCCCCCCCCC",
				"CAGTCAAACTGAC",
				"ACTAGTCTGAGAGTGG"
				};
		int i = 0;
		for(String dna : testCases){
			System.out.println("Test case "+ i);
			System.out.println(cgRatio(dna));
			i++;
		}
	}
	
	public void testCountCTG(){
		String[] testCases = {
				"ATCTGAGCTGTGCCTG",
				"CTG",
				"CT",
				"AAAAACTGAAATTCTGCTG",
				"TTTGGCGTCTGCTAG"
				};
		int i = 0;
		for(String dna : testCases){
			System.out.println("Test case "+ i);
			System.out.println(countCTG(dna));
			i++;
		}
	}
}
