package testPackage2;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Fenster extends JFrame {

	public Fenster() {
		setTitle("Dies ist ein tolles Fenster");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Container pane = getContentPane(); 
		GroupLayout groupLayout = new GroupLayout(pane);
		pane.setLayout(groupLayout);
		
		
		
	}

}
