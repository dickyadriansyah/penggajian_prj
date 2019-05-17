/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import penggajian.entity.Karyawan;

/**
 *
 * @author dickyadriansyah
 */
public interface KaryawanDao extends GeneralDao{
    public Karyawan getKaryawan(String id)throws Exception;
    public List<Karyawan> getKaryawans() throws Exception;
    String getIdKaryawan() throws Exception;
}
