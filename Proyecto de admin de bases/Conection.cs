using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_de_admin_de_bases
{
    /// <summary>
    /// Esta clase sirve para realizar la conexion a la base de datos y realizar las consultas de la misma base
    /// de datos
    /// </summary>
    class Conection
    {
        public static  Conection instance = new Conection();
        private String maggieServer = "DESKTOP-22PJVHV";//;"DESKTOP-CGHOG2P";
        SqlConnection connection;
        /// <summary>
        /// Constructor de la clase Conection
        /// </summary>
        private Conection(){
        }

        /// <summary>
        /// Abre la conexion a la
        /// </summary>
        /// <returns></returns>
        public bool connectionOpen()
        {
            string connectionString;
            try
            {
                connectionString = "Server="+maggieServer+"; Database=Tienda; Trusted_Connection=true";
                connection = new SqlConnection(connectionString);
                connection.Open();
            }
            catch (SqlException e)
            {
                Console.WriteLine(e.ToString());
                return false;
            }
            return true;
        }

        public SqlDataReader datos(typeQuery type, Tables table)
        {
            if (connectionOpen())
            {
                String sql = type + " * FROM " + table;
                var command = new SqlCommand(sql, connection);
                return command.ExecuteReader();
            }
            return null;
        }
        public List<List<string>> datosList(typeQuery type, Tables table)
        {
            var data = datos(type, table);
            List<List<string>> list = new List<List<string>>();
            if(data != null)
            {
                while (data.Read())
                {
                    List<string> row = new List<string>();
                    for (int i = 0; i < data.FieldCount; i++)
                    {
                        row.Add(data.GetValue(i).ToString());
                    }
                    list.Add(row);
                }
                return list;
            }
            return null;
        }
        public bool insert(Tables table, List<object> values)
        {
            try
            {
                int rows = 0;
                switch (table)
                {
                    case Tables.Pedido:
                        rows = insertPedido(values).ExecuteNonQuery();
                        break;
                    case Tables.Producto:
                        rows = insertProducto(values).ExecuteNonQuery();
                        break;
                    case Tables.Cliente:
                        rows = insertaCliente(values).ExecuteNonQuery();
                        break;
                    case Tables.Empleado:
                        rows = insertaEmpleado(values).ExecuteNonQuery();
                        break;
                    case Tables.DetallePedido:
                        rows = insertaDetallesPedido(values).ExecuteNonQuery();
                        break;
                    case Tables.Vehiculo:
                        rows = insertaVehiculo(values).ExecuteNonQuery();
                        break;
                    default:
                        Console.WriteLine("En esta tabla no esta implementado el insert");
                        break;
                }
                Console.WriteLine("Row afectadas" + rows);
                return (rows > 0);
            }
            catch
            {
                return false;
            }
        }
        private SqlCommand insertaDetallesPedido(List<object> values)
        {
            String sql = "INSERT INTO " + Tables.DetallePedido + "(idPedido, idMaterial, cantidad, descuento, iva, subtotal)"
                + " VALUES (@idPedido, @idMaterial, @cantidad, @descuento, @iva, @subtotal)";
            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@idPedido", values[0]);
            command.Parameters.AddWithValue("@idMaterial", values[1]);
            command.Parameters.AddWithValue("@cantidad", values[2]);
            command.Parameters.AddWithValue("@descuento", values[3]);
            command.Parameters.AddWithValue("@iva", values[4]);
            command.Parameters.AddWithValue("@subtotal", values[5]);
            return command;
        }
        private SqlCommand insertPedido(List<object> values)
        {
            String sql =  "INSERT INTO " + Tables.Pedido + "(clienteEnvia, clienteRecibe, total, unidadAsignada, estado, fechaPedido, fechaEntrega, idEmpleado)"
                + " VALUES (@clienteEnvia, @clienteRecibe, @total, @unidadAsignada, @estado, @fechaPedido, @fechaEntrega, @idEmpleado)";
            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@clienteEnvia", values[0]);
            command.Parameters.AddWithValue("@clienteRecibe", values[1]);
            command.Parameters.AddWithValue("@total", values[2]);
            command.Parameters.AddWithValue("@unidadAsignada", values[3]);
            command.Parameters.AddWithValue("@estado", values[4]);
            command.Parameters.AddWithValue("@fechaPedido", values[5]);
            command.Parameters.AddWithValue("@fechaEntrega", values[6]);
            command.Parameters.AddWithValue("@idEmpleado", values[7]);
            return command;
        }


        private SqlCommand insertProducto(List<object> values)
        {
            String sql = "INSERT INTO " + Tables.Producto + " (nombre, precio, marca, Existencias)"
                + " VALUES (@nombre, @precio, @marca, @exsistencias)";
            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@nombre", values[0]);
            command.Parameters.AddWithValue("@precio", values[1]);
            command.Parameters.AddWithValue("@marca", values[2]);
            command.Parameters.AddWithValue("@exsistencias", values[3]);
            return command;
        }

        private SqlCommand insertaEmpleado(List<object> values)
        {
            String sql = "INSERT INTO " + Tables.Empleado + " (nombre, apellido1, apellido2, direccion, telefono, puestoTrabajo, NSS)"
                + " VALUES (@nombre, @apellido1, @apellido2, @direccion, @telefono, @puestoTrabajo, @NSS)";
            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@nombre", values[0]);
            command.Parameters.AddWithValue("@apellido1", values[1]);
            command.Parameters.AddWithValue("@apellido2", values[2]);
            command.Parameters.AddWithValue("@direccion", values[3]);
            command.Parameters.AddWithValue("@telefono", values[4]);
            command.Parameters.AddWithValue("@puestoTrabajo", values[5]);
            command.Parameters.AddWithValue("@NSS", values[6]);
            return command;
        }

        private SqlCommand insertaCliente(List<object> values)
        {
            String sql = "INSERT INTO " + Tables.Cliente + " (nombre, apellido1, apellido2, direccion, telefono, Email)"
                + " VALUES (@nombre, @apellido1, @apellido2, @direccion, @telefono,@email)";

            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@nombre", values[0]);
            command.Parameters.AddWithValue("@apellido1", values[1]);
            command.Parameters.AddWithValue("@apellido2", values[2]);
            command.Parameters.AddWithValue("@direccion", values[3]);
            command.Parameters.AddWithValue("@telefono", values[4]);
            command.Parameters.AddWithValue("@email", values[5]);
            return command;
        }


        private SqlCommand insertaVehiculo(List<object> values)
        {
            String sql = "INSERT INTO " + Tables.Vehiculo + " (placa, modelo, pesoSoportado)"
                + " VALUES (@placa, @modelo, @pesoSoportado)";

            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@placa", values[0]);
            command.Parameters.AddWithValue("@modelo", values[1]);
            command.Parameters.AddWithValue("@pesoSoportado", values[2]);
            return command;
        }

        public bool Actualiza(List<object>values, Tables tables)
        {
            int rows = 0;
            switch (tables)
            {
                case Tables.Pedido:
                    //rows = a(values).ExecuteNonQuery();
                    break;
                case Tables.Producto:
                    rows = Actualiza_Producto(values).ExecuteNonQuery();
                    break;
                case Tables.Cliente:
                    rows = Actualiza_Cliente(values).ExecuteNonQuery();
                    break;
                case Tables.Empleado:
                    //rows = insertaEmpleado(values).ExecuteNonQuery();
                    break;
                
                default:
                    Console.WriteLine("En esta tabla no esta implementado el insert");
                    break;
            }

            return (rows > 0);
        }

        private SqlCommand Actualiza_Producto(List<object> values)
        {
            string query = 
                "UPDATE Producto " +
                "SET nombre=@nombre, precio=@precio, marca=@marca, Existencias=@existencias" +
                " where idProducto=@idProducto";
            var command = new SqlCommand(query, connection);
            command.Parameters.AddWithValue("@idProducto", values[0]);
            command.Parameters.AddWithValue("@nombre", values[1]);
            command.Parameters.AddWithValue("@precio", values[2]);
            command.Parameters.AddWithValue("@marca", values[3]);
            command.Parameters.AddWithValue("@existencias", values[4]);


            return command;
        }

        private SqlCommand Actualiza_Cliente(List<object> values)
        {
            string query =
                "UPDATE Cliente " +
                "SET nombre=@nombre, apellido1=@Apellido1, apellido2=@Apellido2, direccion=@direccion, telefono=@telefono, Email=@email" +
                " where idCliente=@idCliente";
            var command = new SqlCommand(query, connection);
            command.Parameters.AddWithValue("@idCliente", values[0]);
            command.Parameters.AddWithValue("@nombre", values[1]);
            command.Parameters.AddWithValue("@Apellido1", values[2]);
            command.Parameters.AddWithValue("@Apellido2", values[3]);
            command.Parameters.AddWithValue("@direccion", values[4]);
            command.Parameters.AddWithValue("@telefono", values[5]);
            command.Parameters.AddWithValue("@email", values[6]);


            return command;
        }

        public bool Elimina(Tables table, int id)
        {
            String query =  "DELETE from " + table + " Where id" + table + " = " + id;
            if (table == Tables.Vehiculo)
                query = query.Replace("id" + table, "noUnidad");
            var command = new SqlCommand(query, connection);
            int row = 0;
            try
            {
                row = command.ExecuteNonQuery();
            }
            catch (SqlException e)
            {
                Console.WriteLine(e.ErrorCode);
            }
            
            return (row > 0);
        }
    }
}
