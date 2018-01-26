package images_assignment;

public class Tester {

	public static void main(String[] args) {
		GrayScaleConverter gsc = new GrayScaleConverter();
		InvertedConverter ic = new InvertedConverter();
		
//		gsc.testGray();
//		gsc.selectAndConvert();
		
//		ic.testInvert();
		ic.selectAndConvert();

	}

}
