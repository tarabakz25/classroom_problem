import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPanel   ;

public class PaintDot extends JPanel {
    PaintDot() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Graphics g = getGraphics();
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x, y);
            }
        });
    }

    public static void main(String[] args) {
        PaintDot panel = new PaintDot();
        JFrame frame = new JFrame("PaintDot");
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}