package dateiArbeit;

import java.io.File;

public class FileChanger {

	private ROT13Converter myROT13Converter = ROT13Converter.getInstance();
	private WortFinder myWortFinder = new WortFinder();
	
	private DateiLeser myDateiLeser = new DateiLeser();
	private DateiSchreiber myDateiSchreiber = new DateiSchreiber();
	
	public FileChanger() {
	}
	
	public void ReadFileAndWriteWithROT13(File readFile, File writeFile) {
		String fileContent = this.myDateiLeser.readTextFile(readFile);
		String editedFileContent = this.myROT13Converter.convert(fileContent);
		this.myDateiSchreiber.writeTextFile(writeFile, editedFileContent);
	}
	
	public void ReadFileAndReplaceWord(File readFile, File writeFile, String deletionWord, String swapWord) {
		String fileContent = this.myDateiLeser.readTextFile(readFile);
		String editedFileContent = this.myWortFinder.swapWords(fileContent, deletionWord, swapWord);
		this.myDateiSchreiber.writeTextFile(writeFile, editedFileContent);
	}
}
