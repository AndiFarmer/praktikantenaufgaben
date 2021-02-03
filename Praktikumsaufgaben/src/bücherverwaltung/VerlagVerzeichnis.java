package bücherverwaltung;

public class VerlagVerzeichnis {

	private static Verlag[] verlagArray;
	
	public VerlagVerzeichnis() {
		verlagArray = new Verlag[100];
	}

	private void addVerlag(String name, String ort) {
		for (int i = 0; i <= verlagArray.length; i++) {
			if (verlagArray[i] != null) {
				verlagArray[i] = new Verlag(name, ort);
			}
		}
	}
}
