package bücherVerwaltung;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class DataCellRenderer extends DefaultListCellRenderer {

	public DataCellRenderer() {
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (value.getClass() == Buch.class) {
			 this.setText(((Buch) value).getShortInfo());
			 return this;
		}
		if (value.getClass() == Verlag.class) {
			this.setText(((Verlag) value).getShortInfo());
			return this;
		}
		if (value.getClass() == Autor.class) {
			this.setText(((Autor) value).getShortInfo());
			return this;
		}
		this.setText(value.toString());
		return this;
	    
	}
}
