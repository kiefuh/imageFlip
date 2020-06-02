package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MiMenuBar;

public class App extends Application {
	public static String TITLE = "Pixel Inverter";
	private MiMenuBar menuBar;
	private BorderPane root;
	
	@Override
	public void start(Stage stage) throws Exception {
		menuBar = new MiMenuBar();
		root = new BorderPane();
		root.setTop(menuBar);
		stage.setTitle(App.TITLE);
		stage.setScene(new Scene(root, 600, 600));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
