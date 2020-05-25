package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
	static String TITLE = "Pixel Inverter";
	
	@Override
	public void start(Stage stage) throws Exception {
		ImageView iv = new ImageView("cat.jpg");
		stage.setScene(new Scene(new StackPane(iv)));
		stage.setTitle(TITLE);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
