package funktionswertBerechnung11a;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Starter {

	public Starter() {
		
		JFrame frame = new JFrame("Fenstertext");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.requestFocus();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton button;
		button = new JButton("Graph anzeigen");
		button.setBounds(25, 25, 150, 40);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		button.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FunktionsZeichner funktionsZeichner = new FunktionsZeichner();
				frame.dispose();
			}
		});
		
		
		frame.add(button);
		
		
	}

	public static void main(String[] args) {
		
		new Starter();
		//
	}

}
