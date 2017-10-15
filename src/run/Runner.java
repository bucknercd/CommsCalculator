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
	//Group root;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create view
		BorderPane root = new BorderPane();
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
