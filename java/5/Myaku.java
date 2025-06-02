import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// 円クラス
class Circle {
    private int x, y; // 円の中心座標
    private double radius; // 半径の基準値
    private int age = 0; // フレーム毎に更新される年齢
    private Color color; // 色

    public Circle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.radius = Math.random() * 40 + 10; // 半径をランダムに設定
        this.color = color;
    }

    public void update() {
        age += 1; // フレーム毎に年齢を更新
    }

    public void draw(Graphics2D g2) {
        double radius = this.radius; // 半径をスケールに基づいて計算
        double scale = 1.0 + Math.sin(age * 0.15) * 0.2;
        double alpha = 32 + Math.sin(age * 0.15) * 128;
        g2.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(), (int)Math.max(0, Math.min(255, alpha)))); // アルファ値を0〜255の範囲に制限
        g2.fillOval((int)(x - radius * scale), (int)(y - radius * scale), (int)(2 * radius * scale), (int)(2 * radius * scale)); // 円を描画
    }
}

public class Myaku extends JPanel {
    private final ArrayList<Circle> circles = new ArrayList<>(); // 円のリスト
    private boolean mouseDown = false; // マウスが押されているかどうか
    private final Color[] colors = {
      new Color(230, 0, 18),
      new Color(0, 255, 0),
      new Color(0, 191, 255), 
    };
    private int colorIndex = 0;

    // コンストラクタ
    public Myaku() {
        setPreferredSize(new Dimension(800, 600));  // パネルのサイズを設定
        setBackground(Color.WHITE);   // 背景色を設定

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDown = true;   // マウスが押されたとき
            }

            public void mouseReleased(MouseEvent e) {
                mouseDown = false;   // マウスが離されたとき
                colorIndex = (colorIndex + 1) % colors.length; // 色を次に進める
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mouseDown) {
                    Circle c = new Circle(e.getX(), e.getY(), colors[colorIndex]);
                    circles.add(c); // マウスがドラッグされたときに新しい円を追加
                }
            }
        });

        Timer timer = new Timer(16, e -> { // 約60FPS(1/60秒)で更新
            for (Circle c : circles) {
                c.update(); // 各円の年齢を更新
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Circle c : circles) {
            c.draw(g2); // 各円を描画
        }
    }

    // メインメソッド
    public static void main(String[] args) {
        JFrame frame = new JFrame("Myaku Myaku Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Myaku());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
