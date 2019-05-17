package penggajian.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import penggajian.entity.Karyawan;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T22:38:00")
@StaticMetamodel(Absensi.class)
public class Absensi_ { 

    public static volatile SingularAttribute<Absensi, Integer> jmlSakit;
    public static volatile SingularAttribute<Absensi, Integer> jmlHari;
    public static volatile SingularAttribute<Absensi, Karyawan> nip;
    public static volatile SingularAttribute<Absensi, String> kehadiran;
    public static volatile SingularAttribute<Absensi, Integer> jmlIzin;
    public static volatile SingularAttribute<Absensi, Integer> jmlHadir;
    public static volatile SingularAttribute<Absensi, Integer> jmlAlfa;
    public static volatile SingularAttribute<Absensi, String> idAbsensi;

}