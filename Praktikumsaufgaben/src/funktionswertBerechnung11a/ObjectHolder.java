package funktionswertBerechnung11a;

import javax.swing.JDialog;

public class ObjectHolder {
	
	static JDialog dialog = new JDialog();
	static Zeichner zeichner = new Zeichner();
	
	public ObjectHolder() {
		
	}

	public static JDialog getJDialog() {
		return dialog;
	}
}
