package bücherVerwaltung;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BuchResultsPane extends ResultsPane {

	public BuchResultsPane() {
		this.initialize();
	}

	public void initialize() {
		
	}

	public void showResults(ArrayList<Buch> resultsInput, GroundPanel groundPanel) {
		JList<Buch> results = new JList<Buch>(resultsInput.toArray(new Buch[0]));
		results.setCellRenderer (new DataCellRenderer());
		results.setVisibleRowCount(10); // Warum funktioniert das nicht, schließlich ist das Layout VERTICAL (standardmäßig) -> 
		// weil die Fläche, die anzuzeigenist größer ist als die 10
		results.setBackground(Color.LIGHT_GRAY);
		results.setOpaque(true);
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		results.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Buch selectedBuch = results.getSelectedValue();
				try {
					groundPanel.getMyInfoPanelManager().showInfo(selectedBuch);
				} catch (BücherVerwaltungException e1) {
					e1.printStackTrace();
				}
			}
		});
//		SwingUtilities.invokeLater( new Runnable() {
//			@Override
//			public void run() {
				BuchResultsPane.this.setViewportView(results);
//			}
//		});
	}
}
