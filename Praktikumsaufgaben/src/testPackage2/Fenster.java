package testPackage2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Fenster extends JFrame {

	private Panel myContentPane;
	private GruppenLayout groupLayout;
	private MenüBar menuBar;
	private Button[] buttonSammlung;
	
	public Fenster() {
		//GUI
		setTitle("Editor");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//ContentPane
		myContentPane = new Panel(); // contentPane von diesem JFrame ist ein JPanel
		setContentPane(myContentPane); // wie kommt es, dass 
		
		//Layout
		//groupLayout = new GruppenLayout(myContentPane);
		//myContentPane.setLayout(groupLayout);
		myContentPane.setLayout(new BorderLayout());
		
		//Button
		buttonSammlung = new Button[3];
		for(int i = 0; i < buttonSammlung.length ; i++) {
			buttonSammlung[i] = new Button("button" + i);
			this.getContentPane().add(buttonSammlung[i]);
		}
		myContentPane.get
		//this.groupLayout.setVerticalGroup(this.groupLayout.createSequentialGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		//this.groupLayout.setHorizontalGroup(this.groupLayout.createParallelGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		
		
		//MenuBar
		menuBar = new MenüBar();
		setJMenuBar(menuBar);
		
	}
	
}
