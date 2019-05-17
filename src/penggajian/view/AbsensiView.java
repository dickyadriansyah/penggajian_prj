/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.view;

import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import penggajian.dao.AbsensiDao;
import penggajian.dao.KaryawanDao;
import penggajian.dao.MakeId;
import penggajian.daoimpl.AbsensiDaoImpl;
import penggajian.daoimpl.KaryawanDaoImpl;
import penggajian.daoimpl.MakeIdImpl;
import penggajian.dialog.PencarianDialog;
import penggajian.entity.Absensi;
import penggajian.entity.Karyawan;

/**
 *
 * @author dickyadriansyah
 */
public class AbsensiView extends javax.swing.JInternalFrame {

    private EntityManager em;
    private KaryawanDao karyawanDao;
    private AbsensiDao absensiDao;
    private Karyawan karyawan;
    private Absensi absensi;
    private MakeId makeId;
    

    public AbsensiView(EntityManager em){
        this.em=em;
        initComponents();
        karyawanDao=new KaryawanDaoImpl(em);
        absensiDao=new AbsensiDaoImpl(em);
        makeId=new MakeIdImpl();
        tampilanAwal();
    }
    
    private String bulan(int bulan){
        String[] arraymont = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        String bulans = "";
        for (int i = 0; i< arraymont.length; i++) {
            if(i == bulan){
                bulans = arraymont[i];
                break;
            }
        }
        return bulans;
    }
    
    private Absensi getData(){
        Absensi a=new Absensi();
        karyawan=new Karyawan();
        a.setIdAbsensi(txt_id.getText());
        String bln = bulan(cbo_bulan.getMonth());
        
        int year = cbo_tahun.getYear();
        
        Date date_masuk = (Date) cbo_jam_masuk.getValue();
        Date date_keluar = (Date) cbo_jam_keluar.getValue();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String jam_masuk= format.format(date_masuk); 
        String jam_keluar = format.format(date_keluar);
        
        a.setKehadiran(bln +"-"+year+"-"+jam_masuk+"-"+jam_keluar);
        
        String nip = txt_nip.getText();
        karyawan.setNip(nip);
        a.setNip(karyawan);
        a.setJmlHadir(Integer.valueOf(txt_jml_hadir.getText()));
        a.setJmlSakit(Integer.valueOf(txt_jml_sakit.getText()));
        a.setJmlIzin(Integer.valueOf(txt_jml_izin.getText()));
        a.setJmlAlfa(Integer.valueOf(txt_jml_alfa.getText()));
        a.setJmlHari(Integer.valueOf(txt_jml_hari.getText()));
        return a;
    }
    
    private boolean validasi(){
        boolean valid=false;
        if(txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Absensi id not null");
        }else if(txt_nama.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Karyawan not null");
        }else if(txt_jml_hadir.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah Hadir not null");
        }else if(txt_jml_sakit.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah Sakit not null");
        }else if(txt_jml_izin.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah Izin not null !");
        }else if(txt_jml_alfa.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah Alfa not null");
        }else if(txt_jml_hari.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jumlah Hari not null");
        }else if(cbo_jam_masuk.getValue().equals(0)){
            JOptionPane.showMessageDialog(this, "Jam Masuk not null");
        }else if(cbo_jam_keluar.getValue().equals(0)){
            JOptionPane.showMessageDialog(this, "Jam Keluar not null");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void tampilanAwal(){
        btn_save.setEnabled(false);
        cbo_bulan.setEnabled(false);
        cbo_tahun.setEnabled(false);
        cbo_jam_masuk.setEnabled(false);
        cbo_jam_keluar.setEnabled(false);
        txt_jml_hadir.setEnabled(false);
        txt_jml_sakit.setEnabled(false);
        txt_jml_izin.setEnabled(false);
        txt_jml_alfa.setEnabled(false);
        txt_jml_hari.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_search_nip.setEnabled(false);
        
        txt_id.setText("");
        txt_jml_hadir.setText("0");
        txt_jml_sakit.setText("0");
        txt_jml_izin.setText("0");
        txt_jml_alfa.setText("0");
        txt_jml_hari.setText("0");
        txt_nip.setText("");
        karyawan=null;
        txt_nama.setText("");
        
        btn_new.setEnabled(true);
        btn_search.setEnabled(true);
        jProgressBar1.setIndeterminate(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradienColor1 = new penggajian.custom.PanelGradienColor();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nip = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_jml_hadir = new javax.swing.JTextField();
        txt_jml_sakit = new javax.swing.JTextField();
        txt_jml_izin = new javax.swing.JTextField();
        txt_jml_alfa = new javax.swing.JTextField();
        txt_jml_hari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbo_bulan = new com.toedter.calendar.JMonthChooser();
        jLabel3 = new javax.swing.JLabel();
        cbo_tahun = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        Date date=new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        cbo_jam_masuk = new javax.swing.JSpinner(sm);
        JSpinner.DateEditor de=new JSpinner.DateEditor(cbo_jam_masuk, "HH:mm:ss");
        cbo_jam_masuk.setEditor(de);
        jLabel5 = new javax.swing.JLabel();
        Date date1=new Date();
        SpinnerDateModel sm1 = new SpinnerDateModel(date1, null, null, Calendar.HOUR_OF_DAY);
        cbo_jam_keluar = new javax.swing.JSpinner(sm1);
        jPanel3 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        btn_search_nip = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Form Absensi");

        lbl_icon.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lbl_icon.setForeground(new java.awt.Color(242, 182, 0));
        lbl_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_icon.setText("SDIT AKHDOR INSAN MULIA");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/yulia1.jpg"))); // NOI18N

        javax.swing.GroupLayout panelGradienColor1Layout = new javax.swing.GroupLayout(panelGradienColor1);
        panelGradienColor1.setLayout(panelGradienColor1Layout);
        panelGradienColor1Layout.setHorizontalGroup(
            panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradienColor1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGradienColor1Layout.setVerticalGroup(
            panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienColor1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGradienColor1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(82, 89, 243));

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nip :");

        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Nama Karyawan :");

        txt_nip.setEnabled(false);

        txt_nama.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(82, 89, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kehadiran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Jumlah Hadir :");

        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Jumlah Sakit :");

        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Jumlah Izin :");

        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Jumlah Alfa :");

        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Jumlah Hari :");

        txt_jml_hari.setEnabled(false);
        txt_jml_hari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_jml_hariMousePressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Bulan :");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tahun :");

        cbo_tahun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbo_tahunMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_tahunMouseClicked(evt);
            }
        });
        cbo_tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbo_tahunKeyPressed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Jam Masuk :");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Jam Keluar :");

        JSpinner.DateEditor de1=new JSpinner.DateEditor(cbo_jam_keluar, "HH:mm:ss");
        cbo_jam_keluar.setEditor(de1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_jam_keluar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_bulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_tahun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_jam_masuk))))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_jml_hadir)
                    .addComponent(txt_jml_sakit)
                    .addComponent(txt_jml_izin)
                    .addComponent(txt_jml_alfa)
                    .addComponent(txt_jml_hari, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_jml_hadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_jml_sakit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_jml_izin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_jml_alfa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_jml_hari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbo_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbo_jam_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbo_jam_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(82, 89, 243));

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/document_new.png"))); // NOI18N
        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });
        jPanel3.add(btn_new);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel3.add(btn_save);

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/update.png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel3.add(btn_edit);

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_delete);

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/search.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel3.add(btn_search);

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/refresh.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel3.add(btn_refresh);

        btn_search_nip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/search.png"))); // NOI18N
        btn_search_nip.setText("Search");
        btn_search_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_nipActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Id Absensi :");

        txt_id.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_nama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(txt_nip, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(btn_search_nip)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search_nip))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradienColor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradienColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_search_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_nipActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Karyawan> karyawans = karyawanDao.getKaryawans();
            if (!karyawans.isEmpty()) {
                jProgressBar1.setIndeterminate(true);
                DynamicTableModel tableMode = new DynamicTableModel(karyawans, Karyawan.class);
                PencarianDialog dialog = new PencarianDialog();
                //dialog.setTitle("Search Employee");
                dialog.setTableModel(tableMode);
                dialog.loadLokasi();
                String ambilData = dialog.ambilData();
                if (!ambilData.equals("")) {
                    karyawan = karyawanDao.getKaryawan(ambilData);
                    if(karyawan!=null){
                       txt_nip.setText(karyawan.getNip());
                       txt_nama.setText(karyawan.getNama());
                    }
                }
                jProgressBar1.setIndeterminate(false);
            }else{
                JOptionPane.showMessageDialog(this, "Data null !");
            }
        } catch (Exception ex) {
            Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_search_nipActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        try {
            String max = makeId.getId(absensiDao.getIdAbsensi(), "AB-", 10);
            txt_id.setText(String.valueOf(max));
            cbo_bulan.setEnabled(true);
            cbo_tahun.setEnabled(true);
            cbo_jam_masuk.setEnabled(true);
            cbo_jam_keluar.setEnabled(true);
            txt_jml_hadir.setEnabled(true);
            txt_jml_sakit.setEnabled(true);
            txt_jml_izin.setEnabled(true);
            txt_jml_alfa.setEnabled(true);
            btn_search_nip.setEnabled(true);
            
            btn_new.setEnabled(false);
            btn_save.setEnabled(true);
            btn_search.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                jProgressBar1.setIndeterminate(true);
                Absensi data = getData();
                boolean insert = absensiDao.insert(data);
                if(insert){
                    JOptionPane.showMessageDialog(this, "Saved sucsess!");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Saved failed !");
                }
            } catch (Exception ex) {
                Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                Absensi data = getData();
                jProgressBar1.setIndeterminate(true);
                boolean update = absensiDao.update(data);
                if(update){
                    JOptionPane.showMessageDialog(this, "Updated sucsess !");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Updated fail !");
                }
            } catch (Exception ex) {
                Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Do you wont delete it?", 
                "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
             if(absensi!=null){
                try {
                    jProgressBar1.setIndeterminate(true);
                    boolean delete = absensiDao.delete(absensi);
                    if(delete){
                        JOptionPane.showMessageDialog(this, "Deleted sucsesss !");
                        tampilanAwal();
                    }else{
                        JOptionPane.showMessageDialog(this, "Deleted fail !");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Absensi> absensis = absensiDao.getAbsensis();
            if (!absensis.isEmpty()) {
                jProgressBar1.setIndeterminate(true);
                DynamicTableModel tableModel = new DynamicTableModel(absensis, Absensi.class);
                PencarianDialog dialog = new PencarianDialog();
                //dialog.setTitle("Search Tools");
                dialog.setTableModel(tableModel);
                dialog.loadLokasi();
                String ambilData = dialog.ambilData();
                if (!ambilData.equals("")) {
                    absensi = absensiDao.getAbsensi(ambilData);
                    if (absensi != null) {
                        txt_id.setText(absensi.getIdAbsensi());
                        txt_nip.setText(absensi.getNip().getNip());
                        txt_nama.setText(absensi.getNip().getNama());
                        txt_jml_hadir.setText(String.valueOf(absensi.getJmlHadir()));
                        txt_jml_sakit.setText(String.valueOf(absensi.getJmlSakit()));
                        txt_jml_izin.setText(String.valueOf(absensi.getJmlIzin()));
                        txt_jml_alfa.setText(String.valueOf(absensi.getJmlAlfa()));
                        txt_jml_hari.setText(String.valueOf(absensi.getJmlHari()));
                        
                        String[] arraymont = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
                        String kehadiran[] = absensi.getKehadiran().split("-");
                        for(int i=0; i<arraymont.length; i++){
                            if(kehadiran[0].equals(arraymont[i])){
                                cbo_bulan.setMonth(i);
                                break;
                            }
                        }
                        cbo_tahun.setYear(Integer.valueOf(kehadiran[1]));
                        Date date_masuk=new SimpleDateFormat("HH:mm:ss").parse(kehadiran[2]);
                        Date date_keluar=new SimpleDateFormat("HH:mm:ss").parse(kehadiran[3]);
                        cbo_jam_masuk.setValue(date_masuk);
                        cbo_jam_keluar.setValue(date_keluar);
                        
                        cbo_bulan.setEnabled(true);
                        cbo_jam_keluar.setEnabled(true);
                        cbo_jam_masuk.setEnabled(true);
                        cbo_tahun.setEnabled(true);
                        txt_jml_hadir.setEnabled(true);
                        txt_jml_sakit.setEnabled(true);
                        txt_jml_izin.setEnabled(true);
                        txt_jml_alfa.setEnabled(true);
                        txt_jml_hari.setEnabled(true);
                        
                        btn_new.setEnabled(false);
                        btn_save.setEnabled(false);
                        btn_edit.setEnabled(true);
                        btn_delete.setEnabled(true);
                        jProgressBar1.setIndeterminate(false);
                    }
                }else{
                    jProgressBar1.setIndeterminate(false);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Data is null !");
            }
        } catch (Exception ex) {
            Logger.getLogger(AbsensiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void cbo_tahunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_tahunMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbo_tahunMouseClicked

    private void cbo_tahunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_tahunKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbo_tahunKeyPressed

    private void cbo_tahunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_tahunMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbo_tahunMousePressed

    private void txt_jml_hariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_jml_hariMousePressed
        // TODO add your handling code here:
        
            int tahun = cbo_tahun.getYear();
            int jumlahHari;
            if(cbo_bulan.getMonth() == 1){
                if (((tahun % 4== 0)&&!(tahun % 100 == 0))||(tahun % 400 == 0))
                    txt_jml_hari.setText("29");
                else 
                    txt_jml_hari.setText("28");
                
                
            }else if(cbo_bulan.getMonth() == 3||
                     cbo_bulan.getMonth() == 5||
                     cbo_bulan.getMonth() == 8||
                     cbo_bulan.getMonth() == 10)
            {
                     txt_jml_hari.setText("30");
            }else{
                     txt_jml_hari.setText("31");
            }
         
    }//GEN-LAST:event_txt_jml_hariMousePressed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        tampilanAwal();
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_search_nip;
    private com.toedter.calendar.JMonthChooser cbo_bulan;
    private javax.swing.JSpinner cbo_jam_keluar;
    private javax.swing.JSpinner cbo_jam_masuk;
    private com.toedter.calendar.JYearChooser cbo_tahun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbl_icon;
    private penggajian.custom.PanelGradienColor panelGradienColor1;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jml_alfa;
    private javax.swing.JTextField txt_jml_hadir;
    private javax.swing.JTextField txt_jml_hari;
    private javax.swing.JTextField txt_jml_izin;
    private javax.swing.JTextField txt_jml_sakit;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nip;
    // End of variables declaration//GEN-END:variables
}
