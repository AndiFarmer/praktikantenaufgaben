package bücherVerwaltung;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BuchTyp")
@XmlAccessorType (XmlAccessType.FIELD)

public class BuchTyp implements Comparable<BuchTyp>, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3987272742978418998L;
	String bezeichnung;
	
	public BuchTyp() {
		// Existiert nur zur Speicherung/Lesen als XML durch XMLEncoder/Decoder 
	}
	
	public BuchTyp(String input) {
		this.setBezeichnung(input);
	}

	
	@Override
	public String toString() {
		return "BuchTyp [bezeichnung=" + this.bezeichnung + "]";
	}


	@Override
	public int compareTo(BuchTyp otherBuchTyp) {
		if (otherBuchTyp == this) {
			return 0;
		}
		if (otherBuchTyp.equals(this )) {
			return 0;
		}
		return this.getBezeichnung().compareTo(otherBuchTyp.getBezeichnung());
	}
	
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (otherObject.getClass() == this.getClass()) {
			BuchTyp otherBuchTyp = (BuchTyp) otherObject;
			if(otherBuchTyp.getBezeichnung().equals(this.getBezeichnung())) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 29;
		int hashMultiplier = 43;
		for (int i = 0; i < this.getBezeichnung().length(); i++) {
			hc = hc + this.getBezeichnung().charAt(i);
		}
		hc = hc * hashMultiplier;
		return hc;
	}
	

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}
