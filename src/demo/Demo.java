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
			System.out.print(color.toString()+" ");
			System.out.print("Red "+color.getRed());
			System.out.print("Green "+color.getGreen());
			System.out.println("Blue "+color.getBlue());
		}
		
		}
		System.out.println("finished");

	}

}
