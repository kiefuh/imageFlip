package model;

import java.util.ArrayList;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class WhiteBalance {
	private WritableImage wImage;
	private int height;
	private int width;
	private ArrayList<Integer> red;
	private ArrayList<Integer> blue;
	private ArrayList<Integer> green;
	private ArrayList<Integer> alpha;

	public WhiteBalance(WritableImage wImage) {
		this.wImage=wImage;
		this.height=(int) wImage.getHeight();
		this.width=(int) wImage.getWidth();
	}
	
	
	
	
	public WritableImage balance() {
		red= new ArrayList<>();
		blue= new ArrayList<>();
		green= new ArrayList<>();
		alpha= new ArrayList<>();
		PixelReader pr = wImage.getPixelReader();
		WritableImage newImage= new WritableImage(width,height);
		PixelWriter pw= newImage.getPixelWriter();
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				int argb=pr.getArgb(i, j);//grabs pixels argb value then splits it into the individual components
				int a=(argb>>24)&0xFF;
				int r=(argb>>16)&0xFF;
				int g=(argb>>8)&0xFF;
				int b=argb&0xFF;
				alpha.add(a);//adding individual components into their respective arrays
				red.add(r);
				blue.add(b);
				green.add(g);
			}
		}
		java.util.Collections.sort(red);//sorting arrays to find percentiles
		java.util.Collections.sort(green);
		java.util.Collections.sort(blue);
		int fifthPecentileRed=findPercentile(5,red);
		int upperBound=findPercentile(95,red);
		int fifthPecentileBlue=findPercentile(5,blue);
		int upperBoundBlue=findPercentile(95,blue);
		int fifthPecentileGreen=findPercentile(5,green);
		int upperBoundGreen=findPercentile(95,green);
		for(int i=0;i<width;i++) {
		for(int j=0;j<height;j++) {
			int argb=pr.getArgb(i, j);//grabbing pixel again to be modified
			int a=(argb>>24)&0xFF;
			int r=(argb>>16)&0xFF;
			int g=(argb>>8)&0xFF;
			int b=argb&0xFF;
			int newReds=(r-fifthPecentileRed)*255/(upperBound-fifthPecentileRed);//applying white balance on individual components
			int newBlue=(b-fifthPecentileBlue)*255/(upperBoundBlue-fifthPecentileBlue);
			int newGreen=(g-fifthPecentileGreen)*255/(upperBoundGreen-fifthPecentileGreen);
			if(newReds>255) {//keeping pixels within the rgb range
				newReds=255;
			}
			if(newReds<0) {
				newReds=0;
			}
			if(newBlue>255) {
				newBlue=255;
			}
			if(newBlue<0) {
				newBlue=0;
			}
			if(newGreen>255) {
				newGreen=255;
			}
			if(newGreen<0) {
				newGreen=0;
			}
			int newColor=(a<<24)|(newReds<<16)|(newGreen<<8)|newBlue;
			pw.setArgb(i, j, newColor);//writes new image pixels
		}
	}
		return newImage;
	}




	private int findPercentile(int i, ArrayList<Integer> red2) {
		int length=red2.size();
		double percent=(double)i/100;
		int percentile=(int) ((int)length*percent);
		return red2.get(percentile);
	}
}
