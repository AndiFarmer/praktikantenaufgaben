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
	
	public void readAndWriteWithCertainEncodings(File readFile, File writeFile, DateiLeser dateiLeser, DateiSchreiber dateiSchreiber, String readEncoding, String writeEncoding) {
		try {
			dateiLeser.initializeReader(readFile, readEncoding);
			dateiSchreiber.initializeWriter(writeFile, writeEncoding);
			char c;
			char abbruch = (char) -1;
			StringBuffer sb = new StringBuffer();
			System.out.println("Ausgabe im Encoding " + readEncoding + " (während des Lesens): ");
			while ((c = (char) dateiLeser.readChar()) != abbruch) {
				System.out.print(Integer.toHexString(c) + " ");
				dateiSchreiber.writeChar(c);
				sb.append(c);
			}
			System.out.println();
			System.out.println(sb.toString());
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
