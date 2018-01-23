package strings_second_assignment;

public class Part3 {
	
	public int findStopCodon(String dna, int startIndex, String stopCodon){
		int index = dna.indexOf(stopCodon, startIndex);
		if(index == -1 || (index - startIndex)%3 != 0){
			return -1;
		}
		return index;
	}
	
	public String findGene(String dna, int where){
		int startIndex = dna.indexOf("ATG", where);
		
		if(startIndex == -1){
			return "";
		}
		
		int taaIndex = findStopCodon(dna, startIndex+3, "TAA");
		int tagIndex = findStopCodon(dna, startIndex+3, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex+3, "TGA");
		
//		System.out.println(taaIndex + " " + tagIndex + " " + tgaIndex);
		int stopIndex = -1;
		if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
			stopIndex = tgaIndex;
		} else {
			stopIndex = taaIndex;
		}
		
		if(stopIndex == -1 || (tagIndex != -1 && tagIndex < stopIndex)){
			stopIndex = tagIndex;
		}

		if(stopIndex == -1){
			return "";
		}
		
		return dna.substring(startIndex, stopIndex + 3);
	}	
	
	public int countGenes(String dna){
		int startIndex = 0;
		int count = 0;
		while(true){
			String gene = findGene(dna, startIndex);
			if(gene.isEmpty()){
				break;
			}
			count++;
			startIndex = dna.indexOf("ATG", startIndex)+gene.length();
		}
		return count;
	}
	
	public void testCountGenes(){
		String[] testCases = {
				"GAATGCTATACTCACAGTAGTTAGGGTAA",
				"TCAATGCCATATTGACAATAGGG",
				"ATGTAATTATAG",
				"AATATTGTTAATAGATGAATATA",
				"AGATGAAATAATAGATGGTTATTTAAGCTACACCATGAGGTTAAGGTGA",
				"GCTACACCATGAGGTTAAGGTGA"
				};
		for(String dna : testCases){
			System.out.println(dna);
			System.out.println("Gene count: " + countGenes(dna));
		}
	}
}
