package bücherVerwaltung;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StandardView extends JFrame {

	private GroundPanel myGround;
	public static Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public StandardView(BücherVerwaltung myBücherVerwaltung) {
		this.initialize(myBücherVerwaltung);
	}

	public void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.myGround = new GroundPanel(myBücherVerwaltung);
		this.add(this.myGround);
		this.setTitle("Bücherverwaltung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public GroundPanel getMyGround() {
		return this.myGround;
	}

	public void setMyGround(GroundPanel myGround) {
		this.myGround = myGround;
	}

}
