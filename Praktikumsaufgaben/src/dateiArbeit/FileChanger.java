package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFormat.Encoding;

public class FileChanger {

	private static ROT13Converter myROT13Converter = ROT13Converter.getInstance();
	private static WortFinder myWortFinder = WortFinder.getInstance();
	private EncodingChanger myEncodingchanger = EncodingChanger.getInstance();
	private DateiLeser myDateiLeser = null; // nicht static, denn wenn man mehrere FileChanger hat, 
											// will man ja nicht in allen in die gleiche Datei beschreiben
	private DateiSchreiber myDateiSchreiber = null;
	
	public FileChanger() {
		this.setMyDateiLeser(new DateiLeser());
		this.setMyDateiSchreiber(new DateiSchreiber());
	}
	
	public void ReadFileAndWriteWithROT13(File readFile, File writeFile) {
		String fileContent = this.getMyDateiLeser().readTextFile(readFile);
		String editedFileContent = FileChanger.myROT13Converter.convert(fileContent);
		this.getMyDateiSchreiber().writeTextFile(writeFile, editedFileContent);
	}
	
	public void ReadFileAndReplaceWord(File readFile, File writeFile, String deletionWord, String swapWord) {
		String fileContent = this.getMyDateiLeser().readTextFile(readFile);
		String editedFileContent = FileChanger.myWortFinder.swapWords(fileContent, deletionWord, swapWord);
		this.getMyDateiSchreiber().writeTextFile(writeFile, editedFileContent);
	}
	
	public void ReadFileEncoding8859_1AndWriteEncodingUTF_8(File readFile, File writeFile) {
		
		this.getMyEncodingchanger().ReadFileAndWrite(
				readFile, writeFile, this.getMyDateiLeser(), this.getMyDateiSchreiber(), "ISO-8859-1", "UTF-8"); //ISO-8859-15 UTF-8
	}

	public DateiLeser getMyDateiLeser() {
		return this.myDateiLeser;
	}

	public void setMyDateiLeser(DateiLeser myDateiLeser) {
		this.myDateiLeser = myDateiLeser;
	}

	public DateiSchreiber getMyDateiSchreiber() {
		return this.myDateiSchreiber;
	}

	public void setMyDateiSchreiber(DateiSchreiber myDateiSchreiber) {
		this.myDateiSchreiber = myDateiSchreiber;
	}

	public EncodingChanger getMyEncodingchanger() {
		return this.myEncodingchanger;
	}

	public void setMyEncodingchanger(EncodingChanger myEncodingchanger) {
		this.myEncodingchanger = myEncodingchanger;
	}
}
