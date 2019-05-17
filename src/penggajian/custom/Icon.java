/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.custom;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author dickyadriansyah
 */
public class Icon {
    private  Image image;

    public Icon() {
        image=new ImageIcon(getClass().getResource("/penggajian/icon/logo_report.jpeg")).getImage();
    }
    
    public  Image getImage() {
        return image;
    }
}
