package bücherVerwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class BücherVerwaltung {
	
	private AutorenVerwalter autorenVerwalter;
	private VerlagVerwalter verlagVerwalter;
	private BuchTypVerwalter buchTypVerwalter;
	
	private CollectionAdjuster collectionAdjuster;
	
	private Collection<Buch> bücher;
	
	private Collection<Autor> autoren;
	private Collection<Verlag> verläge;
	private Collection<BuchTyp> buchTypen;
	
	
	public BücherVerwaltung() {
		autorenVerwalter = new AutorenVerwalter();
		verlagVerwalter = new VerlagVerwalter();
		buchTypVerwalter = new BuchTypVerwalter();
		
		collectionAdjuster = new CollectionAdjuster(this);
		
		bücher = new ArrayList<Buch>();
		
		autoren = new HashSet<Autor>();
		verläge = new HashSet<Verlag>();
		buchTypen = new HashSet<BuchTyp>();
	}

	

}
