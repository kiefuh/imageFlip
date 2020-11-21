package demo;



import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Inverter;
import model.WhiteBalance;
import utils.MyFiles;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		Image image= new Image("ATTEMPT1.png");
//		ImageView imageView = new ImageView();
//	    imageView.setImage(image);  
//	    Inverter inverter = new Inverter(image);
//	    WritableImage wImage = inverter.initialize();
//	    WhiteBalance wb= new WhiteBalance(wImage);
//	    WritableImage fImage = wb.balance();
//		imageView.setImage(fImage);
////	    imageView.setImage(wImage);
//		MyFiles.imageWriter(fImage, "save1.png");
//	    StackPane root = new StackPane();
//	    root.getChildren().add(imageView);
//	    Scene scene = new Scene(root, 300, 250);
//	    primaryStage.setTitle("Image Write Test");
//	    primaryStage.setScene(scene);
//	    primaryStage.show();
	}

}
