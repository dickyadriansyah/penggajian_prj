/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.UnsupportedLookAndFeelException;
import penggajian.dialog.Splash;
import penggajian.utilities.PersistanceUtilities;

/**
 *
 * @author dickyadriansyah
 */
public class Penggajian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         EntityManager em=PersistanceUtilities.getEntityManagerFactory().createEntityManager();
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(Penggajian.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        Splash splash=new Splash(em);
        splash.setVisible(true);
    
    }
    
}
