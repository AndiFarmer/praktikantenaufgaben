package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DateiLeser {

	public DateiLeser() {
	}
	
	public String readTextFile(File file) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = this.generateBufferedReader(file);
		if (! (file.isFile() && file.canRead())) {
			System.err.println("Datei kann nicht gelesen werden");
			return null;
		}
		try {
			char zeichen = 0;
			char abbruch = (char) -1;
			while ((zeichen = (char)br.read()) != abbruch) { //abbruch seperat deklariert nötig, da read beim Ende -1 zurückgibt
				sb.append(zeichen);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			this.closeReader(br);
		}
		return sb.toString();
	}
	
	private BufferedReader generateBufferedReader(File inputFile) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	private void closeReader(Reader in) {
		if (in != null) {
			try { in.close(); } catch (IOException e) {	e.printStackTrace(); }
		}
	}
}
