package bücherverwaltung;

public class BuchTypListe {

	private static BuchTyp[] buchTypArray;
	
	public BuchTypListe() {
		buchTypArray = new BuchTyp[10];
	}
	
	private void addBuchTyp(String bezeichnung) {
		for (int i = 0; i <= buchTypArray.length; i++) {
			if (buchTypArray[i] != null) {
				buchTypArray[i] = new BuchTyp(bezeichnung);
			}
		}
	}

}
