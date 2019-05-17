/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dickyadriansyah
 */
@Entity
@Table(name = "karyawan", catalog = "penggajian", schema = "")
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k"),
    @NamedQuery(name = "Karyawan.findByNip", query = "SELECT k FROM Karyawan k WHERE k.nip = :nip"),
    @NamedQuery(name = "Karyawan.findByNama", query = "SELECT k FROM Karyawan k WHERE k.nama = :nama"),
    @NamedQuery(name = "Karyawan.findByJk", query = "SELECT k FROM Karyawan k WHERE k.jk = :jk"),
    @NamedQuery(name = "Karyawan.findByTptLahir", query = "SELECT k FROM Karyawan k WHERE k.tptLahir = :tptLahir"),
    @NamedQuery(name = "Karyawan.findByTglLahir", query = "SELECT k FROM Karyawan k WHERE k.tglLahir = :tglLahir"),
    @NamedQuery(name = "Karyawan.findByAgama", query = "SELECT k FROM Karyawan k WHERE k.agama = :agama"),
    @NamedQuery(name = "Karyawan.findByTelpon", query = "SELECT k FROM Karyawan k WHERE k.telpon = :telpon"),
    @NamedQuery(name = "Karyawan.findByStatus", query = "SELECT k FROM Karyawan k WHERE k.status = :status"),
    @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat")})
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nip")
    @TableColumn(name = "NIP", number = 1, size = 15)
    private String nip;
    @Basic(optional = false)
    @Column(name = "nama")
    @TableColumn(name = "Nama", number = 2, size = 25)
    private String nama;
    @Column(name = "jk")
    @TableColumn(name = "Jenis Kelamin", number = 3, size = 15)
    private String jk;
    @Column(name = "tpt_lahir")
    @TableColumn(name = "Tempat Lahir", number = 5, size = 15)
    private String tptLahir;
    @Column(name = "tgl_lahir")
    @Temporal(TemporalType.DATE)
    @TableColumn(name = "Tanggal Lahir", number = 6, size = 15)
    private Date tglLahir;
    @Column(name = "agama")
    @TableColumn(name = "Agama", number = 7, size = 15)
    private String agama;
    @Column(name = "telpon")
    @TableColumn(name = "Telpon", number = 8, size = 15)
    private String telpon;
    @Column(name = "status")
    @TableColumn(name = "Status", number = 9, size = 15)
    private String status;
    @Column(name = "alamat")
    @TableColumn(name = "Alamat", number = 10, size = 25)
    private String alamat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nip")
    private List<Gaji> gajiList;
    @JoinColumn(name = "id_jabatan", referencedColumnName = "id_jabatan")
    @ManyToOne(optional = false)
    @TableColumn(name = "Jabatan", number = 4, size = 20)
    private Jabatan idJabatan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nip")
    private List<Absensi> absensiList;

    public Karyawan() {
    }

    public Karyawan(String nip) {
        this.nip = nip;
    }

    public Karyawan(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getTptLahir() {
        return tptLahir;
    }

    public void setTptLahir(String tptLahir) {
        this.tptLahir = tptLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Gaji> getGajiList() {
        return gajiList;
    }

    public void setGajiList(List<Gaji> gajiList) {
        this.gajiList = gajiList;
    }

    public Jabatan getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(Jabatan idJabatan) {
        this.idJabatan = idJabatan;
    }

    public List<Absensi> getAbsensiList() {
        return absensiList;
    }

    public void setAbsensiList(List<Absensi> absensiList) {
        this.absensiList = absensiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nip != null ? nip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.nip == null && other.nip != null) || (this.nip != null && !this.nip.equals(other.nip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nama;
    }
    
}
