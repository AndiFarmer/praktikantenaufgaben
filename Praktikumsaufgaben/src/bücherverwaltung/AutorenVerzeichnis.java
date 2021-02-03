package bücherverwaltung;

public class AutorenVerzeichnis {

	private static Autor[] autorenArray;
	
	public AutorenVerzeichnis(String vorname, String nachname) {
		autorenArray = new Autor[1000];
	}

	private void addAutor(String vorname, String nachname) {
		for (int i = 0; i <= autorenArray.length; i++) {
			if (autorenArray[i] != null) {
				autorenArray[i] = new Autor(vorname, nachname);
			}
		}
	}
}
