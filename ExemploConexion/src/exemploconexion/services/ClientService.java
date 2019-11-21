/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Client;
import exemploconexion.models.Product;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class ClientService {
   
   public ArrayList<Client> getClient() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT idCliente, nombre, concat(apellido1 ,' ',apellido2) \"lastname\", "
                + "direccion, telefono FROM Cliente";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Client> clients = new ArrayList<>();
        while(result.next())
        {
            Client client = new Client();
            
            client.setId(result.getInt("idCliente"));
            client.setName(result.getString("nombre"));
            client.setLastname(result.getString("lastname"));
            client.setPhone(result.getString("telefono"));
            client.setAddress(result.getString("direccion"));
            
            clients.add(client);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return clients;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList<Client> clients = getClient();
       Object[][] objects = new Object[clients.size()][6];
       for(int i = 0; i < clients.size(); i++){
           Client c = clients.get(i);
           objects[i][0] = c.getName();
           objects[i][1] = c.getLastname();
           objects[i][2] = c.getAddress();
           objects[i][3] = c.getPhone();
       }
       return objects;
   }
   
   public void EliminaCliente(long idCliente) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from cliente where idCliente=%s", idCliente);
        //String stringQuery = "SELECT *  FROM empleado"; 
        st.executeQuery(stringQuery);
       
        st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Client> clientes = this.getClient();
        
        ClavePrimaria= clientes.get(numRow).getId();
        
        return ClavePrimaria;
   }
}

