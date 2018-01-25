package csv_first_assignment;

import java.io.IOException;

import org.apache.commons.csv.*;

import edu.duke.FileResource;

public class Exports {
	
	
	private String countryInfo(CSVParser parser, String country){
		try{
			for(CSVRecord record: parser.getRecords()){
				if(record.get("Country").equals(country)){
					String info = "";
					info += record.get(0) + ": " + record.get(1) + ": " + record.get(2);
					return info;
				}
			}
		} catch (IOException e){}
		
		return "NOT FOUND";
	}
	
	private void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
		try{
			for(CSVRecord record: parser.getRecords()){
				String exports = record.get("Exports");
				if(exports.indexOf(exportItem1) != -1 && exports.indexOf(exportItem2) != -1){
					System.out.println(record.get("Country"));
				}
			}
		} catch (IOException e){}
	}
	
	private int numberOfExporters(CSVParser parser, String exportItem){
		int numCountries = 0;
		try{
			for(CSVRecord record: parser.getRecords()){
				String exports = record.get("Exports");
				if(exports.indexOf(exportItem) != -1){
					numCountries++;
				}
			}
		} catch (IOException e){}
		return numCountries;
	}
	
	private void bigExporters(CSVParser parser, String amount){
		try{
			for(CSVRecord record: parser.getRecords()){
				String value = record.get("Value (dollars)");
				if(value.length() > amount.length()){
					System.out.println(record.get("Country") + " " + value);;
				}
			}
		} catch (IOException e){}
	}
	
	public void tester(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
//		System.out.println(countryInfo(parser, "Nauru"));
//		listExportersTwoProducts(parser, "fish", "nuts");
//		System.out.println(numberOfExporters(parser, "gold"));
		bigExporters(parser, "$999,999,999,999");
	}

}
