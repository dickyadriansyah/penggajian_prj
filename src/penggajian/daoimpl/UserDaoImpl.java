/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.daoimpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import penggajian.dao.UserDao;
import penggajian.entity.User;

/**
 *
 * @author dickyadriansyah
 */
public class UserDaoImpl extends GeneralDaoImpl implements UserDao{

    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User getUser(String id) throws Exception {
        User u=null;
        try{
            this.entityManager.getTransaction().begin();
            u=this.entityManager.find(User.class, id);
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }
        return u;
    }

    @Override
    public List<User> getUser() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String username, String password) throws Exception {
      User u=null;
      List<User> list=new ArrayList();
      try{
      this.entityManager.getTransaction().begin();
      list=this.entityManager.createQuery("select u from User u WHERE u.username=:parm0 AND u.password=:parm1")
      .setParameter("parm0", username)
      .setParameter("parm1", password)
      .getResultList();
      
      for(User u1: list){
      u=u1;
      }
      this.entityManager.getTransaction().commit();
      }catch(Exception e){
      this.entityManager.getTransaction().rollback();
      throw new Exception(e.getMessage());
      }
      return u;
    }
    
}
