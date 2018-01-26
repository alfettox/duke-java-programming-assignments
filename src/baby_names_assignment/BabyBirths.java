package baby_names_assignment;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class BabyBirths {
	public void printNames(){
		FileResource fr = new FileResource();
		for(CSVRecord record : fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(record.get(2));
			if(numBorn <= 100) {
				System.out.println("Name" + record.get(0) +
									" Gender" + record.get(1) +
									" Num Born" + record.get(2));
			}
		}
	}
	
	public void totalBirths(FileResource fr){
		int totalBirths = 		0,
			totalBoys = 		0,
			totalGirls = 		0,
			totalNames = 		0,
			totalBoysNames = 	0,
			totalGirlsNames = 	0;
		
		for (CSVRecord record : fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(record.get(2));
			totalBirths += numBorn;
			totalNames ++;
			if(record.get(1).equals("M")){
				totalBoys += numBorn;
				totalBoysNames++;
			} else {
				totalGirls += numBorn;
				totalGirlsNames++;
			}
		}
		
		System.out.println("total births = " + totalBirths);
		System.out.println("total boys = " + totalBoys);
		System.out.println("total girls = " + totalGirls);
		System.out.println("total Names = " + totalNames);
		System.out.println("total boys names = " + totalBoysNames);
		System.out.println("total girls names= " + totalGirlsNames);
	}
	
	public int getRank(int year, String name, String gender){
		int rank = 1;
		DirectoryResource dr = new DirectoryResource();
		//search for file with the specified year
		for(File f : dr.selectedFiles()){
			if(f.getName().contains(Integer.toString(year))){
				FileResource fr = new FileResource(f);
				CSVParser parser = fr.getCSVParser(false);
				// file is ordered by number of births biggest to smallest
				for(CSVRecord record : parser){
					if(record.get(1).equals(gender)){
						if(record.get(0).equals(name)){
							return rank; //found
						}
						rank++;	//gender but not name	
					}
				}
				
				return -1; //not found in record
			}
		}
		return -1; //record not found
	}
	
	public String getName(int year, int rank, String gender){
		int m_rank = 0;
		DirectoryResource dr = new DirectoryResource();
		//search for file with the specified year
		for(File f : dr.selectedFiles()){
			if(f.getName().contains(Integer.toString(year))){
				FileResource fr = new FileResource(f);
				CSVParser parser = fr.getCSVParser(false);
				//records ordered by birth
				for(CSVRecord record : parser){
					if(record.get(1).equals(gender)){
						m_rank++;
						if(m_rank == rank){
							return record.get(0); //found name
						}
					}
				}
				
				return "NO NAME"; //rank not reached
			}
		}
		return "NO NAME"; //year not present in selected files
	}
	
	public void whatIsNameInYear(String name, int year, int newYear, String gender){
		String heShe = "he";
		String newName = "NO NAME";
		
		if(gender.equals("F")){
			heShe = "she";
		}
		
		int rank = getRank(year, name, gender);
		if(rank != -1){
			newName = getName(newYear, rank, gender);
		}
		if(newName.equals("NO NAME")){
			System.out.println("NAME NOT FOUND");
		} else {
			System.out.println(name + " born in "+
					year + " would be " +
					newName + " if " +
					heShe + " was born in " +
					newYear);
		}
	}
	
	public int yearOfHighestRank(String name, String gender){
		int year = -1;
		int highestRank = 1;
		int currentRank = 1;
		DirectoryResource dr = new DirectoryResource();
		//search for file with the specified year
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			// file is ordered by number of births biggest to smallest
			currentRank = 1;
			for(CSVRecord record : parser){
				if(record.get(1).equals(gender)){
					if(record.get(0).equals(name)){
						//name found
						if(currentRank < highestRank || year == -1){
							highestRank = currentRank; //update rank or set rank if first find (year == -1)
							year = Integer.parseInt(f.getName().substring(3, 7)); //assuming files have standard name yobYYYYshort.csv
							break; //stop for loop for this file
						}
					}
					currentRank++;	//gender but not name	
				}
			}	
		}
		return year;
	}
	
	public double getAverageRank(String name, String gender){
		int fileCount = 0;
		int rankAcc = 0;
		int currentRank = 1;
		DirectoryResource dr = new DirectoryResource();
		//search for file with the specified year
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			// file is ordered by number of births biggest to smallest
			currentRank = 1;
			for(CSVRecord record : parser){
				if(record.get(1).equals(gender)){
					if(record.get(0).equals(name)){
						//name found
						rankAcc += currentRank;
						break;
					}
					currentRank++;	//gender but not name	
				}
			}
			fileCount++;
		}
		
		if(rankAcc == 0){
			return -1.0; //no name found in files
		}

		return ((double)rankAcc)/fileCount;
	}
	
	public int getTotalBirthsRankedHigher(int year, String name, String gender){
		int totalBirths = 0;
		DirectoryResource dr = new DirectoryResource();
		//search for file with the specified year
		for(File f : dr.selectedFiles()){
			if(f.getName().contains(Integer.toString(year))){
				FileResource fr = new FileResource(f);
				CSVParser parser = fr.getCSVParser(false);
				// file is ordered by number of births biggest to smallest
				for(CSVRecord record : parser){
					if(record.get(1).equals(gender)){
						if(record.get(0).equals(name)){
							//name found, stop loop
							break;
						}
						totalBirths += Integer.parseInt(record.get(2)); //add births to total
					}
				}
			}	
		}
		return totalBirths;
	}
	
	public void testTotalBirths() {
		FileResource fr = new FileResource("baby_names/us_babynames_test/example-small.csv");
		totalBirths(fr);
	}
	
}
