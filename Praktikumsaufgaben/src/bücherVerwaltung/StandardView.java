package bücherVerwaltung;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StandardView extends JFrame {

	private GroundPanel myGround;
	
	public StandardView() {
		this.myGround = new GroundPanel();
		this.add(this.myGround);
		this.setTitle("Bücherverwaltung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}

}
