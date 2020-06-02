package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import app.App;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import model.ImageInverter;
import utils.MyFiles;

/**
 * Loads the menus: File, Edit, Window, and Help
 * 
 * @author Camposm97
 */
public class MiMenuBar extends MenuBar {
	private Menu mFile, mEdit, mWindow, mHelp;
	private MenuItem miOpen, miSaveAs, miExit;
	private MenuItem miColorNeg;
	private MenuItem miAbout;

	public MiMenuBar() {
		initMenuItems();
		addMenuItems();
	}

	public void initMenuItems() {
		miOpen = new MenuItem("Open");
		miOpen.setOnAction(event -> {
			File file = MyFiles.emitImageChooser().showOpenDialog(new Stage());
			if (file != null) {
				try { // Try to display image
					Image img = new Image(new FileInputStream(file));
					ImageView iv = new ImageView(img);
					App.getRoot().setCenter(iv);
					Stage stage = (Stage) App.getRoot().getScene().getWindow();
					stage.setWidth(img.getWidth() + 100);
					stage.setHeight(img.getHeight() + 100);
					stage.centerOnScreen();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		miSaveAs = new MenuItem("Save As");
		miSaveAs.setOnAction(event -> {
			File file = MyFiles.emitImageChooser().showSaveDialog(new Stage());
			if (file != null) {
				Object o = App.getRoot().getCenter();
				if (o instanceof ImageView) {
					ImageView iv = (ImageView) o;
					Image img = iv.getImage();
					WritableImage writableImage = new WritableImage(img.getPixelReader(), (int) img.getWidth(),
							(int) img.getHeight());
					MyFiles.imageWriter(writableImage, file);
				}
			}
		});
		miExit = new MenuItem("Exit");
		miExit.setOnAction(event -> {
			Platform.exit();
		});
		miColorNeg = new MenuItem("Color Negative");
		miColorNeg.setOnAction(event -> {
			Object o = App.getRoot().getCenter();
			if (o instanceof ImageView) { // Check if object is a ImageView
				ImageView iv = (ImageView) o;
				ImageInverter imgInverter = new ImageInverter();
				Image img = imgInverter.invert(iv.getImage());
				iv.setImage(img);
			}
		});
		miAbout = new MenuItem("About");
		miAbout.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(App.getTitle());
			alert.showAndWait();
		});
	}

	public void addMenuItems() {
		// Init Menus and Add Menu Items
		mFile = new Menu("File");
		mFile.getItems().addAll(miOpen, miSaveAs, miExit);
		mEdit = new Menu("Edit");
		mEdit.getItems().addAll(miColorNeg);
		mWindow = new Menu("Window");
		mHelp = new Menu("Help");
		mHelp.getItems().addAll(miAbout);
		// Add Menus
		super.getMenus().addAll(mFile, mEdit, mWindow, mHelp);
	}
}
