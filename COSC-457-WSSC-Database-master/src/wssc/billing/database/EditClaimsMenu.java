/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package wssc.billing.database;

/**
 *
 * @author Dev
 */
public class EditClaimsMenu extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditClaimsScreen
     */
    public EditClaimsMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toAddClaim = new javax.swing.JToggleButton();
        toUpdateClaim = new javax.swing.JToggleButton();
        toDeleteClaim = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        toAddClaim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toAddClaim.setText("Add Claim");
        toAddClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toAddClaimActionPerformed(evt);
            }
        });

        toUpdateClaim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toUpdateClaim.setText("Update Claim");

        toDeleteClaim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toDeleteClaim.setText("Delete Claim");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Edit Claims Database");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toUpdateClaim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toAddClaim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toDeleteClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {toAddClaim, toUpdateClaim});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(toAddClaim)
                .addGap(18, 18, 18)
                .addComponent(toUpdateClaim)
                .addGap(18, 18, 18)
                .addComponent(toDeleteClaim)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toAddClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toAddClaimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toAddClaimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton toAddClaim;
    private javax.swing.JToggleButton toDeleteClaim;
    private javax.swing.JToggleButton toUpdateClaim;
    // End of variables declaration//GEN-END:variables
}