package baby_names_assignment;

public class Tester {

	public static void main(String[] args) {
		BabyBirths bb = new BabyBirths();
//		bb.testTotalBirths();
//		System.out.println(bb.getRank(2014, "Jacob", "M"));
//		System.out.println(bb.getName(2014, 52, "F"));
//		bb.whatIsNameInYear("Isabella", 2012, 2014, "F");
//		System.out.println(bb.yearOfHighestRank("Mason", "M"));
//		System.out.println(bb.getAverageRank("Jacob", "M"));
		System.out.println(bb.getTotalBirthsRankedHigher(2012, "Ethan", "M"));
	}

}
