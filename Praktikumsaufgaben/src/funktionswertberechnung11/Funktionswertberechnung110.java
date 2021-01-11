package funktionswertberechnung11;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Funktionswertberechnung110 extends JPanel {

  public void paint(Graphics g) {
    g.drawLine(25, 25, 120, 120);

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Funktionswertberechnung110());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}