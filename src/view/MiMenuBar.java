package view;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

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
		miSaveAs = new MenuItem("Save As");
		miExit = new MenuItem("Exit");
		miExit.setOnAction(event -> {
			Platform.exit();
		});
		miColorNeg = new MenuItem("Color Negative");
		miColorNeg.setOnAction(event -> {
			
		});
		miAbout = new MenuItem("About");
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
