package funktionswertBerechnung11a;

import java.awt.Dimension;
import java.awt.Toolkit;

public class BildschirmAbmessungen {

	private int breite;
	private int höhe;
	
	public BildschirmAbmessungen() {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	this.setBreite(screenSize.width);
	this.setHöhe(screenSize.height);
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHöhe() {
		return höhe;
	}

	public void setHöhe(int höhe) {
		this.höhe = höhe;
	}

}
