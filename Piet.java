import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

class CanvasPanel extends JPanel {
  private static final int LINE_WIDTH = 8;
  private Random rand = new Random();

  public void paintComponent(Graphics g) {
    Rectangle rect = new Rectangle(-LINE_WIDTH/2, -LINE_WIDTH/2, getWidth() + LINE_WIDTH, getHeight() + LINE_WIDTH);
    drawLineInRect(rect, g);
  }

  private void drawLineInRect(Rectangle rect, Graphics g) {
    if (rect.width < 200 && rect.height < 124) {
      return;
    }

    int randomOffset;
    Rectangle rect0, rect1;
    int fromX, fromY, toX, toY;

    if (rect.width < rect.height) {
      randomOffset = rand.nextInt(rect.height);
      rect0 = new Rectangle(rect.x, rect.y, rect.width, randomOffset);
      rect1 = new Rectangle(rect.x, rect.y + randomOffset, rect.width, rect.height - randomOffset);
      fromX = rect.x;
      fromY = rect.y + randomOffset; 
      toX = fromX + rect.width;
      toY = fromY;
    } else {
      randomOffset = rand.nextInt(rect.width);
      rect0 = new Rectangle(rect.x, rect.y, randomOffset, rect.height);
      rect1 = new Rectangle(rect.x + randomOffset, rect.y, rect.width - randomOffset, rect.height);
      fromX = rect.x + randomOffset;
      fromY = rect.y; 
      toX = fromX;
      toY = rect.y + rect.height;
    }

    fillInRect(rect0, LINE_WIDTH / 2, g);
    fillInRect(rect1, LINE_WIDTH / 2, g);

    g.setColor(Color.black);
    Graphics2D g2 = (Graphics2D)g;
    g2.setStroke(new BasicStroke(LINE_WIDTH));
    g2.drawLine(fromX, fromY, toX, toY);

    drawLineInRect(rect0, g);
    drawLineInRect(rect1, g);
  }

  private void fillInRect(Rectangle rect, int gap, Graphics g) {
    float red = rand.nextFloat();
    float grn = rand.nextFloat();
    float blu = rand.nextFloat();
    Color randomColor = new Color(red, grn, blu);
    g.setColor(randomColor);
    g.fillRect(rect.x + gap, rect.y + gap, rect.width - 2*gap, rect.height - 2*gap);
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

