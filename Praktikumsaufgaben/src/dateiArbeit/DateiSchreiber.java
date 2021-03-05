package dateiArbeit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class DateiSchreiber {

	private Writer writer = null;
	private File file = null;

	public DateiSchreiber() {
		
	}

	public void writeChar(Character c) {
		try {
			this.getWriter().write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeWriter(File inputFile, String encoding) throws Exception {
		if (this.getWriter() == null) {
			this.setFile(inputFile);
			try {
				this.setWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.getFile()), encoding)));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if (! (inputFile.canWrite())) {
				System.err.println("Datei kann nicht beschrieben werden");
				this.reset();
				return;
			}
			
		} else {
			throw new Exception("Der Schreiber wurde in der letzten Benutzung nicht resetted");
		}
	}
	
	public void initializeWriter(File inputFile) throws Exception {
		if (this.getWriter() == null) {
			this.setFile(inputFile);
			try {
				this.setWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.getFile()))));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if (! (inputFile.canWrite())) {
				System.err.println("Datei kann nicht beschrieben werden");
				this.reset();
				return;
			}
			
		} else {
			throw new Exception("Der Schreiber wurde in der letzten Benutzung nicht resetted");
		}
	}
	
	public void reset() {
		try {
			this.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setWriter(null);
		this.setFile(null);
	}
	
	public void writeTextFile(File destination, String inputString) {
		if (! destination.canWrite()) {
			System.err.println("Datei kann nicht beschrieben werden");
			return;
		}
		PrintWriter pw = this.generatePrintWriter(destination);
		pw.write(inputString);
		this.closeWriter(pw);
	}
	
	private PrintWriter generatePrintWriter(File inputFile) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(inputFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	private void closeWriter(Writer w) {
		if (w != null) {
			try { w.close(); } catch (IOException e) {	e.printStackTrace(); }
		}
	}

	public Writer getWriter() {
		return this.writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
