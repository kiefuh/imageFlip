package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MyFiles {
	/**
	 * Returns FileChooser object with Filter
	 * @return FileChooser
	 */
	public static FileChooser emitImageChooser() {
		ExtensionFilter ef0 = new ExtensionFilter("All Files", "*.*");
		ExtensionFilter ef1 = new ExtensionFilter("BMP", "*.bmp");
		ExtensionFilter ef2 = new ExtensionFilter("GIF", "*.gif");
		ExtensionFilter ef3 = new ExtensionFilter("JPG", "*.jpg");
		ExtensionFilter ef4 = new ExtensionFilter("PNG", "*.png");
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(ef0, ef1, ef2, ef3, ef4);
		return fc;
	}
	
	public static void imageWriter(WritableImage wImage,String location) {
		BufferedImage bi=SwingFXUtils.fromFXImage((Image)wImage, null);//converts to BufferedImage to save photo
		File a=new File(location);
		try {
			ImageIO.write( bi, "png", a );
		} catch (IOException e) {
			System.out.println("Image write failure");
			e.printStackTrace();
		}//end saving
	}
}
