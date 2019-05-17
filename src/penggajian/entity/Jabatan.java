/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author dickyadriansyah
 */
@Entity
@Table(name = "jabatan", catalog = "penggajian", schema = "")
@NamedQueries({
    @NamedQuery(name = "Jabatan.findAll", query = "SELECT j FROM Jabatan j"),
    @NamedQuery(name = "Jabatan.findByIdJabatan", query = "SELECT j FROM Jabatan j WHERE j.idJabatan = :idJabatan"),
    @NamedQuery(name = "Jabatan.findByJabatan", query = "SELECT j FROM Jabatan j WHERE j.jabatan = :jabatan"),
    @NamedQuery(name = "Jabatan.findByGajiPokok", query = "SELECT j FROM Jabatan j WHERE j.gajiPokok = :gajiPokok"),
    @NamedQuery(name = "Jabatan.findByUangMakan", query = "SELECT j FROM Jabatan j WHERE j.uangMakan = :uangMakan"),
    @NamedQuery(name = "Jabatan.findByUangTransportasi", query = "SELECT j FROM Jabatan j WHERE j.uangTransportasi = :uangTransportasi"),
    @NamedQuery(name = "Jabatan.findByUangLembur", query = "SELECT j FROM Jabatan j WHERE j.uangLembur = :uangLembur"),
    @NamedQuery(name = "Jabatan.findByTunjangan", query = "SELECT j FROM Jabatan j WHERE j.tunjangan = :tunjangan")})
public class Jabatan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_jabatan")
    @TableColumn(name = "Id", number = 1, size = 20)
    private String idJabatan;
    @Basic(optional = false)
    @Column(name = "jabatan")
    @TableColumn(name = "Jabatan", number = 2, size = 25)
    private String jabatan;
    @Column(name = "gaji_pokok")
    @TableColumn(name = "Gaji Pokok", number = 3, size = 15)
    private Long gajiPokok;
    @Column(name = "uang_makan")
    @TableColumn(name = "Uang Makan", number = 4, size = 15)
    private Long uangMakan;
    @Column(name = "uang_transportasi")
    @TableColumn(name = "Uang Transportasi", number = 5, size = 15)
    private Long uangTransportasi;
    @Column(name = "uang_lembur")
    @TableColumn(name = "Uang Lembur", number = 6, size = 15)
    private Long uangLembur;
    @Column(name = "tunjangan")
    @TableColumn(name = "Tunjangan", number = 7, size = 15)
    private Long tunjangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJabatan")
    private List<Karyawan> karyawanList;

    public Jabatan() {
    }

    public Jabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public Jabatan(String idJabatan, String jabatan) {
        this.idJabatan = idJabatan;
        this.jabatan = jabatan;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
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

    public List<Karyawan> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(List<Karyawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJabatan != null ? idJabatan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jabatan)) {
            return false;
        }
        Jabatan other = (Jabatan) object;
        if ((this.idJabatan == null && other.idJabatan != null) || (this.idJabatan != null && !this.idJabatan.equals(other.idJabatan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idJabatan + " - " + jabatan;
    }
    
}
