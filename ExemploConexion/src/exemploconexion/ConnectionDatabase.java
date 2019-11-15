/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Mipc
 */
public class ConnectionDatabase {
    private String server = "jdbc:postgresql://";
    private String dominio = "localhost:5432/";

    private String dataBase = "tienda";
    private String user = "maggiemendez";
    private String password = "M";
    private String connectionString = server + dominio + dataBase;
    private Connection connection;

    public static ConnectionDatabase shared = new ConnectionDatabase();

    private ConnectionDatabase()
    {
    }
    
    public Connection getConnection()
    {
        return(this.connection);
    }
    
    public void Connecting() throws Exception
    {
        
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(connectionString,
                user, password);
        //System.out.println("Conectado");
        
        
    }
    public void Disconnect() throws SQLException
    {
        connection.close();
        //System.out.println("Desconectado");
        
    }
}
