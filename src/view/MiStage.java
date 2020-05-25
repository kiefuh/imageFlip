package view;

import app.App;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This stage will have the menu bar loaded up and anything else necessary for the menu bar to function.
 * @author Camposm97
 */
public class MiStage extends Stage {
	private MiMenuBar menuBar;
	private BorderPane root;
	
	public MiStage() {
		menuBar = new MiMenuBar();
		root = new BorderPane();
		root.setTop(menuBar);
		super.setTitle(App.TITLE);
		super.setScene(new Scene(root, 600, 600));
	}	
}
