﻿using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_de_admin_de_bases
{
    class Conection
    {
        public static  Conection instance = new Conection();
        SqlConnection connection;
        private Conection(){
        }

        public bool connectionOpen()
        {
            string connectionString;
            try
            {
                connectionString = "Server=DESKTOP-CGHOG2P; Database=Tienda; Trusted_Connection=true";
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
            String sql = type + " * FROM " + table;
            var command = new SqlCommand(sql, connection);
            return command.ExecuteReader();
        }

        public bool insert(Tables table, List<object> values)
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
                default:
                    Console.WriteLine("En esta tabla no esta implementado el insert");
                    break;
            }
            Console.WriteLine("Row afectadas" + rows);
            return (rows > 0);
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
            String sql = "INSERT INTO " + Tables.Cliente + " (nombre, apellido1, apellido2, direccion, telefono)"
                + " VALUES (@nombre, @apellido1, @apellido2, @direccion, @telefono)";

            var command = new SqlCommand(sql, connection);
            command.Parameters.AddWithValue("@nombre", values[0]);
            command.Parameters.AddWithValue("@apellido1", values[1]);
            command.Parameters.AddWithValue("@apellido2", values[2]);
            command.Parameters.AddWithValue("@direccion", values[3]);
            command.Parameters.AddWithValue("@telefono", values[4]);

            return command;
        }
    }
}
