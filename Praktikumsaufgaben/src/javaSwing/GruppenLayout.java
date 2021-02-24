package javaSwing;

import javax.swing.GroupLayout;
import javax.swing.JComponent;

public class GruppenLayout extends GroupLayout {

	public GruppenLayout (JComponent pane) {
		super(pane);
		this.setAutoCreateContainerGaps(true);
	}
}
