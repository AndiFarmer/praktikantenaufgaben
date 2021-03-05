package dateiArbeit;

import java.io.File;
import java.io.IOException;

public class MethodenVergleicher {

	private static MethodenVergleicher singleton = null;
	private static DateiLeser myDateiLeser = null;
	private static DateiSchreiber myDateiSchreiber = null;
	
	static {
		MethodenVergleicher.myDateiLeser = new DateiLeser();
		MethodenVergleicher.myDateiSchreiber = new DateiSchreiber();
	}
	
	private MethodenVergleicher() {
		
	}

	public void vergleicheLesenUndSchreibenImBlockMitInStücken(File readFile, File writeFile) {
		try {
			MethodenVergleicher.myDateiLeser.initializeReader(readFile);
			MethodenVergleicher.myDateiSchreiber.initializeWriter(writeFile);
			long start = MethodenVergleicher.getTime();
			
			this.leseUndSchreibeImBlock();
			
			MethodenVergleicher.myDateiLeser.reset();
			MethodenVergleicher.myDateiSchreiber.reset();
			long ende = MethodenVergleicher.getTime();
			System.out.println("Blocklesen/-schreiben Dauer: " + (ende - start)); /* Es wird erst nach
			dem Resetten die Zeit gemessen, da durch das resetten auch geflusht wird uns somit das letzte
			Zeichen geschrieben wurde */ 
			
			
			MethodenVergleicher.myDateiLeser.initializeReader(readFile);
			MethodenVergleicher.myDateiSchreiber.initializeWriter(writeFile);
			start = MethodenVergleicher.getTime();
			
			this.leseUndSchreibeStückFürStück();
			
			MethodenVergleicher.myDateiLeser.reset();
			MethodenVergleicher.myDateiSchreiber.reset();
			ende = MethodenVergleicher.getTime();
			System.out.println("StückFürStücklesen/-schreiben Dauer: " + (ende - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void leseUndSchreibeStückFürStück() {
		char c;
		char abbruch = (char) -1;
		while ((c = (char) MethodenVergleicher.myDateiLeser.readChar()) != abbruch) {
			MethodenVergleicher.myDateiSchreiber.writeChar(c);
		}
	}

	private void leseUndSchreibeImBlock() {
		char c;
		char abbruch = (char) -1;
		StringBuffer sb = new StringBuffer();
		while ((c = (char) MethodenVergleicher.myDateiLeser.readChar()) != abbruch) {
			sb.append(c);
		}
		try {
			MethodenVergleicher.myDateiSchreiber.getWriter().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	public static MethodenVergleicher getInstance() {
		if (MethodenVergleicher.singleton == null) {
			MethodenVergleicher.singleton = new MethodenVergleicher();
		}
		return MethodenVergleicher.singleton;
	}
	
	public static long getTime() {
		return System.currentTimeMillis();
	}
}
