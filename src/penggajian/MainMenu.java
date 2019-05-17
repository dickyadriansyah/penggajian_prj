/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian;

import java.awt.Dimension;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import penggajian.custom.Icon;
import penggajian.dao.AbsensiDao;
import penggajian.dao.GajiDao;
import penggajian.dao.JabatanDao;
import penggajian.dao.KaryawanDao;
import penggajian.daoimpl.AbsensiDaoImpl;
import penggajian.daoimpl.GajiDaoImpl;
import penggajian.daoimpl.JabatanDaoImpl;
import penggajian.daoimpl.KaryawanDaoImpl;
import penggajian.dialog.Login;
import penggajian.dialog.TampilReport;
import penggajian.entity.Absensi;
import penggajian.entity.Gaji;
import penggajian.entity.Jabatan;
import penggajian.entity.Karyawan;
import penggajian.view.AbsensiView;
import penggajian.view.GajiView;
import penggajian.view.JabatanView;
import penggajian.view.KaryawanView;
import penggajian.view.ReportView;
import usu.widget.Form;

/**
 *
 * @author dickyadriansyah
 */
public class MainMenu extends Form {

    private EntityManager em;
    private Image image;
    private JabatanDao jabatanDao;
    private KaryawanDao karyawanDao;
    private AbsensiDao absensiDao;
    private GajiDao gajiDao;
    
    public MainMenu(EntityManager em) {
        this.em=em;
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        image=new ImageIcon(getClass().getResource("/penggajian/icon/logo_report.jpeg")).getImage();
        setIconImage(new Icon().getImage());
        mnu_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnu_jabatan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mnu_karyawan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        mnu_absensi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnu_gaji.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
    }

    private void logout(boolean mode){
        mMaster.setVisible(mode);
        mProcessData.setVisible(mode);
        mReport.setVisible(mode);
    }
    
    private void setSkrin(JInternalFrame frame){
        jDesktopPane1.add(frame);
        Dimension scrin=this.getSize();
        Dimension dim=frame.getSize();
        frame.setLocation((scrin.width-dim.width)/2, (scrin.height-dim.height)/2);
        frame.setVisible(true);
    }
    
        String[] strMonths = {
           "Januari",
           "Februari",
           "Maret",
           "April",
           "Mei",
           "Juni",
           "Juli",
           "Agustus",
           "September",
           "Oktober",
           "November",
           "Desember"
        };
    
        String[] strDays = {
            "Minggu",
            "Senin",
            "Selasa",
            "Rabu",
            "Kamis",
            "Jumat",
            "Sabtu"
        };
        
//    private static double getCurrencyIndo(long uang) {
//        double uangku = uang;
//        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
//        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
//
//        formatRp.setCurrencySymbol("Rp. ");
//        formatRp.setMonetaryDecimalSeparator(',');
//        formatRp.setGroupingSeparator('.');
//        kursIndonesia.setDecimalFormatSymbols(formatRp);
//        kursIndonesia.format(uangku);
//        return uangku;
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnu_logout = new javax.swing.JMenuItem();
        mnu_close = new javax.swing.JMenuItem();
        mMaster = new javax.swing.JMenu();
        mnu_karyawan = new javax.swing.JMenuItem();
        mnu_jabatan = new javax.swing.JMenuItem();
        mProcessData = new javax.swing.JMenu();
        mnu_absensi = new javax.swing.JMenuItem();
        mnu_gaji = new javax.swing.JMenuItem();
        mReport = new javax.swing.JMenu();
        mnu_rpt_jabatan = new javax.swing.JMenuItem();
        mnu_rpt_karyawan = new javax.swing.JMenuItem();
        mnu_rpt_absensi = new javax.swing.JMenuItem();
        mnu_rpt_gaji = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/file.png"))); // NOI18N
        jMenu1.setText("Application");

        mnu_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/exit.png"))); // NOI18N
        mnu_logout.setText("Logout");
        mnu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_logoutActionPerformed(evt);
            }
        });
        jMenu1.add(mnu_logout);

        mnu_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/close.png"))); // NOI18N
        mnu_close.setText("Close");
        mnu_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_closeActionPerformed(evt);
            }
        });
        jMenu1.add(mnu_close);

        jMenuBar1.add(jMenu1);

        mMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/master.png"))); // NOI18N
        mMaster.setText("Master Data");

        mnu_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/karyawan.png"))); // NOI18N
        mnu_karyawan.setText("Karyawan");
        mnu_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_karyawanActionPerformed(evt);
            }
        });
        mMaster.add(mnu_karyawan);

        mnu_jabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/audit.png"))); // NOI18N
        mnu_jabatan.setText("Jabatan");
        mnu_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_jabatanActionPerformed(evt);
            }
        });
        mMaster.add(mnu_jabatan);

        jMenuBar1.add(mMaster);

        mProcessData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/transaction.png"))); // NOI18N
        mProcessData.setText("Process Data");

        mnu_absensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/manajemen.png"))); // NOI18N
        mnu_absensi.setText("Absensi");
        mnu_absensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_absensiActionPerformed(evt);
            }
        });
        mProcessData.add(mnu_absensi);

        mnu_gaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/category.png"))); // NOI18N
        mnu_gaji.setText("Gaji");
        mnu_gaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_gajiActionPerformed(evt);
            }
        });
        mProcessData.add(mnu_gaji);

        jMenuBar1.add(mProcessData);

        mReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/reports.png"))); // NOI18N
        mReport.setText("Report");

        mnu_rpt_jabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/report1.png"))); // NOI18N
        mnu_rpt_jabatan.setText("Report Jabatan");
        mnu_rpt_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_rpt_jabatanActionPerformed(evt);
            }
        });
        mReport.add(mnu_rpt_jabatan);

        mnu_rpt_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/report1.png"))); // NOI18N
        mnu_rpt_karyawan.setText("Report Karyawan");
        mnu_rpt_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_rpt_karyawanActionPerformed(evt);
            }
        });
        mReport.add(mnu_rpt_karyawan);

        mnu_rpt_absensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/report1.png"))); // NOI18N
        mnu_rpt_absensi.setText("Report Absensi");
        mnu_rpt_absensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_rpt_absensiActionPerformed(evt);
            }
        });
        mReport.add(mnu_rpt_absensi);

        mnu_rpt_gaji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/report1.png"))); // NOI18N
        mnu_rpt_gaji.setText("Report All Gaji");
        mnu_rpt_gaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_rpt_gajiActionPerformed(evt);
            }
        });
        mReport.add(mnu_rpt_gaji);

        jMenuBar1.add(mReport);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_logoutActionPerformed
        // TODO add your handling code here:
       logout(false);
       this.setVisible(false);
       Login l=new Login();
       l.setEm(em);
       l.login();
       this.setVisible(false);
    }//GEN-LAST:event_mnu_logoutActionPerformed

    private void mnu_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_closeActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Do You Wont To Exit Application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION)
                ==JOptionPane.OK_OPTION){
            exit();
        }
    }//GEN-LAST:event_mnu_closeActionPerformed

    private void mnu_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_jabatanActionPerformed
        // TODO add your handling code here:
        JabatanView view=new JabatanView(em);
        setSkrin(view);
    }//GEN-LAST:event_mnu_jabatanActionPerformed

    private void mnu_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_karyawanActionPerformed
        // TODO add your handling code here:
        KaryawanView view=new KaryawanView(em);
        view.loadCombo();
        setSkrin(view);
    }//GEN-LAST:event_mnu_karyawanActionPerformed

    private void mnu_absensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_absensiActionPerformed
        // TODO add your handling code here:
        AbsensiView view=new AbsensiView(em);
        setSkrin(view);
    }//GEN-LAST:event_mnu_absensiActionPerformed

    private void mnu_gajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_gajiActionPerformed
        // TODO add your handling code here:
        GajiView view=new GajiView(em);
        setSkrin(view);
    }//GEN-LAST:event_mnu_gajiActionPerformed

    private void mnu_rpt_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_rpt_jabatanActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
                    Calendar now = Calendar.getInstance();
                    LocalDate localDate = LocalDate.now();
                    
                    String tanggal = null;
                    String bulan = null;
                    int day_of_week = now.get(Calendar.DAY_OF_WEEK);
                    int month = localDate.getMonthValue();
                    
                    switch (day_of_week) {
                        case 1:
                            tanggal = strDays[0];
                            break;
                        case 2:
                            tanggal = strDays[1];
                            break;
                        case 3:
                            tanggal = strDays[2];
                            break;
                        case 4:
                            tanggal = strDays[3];
                            break;
                        case 5:
                            tanggal = strDays[4];
                            break;
                        case 6:
                            tanggal = strDays[5];
                            break;
                        case 7:
                            tanggal = strDays[6];
                            break;
                        default:
                            break;
                    }
                    
                    switch(month){
                        case 1:
                            bulan = strMonths[0];
                            break;
                        case 2:
                            bulan = strMonths[1];
                            break;
                        case 3:
                            bulan = strMonths[2];
                            break;
                        case 4:
                            bulan = strMonths[3];
                            break;
                        case 5:
                            bulan = strMonths[4];
                            break;
                        case 6:
                            bulan = strMonths[5];
                            break;
                        case 7:
                            bulan = strMonths[6];
                            break;
                        case 8:
                            bulan = strMonths[7];
                            break;
                        case 9:
                            bulan = strMonths[8];
                            break;
                        case 10:
                            bulan = strMonths[9];
                            break;
                        case 11:
                            bulan = strMonths[10];
                            break;
                        case 12:
                            bulan = strMonths[11];
                            break;
                         default:
                            break;
                    }
                    
                    String tgl = tanggal +" "+ now.get(Calendar.DATE) + " " + bulan + " " + now.get(Calendar.YEAR);
                    jabatanDao=new JabatanDaoImpl(em);
                    List<Jabatan> jabatans = jabatanDao.getJabatans();
                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');
                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    
                    String gaji_pokok=null,tunjangan=null,uang_lembur=null,uang_makan=null,uang_transport=null;
                   
                    for(Jabatan jabatan : jabatans){
                        gaji_pokok = kursIndonesia.format(jabatan.getGajiPokok());
                        tunjangan = kursIndonesia.format(jabatan.getTunjangan());
                        uang_lembur = kursIndonesia.format(jabatan.getUangLembur());
                        uang_makan = kursIndonesia.format(jabatan.getUangMakan());
                        uang_transport = kursIndonesia.format(jabatan.getUangTransportasi());
                    }
                    
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("tanggal", tgl);
                    map.put("gaji_pokok", gaji_pokok);
                    map.put("tunjangan", tunjangan);
                    map.put("uang_lembur", uang_lembur);
                    map.put("uang_makan", uang_makan);
                    map.put("uang_transport", uang_transport);
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/JabatanRpt.jasper"),
                            map, new JRBeanCollectionDataSource(jabatans));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Data Jabatan", jv);
        } catch (Exception ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_rpt_jabatanActionPerformed

    private void mnu_rpt_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_rpt_karyawanActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
                    Calendar now = Calendar.getInstance();
                    LocalDate localDate = LocalDate.now();
                    
                    String tanggal = null;
                    String bulan = null;
                    int day_of_week = now.get(Calendar.DAY_OF_WEEK);
                    int month = localDate.getMonthValue();
                    
                    switch (day_of_week) {
                        case 1:
                            tanggal = strDays[0];
                            break;
                        case 2:
                            tanggal = strDays[1];
                            break;
                        case 3:
                            tanggal = strDays[2];
                            break;
                        case 4:
                            tanggal = strDays[3];
                            break;
                        case 5:
                            tanggal = strDays[4];
                            break;
                        case 6:
                            tanggal = strDays[5];
                            break;
                        case 7:
                            tanggal = strDays[6];
                            break;
                        default:
                            break;
                    }
                    
                    switch(month){
                        case 1:
                            bulan = strMonths[0];
                            break;
                        case 2:
                            bulan = strMonths[1];
                            break;
                        case 3:
                            bulan = strMonths[2];
                            break;
                        case 4:
                            bulan = strMonths[3];
                            break;
                        case 5:
                            bulan = strMonths[4];
                            break;
                        case 6:
                            bulan = strMonths[5];
                            break;
                        case 7:
                            bulan = strMonths[6];
                            break;
                        case 8:
                            bulan = strMonths[7];
                            break;
                        case 9:
                            bulan = strMonths[8];
                            break;
                        case 10:
                            bulan = strMonths[9];
                            break;
                        case 11:
                            bulan = strMonths[10];
                            break;
                        case 12:
                            bulan = strMonths[11];
                            break;
                         default:
                            break;
                    }
                    
                    String tgl = tanggal +" "+ now.get(Calendar.DATE) + " " + bulan + " " + now.get(Calendar.YEAR);
                    karyawanDao=new KaryawanDaoImpl(em);
                    List<Karyawan> karyawans = karyawanDao.getKaryawans();
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("tanggal", tgl);
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/KaryawanRpt.jasper"),
                            map, new JRBeanCollectionDataSource(karyawans));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Data Karyawan", jv);
        } catch (Exception ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_rpt_karyawanActionPerformed

    private void mnu_rpt_absensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_rpt_absensiActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
                   Calendar now = Calendar.getInstance();
                    LocalDate localDate = LocalDate.now();
                    
                    String tanggal = null;
                    String bulan = null;
                    int day_of_week = now.get(Calendar.DAY_OF_WEEK);
                    int month = localDate.getMonthValue();
                    
                    switch (day_of_week) {
                        case 1:
                            tanggal = strDays[0];
                            break;
                        case 2:
                            tanggal = strDays[1];
                            break;
                        case 3:
                            tanggal = strDays[2];
                            break;
                        case 4:
                            tanggal = strDays[3];
                            break;
                        case 5:
                            tanggal = strDays[4];
                            break;
                        case 6:
                            tanggal = strDays[5];
                            break;
                        case 7:
                            tanggal = strDays[6];
                            break;
                        default:
                            break;
                    }
                    
                    switch(month){
                        case 1:
                            bulan = strMonths[0];
                            break;
                        case 2:
                            bulan = strMonths[1];
                            break;
                        case 3:
                            bulan = strMonths[2];
                            break;
                        case 4:
                            bulan = strMonths[3];
                            break;
                        case 5:
                            bulan = strMonths[4];
                            break;
                        case 6:
                            bulan = strMonths[5];
                            break;
                        case 7:
                            bulan = strMonths[6];
                            break;
                        case 8:
                            bulan = strMonths[7];
                            break;
                        case 9:
                            bulan = strMonths[8];
                            break;
                        case 10:
                            bulan = strMonths[9];
                            break;
                        case 11:
                            bulan = strMonths[10];
                            break;
                        case 12:
                            bulan = strMonths[11];
                            break;
                         default:
                            break;
                    }
                    
                    String tgl = tanggal +" "+ now.get(Calendar.DATE) + " " + bulan + " " + now.get(Calendar.YEAR);
                    absensiDao=new AbsensiDaoImpl(em);
                    List<Absensi> absensis = absensiDao.getAbsensis();
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("tanggal", tgl);
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/AbsensiRpt.jasper"),
                            map, new JRBeanCollectionDataSource(absensis));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Data Absensi", jv);
        } catch (Exception ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_rpt_absensiActionPerformed

    private void mnu_rpt_gajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_rpt_gajiActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
                    Calendar now = Calendar.getInstance();
                    LocalDate localDate = LocalDate.now();
                    
                    String tanggal = null;
                    String bulan = null;
                    int day_of_week = now.get(Calendar.DAY_OF_WEEK);
                    int month = localDate.getMonthValue();
                    
                    switch (day_of_week) {
                        case 1:
                            tanggal = strDays[0];
                            break;
                        case 2:
                            tanggal = strDays[1];
                            break;
                        case 3:
                            tanggal = strDays[2];
                            break;
                        case 4:
                            tanggal = strDays[3];
                            break;
                        case 5:
                            tanggal = strDays[4];
                            break;
                        case 6:
                            tanggal = strDays[5];
                            break;
                        case 7:
                            tanggal = strDays[6];
                            break;
                        default:
                            break;
                    }
                    
                    switch(month){
                        case 1:
                            bulan = strMonths[0];
                            break;
                        case 2:
                            bulan = strMonths[1];
                            break;
                        case 3:
                            bulan = strMonths[2];
                            break;
                        case 4:
                            bulan = strMonths[3];
                            break;
                        case 5:
                            bulan = strMonths[4];
                            break;
                        case 6:
                            bulan = strMonths[5];
                            break;
                        case 7:
                            bulan = strMonths[6];
                            break;
                        case 8:
                            bulan = strMonths[7];
                            break;
                        case 9:
                            bulan = strMonths[8];
                            break;
                        case 10:
                            bulan = strMonths[9];
                            break;
                        case 11:
                            bulan = strMonths[10];
                            break;
                        case 12:
                            bulan = strMonths[11];
                            break;
                         default:
                            break;
                    }
                    
                    String tgl = tanggal +" "+ now.get(Calendar.DATE) + " " + bulan + " " + now.get(Calendar.YEAR);
                    gajiDao=new GajiDaoImpl(em);
                    List<Gaji> gajis = gajiDao.getGajis();
                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');
                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    
                    String gaji_pokok=null,tunjangan=null,uang_lembur=null,uang_makan=null,uang_transport=null,total=null;
                   
                    for(Gaji gaji1 : gajis){
                            gaji_pokok = kursIndonesia.format(gaji1.getGajiPokok());
                            tunjangan = kursIndonesia.format(gaji1.getTunjangan());
                            uang_lembur = kursIndonesia.format(gaji1.getUangLembur());
                            uang_makan = kursIndonesia.format(gaji1.getUangMakan());
                            uang_transport = kursIndonesia.format(gaji1.getUangTransportasi());
                            total = gaji1.getTotalGaji();
                            gaji1.setTotalGaji(total);
                    }
                    
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("tanggal", tgl);
                    map.put("gaji_pokok", gaji_pokok);
                    map.put("tunjangan", tunjangan);
                    map.put("uang_lembur", uang_lembur);
                    map.put("uang_makan", uang_makan);
                    map.put("uang_transport", uang_transport);
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/GajiRpt.jasper"),
                            map, new JRBeanCollectionDataSource(gajis));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Data Gaji", jv);
        } catch (Exception ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_rpt_gajiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mMaster;
    private javax.swing.JMenu mProcessData;
    private javax.swing.JMenu mReport;
    private javax.swing.JMenuItem mnu_absensi;
    private javax.swing.JMenuItem mnu_close;
    private javax.swing.JMenuItem mnu_gaji;
    private javax.swing.JMenuItem mnu_jabatan;
    private javax.swing.JMenuItem mnu_karyawan;
    private javax.swing.JMenuItem mnu_logout;
    private javax.swing.JMenuItem mnu_rpt_absensi;
    private javax.swing.JMenuItem mnu_rpt_gaji;
    private javax.swing.JMenuItem mnu_rpt_jabatan;
    private javax.swing.JMenuItem mnu_rpt_karyawan;
    // End of variables declaration//GEN-END:variables
}
