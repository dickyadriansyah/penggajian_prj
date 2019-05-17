/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.daoimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import penggajian.dao.MakeId;

/**
 *
 * @author dickyadriansyah
 */
public class MakeIdImpl implements MakeId{

    @Override
    public String getId(String id, String awalan, int panjangField) throws Exception {
        String max="";
        int nomber=0;
        String strTmp="";
        int panjangId=panjangField-awalan.length();
        int panjangNumber=0;
        if (id.equals("")) {
            nomber=0;
        }else{ 
            String idCut = id.substring(awalan.length(), panjangField);
            nomber = Integer.valueOf(idCut);
        }
             
            panjangNumber = String.valueOf(nomber+1).length();
            for (int i = 0; i < panjangId - panjangNumber; i++) {
                strTmp = strTmp + "0";
            }
            max=awalan+strTmp+String.valueOf(nomber+1);
        return max;
    }

    @Override
    public String getIdDate(String id, String awalan, int panjangField) throws Exception {
        String max="";
        int nomber=0;
        String strTmp="";
        SimpleDateFormat format=new SimpleDateFormat("YY");
        String tgl = format.format(new Date());
        String awalanTgl=awalan+tgl;
        int tglsekarang=Integer.valueOf(tgl);
        int tglAwal = 0;
        if (!id.equals("")) {
            tglAwal = Integer.valueOf(id.substring(awalan.length(), awalanTgl.length()));
        }
        
        int panjangId=panjangField-awalanTgl.length();
        int panjangNumber=0;
        if (id.equals("")||tglsekarang>tglAwal) { 
            nomber=0;
        }else{ 
            String idCut = id.substring(awalanTgl.length(), panjangField);
            nomber = Integer.valueOf(idCut);
        }
             
            panjangNumber = String.valueOf(nomber+1).length();
            for (int i = 0; i < panjangId - panjangNumber; i++) {
                strTmp = strTmp + "0";
            }
            max=awalanTgl+strTmp+String.valueOf(nomber+1);
        return max;
    }
    
}
