package bücherVerwaltung;

import java.util.ArrayList;
import java.util.List;

public class BücherVerwaltung {
	
	private AutorenVerwalter autorenVerwalter;
	private VerlagVerwalter verlagVerwalter;
	private BuchTypVerwalter buchTypVerwalter;
	
	private List<Buch> bücher;
	
	private List<Autor> autoren;
	private List<Verlag> verläge;
	private List<BuchTyp> buchTypen;
	
	
	public BücherVerwaltung() {
		autorenVerwalter = new AutorenVerwalter();
		verlagVerwalter = new VerlagVerwalter();
		buchTypVerwalter = new BuchTypVerwalter();
		
		bücher = new ArrayList<Buch>();
		
		autoren = new ArrayList<Autor>();
		verläge = new ArrayList<Verlag>();
		buchTypen = new ArrayList<BuchTyp>();
	}


	public AutorenVerwalter getAutorenVerwalter() {
		return autorenVerwalter;
	}


	public VerlagVerwalter getVerlagVerwalter() {
		return verlagVerwalter;
	}


	public BuchTypVerwalter getBuchTypVerwalter() {
		return buchTypVerwalter;
	}


	public List<Buch> getBücher() {
		return bücher;
	}


	public List<Autor> getAutoren() {
		return autoren;
	}


	public List<Verlag> getVerläge() {
		return verläge;
	}


	public List<BuchTyp> getBuchTypen() {
		return buchTypen;
	}
}
