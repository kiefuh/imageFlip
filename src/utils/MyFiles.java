package utils;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MyFiles {
	/**
	 * Returns FileChooser object with Filter
	 * @return FileChooser
	 */
	public static FileChooser emitImageChooser() {
		ExtensionFilter ef1 = new ExtensionFilter("BMP", "*.bmp");
		ExtensionFilter ef2 = new ExtensionFilter("GIF", "*.gif");
		ExtensionFilter ef3 = new ExtensionFilter("JPG", "*.jpg");
		ExtensionFilter ef4 = new ExtensionFilter("PNG", "*.png");
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(ef1, ef2, ef3, ef4);
		return fc;
	}
}
