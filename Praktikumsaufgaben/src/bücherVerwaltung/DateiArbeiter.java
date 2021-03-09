package bücherVerwaltung;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DateiArbeiter {

	public DateiArbeiter() {
	}
	
	public void saveStatus(BücherVerwaltung bücherVerwaltung, File file) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bücherVerwaltung);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BücherVerwaltung reconstructStatus(File file) {
		try {
			FileInputStream fis = new FileInputStream(file); /* kein file.canRead() bzw. file.isFile() nötig, 
																da in dieser Zeile indirekt behandelt*/
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			BücherVerwaltung output = (BücherVerwaltung) ois.readObject();
			ois.close();
			return output;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
