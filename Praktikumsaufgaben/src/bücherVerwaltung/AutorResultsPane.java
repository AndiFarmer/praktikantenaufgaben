package bücherVerwaltung;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AutorResultsPane extends ResultsPane {

	public AutorResultsPane() {
		this.initialize();
	}
	
	public void initialize() {
		
	}
	
	public void showResults(ArrayList<Autor> resultsInput, GroundPanel groundPanel) {
		Autor[] autorArr = resultsInput.toArray(new Autor[0]); // Warum gibt es keinen normalen Cast? 
		JList<Autor> results = new JList<Autor>(autorArr);
		results.setCellRenderer (new DataCellRenderer());
		results.setBackground(Color.LIGHT_GRAY);
		results.setOpaque(true);
		results.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		results.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Autor selectedAutor = results.getSelectedValue();
				try {
					groundPanel.getMyInfoPanelManager().showInfo(selectedAutor);
				} catch (BücherVerwaltungException e1) {
					e1.printStackTrace();
				}
			}
		});
		SwingUtilities.invokeLater( new Runnable() {
			@Override
			public void run() {
				AutorResultsPane.this.setViewportView(results);
			}
		});
	}

}
