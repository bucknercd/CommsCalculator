package models;

import views.View;

public class Model {

	private View view;
	private Double eirp;
	private Double fsl;
	private Double rxSensLevel;
	private Double rxSens;
	
	public void getView(View view) {
		this.view = view;
	}
	
	public String calcEIRP() {
		Double txPower = this.view.getTxPower(); // given in watts
		txPower = 10 * Math.log10(txPower) + 30;  // converted to dBm
		Double txGain = this.view.getTxGain();
		Double txLoss = this.view.getTxLoss();
		this.eirp = txPower + txGain - txLoss;
		return this.eirp.toString();
	}

	public String calcFSL() {
		Double dist = this.view.getDistance();
		Double freq = this.view.getFrequency();
		this.fsl = (20 * Math.log10(dist)) + (20 * Math.log10(freq) + 32.44);
		return this.fsl.toString();
	}

	public String calcRSL() {
		Double rxGain = this.view.getRxGain();
		Double rxLoss = this.view.getRxLoss();
		this.rxSensLevel = this.eirp - this.fsl + rxGain - rxLoss;
		return this.rxSensLevel.toString();
	}

	public Boolean calcResult() {
		this.rxSens = this.view.getRxSensitivity();
		if (this.rxSensLevel > this.rxSens)
		 return true;
		else return false;
	}
}
