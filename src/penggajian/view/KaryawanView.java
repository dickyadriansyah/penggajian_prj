/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.view;

import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import penggajian.dao.JabatanDao;
import penggajian.dao.KaryawanDao;
import penggajian.dao.MakeId;
import penggajian.daoimpl.JabatanDaoImpl;
import penggajian.daoimpl.KaryawanDaoImpl;
import penggajian.daoimpl.MakeIdImpl;
import penggajian.dialog.PencarianDialog;
import penggajian.entity.Jabatan;
import penggajian.entity.Karyawan;

/**
 *
 * @author dickyadriansyah
 */
public class KaryawanView extends javax.swing.JInternalFrame {

    private EntityManager em;
    private Karyawan karyawan;
    private KaryawanDao karyawanDao;
    private JabatanDao jabatanDao;
    private MakeId makeId;
    public KaryawanView(EntityManager em) {
        this.em=em;
        initComponents();
        karyawanDao=new KaryawanDaoImpl(em);
        jabatanDao=new JabatanDaoImpl(em);
        makeId=new MakeIdImpl();
        tampilanAwal();
    }

    private Karyawan getData(){
        Karyawan k=new Karyawan();
        k.setNip(txt_nip.getText());
        k.setNama(txt_nama.getText());
        k.setJk(String.valueOf(cbo_jk.getSelectedItem()));
        k.setTptLahir(txt_tmptlahir.getText());
        k.setTglLahir(txt_tgl_lahir.getDate());
        k.setAgama(String.valueOf(cbo_agama.getSelectedItem()));
        k.setTelpon(txt_telepon.getText());
        k.setStatus(String.valueOf(cbo_status.getSelectedItem()));
        //memasukan data jabatan
        Jabatan jabatan=new Jabatan();
        jabatan=(Jabatan) cbo_jabatan.getSelectedItem();
        k.setIdJabatan(jabatan);
        k.setAlamat(txt_alamat.getText());
        return k;
    }
    
    private boolean validasi(){
        boolean valid=false;
        if(txt_nip.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Nip not null");
        }else if(txt_nama.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Employee name not null");
        }else if(cbo_jk.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Jenis Kelamin not null");
        }else if(txt_tmptlahir.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Tempat Lahir not null");
        }else if(txt_tgl_lahir.getDate() == null){
            JOptionPane.showMessageDialog(this, "Tanggal Lahir not null !");
        }else if(cbo_agama.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Agama not null");
        }else if(txt_telepon.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Telepon not null");
        }else if(cbo_status.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Status Pernikahan not null");
        }else if(cbo_jabatan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Jabatan not null");
        }else if(txt_alamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Alamat not null");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void tampilanAwal(){
        btn_save.setEnabled(false);
        txt_nama.setEnabled(false);
        cbo_jk.setEnabled(false);
        txt_tmptlahir.setEnabled(false);
        txt_tgl_lahir.setEnabled(false);
        cbo_agama.setEnabled(false);
        txt_telepon.setEnabled(false);
        cbo_status.setEnabled(false);
        cbo_jabatan.setEnabled(false);
        txt_alamat.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        
        txt_nip.setText("");
        txt_nama.setText("");
        cbo_jk.setSelectedIndex(0);
        txt_tmptlahir.setText("");
        txt_tgl_lahir.setDate(null);
        cbo_agama.setSelectedIndex(0);
        txt_telepon.setText("");
        cbo_status.setSelectedIndex(0);
        cbo_jabatan.setSelectedIndex(0);
        txt_alamat.setText("");
        
        btn_new.setEnabled(true);
        btn_search.setEnabled(true);
        jProgressBar1.setIndeterminate(false);
    }
    
    public void loadCombo(){
        try {
            List<Jabatan> jabatan = jabatanDao.getJabatans();
            for(Jabatan j: jabatan){
                cbo_jabatan.addItem(j);
            }
        } catch (Exception ex) {
            Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradienColor1 = new penggajian.custom.PanelGradienColor();
        lbl_icon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_nip = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        cbo_jk = new javax.swing.JComboBox<>();
        txt_tmptlahir = new javax.swing.JTextField();
        txt_tgl_lahir = new com.toedter.calendar.JDateChooser();
        cbo_agama = new javax.swing.JComboBox<>();
        txt_telepon = new javax.swing.JTextField();
        cbo_status = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        cbo_jabatan = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(82, 89, 243));
        setClosable(true);
        setIconifiable(true);
        setTitle("Form Karyawan");

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
                .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
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
        jLabel2.setText("Nip :");

        jLabel3.setForeground(new java.awt.Color(253, 251, 251));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama :");

        jLabel4.setForeground(new java.awt.Color(253, 251, 251));
        jLabel4.setText("Jenis Kelamin :");

        jLabel5.setForeground(new java.awt.Color(253, 251, 251));
        jLabel5.setText("Tempat Lahir :");

        jLabel6.setForeground(new java.awt.Color(253, 251, 251));
        jLabel6.setText("Tanggal Lahir :");

        jLabel7.setForeground(new java.awt.Color(253, 251, 251));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Agama :");

        jLabel8.setForeground(new java.awt.Color(253, 251, 251));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("No Telpon :");

        jLabel9.setForeground(new java.awt.Color(253, 251, 251));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Status :");

        jLabel10.setForeground(new java.awt.Color(253, 251, 251));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Jabatan :");

        jLabel11.setForeground(new java.awt.Color(253, 251, 251));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Alamat :");

        txt_nip.setEnabled(false);

        cbo_jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select One-", "L", "P" }));

        cbo_agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select One-", "Islam", "Kristen", "Hindu", "Budha", "Protestan" }));

        cbo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select One-", "Menikah", "Belum Menikah" }));

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane1.setViewportView(txt_alamat);

        cbo_jabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Select One -" }));

        jPanel2.setBackground(new java.awt.Color(82, 89, 243));

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/document_new.png"))); // NOI18N
        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });
        jPanel2.add(btn_new);

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save);

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/update.png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edit);

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete);

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/search.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel2.add(btn_search);

        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/refresh.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbo_status, javax.swing.GroupLayout.Alignment.LEADING, 0, 313, Short.MAX_VALUE)
                        .addComponent(txt_telepon, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbo_agama, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tmptlahir, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbo_jk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tmptlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbo_agama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbo_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradienColor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradienColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        try {
            String max = makeId.getId(karyawanDao.getIdKaryawan(), "K-", 10);
            txt_nip.setText(String.valueOf(max));
            txt_nama.setEnabled(true);
            cbo_jk.setEnabled(true);
            txt_tmptlahir.setEnabled(true);
            txt_tgl_lahir.setEnabled(true);
            cbo_agama.setEnabled(true);
            txt_telepon.setEnabled(true);
            cbo_status.setEnabled(true);
            cbo_jabatan.setEnabled(true);
            txt_alamat.setEnabled(true);
            
            btn_new.setEnabled(false);
            btn_save.setEnabled(true);
            btn_search.setEnabled(false);
            txt_nama.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                jProgressBar1.setIndeterminate(true);
                Karyawan data = getData();
                boolean insert = karyawanDao.insert(data);
                if(insert){
                    JOptionPane.showMessageDialog(this, "Saved sucsess!");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Saved failed !");
                }
            } catch (Exception ex) {
                Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                Karyawan data = getData();
                jProgressBar1.setIndeterminate(true);
                boolean update = karyawanDao.update(data);
                if(update){
                    JOptionPane.showMessageDialog(this, "Updated sucsess !");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Updated fail !");
                }
            } catch (Exception ex) {
                Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Do you wont delete it?", 
                "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
             if(karyawan!=null){
                try {
                    jProgressBar1.setIndeterminate(true);
                    boolean delete = karyawanDao.delete(karyawan);
                    if(delete){
                        JOptionPane.showMessageDialog(this, "Deleted sucsesss !");
                        tampilanAwal();
                    }else{
                        JOptionPane.showMessageDialog(this, "Deleted fail !");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Karyawan> karyawans = karyawanDao.getKaryawans();
            if (!karyawans.isEmpty()) {
                jProgressBar1.setIndeterminate(true);
                DynamicTableModel tableModel = new DynamicTableModel(karyawans, Karyawan.class);
                PencarianDialog dialog = new PencarianDialog();
                //dialog.setTitle("Search Tools");
                dialog.setTableModel(tableModel);
                dialog.loadLokasi();
                String ambilData = dialog.ambilData();
                if (!ambilData.equals("")) {
                    karyawan = karyawanDao.getKaryawan(ambilData);
                    if (karyawan != null) {
                        txt_nip.setText(karyawan.getNip());
                        txt_nama.setText(karyawan.getNama());
                        cbo_jk.setSelectedItem(karyawan.getJk());
                        txt_tmptlahir.setText(karyawan.getTptLahir());
                        txt_tgl_lahir.setDate(karyawan.getTglLahir());
                        cbo_agama.setSelectedItem(karyawan.getAgama());
                        txt_telepon.setText(karyawan.getTelpon());
                        cbo_status.setSelectedItem(karyawan.getStatus());
                        cbo_jabatan.setSelectedItem(karyawan.getIdJabatan());
                        txt_alamat.setText(karyawan.getAlamat());
                        txt_nama.setEnabled(true);
                        cbo_jk.setEnabled(true);
                        txt_tmptlahir.setEnabled(true);
                        txt_tgl_lahir.setEnabled(true);
                        cbo_agama.setEnabled(true);
                        txt_telepon.setEnabled(true);
                        cbo_status.setEnabled(true);
                        cbo_jabatan.setEnabled(true);
                        txt_alamat.setEnabled(true);
                        
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
            Logger.getLogger(KaryawanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        tampilanAwal();
    }//GEN-LAST:event_btn_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cbo_agama;
    private javax.swing.JComboBox cbo_jabatan;
    private javax.swing.JComboBox<String> cbo_jk;
    private javax.swing.JComboBox<String> cbo_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_icon;
    private penggajian.custom.PanelGradienColor panelGradienColor1;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nip;
    private javax.swing.JTextField txt_telepon;
    private com.toedter.calendar.JDateChooser txt_tgl_lahir;
    private javax.swing.JTextField txt_tmptlahir;
    // End of variables declaration//GEN-END:variables
}
