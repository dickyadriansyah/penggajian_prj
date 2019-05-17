/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import penggajian.entity.Jabatan;

/**
 *
 * @author dickyadriansyah
 */
public interface JabatanDao extends GeneralDao{
    public Jabatan getJabatan(String id)throws Exception;
    public List<Jabatan> getJabatans() throws Exception;
    String getIdJabatan() throws Exception;
}
