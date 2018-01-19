package perimeter_quiz;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        // iterates through points and counts them
    	int numPoints = 0;
    	for(Point p : s.getPoints()){
    		numPoints++;
    	}
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
    	double maxDistance = 0;
    	Point lastPoint = s.getLastPoint();
    	for(Point p: s.getPoints()){
    		double distance = p.distance(lastPoint);
			if(distance > maxDistance){
				maxDistance = distance;
			}
    		lastPoint = p;
    	}
        return maxDistance;
    }

    public double getLargestX(Shape s) {
        int maxX = 0;
    	for(Point p: s.getPoints()){
    		int x = p.getX();
    		if(x > maxX){
    			maxX = x;
    		}
    	}
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
    	double largestPerimeter = 0.0;
    	DirectoryResource dr = new DirectoryResource();
    	for(File f : dr.selectedFiles()){
    		FileResource fr = new FileResource(f);
    		Shape s = new Shape(fr);
    		double perimeter = getPerimeter(s);
    		if(perimeter > largestPerimeter){
    			largestPerimeter = perimeter;
    		}
    	}
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
    	double largestPerimeter = 0.0;
    	DirectoryResource dr = new DirectoryResource();
    	File temp = null;
    	for(File f : dr.selectedFiles()){
    		FileResource fr = new FileResource(f);
    		Shape s = new Shape(fr);
    		double perimeter = getPerimeter(s);
    		if(perimeter > largestPerimeter){
    			largestPerimeter = perimeter;
    			temp = f;
    		}
    	}
        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
    	System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    	System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("points = " + getNumPoints(s));
        System.out.println("largestX = " + getLargestX(s));
        System.out.println("avgLength = " + getAverageLength(s));
        System.out.println("largestSide = " + getLargestSide(s));
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
//        pr.testFileWithLargestPerimeter();
//        pr.testPerimeterMultipleFiles();
    }

}
