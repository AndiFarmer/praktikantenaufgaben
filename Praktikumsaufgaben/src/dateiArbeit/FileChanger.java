package dateiArbeit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileChanger {

	private static ROT13Converter myROT13Converter = ROT13Converter.getInstance();
	private static WortFinder myWortFinder = WortFinder.getInstance();;
	
	private static DateiLeser myDateiLeser = DateiLeser.getInstance();
	private static DateiSchreiber myDateiSchreiber = DateiSchreiber.getInstance();
	
	static {
	}
	
	public FileChanger() {
	}
	
	public void ReadFileAndWriteWithROT13(File readFile, File writeFile) {
		String fileContent = FileChanger.myDateiLeser.readTextFile(readFile);
		String editedFileContent = FileChanger.myROT13Converter.convert(fileContent);
		FileChanger.myDateiSchreiber.writeTextFile(writeFile, editedFileContent);
	}
	
	public void ReadFileAndReplaceWord(File readFile, File writeFile, String deletionWord, String swapWord) {
		String fileContent = FileChanger.myDateiLeser.readTextFile(readFile);
		String editedFileContent = FileChanger.myWortFinder.swapWords(fileContent, deletionWord, swapWord);
		FileChanger.myDateiSchreiber.writeTextFile(writeFile, editedFileContent);
	}
	
	public void ReadFileEncoding8859_1AndWriteEncodingUTF_8(File readFile, File writeFile) {
		
	}
}
