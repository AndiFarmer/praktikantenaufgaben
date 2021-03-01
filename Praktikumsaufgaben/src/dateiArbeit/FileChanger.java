package dateiArbeit;

import java.io.File;

public class FileChanger {

	private ROT13Converter myROT13Converter = new ROT13Converter();
	private DateiLeser myDateiLeser = new DateiLeser();
	private DateiSchreiber myDateiSchreiber = new DateiSchreiber();
	
	public FileChanger() {
	}
	
	public void ReadFileAndWriteWithROT13(File readFile, File writeFile) {
		String fileContent = this.myDateiLeser.readTextFile(readFile);
		String fileContentROT13 = this.myROT13Converter.convert(fileContent);
		this.myDateiSchreiber.writeTextFile(writeFile, fileContentROT13);
	}

}
