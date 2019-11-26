/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Client;
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
                + "direccion, telefono, puestoTrabajo, NSS, sueldobase FROM Empleado";
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
            employee.setPhone(result.getString("telefono"));
            employee.setAddress(result.getString("direccion"));
            employee.setNSS(result.getString("NSS"));
            employee.setSalary(result.getString("sueldobase"));
            
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
       Object[][] objects = new Object[employees.size()][8];
       for(int i = 0; i < employees.size(); i++){
           Employee e = (Employee) employees.get(i);
           objects[i][0] = e.getName();
           objects[i][1] = e.getLastname();
           objects[i][2] = e.getAddress();
           objects[i][3] = e.getPhone();
           objects[i][4] = e.getWorkstation();
           objects[i][5] = e.getNSS();
           objects[i][6] = e.getSalary();
       }
       return objects;
   }
   
   public void EliminaEmpleado(long idEmpleado) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from empleado where idEmpleado=%s", idEmpleado);
        //String stringQuery = "SELECT *  FROM empleado"; 
        st.executeQuery(stringQuery);
       
        st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   public void InsertEmployee(String name, String lastname1, String lastname2, String address, String phone, String work, String nss, float salary) throws Exception{
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("insert into empleado (nombre, apellido1, apellido2, direccion, telefono,  puestotrabajo , nss, sueldobase ) "
               + "values ('%s', '%s', '%s', '%s', %s, '%s', '%s', %f)", name, lastname1, lastname2, address, phone, work, nss, salary);
       st.executeUpdate(stringQuery);
       st.close();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Employee> empleados = this.getEmployee();
        
        ClavePrimaria= empleados.get(numRow).getId();
        
        return ClavePrimaria;
   }
   
    public void ActualizaEmpleado(long pk, String name, String lastname1, String lastname2, String address, int phone, String work, String nss, float salary) throws Exception{
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("update empleado "
               + "set nombre = '%s', "
               + "apellido1 = '%s', "
               + "apellido2 = '%s', "
               + "direccion = '%s', "
               + "telefono = '%s',  "
               + "puestotrabajo = '%s' , "
               + "nss = '%s',"
               + "sueldobase = %f"
               + "where idEmpleado=%d", name, lastname1, lastname2, address, phone, work, nss,salary,pk);
       st.executeUpdate(stringQuery);
       st.close();
   }
}
