import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class PaintOverride extends JPanel {
    int MAX_POINTS = 10000;               // 最大の点の数
    int pCount = 0;                       // 現在の点の数
    Point[] p = new Point[MAX_POINTS];    // 点の配列
    Color[] c = new Color[MAX_POINTS];    // 各点の色を保存する配列
    Color currentColor = Color.BLACK;     // 現在の描画色

    PaintOverride() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
        setFocusable(true);
        requestFocusInWindow();

        // マウスドラッグで点を追加
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (pCount < MAX_POINTS) {
                    p[pCount] = e.getPoint();       // 点の座標を保存
                    c[pCount] = currentColor;       // 現在の色を保存
                    pCount++;
                    repaint();                      // 再描画
                }
            }
        });

        // キー入力で色を変更
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_R:
                        currentColor = Color.RED;
                        break;
                    case KeyEvent.VK_G:
                        currentColor = Color.GREEN;
                        break;
                    case KeyEvent.VK_B:
                        currentColor = Color.BLUE;
                        break;
                    case KeyEvent.VK_Y:
                        currentColor = Color.YELLOW;
                        break;
                    case KeyEvent.VK_K:
                        currentColor = Color.BLACK;
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 保存した色で一筆書きの線として描画
        for (int i = 1; i < pCount; i++) {
            g.setColor(c[i]);
            g.drawLine(p[i - 1].x, p[i - 1].y, p[i].x, p[i].y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("お絵描きプログラム（オーバーライド版）");
        frame.add(new PaintOverride());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
