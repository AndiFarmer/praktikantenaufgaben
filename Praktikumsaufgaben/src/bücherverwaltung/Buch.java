package bücherverwaltung;

public class Buch {

	private String isbn = "unbekannt";
	private String titel = "unbekannt";
	private String autor = "unbekannt";
	private int erscheinungsJahr = 0;
	private String verlag = "unbekannt";
	private String art = "unbekannt";
	
	public Buch() {
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getErscheinungsJahr() {
		return erscheinungsJahr;
	}

	public void setErscheinungsJahr(int erscheinungsJahr) {
		this.erscheinungsJahr = erscheinungsJahr;
	}

	public String getVerlag() {
		return verlag;
	}

	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	
}
