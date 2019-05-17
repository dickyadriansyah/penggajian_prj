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
import penggajian.dao.AbsensiDao;
import penggajian.entity.Absensi;

/**
 *
 * @author dickyadriansyah
 */
public class AbsensiDaoImpl extends GeneralDaoImpl implements AbsensiDao{

    public AbsensiDaoImpl(EntityManager entityManager){
        super(entityManager);
    }
    
    @Override
    public Absensi getAbsensi(String id) throws Exception {
        Absensi absensi=null;
        try{
            this.entityManager.getTransaction().begin();
            absensi=this.entityManager.find(Absensi.class, id);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return absensi;
    }

    @Override
    public List<Absensi> getAbsensis() throws Exception {
        List list=new ArrayList();
        try{
            this.entityManager.getTransaction().begin();
            list=this.entityManager.createQuery("select a from Absensi a order by a.idAbsensi").getResultList();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return list;
    }

    @Override
    public String getIdAbsensi() throws Exception {
        String id="";
        try {
            for(Absensi a: getAbsensis()){
                id=a.getIdAbsensi();
            }
           
        } catch (Exception ex) {
            Logger.getLogger(AbsensiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }

    
    
}
