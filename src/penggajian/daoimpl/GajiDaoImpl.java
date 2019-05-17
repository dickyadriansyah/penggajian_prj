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
import penggajian.dao.GajiDao;
import penggajian.entity.Gaji;

/**
 *
 * @author dickyadriansyah
 */
public class GajiDaoImpl extends GeneralDaoImpl implements GajiDao{

    public GajiDaoImpl(EntityManager entityManager){
        super(entityManager);
    }
    
    @Override
    public Gaji getGaji(String id) throws Exception {
        Gaji gaji=null;
        try{
            this.entityManager.getTransaction().begin();
            gaji=this.entityManager.find(Gaji.class, id);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return gaji;
    }

    @Override
    public List<Gaji> getGajis() throws Exception {
        List list=new ArrayList();
        try{
            this.entityManager.getTransaction().begin();
            list=this.entityManager.createQuery("select g from Gaji g order by g.idGaji").getResultList();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return list;
    }

    @Override
    public String getIdGaji() throws Exception {
        String id="";
        try {
            for(Gaji g: getGajis()){
                id=g.getIdGaji();
            }
           
        } catch (Exception ex) {
            Logger.getLogger(GajiDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }

    @Override
    public List<Gaji> getGajis(String kode) throws Exception {
        List list=new ArrayList();
        try{
            this.entityManager.getTransaction().begin();
            list=this.entityManager.createQuery("select g from Gaji g WHERE g.idGaji=:id")
                    .setParameter("id", kode).getResultList();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return list;
    }
    
}
