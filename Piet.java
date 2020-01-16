import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

class CanvasPanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    g.drawLine(0, 0, getWidth(), getHeight());
  }
}

class Piet {
  Piet() {
    JFrame f = new JFrame("Piet Mondrian");
    f.setSize(500, 309);
    f.setLocation(50, 50);
    f.add(new CanvasPanel());
    f.setVisible(true);
  }
  
  public static final void main(String[] args) {
    new Piet();
  }
}

