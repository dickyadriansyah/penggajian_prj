/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import penggajian.dao.JabatanDao;
import penggajian.entity.Jabatan;

/**
 *
 * @author dickyadriansyah
 */
public class JabatanDaoImpl extends GeneralDaoImpl implements JabatanDao{

    public JabatanDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
    
    @Override
    public Jabatan getJabatan(String id) throws Exception {
        Jabatan jabatan=null;
        try{
            this.entityManager.getTransaction().begin();
            jabatan=this.entityManager.find(Jabatan.class, id);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return jabatan;
    }

    @Override
    public List<Jabatan> getJabatans() throws Exception {
        List list=new ArrayList();
        try{
            this.entityManager.getTransaction().begin();
            list=this.entityManager.createQuery("select j from Jabatan j order by j.idJabatan").getResultList();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return list;
    }

    @Override
    public String getIdJabatan() throws Exception {
        String id="";
        try {
            for(Jabatan a: getJabatans()){
                id=a.getIdJabatan();
            }
           
        } catch (Exception ex) {
            Logger.getLogger(JabatanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }
    
}
