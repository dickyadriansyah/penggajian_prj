/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.custom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author asep
 */
public class panelLine extends JPanel{

    public panelLine() {
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        Graphics2D gd=(Graphics2D) g.create();
        gd.setStroke(new BasicStroke(3F));
        gd.setColor(Color.BLUE);
        gd.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        gd.dispose();
       
    }
    
    
}
