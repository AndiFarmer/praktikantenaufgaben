package funktionswertBerechnung11a;

public class MinMax {

	private int xMin, xMax, yMin, yMax;
	
	public MinMax(double[] yWertArray, FunktionsZeichner funktionsZeichner) {
		calcXYMinMax(yWertArray, funktionsZeichner.getBildschirmAbmessungen());
	}

	private void calcXYMinMax(double[] yWertArray, BildschirmAbmessungen bildschirmAbmessungen) {
		
		boolean xMinGesetzt = false;
		double yNow;
		int bildschirmBreite = bildschirmAbmessungen.getBreite();
		int bildschirmHöhe = bildschirmAbmessungen.getHöhe();
		for (int i = 0; i < bildschirmBreite; i++) {
			
			System.out.println(yWertArray[i]); ///////////////////////////////////
			
			yNow = yWertArray[i];
			
			if (yNow < bildschirmHöhe/2 && yNow > -bildschirmHöhe/2 && xMinGesetzt == false) {
				setxMin(i);
				xMinGesetzt = true;
			}
			if (yNow < bildschirmHöhe/2 && yNow > -bildschirmHöhe/2) {
				setxMax(i);
			}
			if(yNow < yMin && yNow >= -bildschirmHöhe/2) {
				setyMin(yNow);
			}
			if (yNow > yMax && yNow <= bildschirmHöhe/2) {
				setyMax(yNow);
			}
		}
	}

	public int getxMin() {
		return xMin;
	}

	public void setxMin(int xMin) {
		this.xMin = xMin;
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = (int) yMin;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = (int) yMax;
	}

}
