package bücherVerwaltung;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class BücherVerwaltung implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151384285086266694L;
	private transient AutorenVerwalter autorenVerwalter;
	private transient VerlagVerwalter verlagVerwalter;
	private transient BuchTypVerwalter buchTypVerwalter;
	
	private transient CollectionAdjuster collectionAdjuster;
	
	private Collection<Buch> bücher;
	
	private Collection<Autor> autoren;
	private Collection<Verlag> verläge;
	private Collection<BuchTyp> buchTypen;
	
	
	public BücherVerwaltung() {
		this.autorenVerwalter = new AutorenVerwalter(this);
		this.verlagVerwalter = new VerlagVerwalter(this);
		this.buchTypVerwalter = new BuchTypVerwalter(this);
		this.collectionAdjuster = new CollectionAdjuster(this);
		this.bücher = new ArrayList<Buch>();
		this.autoren = new ArrayList<Autor>();
		this.verläge = new ArrayList<Verlag>();
		this.buchTypen = new ArrayList<BuchTyp>();
	}

	
	public boolean addNewBuch(Buch neuesBuch) { // String titel, String isbn, int erscheinungsJahr, Collection<Verlag> beteiligteVerläge, BuchTyp myBuchTyp, Collection<Autor> beteiligteAutoren
//		Buch neuesBuch = new Buch(titel, isbn, erscheinungsJahr, beteiligteVerläge, myBuchTyp, beteiligteAutoren);
		if (! this.bücher.contains(neuesBuch)) {
			this.collectionAdjuster.adjustCollectionsEffectedByBuchAdding(neuesBuch);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteBuch(Buch buch) {
//		Buch buch = new Buch(titel, isbn, erscheinungsJahr, beteiligteVerläge, myBuchTyp, beteiligteAutoren);
		if (! this.bücher.contains(buch)) {
			return false;
		} else {
			this.collectionAdjuster.adjustCollectionsEffectedByBuchDeletion(buch);
			return true;
		}
	}
	
	public void addAutorToBuch(Buch buch, Autor newAutor, boolean autorSchonvorhanden) {
		this.collectionAdjuster.adjustCollectionsEffectedByAutorAdding(buch, newAutor, autorSchonvorhanden);
	}
	
	public void addVerlagToBuch(Buch buch, Verlag newVerlag, boolean verlagSchonvorhanden) {
		this.collectionAdjuster.adjustCollectionsEffectedByVerlagAdding(buch, newVerlag, verlagSchonvorhanden);
	}
	
	public void removeAutorFromBuch(Buch buch, Autor autor) {
		this.collectionAdjuster.adjustCollectionsEffectedByAutorRemovalFromBuch(buch, autor);
	}
	
	public void removeVerlagFromBuch(Buch buch, Verlag verlag) {
		this.collectionAdjuster.adjustCollectionsEffectedByVerlagRemovalFromBuch(buch, verlag);
	}
	
	public void changeBuchTyp(Buch buch, BuchTyp newBuchTyp) {
		BuchTyp oldBuchTyp = buch.getBuchTyp();
		buch.setBuchTyp(newBuchTyp);
		this.collectionAdjuster.adjustCollectionsEffectedByBuchTypChange(newBuchTyp, oldBuchTyp);
	}
	
	public Buch searchBuch(Buch searchedBuch) {
//		ArrayList<Buch> helpList = new ArrayList<>(bücher); 
//		helpList.sort(null);
//		return helpList.get(Collections.binarySearch(helpList, searchedBuch));
		for (Buch buch : this.bücher) {
			if (buch.equals(searchedBuch)) {
				return buch;
			}
		}
		return null;
	}
	
	public void saveBücherAutorenVerlägeBuchTypen(File bücherFile, File autorenFile, File verlägeFile, File buchTypenFile) 
			throws BücherVerwaltungException {
		FileOutputStream bücherFos;
		FileOutputStream autorenFos;
		FileOutputStream verlägeFos;
		FileOutputStream buchTypenFos;
		try {
			bücherFos = new FileOutputStream(bücherFile);
			autorenFos = new FileOutputStream(autorenFile);
			verlägeFos = new FileOutputStream(verlägeFile);
			buchTypenFos = new FileOutputStream(buchTypenFile);
			BufferedOutputStream bücherBos = new BufferedOutputStream(bücherFos);
			BufferedOutputStream autorenBos = new BufferedOutputStream(autorenFos);
			BufferedOutputStream verlägeBos = new BufferedOutputStream(verlägeFos);
			BufferedOutputStream buchTypenBos = new BufferedOutputStream(buchTypenFos);
			ObjectOutputStream bücherOos = new ObjectOutputStream(bücherBos);
			ObjectOutputStream autorenOos = new ObjectOutputStream(autorenBos);
			ObjectOutputStream verlägeOos = new ObjectOutputStream(verlägeBos);
			ObjectOutputStream buchTypenOos = new ObjectOutputStream(buchTypenBos);
			bücherOos.writeObject(this.getBücher());
			autorenOos.writeObject(this.getAutoren());
			verlägeOos.writeObject(this.getVerläge());
			buchTypenOos.writeObject(this.getBuchTypen());
			bücherOos.close();
			autorenOos.close();
			verlägeOos.close();
			buchTypenOos.close();
		} catch (IOException e) {
			throw new BücherVerwaltungException("Das Speichern der Bücher und oder Autoren und oder Verläge und "
					+ "oder BuchTypen ist fehlgeschlagen, da die Datei(en) nicht geschrieben werden kann/können");
		}
	}
	
	public void loadBücherAutorenVerlägeBuchTypen(File bücherFile, File autorenFile, File verlägeFile, File buchTypenFile) {
		FileInputStream bücherFis;
		FileInputStream autorenFis;
		FileInputStream verlägeFis;
		FileInputStream buchTypenFis;
		try {
			bücherFis = new FileInputStream(bücherFile);
			autorenFis = new FileInputStream(autorenFile);
			verlägeFis = new FileInputStream(verlägeFile);
			buchTypenFis = new FileInputStream(buchTypenFile);
			BufferedInputStream bücherBis = new BufferedInputStream(bücherFis);
			BufferedInputStream autorenBis = new BufferedInputStream(autorenFis);
			BufferedInputStream verlägeBis = new BufferedInputStream(verlägeFis);
			BufferedInputStream buchTypenBis = new BufferedInputStream(buchTypenFis);
			ObjectInputStream bücherOis = new ObjectInputStream(bücherBis);
			ObjectInputStream autorenOis = new ObjectInputStream(autorenBis);
			ObjectInputStream verlägeOis = new ObjectInputStream(verlägeBis);
			ObjectInputStream buchTypenOis = new ObjectInputStream(buchTypenBis);
			this.setBücher((Collection<Buch>) bücherOis.readObject());
			this.setAutoren((Collection<Autor>) autorenOis.readObject());
			this.setVerläge((Collection<Verlag>) verlägeOis.readObject());
			this.setBuchTypen((Collection<BuchTyp>) buchTypenOis.readObject());
			bücherOis.close();
			autorenOis.close();
			verlägeOis.close();
			buchTypenOis.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Die Bücher und oder Autoren und oder Verläge und oder BuchTypen konnten nicht geladen werden, weil die Datei(en) nicht existiert/existieren oder "
					+ "nicht gelesen werden kann/können");
		} catch (ClassNotFoundException e) {
			System.err.println("Die Bücher und oder Autoren und oder Verläge und oder BuchTypen konnten nicht geladen werden, weil die UID('s) der Datei(en) mit keiner aus dem Programm übereinstimmt");
			e.printStackTrace();
		}
	}
	
	public void saveBücher(File file) throws BücherVerwaltungException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this.getBücher());
			oos.close();
		} catch (IOException e) {
			throw new BücherVerwaltungException("Das Speichern der Bücher ist fehlgeschlagen, da die Datei nicht "
					+ "geschrieben werden kann");
		}
	}
	
	public void loadBücher(File file) {
		try {
			FileInputStream fis = new FileInputStream(file); /* kein file.canRead() bzw. file.isFile() nötig, 
																da in dieser Zeile indirekt behandelt*/
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Collection<Buch> helpCollection = new ArrayList<>((Collection<? extends Buch>) ois.readObject());
			for (Buch helpBuch : helpCollection) {
				this.addNewBuch(helpBuch);
			}
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Die Bücher konnten nicht geladen werden, weil die Datei nicht existiert oder "
					+ "nicht gelesen werden kann");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Die Bücher konnten nicht geladen werden, weil die UID der Datei mit keiner aus "
					+ "dem Programm übereinstimmt");
		}
	}

	public void save(File file) throws BücherVerwaltungException {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			XMLEncoder encoder = new XMLEncoder(bos);
//			ObjectOutputStream oos = new ObjectOutputStream(bos);
			encoder.writeObject(this);
			encoder.close();
			bos.close();
		} catch (IOException e) {
			throw new BücherVerwaltungException("Das Speichern der BücherVerwaltung ist fehlgeschlagen, da die Datei nicht "
					+ "geschrieben werden kann");
		}
	}
	
	public BücherVerwaltung load(File file) { //  throws BücherVerwaltungException
		try {
			FileInputStream fis = new FileInputStream(file); /* kein file.canRead() bzw. file.isFile() nötig, 
																da in dieser Zeile indirekt behandelt*/
			BufferedInputStream bis = new BufferedInputStream(fis);
//			ObjectInputStream ois = new ObjectInputStream(bis);
			XMLDecoder decoder = new XMLDecoder(bis);
			BücherVerwaltung output = (BücherVerwaltung) decoder.readObject();
			decoder.close();
			bis.close();
			return output;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Die BücherVerwaltung konnte nicht geladen werden, weil die Datei nicht existiert oder "
					+ "nicht gelesen werden kann");
		} 
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.err.println("Die BücherVerwaltung konnte nicht geladen werden, weil die UID der Datei mit keiner "
//					+ "aus dem Programm übereinstimmt");
//		}
		return null;
	}
	
	public AutorenVerwalter getAutorenVerwalter() {
		return this.autorenVerwalter;
	}


	public void setAutorenVerwalter(AutorenVerwalter autorenVerwalter) {
		this.autorenVerwalter = autorenVerwalter;
	}


	public VerlagVerwalter getVerlagVerwalter() {
		return this.verlagVerwalter;
	}


	public void setVerlagVerwalter(VerlagVerwalter verlagVerwalter) {
		this.verlagVerwalter = verlagVerwalter;
	}


	public BuchTypVerwalter getBuchTypVerwalter() {
		return this.buchTypVerwalter;
	}


	public void setBuchTypVerwalter(BuchTypVerwalter buchTypVerwalter) {
		this.buchTypVerwalter = buchTypVerwalter;
	}


	public Collection<Buch> getBücher() {
		return this.bücher;
	}


	public void setBücher(Collection<Buch> bücher) {
		this.bücher = bücher;
	}


	public Collection<Autor> getAutoren() {
		return this.autoren;
	}


	public void setAutoren(Collection<Autor> autoren) {
		this.autoren = autoren;
	}


	public Collection<Verlag> getVerläge() {
		return this.verläge;
	}


	public void setVerläge(Collection<Verlag> verläge) {
		this.verläge = verläge;
	}


	public Collection<BuchTyp> getBuchTypen() {
		return this.buchTypen;
	}


	public void setBuchTypen(Collection<BuchTyp> buchTypen) {
		this.buchTypen = buchTypen;
	}
}
