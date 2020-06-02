package model;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 * Supports only BMP, GIF, JPEG, PNG
 * @author Camposm97
 */
public class ImageInverter {
	public WritableImage invert(Image image) {
		Inverter inverter = new Inverter(image);
		WritableImage wi = inverter.initialize();
		WhiteBalance wb = new WhiteBalance(wi);
		return wb.balance();
	}
}
