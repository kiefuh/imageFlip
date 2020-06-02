package view;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
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
				
			}
		});
		miSaveAs = new MenuItem("Save As");
		miSaveAs.setOnAction(event -> {
			
		});
		miExit = new MenuItem("Exit");
		miExit.setOnAction(event -> {
			Platform.exit();
		});
		miColorNeg = new MenuItem("Color Negative");
		miColorNeg.setOnAction(event -> {
			
		});
		miAbout = new MenuItem("About");
		miAbout.setOnAction(event -> {
			// For later
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
