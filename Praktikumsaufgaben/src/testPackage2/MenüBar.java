package testPackage2;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenüBar extends JMenuBar{

	private JMenu menu = new JMenu("Menu");;
	private JMenu subMenuHilfe = new JMenu("Help sites");
	private JMenuItem save;
	private JMenuItem hilfeWebsite;
	private JMenuItem exit;
	private ImageIcon linkSymbol = new ImageIcon("C:\\Users\\z1300a2k\\Pictures\\linkSymbol.png");
	private ImageIcon speicherSymbol = new ImageIcon("C:\\Users\\z1300a2k\\Pictures\\speicherSymbol.png");
	private ImageIcon exitSymbol = new ImageIcon("C:\\Users\\z1300a2k\\Pictures\\exitSymbol.png");
	
	public MenüBar() {
		super();
		this.add(menu);
		
		speicherSymbol.setImage(speicherSymbol.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		linkSymbol.setImage(linkSymbol.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		exitSymbol.setImage(exitSymbol.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		
		save = new JMenuItem("Save", speicherSymbol);
		save.addActionListener(produceListenerToSaveTextFile());
		hilfeWebsite = new JMenuItem("Help", linkSymbol);
		hilfeWebsite.addActionListener(produceListenerToOpenWebsite());
		exit = new JMenuItem("Exit", exitSymbol);
		exit.addActionListener(produceListenerToExit());
		
		subMenuHilfe.add(hilfeWebsite);
		
		menu.add(subMenuHilfe);
		menu.add(save);
		menu.addSeparator();
		menu.add(exit);
		menu.setBorder(BorderFactory.createEtchedBorder(1));
		
		
	}
	
	
	private ActionListener produceListenerToOpenWebsite() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();
				URL url = null;
				try {
					url = new URL("https://interaktiv.morgenpost.de/corona-virus-karte-infektionen-deutschland-weltweit/");
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				try {
					desktop.browse(url.toURI());
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				
			}
		};
	}
	
	
	private ActionListener produceListenerToSaveTextFile() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textString = "Später wird das der zuvor im Programm eingegebene Text sein"; 
				new TextHolder(textString);
			}
		};
	}

	private ActionListener produceListenerToExit() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	}
}
