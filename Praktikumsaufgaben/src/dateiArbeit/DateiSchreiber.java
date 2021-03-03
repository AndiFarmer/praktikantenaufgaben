package dateiArbeit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class DateiSchreiber {

	private static DateiSchreiber singleton = null;

	private DateiSchreiber() {
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

	public static DateiSchreiber getInstance() {
		if (DateiSchreiber.singleton == null) {
			DateiSchreiber.singleton  = new DateiSchreiber();
		}
		return DateiSchreiber.singleton;
	}
}
