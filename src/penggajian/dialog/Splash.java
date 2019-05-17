/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penggajian.dialog;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import penggajian.entity.User;

/**
 *
 * @author dickyadriansyah
 */
public class Splash extends javax.swing.JDialog implements PropertyChangeListener{

    private Task task;
    EntityManager em;
    Login l;
    public Splash(EntityManager em) {
        this.em=em;
        initComponents();
        setLocationRelativeTo(null);
    }

    public JProgressBar getProgressBar() {
        return ProgressBar;
    }
    class Task extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            setProgress(0);
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException ignore) {
            }
            while (progress < 100) {
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException ignore) {
                }
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
        @Override
        public void done() {
            taskOutput.setText("");
            lbl_load.setForeground(Color.RED);
            lbl_load.setText("Selesai..!\n");
            dispose();
            User login = l.login();
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradienColor1 = new penggajian.custom.PanelGradienColor();
        jLabel1 = new javax.swing.JLabel();
        lbl_load = new javax.swing.JLabel();
        taskOutput = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAYROLL MANAGEMENT SYSTEM");

        lbl_load.setForeground(new java.awt.Color(247, 239, 238));
        lbl_load.setText("Loading.....");

        taskOutput.setForeground(new java.awt.Color(247, 239, 238));
        taskOutput.setText("0%");

        javax.swing.GroupLayout panelGradienColor1Layout = new javax.swing.GroupLayout(panelGradienColor1);
        panelGradienColor1.setLayout(panelGradienColor1Layout);
        panelGradienColor1Layout.setHorizontalGroup(
            panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienColor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addGroup(panelGradienColor1Layout.createSequentialGroup()
                        .addComponent(lbl_load, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taskOutput)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGradienColor1Layout.setVerticalGroup(
            panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradienColor1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(panelGradienColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_load)
                    .addComponent(taskOutput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(panelGradienColor1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ProgressBar.setIndeterminate(true);
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
        
        l=new Login();
        l.setEm(em);
    }//GEN-LAST:event_formWindowOpened

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_load;
    private penggajian.custom.PanelGradienColor panelGradienColor1;
    private javax.swing.JLabel taskOutput;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            ProgressBar.setIndeterminate(false);
            ProgressBar.setValue(progress);
            taskOutput.setText(String.format(
                    "%d%%  Read Data\n", progress));
        }
    }
}
