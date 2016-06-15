/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.runner;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan van Doodewaard & Kenny Dillewaard
 */
public class Helper extends GameObject {

    private Image helper;
    
    private boolean active;

    public Helper(int x, int y) {
        ImageIcon img = new ImageIcon(ClassLoader.
                getSystemResource("resources/tiles/helper.png"));
        helper = img.getImage();
        
        tileX = x;
        tileY = y;
    }

    @Override
    public Image getGameObject() {
        return helper;
    }

    public void meetHelper() {
        JOptionPane.showMessageDialog(null, "Let me help you by showing you the "
                + "optimal route to your friend!");
    }
}
