/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import penggajian.entity.Gaji;

/**
 *
 * @author dickyadriansyah
 */
public interface GajiDao extends GeneralDao{
    public Gaji getGaji(String id)throws Exception;
    public List<Gaji> getGajis() throws Exception;
    public List<Gaji> getGajis(String kode) throws Exception;
    String getIdGaji() throws Exception;
}
