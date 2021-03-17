package javaSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Fenster extends JFrame {

	private Panel myContentPane;
	private Panel nestedContentPaneNorth;
	private Panel nestedContentPaneCenter;
	private GruppenLayout groupLayout;
	private MenüBar menuBar;
	private Button[] buttonSammlung;
	private TextField textField;
	private JLabel label;
	
	public Fenster() {
		//GUI
		this.setTitle("Editor");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		//ContentPanes
		this.myContentPane = new Panel(); // contentPane von diesem JFrame ist ein JPanel
		this.setContentPane(this.myContentPane); // wie kommt es, dass 
		this.nestedContentPaneNorth = new Panel();
		this.nestedContentPaneCenter = new Panel();
		
		//Layout
		//groupLayout = new GruppenLayout(myContentPane);
		//myContentPane.setLayout(groupLayout);
		this.myContentPane.setLayout(new BorderLayout());
		this.nestedContentPaneNorth.setLayout(new GridLayout());
		this.myContentPane.add(this.nestedContentPaneNorth, BorderLayout.NORTH);
		this.myContentPane.add(this.nestedContentPaneCenter, BorderLayout.CENTER);
		
		
		//Button
		this.buttonSammlung = new Button[5];
		for(int i = 0; i < this.buttonSammlung.length ; i++) {
			this.buttonSammlung[i] = new Button("button" + i);
			this.nestedContentPaneNorth.add(this.buttonSammlung[i]);
		}
		this.getContentPane().add(this.buttonSammlung[0], BorderLayout.SOUTH);
		//this.groupLayout.setVerticalGroup(this.groupLayout.createSequentialGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		//this.groupLayout.setHorizontalGroup(this.groupLayout.createParallelGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		
		
		//TextField
		this.textField = new TextField("hier steht ein text");
		this.nestedContentPaneCenter.add(this.textField);
		
		
		//Label
		this.label = new JLabel("Das ist ein JLabel");
		this.nestedContentPaneCenter.add(this.label);
		
		
		//MenuBar
		this.menuBar = new MenüBar();
		this.setJMenuBar(this.menuBar);
	}
	
}
