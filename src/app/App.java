package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MiMenuBar;

public class App extends Application {
	private static final String TITLE = "Pixel Inverter";
	private static final BorderPane ROOT = new BorderPane();
	private static final MiMenuBar MENU_BAR = new MiMenuBar();

	@Override
	public void start(Stage stage) throws Exception {
		ROOT.setTop(MENU_BAR);
		stage.setTitle(TITLE);
		stage.setScene(new Scene(ROOT, 600, 600));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static String getTitle() {
		return TITLE;
	}
	
	public static BorderPane getRoot() {
		return ROOT;
	}
}
