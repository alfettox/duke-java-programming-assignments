package images_assignment;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

public class InvertedConverter {
	
	public ImageResource invert(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			//invert pixels
			pixel.setRed(255-inPixel.getRed());
			pixel.setGreen(255-inPixel.getGreen());
			pixel.setBlue(255-inPixel.getBlue());
		}
		
		return outImage;
	}
	
	public void testInvert(){
		ImageResource ir = new ImageResource();
		ImageResource inverted = invert(ir);
		inverted.draw();
	}
	
	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource inverted = invert(inImage);
			inverted.setFileName("images/inverted-" + inImage.getFileName());
			inverted.draw();
			inverted.save();
		}
	}
}
