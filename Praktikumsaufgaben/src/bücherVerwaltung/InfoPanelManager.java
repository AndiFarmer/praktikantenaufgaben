package bücherVerwaltung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanelManager {

	private BuchInfoPanel myBuchInfoPanel;
	private VerlagInfoPanel myVerlagInfoPanel;
	private AutorInfoPanel myAutorInfoPanel;
	
	public InfoPanelManager(BücherVerwaltung myBücherVerwaltung) {
		this.initialize(myBücherVerwaltung);
		
		//vorübergehend
				Collection<Verlag> verläge1 = new ArrayList<Verlag>();
				verläge1.add(new Verlag("Scholastic Press", "New York"));
				BuchTyp buchTyp1 = new BuchTyp("Hardcover");
				Collection<Autor> autoren1 = new ArrayList<>();
				autoren1.add(new Autor("Suzanne", "Collins"));
				Buch buch = new Buch("The Hunger Games", "978-0-439-02352-8", 2008, verläge1, buchTyp1, autoren1);
				myBücherVerwaltung.addNewBuch(buch);
				try {
					this.showInfo(myBücherVerwaltung.getBücher().iterator().next());
				} catch (BücherVerwaltungException e) {
					e.printStackTrace();
				}
	}

	public void showInfo(Object input) throws BücherVerwaltungException {
		if (input.getClass() == Buch.class) {
			this.myBuchInfoPanel.setInfo((Buch) input);
			
			return;
		}
		if (input.getClass() == Autor.class) {
			this.myAutorInfoPanel.setInfo((Autor) input);
			
			return;
		}
		if (input.getClass() == Verlag.class) {
			this.myVerlagInfoPanel.setInfo((Verlag) input);
			
			return;
		}
		throw new BücherVerwaltungException("Das anzuzeigende Objekt muss der Klasse Buch, Autor oder Verlag angehören!");
	}

	public void initialize(BücherVerwaltung myBücherVerwaltung) {
		this.myBuchInfoPanel = new BuchInfoPanel(myBücherVerwaltung);
		this.myVerlagInfoPanel = new VerlagInfoPanel(myBücherVerwaltung);
		this.myAutorInfoPanel = new AutorInfoPanel(myBücherVerwaltung);
	}

	
	
	public JPanel getDefaultPanel() {

		return this.myBuchInfoPanel;
//		return this.myVerlagInfoPanel;
//		return this.myAutorInfoPanel;
	}
}
