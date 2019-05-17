/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dao;

import java.util.List;
import penggajian.entity.Absensi;

/**
 *
 * @author dickyadriansyah
 */
public interface AbsensiDao extends GeneralDao{
    public Absensi getAbsensi(String id)throws Exception;
    public List<Absensi> getAbsensis() throws Exception;
    String getIdAbsensi() throws Exception;
}
