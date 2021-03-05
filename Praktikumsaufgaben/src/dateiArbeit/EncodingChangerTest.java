package dateiArbeit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncodingChangerTest {

	EncodingChanger myEncodingChanger = EncodingChanger.getInstance();
	
	@Test
	void testReadAndWriteWithCertainEncodings() {
		File readFile = new File("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8Lesen.txt");
		File writeFile = new File("C:\\Users\\z1300a2k\\Documents\\ReadFileEncoding8859_1AndWriteEncodingUTF_8Schreiben.txt");
		DateiLeser dateiLeser = new DateiLeser();
		DateiSchreiber dateiSchreiber = new DateiSchreiber();
		this.myEncodingChanger.readAndWriteWithCertainEncodings(
				readFile, writeFile, dateiLeser, dateiSchreiber, "ISO-8859-1", "UTF-8");
		String str = "â¬   Ã¶   Ã¼   Ã";
		String str2 = this.leseDateiInString(writeFile);
		System.out.println();
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(Integer.toString(str.charAt(i)) + " ");
		}
		System.out.println();
		System.out.println();
		for (int i = 0; i < str2.length(); i++) {
			System.out.print(Integer.toString(str2.charAt(i)) + " ");
		}
		Assertions.assertEquals(str, this.leseDateiInString(writeFile));
	}
	
	private String leseDateiInString(File readFile) {
		StringBuffer sb = null;
		if (readFile.isFile() && readFile.canRead()) {
			BufferedReader fr = this.generateBufferedReader(readFile);
			try {
				char c;
				char abbruch = (char) -1;
				sb = new StringBuffer();
				while ((c = (char) fr.read()) != abbruch) {
					sb.append(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.closeReader(fr);
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
	
	

}
