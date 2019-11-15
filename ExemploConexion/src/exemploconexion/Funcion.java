/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion;
import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Mipc
 */
public class Funcion {
    public ArrayList<Bares> consultaCliente()
    {
        ArrayList<Bares> bares = new ArrayList<Bares>();
        
        try{
            ConnectionDatabase.shared.Connecting();
            Statement st = ConnectionDatabase.shared.getConnection().createStatement();
            String sql = "SELECT * FROM Producto";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next())
            {
                Bares bar = new Bares();

                bar.id_bar = result.getInt("codB");
                bar.nombre = result.getString("nombre");
                bar.cif = result.getString("cif");
                bar.localidad = result.getString("localidad");

                bares.add(bar);
            }
            result.close();
            st.close();
            ConnectionDatabase.shared.Disconnect();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return bares;
    }
    
    public int insertaCliente(Bares nuevoCliente)
    {
        int resp= -1;
        
        try{
            ConnectionDatabase.shared.Connecting();
            String dml = "INSERT INTO bares(codB,"
                    + " nombre, cif,localidad)"
                    + " values(?,?,?,?)";
            
            PreparedStatement st = ConnectionDatabase.shared.getConnection().prepareStatement(dml);
            
            st.setInt(1, nuevoCliente.id_bar) ;
            st.setString(2, nuevoCliente.nombre);
             
            st.setString(3, nuevoCliente.cif);
            st.setString(4, nuevoCliente.localidad);

            resp = st.executeUpdate();
         
            st.close();
            ConnectionDatabase.shared.Disconnect();  
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error; ", JOptionPane.ERROR_MESSAGE);
        }
        return (resp);
    }
}
