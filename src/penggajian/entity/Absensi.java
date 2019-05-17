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
@Table(name = "absensi", catalog = "penggajian", schema = "")
@NamedQueries({
    @NamedQuery(name = "Absensi.findAll", query = "SELECT a FROM Absensi a"),
    @NamedQuery(name = "Absensi.findByIdAbsensi", query = "SELECT a FROM Absensi a WHERE a.idAbsensi = :idAbsensi"),
    @NamedQuery(name = "Absensi.findByKehadiran", query = "SELECT a FROM Absensi a WHERE a.kehadiran = :kehadiran"),
    @NamedQuery(name = "Absensi.findByJmlHadir", query = "SELECT a FROM Absensi a WHERE a.jmlHadir = :jmlHadir"),
    @NamedQuery(name = "Absensi.findByJmlSakit", query = "SELECT a FROM Absensi a WHERE a.jmlSakit = :jmlSakit"),
    @NamedQuery(name = "Absensi.findByJmlIzin", query = "SELECT a FROM Absensi a WHERE a.jmlIzin = :jmlIzin"),
    @NamedQuery(name = "Absensi.findByJmlAlfa", query = "SELECT a FROM Absensi a WHERE a.jmlAlfa = :jmlAlfa"),
    @NamedQuery(name = "Absensi.findByJmlHari", query = "SELECT a FROM Absensi a WHERE a.jmlHari = :jmlHari")})
public class Absensi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_absensi")
    @TableColumn(name = "ID", number = 1, size = 15)
    private String idAbsensi;
    @Basic(optional = false)
    @Column(name = "kehadiran")
    @TableColumn(name = "Kehadiran", number = 3, size = 25)
    private String kehadiran;
    @Basic(optional = false)
    @Column(name = "jml_hadir")
    @TableColumn(name = "Jumlah Hadir", number = 4, size = 15)
    private int jmlHadir;
    @Basic(optional = false)
    @Column(name = "jml_sakit")
    @TableColumn(name = "Jumlah Sakit", number = 5, size = 15)
    private int jmlSakit;
    @Basic(optional = false)
    @Column(name = "jml_izin")
    @TableColumn(name = "Jumlah Izin", number = 6, size = 15)
    private int jmlIzin;
    @Basic(optional = false)
    @Column(name = "jml_alfa")
    @TableColumn(name = "Jumlah Alfa", number = 7, size = 15)
    private int jmlAlfa;
    @Basic(optional = false)
    @Column(name = "jml_hari")
    @TableColumn(name = "Jumlah Hari", number = 8, size = 15)
    private int jmlHari;
    @JoinColumn(name = "nip", referencedColumnName = "nip")
    @ManyToOne(optional = false)
    @TableColumn(name = "NIP", number = 2, size = 15)
    private Karyawan nip;

    public Absensi() {
    }

    public Absensi(String idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public Absensi(String idAbsensi, String kehadiran, int jmlHadir, int jmlSakit, int jmlIzin, int jmlAlfa, int jmlHari) {
        this.idAbsensi = idAbsensi;
        this.kehadiran = kehadiran;
        this.jmlHadir = jmlHadir;
        this.jmlSakit = jmlSakit;
        this.jmlIzin = jmlIzin;
        this.jmlAlfa = jmlAlfa;
        this.jmlHari = jmlHari;
    }

    public String getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(String idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    public int getJmlHadir() {
        return jmlHadir;
    }

    public void setJmlHadir(int jmlHadir) {
        this.jmlHadir = jmlHadir;
    }

    public int getJmlSakit() {
        return jmlSakit;
    }

    public void setJmlSakit(int jmlSakit) {
        this.jmlSakit = jmlSakit;
    }

    public int getJmlIzin() {
        return jmlIzin;
    }

    public void setJmlIzin(int jmlIzin) {
        this.jmlIzin = jmlIzin;
    }

    public int getJmlAlfa() {
        return jmlAlfa;
    }

    public void setJmlAlfa(int jmlAlfa) {
        this.jmlAlfa = jmlAlfa;
    }

    public int getJmlHari() {
        return jmlHari;
    }

    public void setJmlHari(int jmlHari) {
        this.jmlHari = jmlHari;
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
        hash += (idAbsensi != null ? idAbsensi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absensi)) {
            return false;
        }
        Absensi other = (Absensi) object;
        if ((this.idAbsensi == null && other.idAbsensi != null) || (this.idAbsensi != null && !this.idAbsensi.equals(other.idAbsensi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nip.getNama();
    }
    
    
}
