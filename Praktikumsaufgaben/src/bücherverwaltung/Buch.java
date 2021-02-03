package bücherverwaltung;

public class Buch implements Comparable<Buch>{

	private String titel = "unbekannt";
	private String isbn = "unbekannt";
	private int erscheinungsJahr = 0;
	
//	private Verlag verlag = null;
//	private BuchTyp buchTyp = null;
	private Autor autor = null;
	
	public Buch(String titel, String isbn, int erscheinungsJahr) {
		setTitel(titel);
		setIsbn(isbn);
		setErscheinungsJahr(erscheinungsJahr);
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getErscheinungsJahr() {
		return erscheinungsJahr;
	}

	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int compareTo(Buch o) {
		if (this.titel.equals(o.titel)) {
			return 0;
		}
		return this.titel.compareTo(o.titel);
	}

	
	
	

}
