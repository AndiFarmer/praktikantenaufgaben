package bücherVerwaltung;

public class BuchTyp implements Comparable<BuchTyp> {

	String bezeichnung;
	
	public BuchTyp(String input) {
		setBezeichnung(input);
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
	
	
	@Override
	public String toString() {
		return bezeichnung;
	}
	
	
	public String getBezeichnung() {
		return bezeichnung;
	}

	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}


	
	
}
