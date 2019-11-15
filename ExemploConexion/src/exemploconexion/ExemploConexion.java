/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion;

import exemploconexion.services.EmployeeService;
import exemploconexion.models.Employee;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mipc
 */
public class ExemploConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //ConnectionDatabase.shared.Connecting();
            EmployeeService service = new EmployeeService();
            ArrayList<Employee> employees = service.getEmployee();
            for(Employee e : employees){
                System.out.println("\n" + e.getName());
            }
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                                            "Error: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
