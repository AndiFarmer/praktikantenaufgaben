package funktionswertBerechnung11a;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FunktionsZeichner extends JPanel {
	
	private boolean bereitsAusgeführt = false;
	private Dialog dialog;
	private BildschirmAbmessungen bildschirmAbmessungen;
	private FunktionsWerte funktionsWerte; 
	private Achsenverschiebung achsenVerschiebung;
	private MinMax minMax;
	
	public FunktionsZeichner() {
		dialog = new Dialog(this);
		bildschirmAbmessungen = new BildschirmAbmessungen();
		funktionsWerte = new FunktionsWerte(this);
		achsenVerschiebung = new Achsenverschiebung(this);
		minMax = new MinMax(funktionsWerte.getyWertArray(), this);
	}
	
	
	public void paint(Graphics g) {
		int xPrev = 0;
		int yPrev = (int) funktionsWerte.getyWertArray()[xPrev];
		achsenVerschiebung.calcXYVerschiebung(minMax, dialog, bereitsAusgeführt);
		int yNow, xNow, yVerschiebung = achsenVerschiebung.getyVerschiebung();
		for (xNow = 1; xNow < bildschirmAbmessungen.getBreite(); xNow++) {
			
			yNow = (int) funktionsWerte.getyWertArray()[xNow];
			g.drawLine(xPrev, yPrev + yVerschiebung, xNow, yNow + yVerschiebung); // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
			yPrev=yNow;
			xPrev=xNow;
		}
	
		dialog.updateDialogGröße(achsenVerschiebung);
		setBereitsAusgeführt(true);
	}

	public void setBereitsAusgeführt(boolean bereitsAusgeführt) {
		this.bereitsAusgeführt = bereitsAusgeführt;
	}

	public BildschirmAbmessungen getBildschirmAbmessungen() {
		return this.bildschirmAbmessungen;
	}
}
