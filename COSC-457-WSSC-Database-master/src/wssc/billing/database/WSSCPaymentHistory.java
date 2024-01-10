/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wssc.billing.database;

import wssc.objects.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Dev
 */
public class WSSCPaymentHistory extends javax.swing.JFrame {

    /**
     * Creates new form wsscPaymentHistory
     */
    public WSSCPaymentHistory() {
        initComponents();
    }
    
    public ArrayList<Transaction> paymentHistory(){
        ArrayList<Transaction> paymentHistory = new ArrayList<>();
        
        try{
            DBMSConnection con = new DBMSConnection();
            Statement stmt = con.getConnection().createStatement();
            
            String query = "";
            
            if(accountNumOption.isSelected()){
               String custom_account_num = accountNumField.getText();
               query = "select * from dsoe1db.WSSC_ACCT_PAYMENT_HIST where ACCOUNT_ID = " + custom_account_num;       
            }
            else if(allOption.isSelected()){
                query = "select * from dsoe1db.WSSC_ACCT_PAYMENT_HIST";
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select a search parameter!");
            }
            
            ResultSet rs = stmt.executeQuery(query);
            Transaction transaction;
            
            while(rs.next()){
                transaction = new Transaction(rs.getInt("ACCOUNT_ID"), rs.getInt("BILL_NO"), rs.getInt("ACCOUNT_ID")
                        , rs.getDouble("AMOUNT_PAID"), rs.getString("DATE_PAID"));
                
                paymentHistory.add(transaction);
            }                                        
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        return paymentHistory;
    }
    
    public void showPaymentHistory(){
        ArrayList<Transaction> paymentHistory = paymentHistory();
        DefaultTableModel model = (DefaultTableModel) transactionsTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        
        for(int i = 0; i < paymentHistory.size(); i++){
            row[0] = paymentHistory.get(i).get_transaction_id();
            row[1] = paymentHistory.get(i).get_bill_no();
            row[2] = paymentHistory.get(i).get_account_id();
            row[3] = paymentHistory.get(i).get_amount_paid();
            row[4] = paymentHistory.get(i).get_date_paid();
            
            model.addRow(row);
        }
                
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        for(int i = 0; i < 5; i++){
            transactionsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        if(paymentHistory.isEmpty()){
            JOptionPane.showMessageDialog(null, "No entries found!");
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        allOption = new javax.swing.JRadioButton();
        accountNumField = new javax.swing.JTextField();
        toMainMenu = new javax.swing.JButton();
        accountNumOption = new javax.swing.JRadioButton();
        executeSearch = new javax.swing.JButton();
        mainMenuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PAYMENT HISTORY");

        jPanel2.setBackground(new java.awt.Color(163, 223, 255));

        transactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Bill Number", "Account ID", "Amount Paid", "Date Posted"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(transactionsTable);
        if (transactionsTable.getColumnModel().getColumnCount() > 0) {
            transactionsTable.getColumnModel().getColumn(0).setResizable(false);
            transactionsTable.getColumnModel().getColumn(1).setResizable(false);
            transactionsTable.getColumnModel().getColumn(2).setResizable(false);
            transactionsTable.getColumnModel().getColumn(3).setResizable(false);
            transactionsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Search By:");

        buttonGroup1.add(allOption);
        allOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        allOption.setText("All");
        allOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOptionActionPerformed(evt);
            }
        });

        accountNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumFieldActionPerformed(evt);
            }
        });

        toMainMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        toMainMenu.setText("Back");
        toMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMainMenuActionPerformed(evt);
            }
        });

        buttonGroup1.add(accountNumOption);
        accountNumOption.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accountNumOption.setText("Account Number:");
        accountNumOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountNumOptionActionPerformed(evt);
            }
        });

        executeSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        executeSearch.setText("Search");
        executeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeSearchActionPerformed(evt);
            }
        });

        mainMenuLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        mainMenuLabel.setForeground(new java.awt.Color(102, 204, 255));
        mainMenuLabel.setText("Payment History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(mainMenuLabel))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(accountNumOption)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allOption)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(executeSearch)
                        .addGap(37, 37, 37)
                        .addComponent(toMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainMenuLabel)
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNumOption)
                    .addComponent(accountNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allOption)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toMainMenu)
                    .addComponent(executeSearch))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountNumOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNumOptionActionPerformed

    private void accountNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountNumFieldActionPerformed

    private void toMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMainMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        MainMenuFrame main_menu = new MainMenuFrame();
        main_menu.show();
    }//GEN-LAST:event_toMainMenuActionPerformed

    private void allOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allOptionActionPerformed

    private void executeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeSearchActionPerformed
        // TODO add your handling code here:
        showPaymentHistory();
    }//GEN-LAST:event_executeSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WSSCPaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WSSCPaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WSSCPaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WSSCPaymentHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WSSCPaymentHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumField;
    private javax.swing.JRadioButton accountNumOption;
    private javax.swing.JRadioButton allOption;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton executeSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainMenuLabel;
    private javax.swing.JButton toMainMenu;
    private javax.swing.JTable transactionsTable;
    // End of variables declaration//GEN-END:variables
}
