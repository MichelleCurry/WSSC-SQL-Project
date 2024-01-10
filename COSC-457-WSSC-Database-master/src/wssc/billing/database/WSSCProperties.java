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
public class WSSCProperties extends javax.swing.JFrame {

    /**
     * Creates new form wsscProperties
     */
    public WSSCProperties() {
        initComponents();
    }
    
    public ArrayList<Property> propertyList(){
        
        ArrayList<Property> propertyList = new ArrayList<>();
        
        try{
            DBMSConnection con = new DBMSConnection();
            Statement stmt = con.getConnection().createStatement();
            
            String query = get_query();
            
            Property property;
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                property = new Property(rs.getString("ADDRESS"), rs.getString("PROPERTY_TYPE"), rs.getInt("WATER_METER_READING")
                        , rs.getInt("UTILITY_EMP_ID"), rs.getInt("OWNER_ID"));
                propertyList.add(property);
            }
            
        }
        catch(SQLException e){
            System.err.println(e);
        }
        
        return propertyList;
    }
    
    public void showProperties(){
        ArrayList<Property> propertyList = propertyList();
        
        DefaultTableModel model = (DefaultTableModel) propertyTable.getModel();        
        model.setRowCount(0);
        Object[] row = new Object[5];
        
        for(int i = 0; i < propertyList.size(); i++){
            row[0] = propertyList.get(i).get_address();
            row[1] = propertyList.get(i).get_account_id();
            row[2] = propertyList.get(i).get_utility_worker_id();
            row[3] = propertyList.get(i).get_water_meter();
            row[4] = propertyList.get(i).get_property_type();
                    
            model.addRow(row);
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        for(int i = 0; i < 5; i++){
            propertyTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public String get_query(){
        String query = "";
        String hasPermit = "AND ADDRESS in "
            + "(SELECT ADDRESS_ISSUED from dsoe1db.WSSC_PERMITS)";
        String hasNoPermit = "AND NOT EXISTS (SELECT * FROM dsoe1db.WSSC_PERMITS WHERE ADDRESS_ISSUED = ADDRESS)";
            
        if(govtOption.isSelected()){
            if(hasPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Government' " + hasPermit;
            }
            else if(hasNoPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Government' " + hasNoPermit;
            }
            else if(anyOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Government'";
            }         
            else{
                JOptionPane.showMessageDialog(null, "Please select a filter.");
                return null;
            }
        }
        else if(residentialOption.isSelected()){
            if(hasPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Residential' " + hasPermit;
            }
            else if(hasNoPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Residential' " + hasNoPermit;
            }
            else if(anyOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Residential'";
            }
            else{
                JOptionPane.showMessageDialog(null, "Please select a filter.");
                return null;
            }
        }    
        else if(commercialOption.isSelected()){
            if(hasPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Commercial' " + hasPermit;
            }
            else if(hasNoPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Commercial' " + hasNoPermit;
            }
            else if(anyOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE PROPERTY_TYPE = 'Commercial'";
            }        
            else{
                JOptionPane.showMessageDialog(null, "Please select a filter.");
                return null;
            }
        }
        else if(allOption.isSelected()){
            if(hasPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE ADDRESS IN "
                        + "(SELECT ADDRESS_ISSUED FROM dsoe1db.WSSC_PERMITS)";
            }
            else if(hasNoPermitOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY WHERE NOT EXISTS "
                        + "(SELECT * FROM dsoe1db.WSSC_PERMITS WHERE ADDRESS_ISSUED = ADDRESS)";
            }
            else if(anyOption.isSelected()){
                query = "SELECT * FROM dsoe1db.WSSC_CUST_PROPERTY";
            }  
            else{
                JOptionPane.showMessageDialog(null, "Please select a filter.");
                return null;
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a type.");
            return null;
        }
        
        return query;
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
        jPanel1 = new javax.swing.JPanel();
        govtOption = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        commercialOption = new javax.swing.JRadioButton();
        allOption = new javax.swing.JRadioButton();
        executeSearch = new javax.swing.JButton();
        toMainMenu = new javax.swing.JButton();
        propTypeLabel = new javax.swing.JLabel();
        hasPermitOption = new javax.swing.JRadioButton();
        residentialOption = new javax.swing.JRadioButton();
        anyOption = new javax.swing.JRadioButton();
        hasNoPermitOption = new javax.swing.JRadioButton();
        mainMenuLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WSSCProperties");

        jPanel2.setBackground(new java.awt.Color(163, 223, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(govtOption);
        govtOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        govtOption.setText("Government");
        govtOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                govtOptionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Filter:");

        buttonGroup1.add(commercialOption);
        commercialOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        commercialOption.setText("Commercial");
        commercialOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commercialOptionActionPerformed(evt);
            }
        });

        buttonGroup1.add(allOption);
        allOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allOption.setText("All");
        allOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allOptionActionPerformed(evt);
            }
        });

        executeSearch.setText("Search");
        executeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeSearchActionPerformed(evt);
            }
        });

        toMainMenu.setText("Back");
        toMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMainMenuActionPerformed(evt);
            }
        });

        propTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        propTypeLabel.setText("Type:");

        buttonGroup2.add(hasPermitOption);
        hasPermitOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hasPermitOption.setText("Has Permit");

        buttonGroup1.add(residentialOption);
        residentialOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        residentialOption.setText("Residential");
        residentialOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialOptionActionPerformed(evt);
            }
        });

        buttonGroup2.add(anyOption);
        anyOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        anyOption.setText("Any");
        anyOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyOptionActionPerformed(evt);
            }
        });

        buttonGroup2.add(hasNoPermitOption);
        hasNoPermitOption.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hasNoPermitOption.setText("Has No Permit");
        hasNoPermitOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasNoPermitOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(executeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(propTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residentialOption, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commercialOption, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hasPermitOption, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(govtOption)
                            .addComponent(allOption, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(anyOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hasNoPermitOption, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(govtOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(residentialOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commercialOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allOption)
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hasPermitOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hasNoPermitOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anyOption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(executeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(toMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainMenuLabel.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        mainMenuLabel.setText("PROPERTIES");

        propertyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Address", "Owner Account ID", "Utility Worker ID", "Water Meter Reading", "Property Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
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
        propertyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(propertyTable);
        if (propertyTable.getColumnModel().getColumnCount() > 0) {
            propertyTable.getColumnModel().getColumn(0).setResizable(false);
            propertyTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            propertyTable.getColumnModel().getColumn(1).setResizable(false);
            propertyTable.getColumnModel().getColumn(2).setResizable(false);
            propertyTable.getColumnModel().getColumn(3).setResizable(false);
            propertyTable.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenuLabel)
                .addGap(409, 409, 409))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(mainMenuLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
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

    private void residentialOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialOptionActionPerformed

    private void govtOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_govtOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_govtOptionActionPerformed

    private void commercialOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commercialOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commercialOptionActionPerformed

    private void allOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allOptionActionPerformed

    private void toMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMainMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        MainMenuFrame main_menu = new MainMenuFrame();
        main_menu.show();
    }//GEN-LAST:event_toMainMenuActionPerformed

    private void anyOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anyOptionActionPerformed

    private void hasNoPermitOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasNoPermitOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hasNoPermitOptionActionPerformed

    private void executeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeSearchActionPerformed
        // TODO add your handling code here:
        showProperties();
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
            java.util.logging.Logger.getLogger(WSSCProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WSSCProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WSSCProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WSSCProperties.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WSSCProperties().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allOption;
    private javax.swing.JRadioButton anyOption;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton commercialOption;
    private javax.swing.JButton executeSearch;
    private javax.swing.JRadioButton govtOption;
    private javax.swing.JRadioButton hasNoPermitOption;
    private javax.swing.JRadioButton hasPermitOption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainMenuLabel;
    private javax.swing.JLabel propTypeLabel;
    private javax.swing.JTable propertyTable;
    private javax.swing.JRadioButton residentialOption;
    private javax.swing.JButton toMainMenu;
    // End of variables declaration//GEN-END:variables
}
