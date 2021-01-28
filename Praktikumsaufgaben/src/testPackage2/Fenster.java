package testPackage2;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Fenster extends JFrame {

	Panel myContentPane;
	GruppenLayout groupLayout;
	MenüBar menuBar;
	Button[] buttonSammlung;
	
	public Fenster() {
		//GUI
		setTitle("Dies ist ein tolles Fenster");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//ContentPane
		myContentPane = new Panel(); // contentPane von diesem JFrame ist ein JPanel
		setContentPane(myContentPane); // wie kommt es, dass 
		
		//Layout
		groupLayout = new GruppenLayout(myContentPane);
		myContentPane.setLayout(groupLayout);
		
		//Button
		buttonSammlung = new Button[3];
		for(int i = 0; i < buttonSammlung.length ; i++) {
			buttonSammlung[i] = new Button("button" + i);
			this.getContentPane().add(buttonSammlung[i]);
			this.groupLayout.createSequentialGroup();
		}
		this.groupLayout.setVerticalGroup(this.groupLayout.createSequentialGroup().addComponent(buttonSammlung[0]));
		this.groupLayout.setHorizontalGroup(this.groupLayout.createParallelGroup().addComponent(buttonSammlung[0]));
		
		
		//MenuBar
		menuBar = new MenüBar();
		
		
	}
	
}
