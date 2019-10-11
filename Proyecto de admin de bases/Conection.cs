using System;
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

    }
}
