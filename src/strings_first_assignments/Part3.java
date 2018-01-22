package strings_first_assignments;

public class Part3 {
	
	public boolean twoOccurrences(String stringa, String stringb){
		int index = stringb.indexOf(stringa);
		if(index == -1){
			return false;
		} else{
			stringb = stringb.substring(index+stringa.length());
			index = stringb.indexOf(stringa);
			if(index == -1){
				return false;
			}
		}
		return true;
	}
	
	public String lastPart(String stringa, String stringb){
		int index = stringb.indexOf(stringa);
		if(index == -1){
			return stringb;
		}
		return stringb.substring(index+stringa.length());
	}
	
	public void testing(){
		String[][] tests = {
				{"by", "A story by Abby Long"},
				{"a", "banana"},
				{"atg", "ctgtatgta"},
				{"an", "banana"},
				{"zoo", "forest"}
		};
		for(String[] test : tests){
			System.out.println("Strings: "+ test[0] + ", " + test[1]);
			System.out.println(twoOccurrences(test[0], test[1]));
			System.out.println("Last Part: "+ lastPart(test[0], test[1]));
		}
	}

}
