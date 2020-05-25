package demo;

import java.nio.IntBuffer;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

public class Demo {

	public static void main(String[] args) {
		JFXPanel jfxPanel = new JFXPanel();
		Image image= new Image("cat.jpg");
		PixelReader pr=image.getPixelReader();
		WritablePixelFormat<IntBuffer> g=PixelFormat.getIntArgbInstance();
		int height=(int) image.getHeight();
		int width= (int) image.getWidth();
		
		for (int j=0;j<width;j++) {
//		int[] buffer = new int[100000];
//		pr.getPixels(j, 0, 1, (int) image.getHeight(),g, buffer, 0, 1);
		for(int i=0;i<height;i++) {
//			System.out.println(buffer[i]);
			Color color = pr.getColor(j, i);
			Color color2=color.deriveColor(((color.getHue()+180)%360), color.getSaturation(), color.getBrightness(), color.getOpacity());
			System.out.print(color.toString()+" ");
			System.out.print("Red "+color.getRed());
			System.out.print("Green "+color.getGreen());
			System.out.print("Blue "+color.getBlue()+"| ");
			System.out.print(color2.toString()+" ");
			System.out.print("Red "+color2.getRed());
			System.out.print("Green "+color2.getGreen());
			System.out.println("Blue "+color2.getBlue());
		}
		
		}
		System.out.println("finished");

	}

}
