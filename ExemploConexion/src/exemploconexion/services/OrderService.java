/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Client;
import exemploconexion.models.Order;
import exemploconexion.models.Vehicle;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class OrderService {
    
    
    public ArrayList<Order> getOrders() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "select p.*, concat(c.nombre, ' ',c.apellido1, ' ', c.apellido2) \"nombreClienteRecibe\",\n" +
                        " concat(c2.nombre, ' ',c2.apellido1, ' ', c2.apellido2) \"nombreClienteEnvia\",\n" +
                        " concat(e.nombre, ' ',e.apellido1, ' ', e.apellido2) \"nombreClienteEnvia\", \n" +
                        " v.modelo, v.placa \n" +
                        " from Pedido p \n" +
                        "inner join cliente c on c.idCliente = p.clienterecibe \n" +
                        "inner join cliente c2 on  c2.idCliente = p.clienteenvia\n" +
                        "inner join empleado e on e.idEmpleado = p.idEmpleado\n" +
                        "inner join Vehiculo v on v.noUnidad = p.unidadAsignada;";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Order> orders = new ArrayList<>();
        while(result.next())
        {
            Order order = new Order();
            
            order.setId(result.getInt(1));
            order.setClientSend(result.getInt("clienteenvia"));
            order.setClientReceives(result.getInt("clienterecibe"));
            order.setTotal(result.getDouble("total"));
            order.setIdVehicle(result.getInt("unidadasignada"));
            String send = (result.getString("estado") == "S")? "Enviado": "En espera";
            order.setState(send);
            order.setDateOrder(result.getDate("fechapedido"));
            order.setIdEmployee(result.getInt("idempleado"));
            order.setNameClientSend(result.getString("nombreClienteRecibe"));
            order.setNameClientReceives(result.getString("nombreClienteEnvia"));
            order.setNameDriver(result.getString("nombreClienteEnvia"));
            order.setBrandVehicle(result.getString("modelo"));
            order.setLicensePlate(result.getString("placa"));
            
            orders.add(order);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return orders;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList orders = getOrders();
       Object[][] objects = new Object[orders.size()][10];
       for(int i = 0; i < orders.size(); i++){
           Order order = (Order) orders.get(i);
           objects[i][0] = order.getNameClientReceives();
           objects[i][1] = order.getNameClientSend();
           objects[i][2] = order.getState();
           objects[i][3] = order.getDateOrder();
           objects[i][4] = (order.getDateDelivery() == null )? "en espera" : order.getDateDelivery() ;
           objects[i][5] = order.getNameDriver();
           objects[i][6] = order.getIdVehicle();
           objects[i][7] = order.getBrandVehicle();
           objects[i][8] = order.getLicensePlate();
           objects[i][9] = order.getTotal();
       }
       return objects;
   }
   
   public void EliminaOrder(long idOrder) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from detallepedido where idpedido=%s", idOrder);
        //String stringQuery = "SELECT *  FROM empleado"; 
        st.executeQuery(stringQuery);
       
        st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   
    public void InsertOrder(long sendClient, long recibeClient, long vehicle, String dateOrder, String dateRecibeOrder, long idEmpleado) throws Exception{
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("insert into pedido ( clienteenvia , clienterecibe , unidadasignada , estado , fechapedido , fechaentrega , idempleado ) "
               + "values (%d, %d, %d, '%s', '%s','%s', %d ); ", sendClient, recibeClient, vehicle,'N', dateOrder, dateRecibeOrder, idEmpleado);
       st.executeUpdate(stringQuery);
       st.close();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Order> orders = this.getOrders();
        
        ClavePrimaria= orders.get(numRow).getId();
        
        return ClavePrimaria;
   }
}
