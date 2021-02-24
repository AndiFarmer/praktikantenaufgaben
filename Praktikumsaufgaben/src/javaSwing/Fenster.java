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
		setTitle("Editor");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		//ContentPanes
		myContentPane = new Panel(); // contentPane von diesem JFrame ist ein JPanel
		setContentPane(myContentPane); // wie kommt es, dass 
		nestedContentPaneNorth = new Panel();
		nestedContentPaneCenter = new Panel();
		
		
		//Layout
		//groupLayout = new GruppenLayout(myContentPane);
		//myContentPane.setLayout(groupLayout);
		myContentPane.setLayout(new BorderLayout());
		nestedContentPaneNorth.setLayout(new GridLayout());
		myContentPane.add(nestedContentPaneNorth, BorderLayout.NORTH);
		myContentPane.add(nestedContentPaneCenter, BorderLayout.CENTER);
		
		
		//Button
		buttonSammlung = new Button[5];
		for(int i = 0; i < buttonSammlung.length ; i++) {
			buttonSammlung[i] = new Button("button" + i);
			nestedContentPaneNorth.add(buttonSammlung[i]);
		}
		getContentPane().add(buttonSammlung[0], BorderLayout.SOUTH);
		//this.groupLayout.setVerticalGroup(this.groupLayout.createSequentialGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		//this.groupLayout.setHorizontalGroup(this.groupLayout.createParallelGroup().addComponent(buttonSammlung[0]).addComponent(buttonSammlung[1]).addComponent(buttonSammlung[2]));
		
		
		//TextField
		textField = new TextField("hier steht ein text");
		nestedContentPaneCenter.add(textField);
		
		
		//Label
		label = new JLabel("Das ist ein JLabel");
		nestedContentPaneCenter.add(label);
		
		
		//MenuBar
		menuBar = new MenüBar();
		setJMenuBar(menuBar);
	}
	
}
