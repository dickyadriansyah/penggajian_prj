package penggajian.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import penggajian.entity.Absensi;
import penggajian.entity.Gaji;
import penggajian.entity.Jabatan;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T22:38:00")
@StaticMetamodel(Karyawan.class)
public class Karyawan_ { 

    public static volatile SingularAttribute<Karyawan, String> telpon;
    public static volatile SingularAttribute<Karyawan, String> jk;
    public static volatile SingularAttribute<Karyawan, Date> tglLahir;
    public static volatile SingularAttribute<Karyawan, String> nip;
    public static volatile SingularAttribute<Karyawan, String> nama;
    public static volatile SingularAttribute<Karyawan, String> tptLahir;
    public static volatile ListAttribute<Karyawan, Gaji> gajiList;
    public static volatile SingularAttribute<Karyawan, String> agama;
    public static volatile SingularAttribute<Karyawan, Jabatan> idJabatan;
    public static volatile SingularAttribute<Karyawan, String> alamat;
    public static volatile SingularAttribute<Karyawan, String> status;
    public static volatile ListAttribute<Karyawan, Absensi> absensiList;

}