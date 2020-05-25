package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Loads the menus: File, Edit, Window, and Help
 * @author Camposm97
 */
public class MiMenuBar extends MenuBar {
	private Menu mFile, mEdit, mWindow, mHelp;
	private MenuItem miLoad, miSaveAs, miExit;
	private MenuItem miColorNeg;
	private MenuItem miAbout;
	
	public MiMenuBar() {
		// Init Menu Items
		miLoad = new MenuItem("Load");
		miSaveAs = new MenuItem("Save As");
		miExit = new MenuItem("Exit");
		miColorNeg = new MenuItem("Color Negative");
		miAbout = new MenuItem("About");
		
		// Init Menus and Add Menu Items
		mFile = new Menu("File");
		mFile.getItems().addAll(miLoad, miSaveAs, miExit);
		
		mEdit = new Menu("Edit");
		mEdit.getItems().addAll(miColorNeg);
		
		mWindow = new Menu("Window");
		
		
		mHelp = new Menu("Help");
		mHelp.getItems().addAll(miAbout);
		
		// Add Menus
		super.getMenus().addAll(mFile, mEdit, mWindow, mHelp);
	}
}
