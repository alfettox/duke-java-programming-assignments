package images_assignment;
/**
 * Convert any number of images to a gray scale version by setting all color components of each pixel to the same value.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
	//I started with the image I wanted (inImage)
	public ImageResource makeGray(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			//compute average of rgb pixel values
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			
			//set pixel's to average
			pixel.setRed(average);
			pixel.setGreen(average);
			pixel.setBlue(average);
		}
		//outImage is your answer
		return outImage;
	}

	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource gray = makeGray(inImage);
			gray.setFileName("images/gray-" + inImage.getFileName());
			gray.draw();
			gray.save();
		}
	}
	

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource gray = makeGray(ir);
		gray.draw();
	}
	
}
