/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Client;
import exemploconexion.models.Employee;
import exemploconexion.models.Nomina;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CROSVER
 */
public class NominaService {
    
    public ArrayList<Nomina> getClient() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT * from nomina";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Nomina> nominas = new ArrayList<>();
        while(result.next())
        {
            Nomina row = new Nomina();
            
            row.setIdEmpleado(result.getInt("idEmpleado"));
            row.setMes(result.getInt("mes"));
            row.setAño(result.getInt("año"));
            //row.setSueldoBase(result.getString("sueldobase"));
            row.setHorasExtra(result.getInt("horasextra"));
            row.setSueldoBruto(result.getString("sueldoBruto"));
            
            nominas.add(row);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return nominas;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList<Nomina> clients = getClient();
       Object[][] objects = new Object[clients.size()][6];
       for(int i = 0; i < clients.size(); i++){
           Nomina c = clients.get(i);
           objects[i][0] = c.getIdEmpleado();
           objects[i][1] = c.getMes();
           objects[i][2] = c.getAño();
           objects[i][3] = c.getHorasExtra();
           objects[i][4] = c.getSueldoBruto();
       }
       return objects;
   }
   //TODO: Esta metodo elimina todas las tuplas de la nomina de un empleado 
   // cambiar nombre o arreglar este metodo 
   public void EliminaNomina(long idEmpleado) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from nomina where idEmpleado=%s", idEmpleado);
        //String stringQuery = "SELECT *  FROM empleado"; 
        st.executeQuery(stringQuery);
       
        st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   public void generateNomina(int month, int year) throws Exception{
       EmployeeService service = new EmployeeService();
       ArrayList<Employee> employees = service.getEmployee();
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       for (int i = 0 ; i < employees.size(); i++){
            String stringQuery = String.format("insert into nomina (idEmpleado, mes, año,  horasextra, sueldobruto ) "
                    + "values (%d, %d, %d, %d, %f)", employees.get(i).getId(), month, year, 0, employees.get(i).getSalary());
            st.executeUpdate(stringQuery);
       }
       st.close();
       ConnectionDatabase.shared.Disconnect();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Nomina> clientes = this.getClient();
        
        ClavePrimaria= clientes.get(numRow).getIdEmpleado();
        
        return ClavePrimaria;
   }
    
}
