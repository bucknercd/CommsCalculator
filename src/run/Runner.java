package run;

import controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Model;
import views.View;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Runner extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create the root node to build the view on 
		BorderPane root = new BorderPane();
		
		// create model, view, and controller
		Model model = new Model();
		View view = new View(root);
		Controller controller = new Controller(model, view);
		
		// create scene and pass to stage
		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		primaryStage.setTitle("Comms Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
