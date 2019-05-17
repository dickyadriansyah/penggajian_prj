package penggajian.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import penggajian.entity.Karyawan;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T22:38:00")
@StaticMetamodel(Jabatan.class)
public class Jabatan_ { 

    public static volatile SingularAttribute<Jabatan, Long> uangTransportasi;
    public static volatile SingularAttribute<Jabatan, Long> uangLembur;
    public static volatile SingularAttribute<Jabatan, String> jabatan;
    public static volatile SingularAttribute<Jabatan, Long> gajiPokok;
    public static volatile ListAttribute<Jabatan, Karyawan> karyawanList;
    public static volatile SingularAttribute<Jabatan, Long> uangMakan;
    public static volatile SingularAttribute<Jabatan, String> idJabatan;
    public static volatile SingularAttribute<Jabatan, Long> tunjangan;

}