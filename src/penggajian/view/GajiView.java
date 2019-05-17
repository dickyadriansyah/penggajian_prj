/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.view;

import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import penggajian.MainMenu;
import penggajian.dao.GajiDao;
import penggajian.dao.JabatanDao;
import penggajian.dao.KaryawanDao;
import penggajian.dao.MakeId;
import penggajian.daoimpl.GajiDaoImpl;
import penggajian.daoimpl.JabatanDaoImpl;
import penggajian.daoimpl.KaryawanDaoImpl;
import penggajian.daoimpl.MakeIdImpl;
import penggajian.dialog.PencarianDialog;
import penggajian.dialog.TampilReport;
import penggajian.entity.Gaji;
import penggajian.entity.Jabatan;
import penggajian.entity.Karyawan;

/**
 *
 * @author dickyadriansyah
 */
public class GajiView extends javax.swing.JInternalFrame {

    private EntityManager em;
    private KaryawanDao karyawanDao;
    private GajiDao gajiDao;
    private JabatanDao jabatanDao;
    private Karyawan karyawan;
    private Gaji gaji;
    private Jabatan jabatan;
    private MakeId makeId;
    private Image image;
    
    public GajiView(EntityManager em) {
        this.em=em;
        initComponents();
        image=new ImageIcon(getClass().getResource("/penggajian/icon/logo_report.jpeg")).getImage();
        karyawanDao=new KaryawanDaoImpl(em);
        gajiDao=new GajiDaoImpl(em);
        jabatanDao=new JabatanDaoImpl(em);
        makeId=new MakeIdImpl();
        tampilanAwal();
    }

//    private String bulan(int bulan){
//        String[] arraymont = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
//        String bulans = "";
//        for (int i = 0; i< arraymont.length; i++) {
//            if(i == bulan){
//                bulans = arraymont[i];
//                break;
//            }
//        }
//        return bulans;
//    }
    
    private String bulanEng(String month){
        List<String> monthar = new ArrayList<>(12);
        monthar.add("Januari");
        monthar.add("Februari");
        monthar.add("Maret");
        monthar.add("April");
        monthar.add("Mei");
        monthar.add("Juni");
        monthar.add("Juli");
        monthar.add("Agustus");
        monthar.add("September");
        monthar.add("Oktober");
        monthar.add("November");
        monthar.add("Desember");
        
        String[] arraymont = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String bulans = null;
        int index=0;
        for(String i : monthar){
            if(month.equals(i)){
                index = monthar.indexOf(month);
                bulans = arraymont[index];
                break;
            }
        }
        
        return bulans;
    }
    
    
    
    private Gaji getData(){
        Gaji g=new Gaji();
        karyawan=new Karyawan();
        g.setIdGaji(txt_id.getText());
        
        Locale id = new Locale("in", "ID");
        String pattern = "EEEE, dd MMMM yyyy";
        Date tgl = txt_tanggal.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, id);
        String formatindo = sdf.format(tgl);
        g.setBlnTahun(formatindo);
        
//        String bln = bulan(cbo_bulan.getMonth());
//        int year = cbo_tahun.getYear();
//        g.setBlnTahun(bln+"-"+year);
        
        String nip = txt_nip.getText();
        karyawan.setNip(nip);
        g.setNip(karyawan);
        g.setGajiPokok(Long.valueOf(txt_gaji_pokok.getText()));
        g.setUangMakan(Long.valueOf(txt_uang_makan.getText()));
        g.setUangTransportasi(Long.valueOf(txt_uang_transport.getText()));
        g.setUangLembur(Long.valueOf(txt_uang_lembur.getText()));
        g.setTunjangan(Long.valueOf(txt_tunjangan.getText()));
        g.setTotalGaji(txt_total_gaji.getText());
        return g;
    }
    
    private boolean validasi(){
        boolean valid=false;
        if(txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Gaji id not null");
        }else if(txt_nip.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Karyawan not null");
        }else if(txt_total_gaji.getText() == "0"){
            JOptionPane.showMessageDialog(this, "Total gaji not null Plese CLick Text");
        }
        else{
            valid=true;
        }
        return valid;
    }
    
    private void tampilanAwal(){
        btn_save.setEnabled(false);
        //cbo_bulan.setEnabled(false);
        //cbo_tahun.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_search_nip.setEnabled(false);
        txt_tanggal.setEnabled(false);
        
        txt_id.setText("");
        txt_gaji_pokok.setText("0");
        txt_uang_makan.setText("0");
        txt_uang_transport.setText("0");
        txt_uang_lembur.setText("0");
        txt_tunjangan.setText("0");
        txt_total_gaji.setText("0");
        txt_nip.setText("");
        txt_nama.setText("");
        txt_tanggal.setDate(new Date());
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_gaji_pokok = new javax.swing.JTextField();
        txt_uang_makan = new javax.swing.JTextField();
        txt_uang_transport = new javax.swing.JTextField();
        txt_uang_lembur = new javax.swing.JTextField();
        txt_tunjangan = new javax.swing.JTextField();
        txt_total_gaji = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_nip = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        btn_search_nip = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Form Gaji");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGradienColor1Layout.setVerticalGroup(
            panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienColor1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(82, 89, 243));

        jLabel2.setForeground(new java.awt.Color(253, 251, 251));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Gaji :");

        jLabel5.setForeground(new java.awt.Color(253, 251, 251));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nip :");

        jLabel6.setForeground(new java.awt.Color(253, 251, 251));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nama :");

        jPanel2.setBackground(new java.awt.Color(82, 89, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Uang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(253, 251, 251));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Gaji Pokok :");

        jLabel9.setForeground(new java.awt.Color(253, 251, 251));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Uang Makan :");

        jLabel10.setForeground(new java.awt.Color(253, 251, 251));
        jLabel10.setText("Uang Transport :");

        jLabel11.setForeground(new java.awt.Color(253, 251, 251));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Uang Lembur :");

        jLabel12.setForeground(new java.awt.Color(253, 251, 251));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tunjangan :");

        jLabel13.setForeground(new java.awt.Color(253, 251, 251));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Total Gaji :");

        txt_gaji_pokok.setEnabled(false);

        txt_uang_makan.setEnabled(false);

        txt_uang_transport.setEnabled(false);

        txt_uang_lembur.setEnabled(false);

        txt_tunjangan.setEnabled(false);

        txt_total_gaji.setEnabled(false);
        txt_total_gaji.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_total_gajiMousePressed(evt);
            }
        });
        txt_total_gaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_gajiActionPerformed(evt);
            }
        });
        txt_total_gaji.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_total_gajiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_total_gajiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_gaji_pokok)
                    .addComponent(txt_uang_makan)
                    .addComponent(txt_uang_transport)
                    .addComponent(txt_uang_lembur)
                    .addComponent(txt_tunjangan)
                    .addComponent(txt_total_gaji, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_gaji_pokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_uang_makan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_uang_transport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txt_uang_lembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_tunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_total_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        txt_id.setEnabled(false);

        txt_nip.setEnabled(false);

        txt_nama.setEnabled(false);

        btn_search_nip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/search.png"))); // NOI18N
        btn_search_nip.setText("Search");
        btn_search_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_nipActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(253, 251, 251));
        jLabel7.setText("Tanggal :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btn_search_nip))
                                    .addComponent(txt_nama))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(86, 86, 86)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel7))
                            .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search_nip))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradienColor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradienColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
                       txt_gaji_pokok.setText(String.valueOf(karyawan.getIdJabatan().getGajiPokok()));
                       txt_uang_makan.setText(String.valueOf(karyawan.getIdJabatan().getUangMakan()));
                       txt_uang_transport.setText(String.valueOf(karyawan.getIdJabatan().getUangTransportasi()));
                       txt_uang_lembur.setText(String.valueOf(karyawan.getIdJabatan().getUangLembur()));
                       txt_tunjangan.setText(String.valueOf(karyawan.getIdJabatan().getTunjangan()));
                       
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
            String max = makeId.getId(gajiDao.getIdGaji(), "GJ-", 10);
            txt_id.setText(String.valueOf(max));
            //cbo_bulan.setEnabled(true);
            //cbo_tahun.setEnabled(true);
            btn_search_nip.setEnabled(true);
            txt_tanggal.setEnabled(true);
            
            btn_new.setEnabled(false);
            btn_save.setEnabled(true);
            btn_search.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(GajiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                jProgressBar1.setIndeterminate(true);
                Gaji data = getData();
                boolean insert = gajiDao.insert(data);
                if(insert){
                    JOptionPane.showMessageDialog(this, "Saved sucsess!");
                    List<Gaji> gajis = gajiDao.getGajis(txt_id.getText());
                    
                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');
                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    
                    String gaji_pokok=null,tunjangan=null,uang_lembur=null,uang_makan=null,uang_transport=null,total=null;
                   
                    for(Gaji gaji1 : gajis){
                        if(gaji1!=null){
                            gaji_pokok = kursIndonesia.format(gaji1.getGajiPokok());
                            tunjangan = kursIndonesia.format(gaji1.getTunjangan());
                            uang_lembur = kursIndonesia.format(gaji1.getUangLembur());
                            uang_makan = kursIndonesia.format(gaji1.getUangMakan());
                            uang_transport = kursIndonesia.format(gaji1.getUangTransportasi());
                            total = kursIndonesia.format(Long.valueOf(gaji1.getTotalGaji()));
                            gaji1.setTotalGaji(total);
                            break;
                        }
                        
                    }
//                    for (Gaji gaji1 : gajis) {
//                        String kehadiran[] = gaji1.getBlnTahun().split("-");
//                        gaji1.setBlnTahun(kehadiran[0] + " "+ kehadiran[1]);
//                        break;
//                    }
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("gaji_pokok", gaji_pokok);
                    map.put("tunjangan", tunjangan);
                    map.put("uang_lembur", uang_lembur);
                    map.put("uang_makan", uang_makan);
                    map.put("uang_transport", uang_transport);
                    
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/SlipGajiRpt.jasper"),
                            map, new JRBeanCollectionDataSource(gajis));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Slip Gaji", jv);
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Saved failed !");
                }
            } catch (Exception ex) {
                Logger.getLogger(GajiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                Gaji data = getData();
                jProgressBar1.setIndeterminate(true);
                boolean update = gajiDao.update(data);
                if(update){
                    JOptionPane.showMessageDialog(this, "Updated sucsess !");
                    List<Gaji> gajis = gajiDao.getGajis(txt_id.getText());
                    
                    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                    formatRp.setCurrencySymbol("Rp. ");
                    formatRp.setMonetaryDecimalSeparator(',');
                    formatRp.setGroupingSeparator('.');
                    kursIndonesia.setDecimalFormatSymbols(formatRp);
                    
                    String gaji_pokok=null,tunjangan=null,uang_lembur=null,uang_makan=null,uang_transport=null,total=null;
                   
                    for(Gaji gaji1 : gajis){
                        if(gaji1!=null){
                            gaji_pokok = kursIndonesia.format(gaji1.getGajiPokok());
                            tunjangan = kursIndonesia.format(gaji1.getTunjangan());
                            uang_lembur = kursIndonesia.format(gaji1.getUangLembur());
                            uang_makan = kursIndonesia.format(gaji1.getUangMakan());
                            uang_transport = kursIndonesia.format(gaji1.getUangTransportasi());
                            total = gaji1.getTotalGaji();
                            gaji1.setTotalGaji(total);
                            break;
                        }
                        
                    }
//                    for (Gaji gaji1 : gajis) {
//                        String kehadiran[] = gaji1.getBlnTahun().split("-");
//                        gaji1.setBlnTahun(kehadiran[0] + " "+ kehadiran[1]);
//                        break;
//                    }
                    HashMap map=new HashMap();
                    map.put("logo", image);
                    map.put("gaji_pokok", gaji_pokok);
                    map.put("tunjangan", tunjangan);
                    map.put("uang_lembur", uang_lembur);
                    map.put("uang_makan", uang_makan);
                    map.put("uang_transport", uang_transport);
                    JasperPrint jPrint=JasperFillManager.fillReport(this.getClass().
                        getClassLoader().getResourceAsStream("penggajian/laporan/SlipGajiRpt.jasper"),
                            map, new JRBeanCollectionDataSource(gajis));
                    
                    JRViewer jv=new JRViewer(jPrint);
                    TampilReport report=new TampilReport("Slip Gaji", jv);
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Updated fail !");
                }
            } catch (Exception ex) {
                Logger.getLogger(GajiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Do you wont delete it?", 
                "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
             if(gaji!=null){
                try {
                    jProgressBar1.setIndeterminate(true);
                    boolean delete = gajiDao.delete(gaji);
                    if(delete){
                        JOptionPane.showMessageDialog(this, "Deleted sucsesss !");
                        tampilanAwal();
                    }else{
                        JOptionPane.showMessageDialog(this, "Deleted fail !");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(GajiView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Gaji> gajis = gajiDao.getGajis();
            if (!gajis.isEmpty()) {
                jProgressBar1.setIndeterminate(true);
                DynamicTableModel tableModel = new DynamicTableModel(gajis, Gaji.class);
                PencarianDialog dialog = new PencarianDialog();
                //dialog.setTitle("Search Tools");
                dialog.setTableModel(tableModel);
                dialog.loadLokasi();
                String ambilData = dialog.ambilData();
                if (!ambilData.equals("")) {
                    gaji = gajiDao.getGaji(ambilData);
                    if (gaji != null) {
                        txt_id.setText(gaji.getIdGaji());
                        txt_nip.setText(gaji.getNip().getNip());
                        txt_nama.setText(gaji.getNip().getNama());
                        txt_gaji_pokok.setText(String.valueOf(gaji.getGajiPokok()));
                        txt_uang_makan.setText(String.valueOf(gaji.getUangMakan()));
                        txt_uang_transport.setText(String.valueOf(gaji.getUangTransportasi()));
                        txt_uang_lembur.setText(String.valueOf(gaji.getUangLembur()));
                        txt_tunjangan.setText(String.valueOf(gaji.getTunjangan()));
                        txt_total_gaji.setText(gaji.getTotalGaji());
                        
                        String tgl = gaji.getBlnTahun();
                        String splittgl[] = tgl.split(" ");
                        String bulan = splittgl[2];
                        String hasilbulan = bulanEng(bulan);
                        String tanggal = splittgl[1];
                        String tahun = splittgl[3];
                        
                        String oke = hasilbulan+" "+tanggal+", "+tahun;
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
                        Date d = dateFormat.parse(oke);
                        txt_tanggal.setDate(d);
                        
//                        String[] arraymont = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
//                        String kehadiran[] = gaji.getBlnTahun().split("-");
//                        for(int i=0; i<arraymont.length; i++){
//                            if(kehadiran[0].equals(arraymont[i])){
//                                cbo_bulan.setMonth(i);
//                                break;
//                            }
//                        }
//                        cbo_tahun.setYear(Integer.valueOf(kehadiran[1]));
                        
                        //cbo_bulan.setEnabled(true);
                        //cbo_tahun.setEnabled(true);
                        
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
            Logger.getLogger(GajiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_total_gajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_gajiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gajiActionPerformed

    private void txt_total_gajiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_total_gajiKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_total_gajiKeyPressed

    private void txt_total_gajiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_total_gajiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_gajiKeyReleased

    private void txt_total_gajiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_total_gajiMousePressed
        // TODO add your handling code here:
        if(txt_gaji_pokok.getText().trim().isEmpty() || txt_gaji_pokok.getText() == "0"){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Karyawan");
        }
        else{
            long gaji_pokok = 0, uang_makan = 0, uang_transport=0, uang_lembur=0, tunjangan=0, total_gaji=0;
            gaji_pokok = Long.valueOf(txt_gaji_pokok.getText());
            uang_makan = Long.valueOf(txt_uang_makan.getText());
            uang_transport = Long.valueOf(txt_uang_transport.getText());
            uang_lembur = Long.valueOf(txt_uang_lembur.getText());
            tunjangan = Long.valueOf(txt_tunjangan.getText());
            
            total_gaji =  gaji_pokok + uang_makan + uang_transport + uang_lembur + tunjangan;
            txt_total_gaji.setText(String.valueOf(total_gaji));
        }
    }//GEN-LAST:event_txt_total_gajiMousePressed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txt_gaji_pokok;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nip;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    private javax.swing.JTextField txt_total_gaji;
    private javax.swing.JTextField txt_tunjangan;
    private javax.swing.JTextField txt_uang_lembur;
    private javax.swing.JTextField txt_uang_makan;
    private javax.swing.JTextField txt_uang_transport;
    // End of variables declaration//GEN-END:variables
}
