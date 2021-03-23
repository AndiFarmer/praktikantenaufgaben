package GridBagLayoutVerzweiflung;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutTestClass extends JPanel {
	
	JButton b1, b2, b3, b4, b5;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public GridBagLayoutTestClass() {
		this.setLayout(new GridBagLayout());
		
		this.b1 = new JButton("Button1");
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
//		this.gbc.gridheight = 4;
		this.gbc.fill = GridBagConstraints.BOTH;
		this.add(this.b1, this.gbc);
		
		this.b2 = new JButton("Button2");
		this.gbc.gridx = 1;
		this.gbc.gridy = 1;
		this.gbc.gridheight = 2;
		this.add(this.b2, this.gbc);
		
		JButton b2_5 = new JButton("Button2_5");
		this.gbc.gridx = 5;
		this.gbc.gridy = 1;
		this.gbc.gridheight = 1;
		this.add(b2_5, this.gbc);
		
		this.b3 = new JButton("Button3");
		this.gbc.gridx = 2;
		this.gbc.gridy = 2;
		this.gbc.gridheight = 1;
		this.add(this.b3, this.gbc);
		
		this.b4 = new JButton("Button4");
		this.gbc.gridx = 3;
		this.gbc.gridy = 3;
		this.add(this.b4, this.gbc);
		
		this.b5 = new JButton("Button5");
		this.gbc.gridx = 1;
		this.gbc.gridy = 4;
		this.gbc.gridwidth = 3;
		this.gbc.fill = GridBagConstraints.BOTH;
		this.add(this.b5, this.gbc);
	}

	public static void main(String[] args) {
		GridBagLayoutTestClass g = new GridBagLayoutTestClass();
		JFrame jf = new JFrame();
		
		jf.setTitle("FensterTitel");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.add(g);
	}

}
