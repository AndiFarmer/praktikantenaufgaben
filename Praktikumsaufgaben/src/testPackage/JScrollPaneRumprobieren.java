package testPackage;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class JScrollPaneRumprobieren {

	public JScrollPaneRumprobieren() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JScrollPane scrollPane = new JScrollPane();
		String[] strArr = {"1", "2", "3"};
		JList<String> list = new JList<>(strArr);
		
		frame.setLayout(gbl);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbl.setConstraints(scrollPane, gbc);
		
		scrollPane.setViewportView(list); // !!!!!!!!!!!!!!!!!!!!
		frame.add(scrollPane);
		frame.setSize(new Dimension(300, 300));
		frame.setVisible(true);
//		
//		JFrame frame = new JFrame();
//		GridBagLayout gbl = new GridBagLayout();
//		GridBagConstraints gbc = new GridBagConstraints();
//		String[] strArr = {"1", "2", "3"};
//		JList<String> list = new JList<>(strArr);
//		
//		frame.setLayout(gbl);
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.weightx = 0.1;
//		gbc.weighty = 0.1;
//		gbl.setConstraints(list, gbc);
//		
//		frame.add(list);
//		frame.setSize(new Dimension(300, 300));
//		frame.setVisible(true);
	}

}
