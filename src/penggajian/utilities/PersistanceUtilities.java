/*
 *  
 *                 License
 *  Program ini dibuat oleh ASEP KOMARUDIN
 *  Dilarang keras mengkopi atau merubah file ini tanpa seijin asep komarudin
 * 
 *  Jika anda membutuhkan informasi lebih lanjut bisa mnghubungi
 *  nama   :asep komarudin
 *  tlp    :081383551124 atau 085716769910
 *  blog   :aasseepp.blogspot.com
 *  email  :aasseepp@gmail.com
 *  
 */
package penggajian.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asep
 */
public class PersistanceUtilities {
    
    private final static EntityManagerFactory entityManagerFactory;
    static{
        entityManagerFactory=Persistence.createEntityManagerFactory("PenggajianPU");
        
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
}
