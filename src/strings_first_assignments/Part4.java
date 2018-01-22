package strings_first_assignments;

import edu.duke.URLResource;

public class Part4 {
	
	private URLResource urlResource;
	private String source;
	
	public Part4(){
		urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		source = urlResource.asString();
	}
	
	public String getYoutubeLink(){
		String lowerCaseSource = source.toLowerCase();
		int startIndex = lowerCaseSource.indexOf("youtube.com");
		if(startIndex == -1){
			//no link
			return "";
		}
		
		startIndex = lowerCaseSource.lastIndexOf("\"", startIndex)+1;
		int endIndex = lowerCaseSource.indexOf("\"", startIndex);
		
//		System.out.println(startIndex + " " + endIndex);
		
		return source.substring(startIndex, endIndex);
	}
	
	public void testing(){
		System.out.println(getYoutubeLink());
	}
}
