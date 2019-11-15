/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Employee;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maggiemendez
 */
public class EmployeeService {
   // public List<Employee> employees
   
   public ArrayList<Employee> getEmployee() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT idEmpleado, nombre, concat(apellido1 ,' ',apellido2) \"lastname\", "
                + "direccion, telefono, puestoTrabajo, NSS FROM Empleado";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Employee> employees = new ArrayList<>();
        while(result.next())
        {
            Employee employee = new Employee();
            
            employee.setId(result.getInt("idEmpleado"));
            employee.setName(result.getString("nombre"));
            employee.setLastname(result.getString("lastname"));
            employee.setWorkstation(result.getString("puestoTrabajo"));
            employee.setPhone(result.getInt("telefono"));
            employee.setAddress(result.getString("direccion"));
            employee.setNSS(result.getString("NSS"));
            
            employees.add(employee);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return employees;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList employees = getEmployee();
       Object[][] objects = new Object[employees.size()][6];
       for(int i = 0; i < employees.size(); i++){
           Employee e = (Employee) employees.get(i);
           objects[i][0] = e.getName();
           objects[i][1] = e.getLastname();
           objects[i][2] = e.getAddress();
           objects[i][3] = e.getPhone();
           objects[i][4] = e.getWorkstation();
           objects[i][5] = e.getNSS();
       }
       return objects;
   }
}
