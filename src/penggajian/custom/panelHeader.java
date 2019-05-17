/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.custom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class panelHeader extends JPanel{
    
    private Image image;
    public panelHeader() {
        image=new ImageIcon(getClass().getResource("penggajian/icon/toolsHeader1.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D) g.create();
        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gd.dispose();
    }
    
}
