using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto_de_admin_de_bases
{
    public partial class NuevoEmpleado : Form
    {
        DataGridView tabladt;
        public NuevoEmpleado(DataGridView data )
        {
            InitializeComponent();
            tabladt = data;
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(!numeroTelefonoValido())
                MessageBox.Show("Error", "Formato del número de telefono incorrecto" + Tables.Producto, MessageBoxButtons.OK, MessageBoxIcon.Error, MessageBoxDefaultButton.Button1);
            if (validateFields())
            {
                object[] values = new object[] { txtNombre.Text, txtApellido1.Text, txtApellido2.Text, txtDireccion.Text,
                    txtTelefono.Text, txtPuestoTrabajo.Text, txtNSS.Text};
                if (Conection.instance.insert(Tables.Empleado, values.ToList()))
                {
                    Refresh();
                    MessageBox.Show("Insercion", "Insercion Exsitosa en la tabla " + Tables.Empleado, MessageBoxButtons.OK);
                }
            }
        }
        private bool validateFields()
        {
            return (txtNombre.Text != "" && txtApellido1.Text != "" && txtApellido2.Text != ""
                && txtDireccion.Text != ""  && txtPuestoTrabajo.Text != "" && txtNSS.Text != "" && numeroTelefonoValido());
        }
        private void RefreshTable(Tables table)
        {
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, table))
                    {
                        tabladt.Rows.Clear();
                        while (dataReader.Read())
                        {
                            List<string> row = new List<string>();
                            for (int i = 0; i < dataReader.FieldCount; i++)
                            {
                                row.Add(dataReader.GetValue(i).ToString());
                            }
                            tabladt.Rows.Add(row.ToArray());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
        }
        private bool numeroTelefonoValido()
        {
            if (txtTelefono.Text.Length <= 12 && txtTelefono.Text.Length >= 10)
            {
                var numeros = txtTelefono.Text.Split('-');
                foreach(var num in numeros)
                {
                    int value;
                    if (!int.TryParse(num, out value)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
