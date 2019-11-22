/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion;

import exemploconexion.services.ClientService;
import exemploconexion.services.EmployeeService;
import exemploconexion.services.NominaService;
import exemploconexion.services.OrderService;
import exemploconexion.services.PayrollService;
import exemploconexion.services.ProductService;
import exemploconexion.services.VehicleService;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maggiemendez
 */
public class ScreenOne extends javax.swing.JFrame {

    private final EmployeeService serviceEmployee = new EmployeeService();
    private final ClientService serviceClient = new ClientService();
    private final ProductService serviceProduct = new ProductService();
    private final VehicleService serviceVehicle = new VehicleService();
    private final OrderService serviceOrder = new OrderService();
    private final NominaService serviceNomina = new NominaService();
    /**
     * Creates new form ScreenOne
     */
    public ScreenOne() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        ProductosTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        ProductosTab.setBackground(new java.awt.Color(204, 204, 204));
        ProductosTab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        ProductosTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductosTabMouseClicked(evt);
            }
        });

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            getClients(),
            new String [] {
                "Name", "Lastname", "Address", "Phone"
            }
        ));
        jScrollPane2.setViewportView(clientTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        ProductosTab.addTab("Clientes", jPanel1);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            getEmployees(),new String [] {
                "Name", "Lastname", "Address", "Phone", "Workstation", "NSS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);
        employeeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        ProductosTab.addTab("Empleados", jScrollPane1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            getProducts(),
            new String [] {
                "Name", "Price", "Brand", "Excistences"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        ProductosTab.addTab("Productos", jScrollPane3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            getOrders(),
            new String [] {
                "Client Send", "Client Receives", "State", "Date Order",  "Date Received", "Driver","Vehicle", "Brand","License plates","Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        ProductosTab.addTab("Pedidos", jScrollPane5);

        jTable4.setModel(new DefaultTableModel(
            getNomina(),
            new String [] {
                "idEmpleado", "mes", "Año",  "Horas Extra", "Suledo Bruto"
            }));
            jScrollPane6.setViewportView(jTable4);

            ProductosTab.addTab("Nomina", jScrollPane6);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                getVehicles(),
                new String [] {
                    "noUnidad", "Placas", "Peso Soportado", "Marca"
                }
            ));
            jScrollPane4.setViewportView(jTable1);

            ProductosTab.addTab("Vehiculos", jScrollPane4);

            jDesktopPane1.setLayer(ProductosTab, javax.swing.JLayeredPane.DEFAULT_LAYER);

            javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
            jDesktopPane1.setLayout(jDesktopPane1Layout);
            jDesktopPane1Layout.setHorizontalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ProductosTab)
            );
            jDesktopPane1Layout.setVerticalGroup(
                jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ProductosTab, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            );

            jMenu1.setText("File");
            jMenuBar1.add(jMenu1);

            jMenu2.setText("Edit");

            jMenuItem1.setText("Eliminar");
            jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenuItem1MouseClicked(evt);
                }
            });
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
            jMenu2.add(jMenuItem1);

            jMenuBar1.add(jMenu2);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jDesktopPane1))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON3){
            //TODO: implement popup
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void ProductosTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductosTabMouseClicked
        
        
        
        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            getClients(),
            new String [] {
                "Name", "Lastname", "Address", "Phone"
            }
        ));
    }//GEN-LAST:event_ProductosTabMouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int i = ProductosTab.getSelectedIndex();
        switch(i){
            case 0:
                int numrowC=clientTable.getSelectedRow();
                
                try{
                   long pk = serviceClient.regresaClavePrimaria(numrowC);
                   serviceClient.EliminaCliente(pk);
                }
                catch(Exception e){
                   clientTable.setVisible(false);
                   DefaultTableModel modelCliente = new DefaultTableModel(  getClients(),
                        new String [] {
                            "Name", "Lastname", "Address", "Phone"
                        });
                   clientTable.setModel(modelCliente);
                   modelCliente.fireTableDataChanged();
                   clientTable.setVisible(true);
                }
                break;
            case 1:
                int numrowEm=employeeTable.getSelectedRow();
                
                try{
                   long pk = serviceEmployee.regresaClavePrimaria(numrowEm);
                   serviceEmployee.EliminaEmpleado(pk);
                }
                catch(Exception e){
                   employeeTable.setVisible(false);
                   DefaultTableModel modelEmpleado = new DefaultTableModel( getEmployees(),new String [] {
                    "Name", "Lastname", "Address", "Phone", "Workstation", "NSS"
                     });
                   employeeTable.setModel(modelEmpleado);
                   modelEmpleado.fireTableDataChanged();
                   employeeTable.setVisible(true);
                }
                break;
            case 2:
                int numrowP=jTable3.getSelectedRow();
                
                try{
                   long pk = serviceProduct.regresaClavePrimaria(numrowP);
                   serviceProduct.EliminaProducto(pk);
                   
                   
                }
                catch(Exception e){
                   jTable3.setVisible(false);
                   DefaultTableModel modelProducto = new DefaultTableModel( getProducts(),
                        new String [] {
                            "Name", "Price", "Brand", "Excistences"
                        });
                   jTable3.setModel(modelProducto);
                   modelProducto.fireTableDataChanged();
                   jTable3.setVisible(true);
                }
                break;
            case 3:
                int numrowPedido=jTable2.getSelectedRow();
                
                try{
                   long pk = serviceOrder.regresaClavePrimaria(numrowPedido);
                   serviceOrder.EliminaOrder(pk);
                }
                catch(Exception e){
                   jTable2.setVisible(false);
                   DefaultTableModel modelProducto = new DefaultTableModel( getOrders(),
                    new String [] {
                        "Client Send", "Client Receives", "State", "Date Order",  "Date Received", "Driver","Vehicle", "Brand","License plates","Total"
                    });
                   jTable2.setModel(modelProducto);
                   modelProducto.fireTableDataChanged();
                   jTable2.setVisible(true);
                }
                break;
            case 4:
                int numrowNomina=jTable4.getSelectedRow();
                
                try{
                   long pk = serviceNomina.regresaClavePrimaria(numrowNomina);
                   serviceNomina.EliminaNomina(pk);
                }
                catch(Exception e){
                   jTable4.setVisible(false);
                   DefaultTableModel modelNomina = new DefaultTableModel(  getNomina(),
                    new String [] {
                        "idEmpleado", "mes", "Año", "Sueldo Base", "Horas Extra", "Suledo Bruto"
                    });
                   jTable4.setModel(modelNomina);
                   modelNomina.fireTableDataChanged();
                   jTable4.setVisible(true);
                }
                break;
            case 5:
                int numrowVehiculo=jTable1.getSelectedRow();
                
                try{
                   long pk = serviceVehicle.regresaClavePrimaria(numrowVehiculo);
                   serviceVehicle.EliminaVehiculo(pk);
                }
                catch(Exception e){
                   jTable1.setVisible(false);
                   DefaultTableModel modelVehiculos = new DefaultTableModel(getVehicles(),
                    new String [] {
                        "noUnidad", "Placas", "Peso Soportado", "Marca"
                    });
                   jTable1.setModel(modelVehiculos);
                   modelVehiculos.fireTableDataChanged();
                   jTable1.setVisible(true);
                }
                break;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, jTable2.rowAtPoint(evt.getPoint()), "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(ScreenOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenOne.class.getName()).log(java.util.logging.Level.ALL, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ProductosTab;
    private javax.swing.JTable clientTable;
    private javax.swing.JTable employeeTable;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables

    private Object[][] getEmployees() {
        try{
            return serviceEmployee.getObjects();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    private Object[][] getNomina() {
        try{
            return serviceNomina.getObjects();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private Object[][] getClients(){
        try{
            return serviceClient.getObjects();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private Object[][] getProducts(){
        try{
            return serviceProduct.getObjects();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private Object[][] getVehicles(){
        try{
            return serviceVehicle.getObjects();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private Object[][] getOrders(){
        try{
            return serviceOrder.getObjects();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    private Object[][] getPayroll(){
        try {
            PayrollService servicePayroll = new PayrollService();
            return servicePayroll.getObjects();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
