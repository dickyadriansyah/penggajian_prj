package penggajian.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import penggajian.entity.Karyawan;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-15T22:38:00")
@StaticMetamodel(Gaji.class)
public class Gaji_ { 

    public static volatile SingularAttribute<Gaji, Long> uangTransportasi;
    public static volatile SingularAttribute<Gaji, Long> uangLembur;
    public static volatile SingularAttribute<Gaji, Karyawan> nip;
    public static volatile SingularAttribute<Gaji, String> blnTahun;
    public static volatile SingularAttribute<Gaji, Long> gajiPokok;
    public static volatile SingularAttribute<Gaji, String> idGaji;
    public static volatile SingularAttribute<Gaji, Long> uangMakan;
    public static volatile SingularAttribute<Gaji, String> totalGaji;
    public static volatile SingularAttribute<Gaji, Long> tunjangan;

}