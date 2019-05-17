/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import penggajian.entity.User;

/**
 *
 * @author dickyadriansyah
 */
public interface UserDao extends GeneralDao{
    public User getUser(String id) throws Exception;
    public List<User> getUser() throws Exception;
    public User login(String username, String password) throws Exception;
}
