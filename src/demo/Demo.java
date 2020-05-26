package demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Inverter;
import model.WhiteBalance;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image= new Image("writer.bmp");
//		PixelReader pr=image.getPixelReader();
		ImageView imageView = new ImageView();
	        imageView.setImage(image);
//		WritablePixelFormat<IntBuffer> g=PixelFormat.getIntArgbInstance();
//		int height=(int) image.getHeight();
//		int width= (int) image.getWidth();
//		WritableImage wImage = new WritableImage(
//                 (int)image.getWidth(),
//                 (int)image.getHeight());
//		PixelWriter pixelWriter = wImage.getPixelWriter();
//		for (int j=0;j<width;j++) {
////		int[] buffer = new int[100000];
////		pr.getPixels(j, 0, 1, (int) image.getHeight(),g, buffer, 0, 1);
//		for(int i=0;i<height;i++) {
////			System.out.println(buffer[i]);
//			//Color color = pr.getColor(j, i);
//			int inverted=pr.getArgb(j, i)^0xFFFFFF;
//			//Color color2=color.deriveColor((color.getHue()+180)%360, color.getSaturation(), color.getBrightness(), color.getOpacity());
//			//Color color2=color^0xFFFFFF;
////			System.out.print(color.toString()+" ");
////			System.out.print("Red "+color.getRed());
////			System.out.print("Green "+color.getGreen());
////			System.out.print("Blue "+color.getBlue()+"| ");
////			System.out.print(color2.toString()+" ");
////			System.out.print("Red "+color2.getRed());
////			System.out.print("Green "+color2.getGreen());
////			System.out.println("Blue "+color2.getBlue());
//			pixelWriter.setArgb(j, i, inverted);
//		}
//		}
//		double max=0;
//		double min=360;
//		for(int i=0;i<width;i++) {
//			
//			for(int j=0;j<height;j++) {
//				Color color=wImage.getPixelReader().getColor(i, j);
//				if(max<color.getHue()) {
//					max=color.getHue();
//				}
//				if(min>color.getHue()) {
//					min=color.getHue();
//				}
//			}
//		}
//		double hue=max-min;
//		for(int i=0;i<width;i++) {
//			for(int j=0;j<height;j++) {
//				Color color=wImage.getPixelReader().getColor(i, j);
//				hue=1/(color.getHue()/hue);
//				color=color.deriveColor(hue, color.getSaturation(), color.getBrightness(), color.getOpacity());
//				pixelWriter.setColor(i, j, color);
//			}
//		}
	        
	    Inverter inverter = new Inverter(image);
	    
	    WritableImage wImage = inverter.initialize();
	    WhiteBalance wb= new WhiteBalance(wImage);
	    WritableImage fImage = wb.balance();
	    
		
		System.out.println("finished");
		    imageView.setImage(fImage);
	        StackPane root = new StackPane();
	        root.getChildren().add(imageView);
	        Scene scene = new Scene(root, 300, 250);
	        primaryStage.setTitle("Image Write Test");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}

}
