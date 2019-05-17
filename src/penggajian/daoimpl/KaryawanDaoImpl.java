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
import penggajian.dao.KaryawanDao;
import penggajian.entity.Karyawan;

/**
 *
 * @author dickyadriansyah
 */
public class KaryawanDaoImpl extends GeneralDaoImpl implements KaryawanDao{

    public KaryawanDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }
    
    @Override
    public Karyawan getKaryawan(String id) throws Exception {
        Karyawan karyawan=null;
        try{
            this.entityManager.getTransaction().begin();
            karyawan=this.entityManager.find(Karyawan.class, id);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return karyawan;
    }

    @Override
    public List<Karyawan> getKaryawans() throws Exception {
        List list=new ArrayList();
        try{
            this.entityManager.getTransaction().begin();
            list=this.entityManager.createQuery("select k from Karyawan k order by k.nip").getResultList();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return list;
    }

    @Override
    public String getIdKaryawan() throws Exception {
        String id="";
        try {
            for(Karyawan k: getKaryawans()){
                id=k.getNip();
            }
           
        } catch (Exception ex) {
            Logger.getLogger(KaryawanDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }
    
}
