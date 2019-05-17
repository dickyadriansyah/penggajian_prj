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
import penggajian.dao.MakeId;
import penggajian.daoimpl.JabatanDaoImpl;
import penggajian.daoimpl.MakeIdImpl;
import penggajian.dialog.PencarianDialog;
import penggajian.entity.Jabatan;

/**
 *
 * @author dickyadriansyah
 */
public class JabatanView extends javax.swing.JInternalFrame {

    private EntityManager em;
    private Jabatan jabatan;
    private JabatanDao jabatanDao;
    private MakeId makeId;
    public JabatanView(EntityManager em) {
        this.em = em;
        initComponents();
        jabatanDao=new JabatanDaoImpl(em);
        makeId=new MakeIdImpl();
        tampilanAwal();
    }

    private Jabatan getData(){
        Jabatan j=new Jabatan();
        j.setIdJabatan(txt_id.getText());
        j.setJabatan(txt_jabatan.getText());
        j.setGajiPokok(Long.valueOf(txt_gaji_pokok.getText()));
        j.setUangMakan(Long.valueOf(txt_uang_makan.getText()));
        j.setUangTransportasi(Long.valueOf(txt_uang_transport.getText()));
        j.setUangLembur(Long.valueOf(txt_uang_lembur.getText()));
        j.setTunjangan(Long.valueOf(txt_tunjangan.getText()));
        return j;
    }
    
    private boolean validasi(){
        boolean valid=false;
        if(txt_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jabatan id not null");
        }else if(txt_jabatan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Jabatan name not null");
        }else if(txt_gaji_pokok.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Gaji Pokok not null");
        }else if(txt_uang_makan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Uang Makan not null");
        }else if(txt_uang_transport.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Uang Transport not null !");
        }else if(txt_uang_lembur.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Uang Lembur not null");
        }else if(txt_tunjangan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Tunjangan not null");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void tampilanAwal(){
        btn_save.setEnabled(false);
        txt_jabatan.setEnabled(false);
        txt_gaji_pokok.setEnabled(false);
        txt_uang_makan.setEnabled(false);
        txt_uang_transport.setEnabled(false);
        txt_uang_lembur.setEnabled(false);
        txt_tunjangan.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        
        txt_id.setText("");
        txt_jabatan.setText("");
        txt_gaji_pokok.setText("");
        txt_uang_makan.setText("");
        txt_uang_transport.setText("");
        txt_uang_lembur.setText("");
        txt_tunjangan.setText("");
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_jabatan = new javax.swing.JTextField();
        txt_gaji_pokok = new javax.swing.JTextField();
        txt_uang_makan = new javax.swing.JTextField();
        txt_uang_transport = new javax.swing.JTextField();
        txt_uang_lembur = new javax.swing.JTextField();
        txt_tunjangan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setClosable(true);
        setForeground(new java.awt.Color(36, 46, 224));
        setIconifiable(true);
        setTitle("Form Jabatan");

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
                .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
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

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Id Jabatan :");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jabatan :");

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Gaji Pokok :");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Uang Makan :");

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Uang Transportasi :");

        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Uang Lembur :");

        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tunjangan :");

        txt_id.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_tunjangan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addComponent(txt_uang_lembur, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_uang_transport, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_uang_makan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_gaji_pokok, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_gaji_pokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_uang_makan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_uang_transport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_uang_lembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(82, 89, 243));

        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penggajian/icon/add.png"))); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradienColor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGradienColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        try {
            String max = makeId.getId(jabatanDao.getIdJabatan(), "JB-", 10);
            txt_id.setText(String.valueOf(max));
            txt_jabatan.setEnabled(true);
            txt_gaji_pokok.setEnabled(true);
            txt_uang_makan.setEnabled(true);
            txt_uang_transport.setEnabled(true);
            txt_uang_lembur.setEnabled(true);
            txt_tunjangan.setEnabled(true);
            
            btn_new.setEnabled(false);
            btn_save.setEnabled(true);
            btn_search.setEnabled(false);
            txt_jabatan.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(JabatanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        tampilanAwal();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                jProgressBar1.setIndeterminate(true);
                Jabatan data = getData();
                boolean insert = jabatanDao.insert(data);
                if(insert){
                    JOptionPane.showMessageDialog(this, "Saved sucsess!");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Saved failed !");
                }
            } catch (Exception ex) {
                Logger.getLogger(JabatanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if(validasi()){
            try {
                Jabatan data = getData();
                jProgressBar1.setIndeterminate(true);
                boolean update = jabatanDao.update(data);
                if(update){
                    JOptionPane.showMessageDialog(this, "Updated sucsess !");
                    tampilanAwal();
                }else{
                    JOptionPane.showMessageDialog(this, "Updated fail !");
                }
            } catch (Exception ex) {
                Logger.getLogger(JabatanView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Do you wont delete it?", 
                "Confirmation", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
             if(jabatan!=null){
                try {
                    jProgressBar1.setIndeterminate(true);
                    boolean delete = jabatanDao.delete(jabatan);
                    if(delete){
                        JOptionPane.showMessageDialog(this, "Deleted sucsesss !");
                        tampilanAwal();
                    }else{
                        JOptionPane.showMessageDialog(this, "Deleted fail !");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(JabatanView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            List<Jabatan> jabatans = jabatanDao.getJabatans();
            if (!jabatans.isEmpty()) {
                jProgressBar1.setIndeterminate(true);
                DynamicTableModel tableModel = new DynamicTableModel(jabatans, Jabatan.class);
                PencarianDialog dialog = new PencarianDialog();
                //dialog.setTitle("Search Tools");
                dialog.setTableModel(tableModel);
                dialog.loadLokasi();
                String ambilData = dialog.ambilData();
                if (!ambilData.equals("")) {
                    jabatan = jabatanDao.getJabatan(ambilData);
                    if (jabatan != null) {
                        txt_id.setText(jabatan.getIdJabatan());
                        txt_jabatan.setText(jabatan.getJabatan());
                        txt_gaji_pokok.setText(String.valueOf(jabatan.getGajiPokok()));
                        txt_uang_makan.setText(String.valueOf(jabatan.getUangMakan()));
                        txt_uang_transport.setText(String.valueOf(jabatan.getUangTransportasi()));
                        txt_uang_lembur.setText(String.valueOf(jabatan.getUangLembur()));
                        txt_tunjangan.setText(String.valueOf(jabatan.getTunjangan()));
                        txt_jabatan.setEnabled(true);
                        txt_gaji_pokok.setEnabled(true);
                        txt_uang_makan.setEnabled(true);
                        txt_uang_transport.setEnabled(true);
                        txt_uang_lembur.setEnabled(true);
                        txt_tunjangan.setEnabled(true);
                        
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
            Logger.getLogger(JabatanView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbl_icon;
    private penggajian.custom.PanelGradienColor panelGradienColor1;
    private javax.swing.JTextField txt_gaji_pokok;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jabatan;
    private javax.swing.JTextField txt_tunjangan;
    private javax.swing.JTextField txt_uang_lembur;
    private javax.swing.JTextField txt_uang_makan;
    private javax.swing.JTextField txt_uang_transport;
    // End of variables declaration//GEN-END:variables
}
