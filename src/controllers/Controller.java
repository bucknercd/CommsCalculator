package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.Model;
import views.View;

public class Controller implements EventHandler<ActionEvent>{
	
	private View view;
	private Model model;
	private Button button;
	
	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		
		this.view.addListener(this);
		this.model.getView(this.view);
		this.button = this.view.getButton();
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == this.button) {
			System.out.println("Calculating ... ");
			this.view.updateEIRP(this.model.calcEIRP());
			this.view.updateFSL(this.model.calcFSL());
			this.view.updateRSL(this.model.calcRSL());
			this.view.updateOutput(this.model.calcResult());
			
		}
		
	}

}
