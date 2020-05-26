package model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Inverter {
	private Image image;
	private int height;
	private int width;
	
	
	public Inverter(Image image) {// image is brought in and height and width are set
		this.image=image;
		this.height=(int) image.getHeight();
		this.width=(int) image.getWidth();
	}
	
	
	private WritableImage initialize() {//flips the image initially so it can then have white balance applied
		WritableImage wImage = new WritableImage(width,height);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		PixelReader pr=image.getPixelReader();
		for (int j=0;j<width;j++) {
			for(int i=0;i<height;i++) {
				int inverted=pr.getArgb(j, i)^0xFFFFFF;//reads pixel then uses xor to shift to inverse ARBG
				pixelWriter.setArgb(j, i, inverted);//new pixel is written to image
			}

	}
		return wImage;
	}
	
	public WritableImage invert() {//applies white balance 
		WritableImage wImage =initialize();
		PixelWriter pixelWriter = wImage.getPixelWriter();
		double max=0;
		double min=360;
		for(int i=0;i<width;i++) {
			
			for(int j=0;j<height;j++) {
				Color color=wImage.getPixelReader().getColor(i, j);
				if(max<color.getHue()) {
					max=color.getHue();
				}
				if(min>color.getHue()) {
					min=color.getHue();
				}
			}
		}
		double hue=max-min;
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				Color color=wImage.getPixelReader().getColor(i, j);
				hue=1/(color.getHue()/hue);
				color=color.deriveColor(hue, color.getSaturation(), color.getBrightness(), color.getOpacity());
				pixelWriter.setColor(i, j, color);
			}
		}
		return wImage;
	}
	
}
