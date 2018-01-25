package strings_third_assignment;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {
	
	public void processGenes(StorageResource sr){
		int longStrings = 0; //Count strings that are longer than 9
		int greatCGRatio = 0; //count strings that have a cg ratio higher than 0.35
		String longestGene = "";
		Part2 p2 = new Part2();
		for(String data: sr.data()){
			boolean printed = false;
			if(data.length() > 60){
				System.out.println(data);
				longStrings++;
				printed = true;
			}
			if(p2.cgRatio(data) > 0.35){
				if(!printed){
					System.out.println(data);
				}
				greatCGRatio++;
			}
			
			if(data.length() > longestGene.length()){
				longestGene = data;
			}
			
		}
		
		System.out.println("Strings longer than 60: " + longStrings);
		System.out.println("CGRatio higher than 0.35: " + greatCGRatio);
		System.out.println("Longest gene: "+ longestGene);
	}
	
	public void testProcessGenes(){
		FileResource fr = new FileResource("brca1line.fa");
		String dna = fr.asString().toUpperCase();
		Part1 p1 = new Part1();
		StorageResource genes = p1.getAllGenes(dna);
		System.out.println("Size: "+genes.size());
		processGenes(genes);
	}
}
