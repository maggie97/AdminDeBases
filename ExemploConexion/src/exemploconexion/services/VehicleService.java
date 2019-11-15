/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Vehicle;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class VehicleService {
    
   public ArrayList<Vehicle> getVehicles() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT nounidad , placa  , modelo , pesosoportado,"
                + " disponibilidad  FROM Vehiculo";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        while(result.next())
        {
            Vehicle vehicle = new Vehicle();
            
            vehicle.setId(result.getInt(1));
            vehicle.setPlaca(result.getString(2));
            vehicle.setBrand(result.getInt(3));
            vehicle.setWeight(result.getInt(4));
            vehicle.setDisponibility(result.getBoolean(5));
            
            vehicles.add(vehicle);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return vehicles;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList vehicles = getVehicles();
       Object[][] objects = new Object[vehicles.size()][6];
       for(int i = 0; i < vehicles.size(); i++){
           Vehicle v = (Vehicle) vehicles.get(i);
           objects[i][0] = v.getId();
           objects[i][1] = v.getPlaca();
           objects[i][2] = v.getWeight();
           objects[i][3] = v.getBrand();
       }
       return objects;
   }

}
