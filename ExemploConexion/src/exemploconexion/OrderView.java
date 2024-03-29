/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion;

import exemploconexion.models.*;
import exemploconexion.services.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maggiemendez
 */
public class OrderView extends javax.swing.JFrame {

    private final EmployeeService serviceEmployee = new EmployeeService();
    private final DriverService serviceDriver = new DriverService();
    private final ClientService serviceClient = new ClientService();
    private final VehicleService serviceVehicle = new VehicleService();
    private final ProductService productService = new ProductService();
    
    OrderDetailView details;
    
    ArrayList<Object[]> employees;
    ArrayList<Client> clients;
    ArrayList<Vehicle> vehicles;
    ArrayList<Product> products;
    
    ArrayList<OrderDetail> orderProduts;
    
    long id;
    boolean update = false;
    
    JPopupMenu popup = new JPopupMenu();
    JMenuItem jMItem = new JMenuItem("Eliminar registro"); 
    /**
     * Creates new form ProductiView
     */
    public OrderView() {
        initComponents();
        fillData();
        chSend.setVisible(false);
        popup.add(jMItem);
        jMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int numrowC = jTable1.getSelectedRow();
                orderProduts.remove(numrowC);
            }
        });
        jTable1.setComponentPopupMenu(popup);
    }

    OrderView(Order order) {
        initComponents();
        id = order.getId();
        update = true;
        label1.setText("Actualiza Pedido");
        buttonAdd.setLabel("Actualiza");
        chSend.setState(("S".equals(order.getState())));
        chSend.isVisible();
        txtDate.setText(order.getDateOrder().toString());
        
        getProducts();
        fillData(order.getIdEmployee(), order.getClientSend(), order.getClientReceives(), order.getIdVehicle());
        popup.add(jMItem);
        jMItem.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                OrderService service = new OrderService();
                int numrowC = jTable1.getSelectedRow();
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.fireTableDataChanged();
                service.removeDetailOrder(orderProduts.get(numrowC).getId(), orderProduts.get(numrowC).getProduct().getId());
                orderProduts.remove(numrowC);
            } catch (Exception ex) {
                Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        jTable1.setComponentPopupMenu(popup);
        
    }
    void fillData(){
        
        try{
            employees = serviceDriver.getDriversWithName();
            clients = serviceClient.getClient();
            vehicles = serviceVehicle.getVehicles();
            products = productService.getProduct();
            
            orderProduts = new ArrayList();
           
            for(int i = 0; i < employees.size(); i++ ){
                chEmployee.add((String)employees.get(i)[2]);
            }
            
            for(int i = 0; i < clients.size(); i++ ){
                chSendClient.add(clients.get(i).getFullname());
                chRecibeClient.add(clients.get(i).getFullname());
            }
            
            for(int i = 0; i < vehicles.size(); i++ ){
                chVehicle.add(vehicles.get(i).getString());
            }
            
            for(int i = 0; i < products.size(); i++ ){
                chProduct.add(products.get(i).toString());
            }
            
        } catch (Exception e){
            
        }
    }
    
    void fillData(long idEmpleado, long idClienteEnv, long idClienteRecive, long idVehicle){
        
        int iEmpl, iEnvia, iRecibe, iVehic, iProd;
        iEmpl =  iEnvia=  iRecibe= iVehic=  iProd =0;
        try{
            employees = serviceDriver.getDriversWithName();
            clients = serviceClient.getClient();
            vehicles = serviceVehicle.getVehicles();
            products = productService.getProduct();
            
            orderProduts = new ArrayList();
            
            for(int i = 0; i < employees.size(); i++ ){
                chEmployee.add((String)employees.get(i)[2]);
                
                if((int)employees.get(i)[0] == idEmpleado)
                    iEmpl = i;
            }
            chEmployee.select(iEmpl);
            
            for(int i = 0; i < clients.size(); i++ ){
                chSendClient.add(clients.get(i).getFullname());
                chRecibeClient.add(clients.get(i).getFullname());
                
                 if(clients.get(i).getId() == idClienteEnv)
                    iEnvia = i;
                 if(clients.get(i).getId() == idClienteRecive)
                    iRecibe = i;
                
            }
            chSendClient.select(iEnvia);
            chRecibeClient.select(iRecibe);
            for(int i = 0; i < vehicles.size(); i++ ){
                chVehicle.add(vehicles.get(i).getString());
                 if(vehicles.get(i).getId() == idVehicle)
                    iVehic = i;
            }
            chVehicle.select(iVehic);
            for(int i = 0; i < products.size(); i++ ){
                chProduct.add(products.get(i).toString());
            }
        } catch (Exception e){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        buttonAdd = new java.awt.Button();
        button2 = new java.awt.Button();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        chSendClient = new java.awt.Choice();
        chRecibeClient = new java.awt.Choice();
        chVehicle = new java.awt.Choice();
        chEmployee = new java.awt.Choice();
        txtDate = new java.awt.TextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        button3 = new java.awt.Button();
        chProduct = new java.awt.Choice();
        txtCantidad = new java.awt.TextField();
        label9 = new java.awt.Label();
        chSend = new java.awt.Checkbox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("Nuevo Pedido");

        label2.setText("Cliente Envia:");

        label3.setText("Cliente Recibe:");

        label4.setText("UnidadAsignada:");

        buttonAdd.setLabel("Agregar");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        button2.setLabel("Cancelar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        label5.setText("FechaEnvio  (MM/DD/YYYY) :");

        label6.setText("Empleado:");

        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setForeground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Productos", jScrollPane1);

        label7.setText("Producto:");

        label8.setText("Cantidad:");

        button3.setActionCommand("Generar");
        button3.setLabel("Añadir Producto");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        label9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        label9.setForeground(new java.awt.Color(0, 0, 0));
        label9.setText(" Añadir Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Añadir Producto", jPanel1);

        chSend.setLabel("enviado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chSendClient, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chRecibeClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chRecibeClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chSendClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(chVehicle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        label5.getAccessibleContext().setAccessibleName("FechaEnvio :");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void update(OrderService service) throws Exception{
        service.UpdateOrder(id, chSend.getState(), clients.get(chSendClient.getSelectedIndex()).getId() , 
                        clients.get(chRecibeClient.getSelectedIndex()).getId(),
                        vehicles.get(chVehicle.getSelectedIndex()).getId(), txtDate.getText(), txtDate.getText(), 
                        (int ) employees.get(chEmployee.getSelectedIndex())[0]);
    }
    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        // TODO add your handling code here:
        if (!txtDate.getText().isEmpty() ){
            OrderService service = new OrderService();
            try {
                if (update){
                    update(service);
                }{
                    service.InsertOrder(clients.get(chSendClient.getSelectedIndex()).getId() , 
                            clients.get(chRecibeClient.getSelectedIndex()).getId(),
                            vehicles.get(chVehicle.getSelectedIndex()).getId(), txtDate.getText(), txtDate.getText(), 
                            (int)employees.get(chEmployee.getSelectedIndex())[0]);
                    addProductToOrder();
                    JOptionPane.showMessageDialog(null, "Pedido Completado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                dispose();
            } catch (Exception ex) {
                Logger.getLogger(ProductiView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void addProductToOrder(){
        if (orderProduts == null) return;
        for(int i = 0; i < orderProduts.size() ; i++){
            OrderService service = new OrderService();
            try {
                service.InsertDetailOrder(orderProduts.get(i));
            } catch (Exception ex) {
                Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void getProducts(){
        OrderService service = new OrderService();
        try {
            orderProduts =  service.getDetailOrders(id);
        } catch (Exception ex) {
            Logger.getLogger(OrderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        if (!txtCantidad.getText().isEmpty()){
            NominaService service = new NominaService();
            try {
                Product _product = products.get(chProduct.getSelectedIndex());
                int cant = Integer.parseInt( txtCantidad.getText());
                double price = cant * _product.getPrice();
                
                OrderDetail detail = new OrderDetail(_product, cant, 0, 16, _product.getPrice() * cant);
                orderProduts.add(detail);
            } catch (Exception ex) {
                Logger.getLogger(OrderDetailView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            getProductsOfOrder(),
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ));
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private Object[][] getProductsOfOrder(){
        try{
            if (update){
                getProducts();
            }
            Object[][] objects = new Object[orderProduts.size()][3];
            for(int i = 0; i < orderProduts.size(); i++){
                OrderDetail order = orderProduts.get(i);
                objects[i][0] = order.getProduct().getName();
                objects[i][1] = order.getQuantity();
                objects[i][2] = order.getPrice();
            }
            return objects;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
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
            java.util.logging.Logger.getLogger(ProductiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button buttonAdd;
    private java.awt.Choice chEmployee;
    private java.awt.Choice chProduct;
    private java.awt.Choice chRecibeClient;
    private java.awt.Checkbox chSend;
    private java.awt.Choice chSendClient;
    private java.awt.Choice chVehicle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextField txtCantidad;
    private java.awt.TextField txtDate;
    // End of variables declaration//GEN-END:variables
}
