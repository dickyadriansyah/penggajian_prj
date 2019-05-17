/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

/**
 *
 * @author dickyadriansyah
 */
public interface GeneralDao {
    public boolean insert(Object obj)throws Exception;
    public boolean update(Object obj)throws Exception;
    public boolean delete(Object obj)throws Exception;
}
