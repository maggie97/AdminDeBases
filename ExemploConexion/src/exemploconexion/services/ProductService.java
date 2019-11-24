/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploconexion.services;

import exemploconexion.ConnectionDatabase;
import exemploconexion.models.Product;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maggiemendez
 */
public class ProductService {
   public ArrayList<Product> getProduct() throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = "select * from producto";
        //String stringQuery = "SELECT *  FROM empleado"; 
        ResultSet result = st.executeQuery(stringQuery);
        ArrayList<Product> products = new ArrayList<>();
        while(result.next())
        {
            Product product = new Product();
            
            product.setId(result.getInt("idproducto"));
            product.setName(result.getString("nombre"));
            product.setPrice(result.getDouble("precio"));
            product.setBrand(result.getString("marca"));
            product.setExcistences(result.getInt("existencias"));
            products.add(product);
        }
        result.close();
        st.close();
        ConnectionDatabase.shared.Disconnect();
        
        return products;
   }
   
   public Object[][] getObjects() throws Exception{
       
       //ArrayList<Object[]> list = new ArrayList<>(); //= getEmployee().toArray();
       ArrayList<Product> products = getProduct();
       Object[][] objects = new Object[products.size()][6];
       for(int i = 0; i < products.size(); i++){
           Product p = products.get(i);
           objects[i][0] = p.getName();
           objects[i][1] = p.getPrice();
           objects[i][2] = p.getBrand();
           objects[i][3] = p.getExcistences();
       }
       return objects;
   }
   public void InsertProduct(String name, String brand, float price, int existencias) throws Exception{
       ConnectionDatabase.shared.Connecting();
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("insert into producto (nombre, marca,  precio, existencias ) values ('%s', '%s', %f, %d)", name, brand, price, existencias);
       st.executeUpdate(stringQuery);
       st.close();
   }
   public void EliminaProducto(long idProducto) throws Exception{
        ConnectionDatabase.shared.Connecting();
        Statement st = ConnectionDatabase.shared.getConnection().createStatement();
        String stringQuery = String.format("Delete from producto where idProducto=%s", idProducto);
        //String stringQuery = "SELECT *  FROM empleado"; 
       ResultSet result = st.executeQuery(stringQuery);
       result.close();
       st.close();
        ConnectionDatabase.shared.Disconnect();
   }
   
   public long regresaClavePrimaria(int numRow)throws Exception
   {
       long ClavePrimaria=0;
        ArrayList<Product> products = getProduct();
        
        ClavePrimaria= products.get(numRow).getId();
        
        return ClavePrimaria;
   }
   
   public void ActualizaProducto(int numRow,String name, String brand, float price, int existencias) throws Exception{
       ConnectionDatabase.shared.Connecting();
       long pk = regresaClavePrimaria(numRow);
       Statement st = ConnectionDatabase.shared.getConnection().createStatement();
       String stringQuery = String.format("update producto"
               + "set nombre='%s', "
               + "marca= '%s',  "
               + "precio=%f, "
               + "existencias=%d,"
               + "where idProducto=%d", name, brand, price, existencias,pk);
       st.executeUpdate(stringQuery);
       st.close();
   }
}
