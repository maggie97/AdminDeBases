/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class DriverService {
   
   public ArrayList<Driver> getDrivers() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT * FROM Conductor";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Driver> drivers = new ArrayList<>();
        while(result.next())
        {
            Driver driver = new Driver();
            
            driver.setIdEmpleado(result.getInt("idempleado"));
            driver.setUnidadAsignada(result.getInt("unidadasignada"));
            driver.setDisponibilidad(result.getBoolean("disponibilidad"));
            
            drivers.add(driver);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return drivers;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList<Driver> clients = getDrivers();
       Object[][] objects = new Object[clients.size()][6];
       for(int i = 0; i < clients.size(); i++){
           Driver d = clients.get(i);
           objects[i][0] = d.getUnidadAsignada();
           objects[i][1] = d.getIdEmpleado();
           objects[i][2] = d.isDisponibilidad();
       }
       return objects;
   }
   
   public void EliminaDriver(long numberVehicle) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from Driver where unidadasignada=%s", numberVehicle);
        //String stringQuery = "SELECT *  FROM empleado"; 
        st.executeQuery(stringQuery);
       
        st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   
   public void InsertDriver(long vehicle, long employee, boolean disponibility) throws Exception{
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("insert into conductor (unidadasignada, idempleado, disponibilidad ) "
               + "values ('%d', '%d', '%b')", vehicle, employee, disponibility);
       st.executeUpdate(stringQuery);
       st.close();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Driver> drivers = this.getDrivers();
        
        ClavePrimaria = drivers.get(numRow).getUnidadAsignada();
        
        return ClavePrimaria;
   }
   /*
   */
   public void ActualizaConductor(int numRow,long vehicle, long employee, boolean disponibility) throws Exception{
       ConnectionDatabase.shared.Connecting();
       long pk = regresaClavePrimaria(numRow);
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("uptade conductor"
               + "set unidadasignada = %d,"
               + "idempleado=%d,"
               + "disponibilidad=%b,"
               + "where idConductor=%d", vehicle, employee, disponibility,pk);
       st.executeUpdate(stringQuery);
       st.close();
   }
}

