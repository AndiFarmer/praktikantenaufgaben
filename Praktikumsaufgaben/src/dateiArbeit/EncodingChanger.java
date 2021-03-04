package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFormat.Encoding;

public class EncodingChanger {

	private static EncodingChanger singleton = null; //
	
	private EncodingChanger() {
		
	}
	
	public void ReadFileAndWrite(File readFile, File writeFile, DateiLeser dateiLeser, DateiSchreiber dateiSchreiber, String readEncoding, String writeEncoding) {
		try {
			dateiLeser.initializeReader(readFile, readEncoding);
			dateiSchreiber.initializeWriter(writeFile, writeEncoding);
			char c;
			char abbruch = (char) -1;
			StringBuffer sb = new StringBuffer();
			int zähler = 0;
			while ((c = (char) dateiLeser.readChar()) != abbruch) {
				dateiSchreiber.writeChar(c);
				System.out.print(Integer.toHexString(c) + " ");
				sb.append(c);
				zähler++;
			}
			System.out.println(" als Zeichen(Anzahl " +zähler+ "): " + sb.toString());
			System.out.println();
			dateiLeser.reset();
			dateiSchreiber.reset();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EncodingChanger getInstance() {
		if (EncodingChanger.singleton == null) {
			EncodingChanger.singleton = new EncodingChanger();
		}
		return EncodingChanger.singleton;
	}

}
