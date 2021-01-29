package testPackage2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextHolder {

	private PrintWriter pWriter = null;
	
	public TextHolder(String input) {
		
		String dateiVerzeichnis = "D:\\JavaTestTextDateien\\test.txt";
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter(dateiVerzeichnis)));
            pWriter.printf(input);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
        System.out.println("Datei wurde in '" + dateiVerzeichnis + "' angelegt");
	}

}
