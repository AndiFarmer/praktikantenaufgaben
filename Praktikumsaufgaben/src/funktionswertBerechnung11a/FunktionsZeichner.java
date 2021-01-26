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
		minMax = new MinMax(funktionsWerte.getyWertArray(), this);
		achsenVerschiebung = new Achsenverschiebung(this);
		
	}
	
	
	public void paint(Graphics g) {
		achsenVerschiebung.calcXYVerschiebung(minMax, dialog, bereitsAusgeführt);
		int yVerschiebung = achsenVerschiebung.getyVerschiebung();
		int xVerschiebung = achsenVerschiebung.getxVerschiebung();
		int yAbweichung = 20; // durch die Titelleiste wird das innere Fenster um 16 in x-Richtung und 39 in y-Richtung verkleinert
		int xAbweichung = 8;
		
		int xPrev = 0 - bildschirmAbmessungen.getBreite() / 2 + xVerschiebung - xAbweichung;
		int yPrev = (int) funktionsWerte.getyWertArray()[0] + yVerschiebung - yAbweichung;
		int yNow, xNow;

		for (int pixelNr = 1; pixelNr < bildschirmAbmessungen.getBreite(); pixelNr++) {
			xNow = pixelNr - bildschirmAbmessungen.getBreite() / 2 + xVerschiebung  - xAbweichung;
			yNow = (int) funktionsWerte.getyWertArray()[pixelNr]  + yVerschiebung  - yAbweichung;
			g.drawLine(xPrev, yPrev, xNow, yNow); 
			yPrev=yNow;
			xPrev=xNow;
		}
		g.drawLine(0, yVerschiebung - yAbweichung, bildschirmAbmessungen.getBreite(),yVerschiebung - yAbweichung);
		g.drawLine(xVerschiebung - xAbweichung,0 ,xVerschiebung - xAbweichung,bildschirmAbmessungen.getHöhe());
		dialog.updateDialogGröße(achsenVerschiebung);
		bereitsAusgeführt = true;
	}

	public BildschirmAbmessungen getBildschirmAbmessungen() {
		return this.bildschirmAbmessungen;
	}
}
