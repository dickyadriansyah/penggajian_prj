/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.custom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

/**
 *
 * @author asep
 */
public class PanelGradienColor extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D) g.create();
        gd.setStroke(new BasicStroke(3F));
        int x1=getWidth()/2;
        int y1=0;
        int x2=getWidth()/2;
        int y2=getHeight();
        Paint paint=new GradientPaint(x1, y1, Color.BLUE, x2, y2, Color.black);
        gd.setPaint(paint);
        gd.fillRect(0, 0, getWidth(), getHeight());
        gd.dispose();
    }
}
