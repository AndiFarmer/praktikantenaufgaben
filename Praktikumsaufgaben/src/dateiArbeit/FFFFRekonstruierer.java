package dateiArbeit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class FFFFRekonstruierer {

	/*Das Schreiben einer Datei mit den ausgelesenen Zeichen klappt ohne Probleme,
	 * aber falls du das auch mal durchgehen möchtest, ist Code zum Schreiben auskommentiert dabei*/
	
	
	
	private static File file = new File("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8Lesen.txt"); /* Datei mit €, ß, ö, ä, etc. einfügen */
	
	public static void main(String[] args) {
		FFFFRekonstruierer.gebeDateiZeichenweiseAus(FFFFRekonstruierer.file);
		System.out.println();
		FFFFRekonstruierer.gebeDateiZeichenweiseAusInHexa(FFFFRekonstruierer.file);
		FFFFRekonstruierer.schreibeDateiZeichenweise(FFFFRekonstruierer.file, new File ("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8Schreiben.txt"));
		FFFFRekonstruierer.gebeDateiZeichenweiseAusInHexa(new File ("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8Schreiben.txt"));
		System.exit(0);
	}

	public static void gebeDateiZeichenweiseAus(File inputFile) {
		System.out.println("Zeichenweise Ausgabe von: " + inputFile);
		System.out.println("Länge der Datei: " + inputFile.length());
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = FFFFRekonstruierer.generateFileReader(inputFile);
				try {
					char zeichen = 0;
					char abbruch = (char) -1;
					while ((zeichen = (char)fr.read()) != abbruch) { 
						System.out.println(zeichen);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				FFFFRekonstruierer.closeReader(fr);
		}
	}
	
	public static void schreibeDateiZeichenweise(File readFile, File writeFile) {
		System.out.println("EinlesenUndSchreibenVonText");	
		System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
		FileReader fr = FFFFRekonstruierer.generateFileReader(readFile);
		PrintWriter fw = FFFFRekonstruierer.generatePrintWriter(writeFile);
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			try {
				char zeichen = 0;
				char abbruch = (char) -1;
				while ((zeichen = (char)fr.read()) != abbruch) { 
					fw.write(zeichen);
				}
				fw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			FFFFRekonstruierer.closeReader(fr);
			FFFFRekonstruierer.closeWriter(fw);
		}
	}
	
	public static void gebeDateiZeichenweiseAusInHexa(File inputFile) {
		System.out.println("Zeichenweise Ausgabe als Hexadezimalzahl von: " + inputFile);
		System.out.println("Länge der Datei: " + inputFile.length());
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = FFFFRekonstruierer.generateFileReader(inputFile);
			for (int i = 0; i < inputFile.length(); i++) {
				try {
					char c = (char)fr.read();
					System.out.print(Integer.toHexString(c) + " ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			FFFFRekonstruierer.closeReader(fr);
		}
	}
	
	private static FileReader generateFileReader(File inputFile) {
		try {
			FileReader fr = new FileReader(inputFile);
			return fr;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static PrintWriter generatePrintWriter(File inputFile) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(inputFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	private static void closeReader(Reader in) {
		if (in != null) {
			try { in.close(); } catch (IOException e) {	e.printStackTrace(); }
		}
	}
	
	private static void closeWriter(Writer w) {
		if (w != null) {
			try { w.close(); } catch (IOException e) {	e.printStackTrace(); }
		}
	}
}
