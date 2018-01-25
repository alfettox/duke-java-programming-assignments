package strings_third_assignment;

import edu.duke.StorageResource;

public class Part1 {
	
	public int findStopCodon(String dna, int startIndex, String stopCodon){
		int index = startIndex;
		while(true){
			index = dna.indexOf(stopCodon, startIndex);
			int diff = index-startIndex;
			if(index == -1 || diff%3 == 0){
				break;
			}
			startIndex += diff+3-(diff%3);
		}
		
		return index;
	}
	
	public String findGene(String dna, int where){
		int startIndex = where;
	
		startIndex = dna.indexOf("ATG", startIndex);
		
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
	
	public StorageResource getAllGenes(String dna){
		int startIndex = 0;
		StorageResource genes = new StorageResource();
		while(true){
			String gene = findGene(dna, startIndex);
			if(gene.isEmpty()){
				break;
			}
			genes.add(gene);
			startIndex = dna.indexOf("ATG", startIndex)+gene.length();
		}
		return genes;
	}
	
	
	
	public void testFindStopCodon(){
		String[] testCases = {
				"GAATGCTATAATCACA",
				"TCAATGCTATATTTACA",
				"ATGTAATTA"
				};
		System.out.println("Testing TAA");
		for(String dna : testCases){
			int start = dna.indexOf("ATG");
			System.out.println("TAA index: "+ findStopCodon(dna, start, "TAA"));
		}
		System.out.println("Testing TTA");
		for(String dna : testCases){
			int start = dna.indexOf("ATG");
			System.out.println("TTA index: "+ findStopCodon(dna, start, "TTA"));
		}
	}
	
	public void testFindGenes(){
		String[] testCases = {
				"GAATGCTATACTCACAGTAGTTAGGGTAA",
				"TCAATGCCATATTGACAATAGGG",
				"ATGTAATTATAG",
				"AATATTGTTAATAGATGAATATA",
				"AGATGAAATAATAGATGGTTATTTAAGCTACACCATGAGGTTAAGGATGA",
				"GCTACACCATGAGGTTAAGGTGA"
				};
		for(String dna : testCases){
			System.out.println("Gene: "+ findGene(dna, 0));
		}
	}
	
	public void testGetAllGenes(){
		String[] testCases = {
				"GAATGCTATACTCACAGTAGTTAGGGTAA",
				"TCAATGCCATATTGACAATAGGG",
				"ATGTAATTATAG",
				"AATATTGTTAATAGATGAATATA",
				"AGATGAAATAATAGATGGTTATTTAAGCTACACCATGAGGTTAAGGTGA",
				"ATGTGCATGACCATATAAAGGTCCTAA"
				};
		int i = 0;
		for(String dna : testCases){
			System.out.println("Test case "+ i);
			StorageResource genes = getAllGenes(dna);
			for(String gene: genes.data()){
				System.out.println(gene);
			}
			i++;
		}
	}
	
}
