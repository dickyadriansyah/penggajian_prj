/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dialog;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JDialog;
import net.sf.jasperreports.swing.JRViewer;
import penggajian.custom.Icon;

/**
 *
 * @author dickyadriansyah
 */
public class TampilReport extends JDialog{
    private String title;
    private JRViewer jv;
    

    
    public TampilReport(String title, JRViewer jv) {
        this.title = title;
        this.jv = jv;
        atur();
    }
    
    private void atur(){
        
        //setSize(1200, 750);
        setModal(true);
        setLocationRelativeTo(null);
        setTitle(title);
        setIconImage(new Icon().getImage());
        getContentPane().add(jv);
        GraphicsDevice gd= GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        //setVisible(true);
    }
    
}
