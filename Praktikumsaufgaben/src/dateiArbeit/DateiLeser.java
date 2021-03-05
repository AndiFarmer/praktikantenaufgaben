package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class DateiLeser {

	File file = null;
	BufferedReader reader = null;
	
	public DateiLeser() {
		
	}
	
	public int readChar() {
		try {
			return this.getReader().read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void initializeReader(File inputFile, String encoding) throws Exception {
		if (this.getReader() == null) {
			if (! (inputFile.isFile() && inputFile.canRead())) {
				System.err.println("Datei kann nicht gelesen werden");
				return;
			}
			this.setFile(inputFile);
			try {
				this.setReader(new BufferedReader(new InputStreamReader(new FileInputStream(this.getFile()), encoding)));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Der Leser wurde in der letzten Benutzung nicht resetted");
		}
	}
	
	public void initializeReader(File inputFile) throws DateiArbeitException {
		if (this.getReader() == null) {
			if (! (inputFile.isFile() && inputFile.canRead())) {
				DateiArbeitException e = new DateiArbeitException("Datei: " + inputFile.getAbsolutePath() + " kann nicht gelesen werden");
				e.printStackTrace();
				throw e;
			}
			this.setFile(inputFile);
			try {
				this.setReader(new BufferedReader(new InputStreamReader(new FileInputStream(this.getFile()))));
			}
			catch (Exception e) {
				e.printStackTrace(); //loggen -> System.err
				throw new DateiArbeitException("Reader konnte nicht initialisiert werden.", e);
			}
		} else {
			throw new DateiArbeitException("Der Leser wurde in der letzten Benutzung nicht resetted");
		}
	}
	
	public void reset() {
		try {
			this.reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setReader(null);
		this.setFile(null);
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
	
	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public BufferedReader getReader() {
		return this.reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

}
