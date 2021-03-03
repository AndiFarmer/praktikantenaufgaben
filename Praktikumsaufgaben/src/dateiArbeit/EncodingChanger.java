package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFormat.Encoding;

public class EncodingChanger {

	private static EncodingChanger singleton = null;
	
	static {
		
	}
	private EncodingChanger() {
		
	}
	
	public String ReadFileEncoding8859_1AndWriteEncodingUTF_8(File readFile) {
		if (! (readFile.isFile() && readFile.canRead())) {
			System.err.println("Datei kann nicht gelesen werden");
			return null;
		}
		StringBuffer sb = new StringBuffer();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readFile), "ISO-8859-1"))) {
			char zeichen = 0;
			char abbruch = (char) -1;
			while ((zeichen = (char) reader.read()) != abbruch) {
				sb.append(zeichen);
			}
			reader.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static EncodingChanger getInstance() {
		if (EncodingChanger.singleton == null) {
			EncodingChanger.singleton = new EncodingChanger();
		}
		return EncodingChanger.singleton;
	}

}
