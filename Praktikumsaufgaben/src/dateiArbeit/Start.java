package dateiArbeit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.regex.Matcher;

import javax.xml.soap.Text;


public class Start {

	static File myFile = new File("C:\\Users\\z1300a2k\\Documents\\beispielDatei.txt");
	static File myFile2 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreiben.txt");
	static File myFile3 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreibenRückwärts.txt");
	static File myFile4 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreibenRückwärtsZeilenweise.txt");
	static File myFile5 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreibenROT13.txt");
	static File myFile6 = new File("C:\\Users\\z1300a2k\\Documents\\beispielDateiSchreibenWortAustauschen.txt");
	static File myFile7 = new File("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8.txt");
	
	public static void main(String[] args) {
		FileChanger myFileTextEditor = new FileChanger();
		myFileTextEditor.ReadFileEncoding8859_1AndWriteEncodingUTF_8(Start.myFile, Start.myFile7);
		myFileTextEditor.ReadFileAndWriteWithROT13(Start.myFile, Start.myFile5);
		myFileTextEditor.ReadFileAndReplaceWord(Start.myFile, Start.myFile6, "$", "\\");
		Start.gebeDateiZeichenweiseAus(Start.myFile);
		System.out.println();
		Start.gebeDateiZeichenweiseAus(Start.myFile5);
		System.out.println();
		Start.gebeDateiZeichenweiseAus(Start.myFile6);
		
		System.exit(0);
	}
	
	private static void einlesenUndSchreibenMitWortaustausch(File readFile, File writeFile) {
		System.out.println("einlesenUndSchreibenMitWortaustausch");
		System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			
			BufferedReader in = Start.generateBufferedReader(readFile);
			String zeile = "";
			StringBuffer wholeTextBackward =  new StringBuffer();
			PrintWriter pw = Start.generatePrintWriter(writeFile);
			System.out.println(in.lines());
			try {
				while ((zeile = in.readLine()) != null) { //falls am Ende der Datei noch Newlines sind, dann werden diese gekürzt
					for (int i = (zeile.length()-1); i >= 0; i--) {
						wholeTextBackward.append(zeile.charAt(i));
					}
//					in.mark(100); //Wenn Zeile länger dann Problem
//					if (in.readLine() != null) {
						wholeTextBackward.append(System.lineSeparator());
//					}
//					in.reset();
				}
				if(wholeTextBackward.length() > 0  ) {
					wholeTextBackward.delete(wholeTextBackward.length()-2, wholeTextBackward.length()); // löscht das letzte NewLine
				}
				System.out.println(wholeTextBackward.length() + "-> Länge des zu Schreibenden Textes");
				pw.print(wholeTextBackward);
				pw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				Start.closeReader(in);
				Start.closeWriter(pw);
			}
		}
	}
	
	private static void einlesenUndMitROT13Schreiben(File readFile, File writeFile) {
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			
			System.out.println("EinlesenUndMitROT13Schreiben");
			System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
			BufferedReader in = Start.generateBufferedReader(readFile);
			char c = 0;
			StringBuffer wholeTextRot13 =  new StringBuffer();
			PrintWriter pw = Start.generatePrintWriter(writeFile);
			try {
				char abbruch = (char) -1;
				while ((c = (char) in.read()) != abbruch) {
					char cEncrypted = (char) (c + 13);
					wholeTextRot13.append(cEncrypted);
				}
				
				////////// HIER WERDEN ZWEI ZEICHEN ANGEHÄGT /////////
				System.out.println(wholeTextRot13.length() + "-> Länge des zu Schreibenden Textes");
				pw.print(wholeTextRot13);
//				pw.write(wholeTextRot13.toString()); -> ändert nichts an der Zeichenanzahl in Datei
				pw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				Start.closeReader(in);
				Start.closeWriter(pw);
			}
		}
	}
	
	private static void einlesenUndZeilenweiseRückwärtsSchreiben(File readFile, File writeFile) {
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			
			System.out.println("EinlesenUndZeilenweiseRückwärtsSchreiben");
			System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
			BufferedReader in = Start.generateBufferedReader(readFile);
			String zeile = "";
			ArrayList<String> lineArray = new ArrayList<>();
			StringBuffer linesBackward =  new StringBuffer();
			PrintWriter pw = Start.generatePrintWriter(writeFile);
			try {
				while ((zeile = in.readLine()) != null) {
					lineArray.add(zeile);				
				}
				for (int i = (lineArray.size()-1); i >= 0; i--)
				{
					linesBackward.append(lineArray.get(i));
					linesBackward.append(System.lineSeparator());
				}
				if(linesBackward.length() > 0) {
					linesBackward.delete(linesBackward.length()-2, linesBackward.length()); // löscht das letzte NewLine
				}
				
				
				//////// HIER WERDEN KEINE ZEICHEN ANGEHÄGT /////////
				System.out.println(linesBackward.length() + "-> Länge des zu Schreibenden Textes");
				pw.print(linesBackward);
				pw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				Start.closeReader(in);
				Start.closeWriter(pw);
			}
		}
	}
	
	private static void einlesenUndBuchstabenweiseRückwärtsSchreiben(File readFile, File writeFile) {
		System.out.println("EinlesenUndBuchstabenweiseRückwärtsSchreiben");
		System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			
			BufferedReader in = Start.generateBufferedReader(readFile);
			String zeile = "";
			StringBuffer wholeTextBackward =  new StringBuffer();
			PrintWriter pw = Start.generatePrintWriter(writeFile);
			
			try {
				while ((zeile = in.readLine()) != null) { //falls am Ende der Datei noch Newlines sind, dann werden diese gekürzt
					for (int i = (zeile.length()-1); i >= 0; i--) {
						wholeTextBackward.append(zeile.charAt(i));
					}
//					in.mark(100); //Wenn Zeile länger dann Problem
//					if (in.readLine() != null) {
						wholeTextBackward.append(System.lineSeparator());
//					}
//					in.reset();
				}
				if(wholeTextBackward.length() > 0  ) {
//					wholeTextBackward.delete(wholeTextBackward.length()-2, wholeTextBackward.length()); // löscht das letzte NewLine
				}
				System.out.println(wholeTextBackward.length() + "-> Länge des zu Schreibenden Textes");
				pw.print(wholeTextBackward);
				pw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				Start.closeReader(in);
				Start.closeWriter(pw);
			}
		}
	}

	public static void einlesenUndSchreibenVonText(File readFile, File writeFile) {
		System.out.println("EinlesenUndSchreibenVonText");	
		System.out.println(readFile.length() + "-> Länge der Ursprungsdatei");
		FileReader fr = Start.generateFileReader(readFile);
		PrintWriter fw = Start.generatePrintWriter(writeFile);
		if (readFile.isFile() && readFile.canRead() && writeFile.canWrite()) {
			try {
				char zeichen = 0;
				char abbruch = (char) -1;
				while ((zeichen = (char)fr.read()) != abbruch) { //abbruch seperat deklariert nötig, da read beim Ende -1 zurückgibt
					fw.write(zeichen);
				}
				fw.flush();
				System.out.println(writeFile.length() + "-> Länge der beschriebenen Datei");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			finally {
				Start.closeReader(fr);
				Start.closeWriter(fw);
			}
		}
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

	private static BufferedReader generateBufferedReader(File inputFile) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
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
	
	private static FileReader generateFileReader(File inputFile) {
		try {
			FileReader fr = new FileReader(inputFile);
			return fr;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void gebeDateiZeichenweiseAus(File inputFile) {
		System.out.println("Zeichenweise Ausgabe von: " + inputFile);
		System.out.println(inputFile.length());
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = Start.generateFileReader(inputFile);
			for (int i = 0; i < inputFile.length(); i++) {
				try {
					char c = (char)fr.read();
					System.out.print(c);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Start.closeReader(fr);
		}
	}
	
	public static void gebeDateiZeilenweiseAus(File inputFile) {
		System.out.println("Zeilenweise Ausgabe von: " + inputFile);
		if (inputFile.isFile() && inputFile.canRead()) {
			BufferedReader in = Start.generateBufferedReader(inputFile);
			String zeile = null;
			try {
				while ((zeile = in.readLine()) != null) {
					System.out.println(zeile);
				}
			} catch (IOException e) { e.printStackTrace(); }
			finally {
				Start.closeReader(in);
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
	
	public static void gebeDateiROT13DecryptedAus(File inputFile) {
		System.out.println("ROT13 Decrypted von: " + inputFile);
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = Start.generateFileReader(inputFile);
			System.out.println(inputFile.length());
			for (int i = 0; i < inputFile.length(); i++) {
				try {
					char c = (char)fr.read();
					char cDecrypted = (char) (c-13);
					System.out.print(cDecrypted);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Start.closeReader(fr);
		} 
	}
	
	public static void gebeDateiZeichenweiseAusInHexa(File inputFile) {
		System.out.println("Zeichenweise Ausgabe als Hexadezimalzahl von: " + inputFile);
		System.out.println(inputFile.length());
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = Start.generateFileReader(inputFile);
			for (int i = 0; i < inputFile.length(); i++) {
				try {
					char c = (char)fr.read();
					System.out.print(Integer.toHexString(c) + " ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Start.closeReader(fr);
		}
	}
	
	private static void gebeDateiZeichenweiseAusInDezimal(File inputFile) {
		System.out.println("Zeichenweise Ausgabe als Dezimalzahl von: " + inputFile);
		System.out.println(inputFile.length());
		if (inputFile.isFile() && inputFile.canRead()) {
			FileReader fr = Start.generateFileReader(inputFile);
			for (int i = 0; i < inputFile.length(); i++) {
				try {
					char c = (char)fr.read();
					System.out.print((int) c + " ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Start.closeReader(fr);
		}
	}

}
