/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dickyadriansyah
 */
@Entity
@Table(name = "gaji", catalog = "penggajian", schema = "")
@NamedQueries({
    @NamedQuery(name = "Gaji.findAll", query = "SELECT g FROM Gaji g"),
    @NamedQuery(name = "Gaji.findByIdGaji", query = "SELECT g FROM Gaji g WHERE g.idGaji = :idGaji"),
    @NamedQuery(name = "Gaji.findByBlnTahun", query = "SELECT g FROM Gaji g WHERE g.blnTahun = :blnTahun"),
    @NamedQuery(name = "Gaji.findByGajiPokok", query = "SELECT g FROM Gaji g WHERE g.gajiPokok = :gajiPokok"),
    @NamedQuery(name = "Gaji.findByUangMakan", query = "SELECT g FROM Gaji g WHERE g.uangMakan = :uangMakan"),
    @NamedQuery(name = "Gaji.findByUangTransportasi", query = "SELECT g FROM Gaji g WHERE g.uangTransportasi = :uangTransportasi"),
    @NamedQuery(name = "Gaji.findByUangLembur", query = "SELECT g FROM Gaji g WHERE g.uangLembur = :uangLembur"),
    @NamedQuery(name = "Gaji.findByTunjangan", query = "SELECT g FROM Gaji g WHERE g.tunjangan = :tunjangan"),
    @NamedQuery(name = "Gaji.findByTotalGaji", query = "SELECT g FROM Gaji g WHERE g.totalGaji = :totalGaji")})
public class Gaji implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_gaji")
    @TableColumn(name = "Id Gaji", number = 1, size = 15)
    private String idGaji;
    @Basic(optional = false)
    @Column(name = "bln_tahun")
    @TableColumn(name = "Bulan / Tahun", number = 3, size = 18)
    private String blnTahun;
    @Column(name = "gaji_pokok")
    @TableColumn(name = "Gaji Pokok", number = 4, size = 15)
    private Long gajiPokok;
    @Column(name = "uang_makan")
    @TableColumn(name = "Uang Makan", number = 5, size = 15)
    private Long uangMakan;
    @Column(name = "uang_transportasi")
    @TableColumn(name = "Uang Transportasi", number = 6, size = 15)
    private Long uangTransportasi;
    @Column(name = "uang_lembur")
    @TableColumn(name = "Uang Lembur", number = 7, size = 15)
    private Long uangLembur;
    @Column(name = "tunjangan")
    @TableColumn(name = "Tunjangan", number = 8, size = 15)
    private Long tunjangan;
    @Column(name = "total_gaji")
    @TableColumn(name = "Total Gaji", number = 9, size = 15)
    private String totalGaji;
    @JoinColumn(name = "nip", referencedColumnName = "nip")
    @ManyToOne(optional = false)
    @TableColumn(name = "Nip/Nama", number = 2, size = 25)
    private Karyawan nip;

    public Gaji() {
    }

    public Gaji(String idGaji) {
        this.idGaji = idGaji;
    }

    public Gaji(String idGaji, String blnTahun) {
        this.idGaji = idGaji;
        this.blnTahun = blnTahun;
    }

    public String getIdGaji() {
        return idGaji;
    }

    public void setIdGaji(String idGaji) {
        this.idGaji = idGaji;
    }

    public String getBlnTahun() {
        return blnTahun;
    }

    public void setBlnTahun(String blnTahun) {
        this.blnTahun = blnTahun;
    }

    public Long getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(Long gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public Long getUangMakan() {
        return uangMakan;
    }

    public void setUangMakan(Long uangMakan) {
        this.uangMakan = uangMakan;
    }

    public Long getUangTransportasi() {
        return uangTransportasi;
    }

    public void setUangTransportasi(Long uangTransportasi) {
        this.uangTransportasi = uangTransportasi;
    }

    public Long getUangLembur() {
        return uangLembur;
    }

    public void setUangLembur(Long uangLembur) {
        this.uangLembur = uangLembur;
    }

    public Long getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(Long tunjangan) {
        this.tunjangan = tunjangan;
    }

    public String getTotalGaji() {
        return totalGaji;
    }

    public void setTotalGaji(String totalGaji) {
        this.totalGaji = totalGaji;
    }

    public Karyawan getNip() {
        return nip;
    }

    public void setNip(Karyawan nip) {
        this.nip = nip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGaji != null ? idGaji.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gaji)) {
            return false;
        }
        Gaji other = (Gaji) object;
        if ((this.idGaji == null && other.idGaji != null) || (this.idGaji != null && !this.idGaji.equals(other.idGaji))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "penggajian.entity.Gaji[ idGaji=" + idGaji + " ]";
    }

    
}
