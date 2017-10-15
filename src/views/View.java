package views;


import controllers.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class View {
	
	private Button button;
	private Label eirp;
	private Label fsl;
	private Label rsl;
	private Label output;
	
	private TextField distance;
	private TextField frequency;
	private TextField rxSensitivity;
	private TextField txPower;
	private TextField txGain;
	private TextField txLoss;
	private TextField rxGain;
	private TextField rxLoss;
	
	
	
	public View(BorderPane root) {
		this.distance = new TextField("0.0");
		this.frequency = new TextField("0.0");
		this.rxSensitivity = new TextField("0.0");
		this.txPower = new TextField("0.0");
		this.txGain = new TextField("0.0");
		this.txLoss = new TextField("0.0");
		this.rxGain = new TextField("0.0");
		this.rxLoss = new TextField("0.0");
		this.init(root);
	}
	
	private void init(BorderPane root) {
		VBox input = new VBox();
		VBox results = new VBox();
		this.button = new Button("Calculate");
		this.output = this.createLabel("The RX ...   ", "yellow", "RED");
		
		HBox row0 = createRow(this.rxSensitivity, "RX Sesitivity (dBm)  ");
		HBox row1 = createRow(this.distance, "Distance (km)          ");
		HBox row2 = createRow(this.frequency, "Frequency (MHz)     ");
		HBox row3 = createRow(this.txPower, "TX Power (Watts)    ");
		HBox row4 = createRow(this.txGain, "TX Gain (dBi)          ");
		HBox row5 = createRow(this.txLoss, "TX Loss (dBd)         ");
		HBox row6 = createRow(this.rxGain, "RX Gain (dbi)          ");
		HBox row7 = createRow(this.rxLoss, "RX Loss (dBd)         ");
		input.getChildren().addAll(row0, row1, row2, row3, row4, row5, row6, row7);
		
		this.eirp = this.createLabel("EIRP: ", "yellow", "RED");
		this.fsl = this.createLabel("FSL: ", "yellow", "RED");
		this.rsl = this.createLabel("RSL: ", "yellow", "RED");
		results.getChildren().addAll(this.eirp, this.fsl, this.rsl);
		
		root.setTop(input);
		root.setRight(this.button);
		root.setCenter(results);
		root.setBottom(output);
		root.setBackground(Background.EMPTY);
	}
	
	private HBox createRow(TextField field, String labelName) {
		HBox row = new HBox();
        row.setPadding(new Insets(10, 10, 10, 10));
        row.setSpacing(5);   // Gap between nodes
		
        Label label = this.createLabel(labelName, "blue", "WHITE");
        
		row.getChildren().addAll(label, field);
		return row;
	}
	
	private Label createLabel(String labelName, String borderColor, String textColor) {
		Label label = new Label(labelName);
		label.setStyle("-fx-border-color: "+ borderColor+ ";");
		label.setTextFill(Paint.valueOf(textColor));
		return label;
	}
	
	public void addListener(Controller controller) {
		this.button.setOnAction(controller);
	}
	
	public Button getButton() {
		return this.button;
	}
	
	// output Label to set
	public void updateEIRP(String newText) {
		this.eirp.setText("EIRP: " + newText + " dBm  ");
	}
	
	public void updateFSL(String newText) {
		this.fsl.setText("FSL: " + newText + " dB  ");
	}
	
	public void updateRSL(String newText) {
		this.rsl.setText("RSL: " + newText + " dBm  ");
	}
	
	public void updateOutput(Boolean canHear) {
		if (canHear) {
			this.output.setText("The RX can hear the TX!  ");
		} else {
			this.output.setText("The RX cannot hear the TX :(  ");
		}
	}
	
	// input text to get
	
	public Double getDistance() {
		return Double.parseDouble(this.distance.getText());
	}
	
	public Double getFrequency() {
		return Double.parseDouble(this.frequency.getText());
	}
	
	public Double getRxSensitivity() {
		return Double.parseDouble(this.rxSensitivity.getText());
	}
	
	public Double getTxPower() {
		return Double.parseDouble(this.txPower.getText());
	}
	
	public Double getTxGain() {
		return Double.parseDouble(this.txGain.getText());
	}
	
	public Double getTxLoss() {
		return Double.parseDouble(this.txLoss.getText());
	}
	
	public Double getRxGain() {
		return Double.parseDouble(this.rxGain.getText());
	}
	
	public Double getRxLoss() {
		return Double.parseDouble(this.rxLoss.getText());
	}
	
}
