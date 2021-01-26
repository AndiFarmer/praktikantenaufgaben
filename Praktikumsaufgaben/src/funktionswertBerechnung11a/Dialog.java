package funktionswertBerechnung11a;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Dialog extends JDialog {

	public Dialog(JPanel Funktioszeichner) {
		this.add(Funktioszeichner);
		this.setTitle("Funktionsgraph");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(0, 40);
		this.setVisible(true);
	}
	
	public void updateDialogGröße(Achsenverschiebung achsenVerschiebung) {
		this.setSize(2 * achsenVerschiebung.getxVerschiebung(), 2 * achsenVerschiebung.getyVerschiebung());
	}

}
