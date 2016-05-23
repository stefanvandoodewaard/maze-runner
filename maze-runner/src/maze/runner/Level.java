package maze.runner;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Stefan & Kenny
 */
public class Level extends JPanel implements ActionListener {

    private Timer timer;
    private Map map;
    private Player player;

    public Level() {
        map = new Map();
        player = new Player();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int y = 0; y < 14; y++) {
            for (int x = 0; x < 14; x++) {
                if (map.getMap(x, y).equals("g")) {
                    g.drawImage(map.getGrass(), x * 32, y * 32, null);
                }
                if (map.getMap(x, y).equals("w")) {
                    g.drawImage(map.getWall(), x * 32, y * 32, null);
                }
            }
        }

        g.drawImage(player.getPlayer(), player.getTileX() * 32, player.getTileY() * 32, null);
    }

    public class Al extends KeyAdapter {

        public void keyPressed(KeyEvent event) {
            int keycode = event.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (!map.getMap(player.getTileX(), player.getTileY() - 1).equals("w")) {
                    player.move(0, -1);
                }
            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (!map.getMap(player.getTileX(), player.getTileY() + 1).equals("w")) {
                    player.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!map.getMap(player.getTileX() - 1, player.getTileY()).equals("w")) {
                    player.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!map.getMap(player.getTileX() + 1, player.getTileY()).equals("w")) {
                    player.move(1, 0);
                }
            }
        }

        public void keyReleased(KeyEvent event) {

        }

        public void keyTyped(KeyEvent event) {

        }
    }
}