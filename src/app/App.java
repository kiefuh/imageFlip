package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MiStage;

public class App extends Application {
	public static String TITLE = "Pixel Inverter";
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new MiStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
