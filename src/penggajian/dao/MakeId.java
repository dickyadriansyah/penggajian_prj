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
public interface MakeId {
    public String getId(String id, String awalan, int panjangField) throws Exception;
    public String getIdDate(String id, String awalan, int panjangField) throws Exception;
}
