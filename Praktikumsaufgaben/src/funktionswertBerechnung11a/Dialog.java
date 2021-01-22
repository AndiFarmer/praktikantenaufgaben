package funktionswertBerechnung11a;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Dialog extends JDialog {

	public Dialog(JPanel JPanelZeichner) {
		this.add(JPanelZeichner);
		this.setTitle("Funktionsgraph");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(0, 40);
		this.setVisible(true);
	}

}
