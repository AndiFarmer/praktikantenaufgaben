package bücherVerwaltung;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BücherVerwaltung {
	
	private AutorenVerwalter autorenVerwalter;
	private VerlagVerwalter verlagVerwalter;
	private BuchTypVerwalter buchTypVerwalter;
	
	private Set<Buch> bücher;
	
	private Set<Autor> autoren;
	private Set<Verlag> verläge;
	private Set<BuchTyp> buchTypen;
	
	
	public BücherVerwaltung() {
		autorenVerwalter = new AutorenVerwalter();
		verlagVerwalter = new VerlagVerwalter();
		buchTypVerwalter = new BuchTypVerwalter();
		
		bücher = new HashSet<Buch>();
		
		autoren = new HashSet<Autor>();
		verläge = new HashSet<Verlag>();
		buchTypen = new HashSet<BuchTyp>();
	}


	public AutorenVerwalter getAutorenVerwalter() {
		return autorenVerwalter;
	}


	public void setAutorenVerwalter(AutorenVerwalter autorenVerwalter) {
		this.autorenVerwalter = autorenVerwalter;
	}


	public VerlagVerwalter getVerlagVerwalter() {
		return verlagVerwalter;
	}


	public void setVerlagVerwalter(VerlagVerwalter verlagVerwalter) {
		this.verlagVerwalter = verlagVerwalter;
	}


	public BuchTypVerwalter getBuchTypVerwalter() {
		return buchTypVerwalter;
	}


	public void setBuchTypVerwalter(BuchTypVerwalter buchTypVerwalter) {
		this.buchTypVerwalter = buchTypVerwalter;
	}


	public Set<Buch> getBücher() {
		return bücher;
	}


	public void setBücher(Set<Buch> bücher) {
		this.bücher = bücher;
	}


	public Set<Autor> getAutoren() {
		return autoren;
	}


	public void setAutoren(Set<Autor> autoren) {
		this.autoren = autoren;
	}


	public Set<Verlag> getVerläge() {
		return verläge;
	}


	public void setVerläge(Set<Verlag> verläge) {
		this.verläge = verläge;
	}


	public Set<BuchTyp> getBuchTypen() {
		return buchTypen;
	}


	public void setBuchTypen(Set<BuchTyp> buchTypen) {
		this.buchTypen = buchTypen;
	}
	
	
	

}
