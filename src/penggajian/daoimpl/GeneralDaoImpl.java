/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.daoimpl;

import javax.persistence.EntityManager;
import penggajian.dao.GeneralDao;

/**
 *
 * @author dickyadriansyah
 */
public class GeneralDaoImpl implements GeneralDao{

    protected EntityManager entityManager;
    
    public GeneralDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public boolean insert(Object obj) throws Exception {
        boolean valid;
       try{
          this.entityManager.getTransaction().begin();
          this.entityManager.persist(obj);
          this.entityManager.getTransaction().commit();
          entityManager.clear();
          valid=true;
       }catch(Exception e){
         this.entityManager.getTransaction().rollback();
         valid=false;
         throw new Exception(e.getMessage());
       }
       return valid;
    }

    @Override
    public boolean update(Object obj) throws Exception {
        boolean valid;
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(obj);
            this.entityManager.getTransaction().commit();
            this.entityManager.clear();
            valid=true;
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            valid=false;
            throw new Exception(e.getMessage());
        }
        return valid;
    }

    @Override
    public boolean delete(Object obj) throws Exception {
        boolean valid;
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(obj);
            this.entityManager.getTransaction().commit();
            valid=true;
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            valid=false;
            throw new Exception(e.getMessage());
        }
        return valid;
    }
    
}
