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
		this.button = this.view.getButton();
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == this.button) {
			System.out.println("Calculating ... ");
			this.updateModel(this.model);
			this.updateView(this.view);
		}
	}
	
	public void updateModel(Model model) {
		model.setRxSensitivity(this.view.getRxSensitivity());
		model.setTxPower(this.view.getTxPower());
		model.setTxGain(this.view.getTxGain());
		model.setTxLoss(this.view.getTxLoss());
		model.setRxGain(this.view.getRxGain());
		model.setrxLoss(this.view.getRxLoss());
		model.setDist(this.view.getDistance());
		model.setFreq(this.view.getFrequency());
	}
	
	public void updateView(View view) {
		view.updateEIRP(this.model.calcEIRP());
		view.updateFSL(this.model.calcFSL());
		view.updateRSL(this.model.calcRSL());
		view.updateOutput(this.model.calcResult());
	}

}
