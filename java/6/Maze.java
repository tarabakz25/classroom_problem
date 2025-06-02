import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class Maze extends JPanel implements KeyListener {
    final int W = 21, H = 13; // 迷路の幅と高さ
    int px = 1, py = 1; // プレイヤーの位置
    int[][] maze = { // 迷路の初期状態
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,0,0,0,0,1,0,1,0,2,0,0,0,1,0,0,0,1},
        {1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,2,1,0,1},
        {1,0,0,0,1,0,1,0,2,0,0,0,1,0,0,0,0,0,1,0,1},
        {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
        {1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,2,1,0,1},
        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
        {1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1},
        {1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},
        {1,0,1,1,1,0,1,1,1,0,1,1,1,2,1,1,1,0,1,0,1},
        {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };

    public Maze() {
        setPreferredSize(new Dimension(W * 20, H * 20));
        JFrame f = new JFrame("Maze");
        f.add(this);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(this);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Color[] block = { Color.WHITE, Color.BLACK, Color.GREEN }; // 0: 道, 1: 壁, 2: 通り抜けれる壁
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                g.setColor(block[maze[y][x]]); // 迷路の色を設定
                g.fillRect(x * 20, y * 20, 20, 20); // ブロックを描画
            }
        }
        g.setColor(Color.RED); // ゴールを描画
        g.fillRect((W - 2) * 20, (H - 2) * 20, 20, 20);
        g.setColor(Color.BLUE); // プレイヤーを描画
        g.fillRect(px * 20, py * 20, 20, 20);
    }

    public void keyPressed(KeyEvent e) {
        int nx = px, ny = py; // 次のプレイヤーの位置
        if (e.getKeyCode() == 37) nx--; // 左
        if (e.getKeyCode() == 39) nx++; // 右
        if (e.getKeyCode() == 38) ny--; // 上
        if (e.getKeyCode() == 40) ny++; // 下
        if (maze[ny][nx] != 1) { // 壁でなければ
            px = nx; py = ny; // プレイヤーを移動する
            repaint();
        }
        if (px == W - 2 && py == H - 2) { // 右下のゴールに到達したら
            JOptionPane.showMessageDialog(this, "ゴール！");
            px = 1; py = 1; // プレイヤーを左上に戻す
            repaint();
        }
    }

    public void autoMove() {
      int nx = px, ny = py;
      // 一秒ごとに右回りで移動する
      while (true) {
        boolean t, b, l, r, isMoveAbove, isMoveLeft;
        t = b = l = r = isMoveAbove = isMoveLeft = false;
        if (maze[ny - 1][nx] == 0) t = true;
        if (maze[ny + 1][nx] == 0) b = true;
        if (maze[ny][nx - 1] == 0) l = true;
        if (maze[ny][nx + 1] == 0) r = true;
        if (!b && !isMoveAbove) {
          ny++;
          isMoveAbove = true;
        }
        if (b && !t && isMoveAbove) {
          ny--;
          isMoveAbove = false;
        }
        if (l && !r && !isMoveLeft) {
          nx--;
          isMoveLeft = true;
        }
        if (r && !l && isMoveLeft) {
          nx++;
          isMoveLeft = false;
        }
        if (maze[ny][nx] != 1) {
          px = nx; py = ny;
          repaint();
        } else {
          break;
        }
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}
      }
   }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public static void main(String[] a) {
      Maze m = new Maze();
      m.autoMove();
    }
}