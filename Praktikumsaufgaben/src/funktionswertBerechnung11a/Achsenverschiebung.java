package funktionswertBerechnung11a;

import javax.swing.JDialog;

public class Achsenverschiebung {

	int xVerschiebung;
	int yVerschiebung;
	private FunktionsZeichner funktionsZeichner;
	
	public Achsenverschiebung(FunktionsZeichner funktionsZeichner) {
		this.funktionsZeichner = funktionsZeichner;
	}
	
	public void calcXYVerschiebung (MinMax minMax, JDialog dialog, boolean schonAusgeführt) {
		int bildschirmBreiteHälfte = this.funktionsZeichner.getBildschirmAbmessungen().getBreite()/2;
		int xMinAbstandMittelpunkt = entferneVorzeichen(minMax.getxMin() - bildschirmBreiteHälfte);
		int xMaxAbstandMittelpunkt = entferneVorzeichen(minMax.getxMax() - bildschirmBreiteHälfte);
		int yMinAbstandMittelpunkt = entferneVorzeichen(minMax.getyMin());
		int yMaxAbstandMittelpunkt = entferneVorzeichen(minMax.getyMax());
		
		if (schonAusgeführt == false) {
			if(xMinAbstandMittelpunkt > xMaxAbstandMittelpunkt) {
				setxVerschiebung(xMinAbstandMittelpunkt);
			}else {
				setxVerschiebung(xMaxAbstandMittelpunkt);
			}
			if(yMinAbstandMittelpunkt > yMaxAbstandMittelpunkt) {
				setyVerschiebung(yMinAbstandMittelpunkt);
			}else {
				setyVerschiebung(yMaxAbstandMittelpunkt);
			}
		} else {
			setxVerschiebung(dialog.getWidth()/2);
			setyVerschiebung(dialog.getHeight()/2);
		}
	}
	
	private int entferneVorzeichen (double input ) {
		return (int) Math.pow(Math.pow(input,2), 0.5);
	}

	public int getxVerschiebung() {
		return xVerschiebung;
	}

	public void setxVerschiebung(int xVerschiebung) {
		this.xVerschiebung = xVerschiebung;
	}

	public int getyVerschiebung() {
		return yVerschiebung;
	}

	public void setyVerschiebung(int yVerschiebung) {
		this.yVerschiebung = yVerschiebung;
	}
}
