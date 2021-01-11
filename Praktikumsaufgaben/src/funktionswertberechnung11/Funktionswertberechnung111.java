package funktionswertberechnung11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * 
 * @author z1300a2k
 *
 */
public class Funktionswertberechnung111 extends JPanel {
	/**
	 * Zeichnet Graph in einem Fenster(Dialog)
	 * @param args
	 */
	
	private int counter = 0;
	private double yMax = 0;
	private double yMin = 0;
	private double xMin=-100;
	private double xMax=100;
	
	public void paint(Graphics g) {
		counter++;
		double xPrev=xMin;
		double yPrev=f(xPrev);
		for (double xWert = xMin; xWert <= xMax; xWert++) {
			double xNow = xWert;
			double yNow = f(xWert);
			System.out.println(xWert);
			g.drawLine((int) (xPrev-xMin), (int) yPrev, (int) (xNow-xMin), (int) yNow);
			yPrev=yNow;
			xPrev=xNow;
		}
	}
	
	public static void main(String[] args) {
		JDialog dialog = new JDialog();
		dialog.getContentPane().add(new Funktionswertberechnung111());
		
		dialog.setTitle("Funktionsgraph");
		dialog.setSize(800, 600);
		dialog.setVisible(true);
		
		//System.exit(0);
	}
	
	static private double f(double x) {
		return Math.pow(x, 2) + Math.pow(x, 1) + Math.pow(x, 2); //Die Funktion ist fix
	}

}
