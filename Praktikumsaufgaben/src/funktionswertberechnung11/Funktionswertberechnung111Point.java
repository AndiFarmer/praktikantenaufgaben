package funktionswertberechnung11;

public class Funktionswertberechnung111Point{
	
	public double xKoordinate=0;
	public double yKoordinate=0;
	
	public void setPoint(double xInput, double yInput) {
		xKoordinate = xInput;
		yKoordinate = yInput;
	}
	
	public void setXKoordinate(double xInput) {
		xKoordinate = xInput;
	}
	
	public void setYKoordinate(double yInput) {
		yKoordinate = yInput;
	}
	
	public Funktionswertberechnung111Point getPoint() {
		return this;
	}
	
	public double getXKoordinate() {
		return xKoordinate;
	}
	
	public double getYKoordinate() {
		return yKoordinate;
	}
}
