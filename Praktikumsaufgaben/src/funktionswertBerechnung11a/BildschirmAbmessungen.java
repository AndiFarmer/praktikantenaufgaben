package funktionswertBerechnung11a;

import java.awt.Dimension;
import java.awt.Toolkit;

public class BildschirmAbmessungen {

	private double breite;
	private double höhe;
	
	public BildschirmAbmessungen() {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setBreite(screenSize.width);
	this.setHöhe(screenSize.height);
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getHöhe() {
		return höhe;
	}

	public void setHöhe(double höhe) {
		this.höhe = höhe;
	}

}
