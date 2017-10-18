package models;


public class Model {

	private Double dist;
	private Double freq;
	private Double txPower;
	private Double txGain;
	private Double txLoss;
	private Double rxGain;
	private Double rxLoss;
	private Double eirp;
	private Double fsl;
	private Double rxSensLevel;
	private Double rxSens;
	
	public String calcEIRP() {
		this.txPower = 10 * Math.log10(this.txPower) + 30;  // converted to dBm
		this.eirp = this.txPower + this.txGain - this.txLoss;
		return this.eirp.toString();
	}

	public String calcFSL() {
		this.fsl = (20 * Math.log10(this.dist)) + (20 * Math.log10(this.freq) + 32.44);
		return this.fsl.toString();
	}

	public String calcRSL() {
		this.rxSensLevel = this.eirp - this.fsl + this.rxGain - this.rxLoss;
		return this.rxSensLevel.toString();
	}

	public Boolean calcResult() {
		if (this.rxSensLevel > this.rxSens)
			return true;
		else return false;
	}
	
	public void setRxSensitivity(Double rxSens) {
		this.rxSens = rxSens;
	}
	
	public void setTxPower(Double txPower) {
		this.txPower = txPower;
	}
	
	public void setTxGain(Double txGain) {
		this.txGain = txGain;
	}
	
	public void setTxLoss(Double txLoss) {
		this.txLoss = txLoss;
	}
	
	public void setRxGain(Double rxGain) {
		this.rxGain = rxGain;
	}
	
	public void setrxLoss(Double rxLoss) {
		this.rxLoss = rxLoss;
	}
	
	public void setDist(Double dist) {
		this.dist = dist;
	}
	
	public void setFreq(Double freq) {
		this.freq = freq;
	}
	
}
