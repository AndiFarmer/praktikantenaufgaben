package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Start {

	static File myFile = new File("C:\\Users\\z1300a2k\\Documents\\beispielDatei.txt");
	static File myFile2 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreiben.txt");
	
	StringBuffer wholeText; //evtl. noch nützlich
	
	public static void main(String[] args) {
		
		System.out.println("EinlesenUndSchreibenVonText\n");
		Start.EinlesenUndSchreibenVonText();
		
		System.out.println();
		Start.gebeDateiZeilenweiseAus(Start.myFile);
		System.out.println();
		Start.gebeDateiByteweiseAus(Start.myFile);
		System.out.println();
		Start.gebeDateiZeichenweiseAus(Start.myFile2);
		System.out.println();
		Start.gebeDateiByteweiseAus(Start.myFile2);
		
		System.exit(0);
	}
	
	
	public static void EinlesenUndSchreibenVonText() {
		FileReader fr = null;
		FileWriter fw = null;
		try { fr = new FileReader(Start.myFile); }
		catch (FileNotFoundException e1) { e1.printStackTrace(); }
		try { fw = new FileWriter("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreiben.txt"); } 
		catch ( IOException e ) { System.err.println( "Konnte Datei nicht erstellen" ); }
		
		if (Start.myFile.isFile() && Start.myFile.canRead()) {
			try {
				char zeichen = 0;
				char abbruch = (char) -1;
				while ((zeichen = (char)fr.read()) != abbruch) { //abbruch seperat deklariert nötig, da read beim Ende -1 zurückgibt
					fw.write(zeichen);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			finally {
				if (fr != null) {
					try { fr.close(); } catch (IOException e) {	e.printStackTrace(); }
				}
				if ( fw != null ) {
					try { fw.close(); } catch ( IOException e ) { e.printStackTrace(); } 
				}
			}
		}
	}

	
	public static void gebeDateiZeichenweiseAus(File inputFile) {
		System.out.println("Zeichenweise Ausgabe von: " + inputFile);
		if (inputFile.isFile() && inputFile.canRead()) {
			try {
				FileReader fr = new FileReader(inputFile);
				for (int i = 0; i < inputFile.length(); i++) {
					try {
						char c = (char)fr.read();
						System.out.print(c);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					if (fr != null) {
						try { fr.close(); } catch (IOException e) {	e.printStackTrace(); }
					}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void gebeDateiZeilenweiseAus(File inputFile) {
		System.out.println("Zeilenweise Ausgabe von: " + inputFile);
		if (inputFile.isFile() && inputFile.canRead()) {
			BufferedReader in = null;
			FileReader fr = null;
			try {
				in = new BufferedReader(fr = new FileReader(inputFile));
			} catch (FileNotFoundException e) { e.printStackTrace(); }
			String zeile = null;
			try {
				while ((zeile = in.readLine()) != null) {
					System.out.println(zeile);
				}
			} catch (IOException e) { e.printStackTrace(); }
			finally {
				if (in != null) {
					try {
						in.close(); // schließt auch FileReader, bzw. inputReader
					}
					catch (IOException e) {
					}
				}
			}
		}
	}
	
	
	public static void gebeDateiByteweiseAus(File inputFile) {
		System.out.println("Byteweise Ausgabe von: " + inputFile);
		if (inputFile.isFile() && inputFile.canRead()) {
			byte[] buffer = new byte[(int) inputFile.length()];
			FileInputStream in = null;
			try {
				in = new FileInputStream(inputFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				in.read(buffer);
				for (int i = 0; i < buffer.length; i++) {
					System.out.print(buffer[i] + " ");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (in != null) {
					try {
						in.close(); // schließt auch FileReader, bzw. inputReader
					}
					catch (IOException e) {
					}
				}
			}
		}
	}
}
