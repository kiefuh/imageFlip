package model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Inverter {
	private Image image;
	private int height;
	private int width;
	
	
	public Inverter(Image image) {// image is brought in and height and width are set
		this.image=image;
		this.height=(int) image.getHeight();
		this.width=(int) image.getWidth();
	}
	
	
	public WritableImage initialize() {//flips the image initially so it can then have white balance applied
		WritableImage wImage = new WritableImage(width,height);
		PixelWriter pixelWriter = wImage.getPixelWriter();
		PixelReader pr=image.getPixelReader();
		for (int j=0;j<width;j++) {
			for(int i=0;i<height;i++) {
//				Color color=pr.getColor(j,i);
//				pixelWriter.setColor(j, i, color.invert());
				int inverted=pr.getArgb(j, i)^0xFFFFFF;//reads pixel then uses xor to shift to inverse ARBG
				pixelWriter.setArgb(j, i, inverted);//new pixel is written to image
			}

	}
		return wImage;
	}
	
}
