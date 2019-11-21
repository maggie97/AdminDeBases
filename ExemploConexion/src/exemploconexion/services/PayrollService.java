/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Payroll;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class PayrollService {
    
   public ArrayList<Payroll> getClient() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "SELECT * FROM Nomina";
        //idempleado | mes | año | sueldobase | horasextra | sueldobruto
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Payroll> payroll = new ArrayList<>();
        while(result.next())
        {
            Payroll salary = new Payroll();
            
            salary.setIdEmployee(result.getInt("idempleado"));
            salary.setMonth(result.getInt("mes"));
            salary.setYear(result.getInt("año"));
            salary.setSalary(result.getFloat("sueldobase"));
            salary.setExtraHours(result.getInt("horasextra"));
            salary.setTotalSalary(result.getFloat("sueldobruto"));
            
            payroll.add(salary);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return payroll;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList<Payroll> payroll = getClient();
       Object[][] objects = new Object[payroll.size()][6];
       for(int i = 0; i < payroll.size(); i++){
           Payroll p = payroll.get(i);
           objects[i][0] = p.getIdEmployee();
           objects[i][1] = p.getMonth();
           objects[i][2] = p.getYear();
           objects[i][3] = p.getSalary();
           objects[i][4] = p.getExtraHours();
           objects[i][5] = p.getTotalSalary();
       }
       return objects;
   }
}
