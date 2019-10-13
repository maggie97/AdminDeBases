using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto_de_admin_de_bases
{
    public partial class NuevoCliente : Form
    {
        public NuevoCliente()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(!numeroTelefonoValido())
                MessageBox.Show("Error", "Formato del número de telefono incorrecto" + Tables.Producto, MessageBoxButtons.OK, MessageBoxIcon.Error, MessageBoxDefaultButton.Button1);
            else if (validateFields())
            {
                object[] values = new object[] { txtNombre.Text, txtApellido1.Text, txtApellido2.Text,
                    txtDireccion.Text, txtTelefono.Text};
                if (Conection.instance.insert(Tables.Cliente, values.ToList()))
                {
                    MessageBox.Show("Insercion", "Insercion Exsitosa en la tabla " + Tables.Producto, MessageBoxButtons.OK);
                }
            }
        }
        private bool validateFields()
        {
            return (txtNombre.Text != "" && txtApellido1.Text != "" && txtApellido2.Text != ""
                && txtDireccion.Text != ""  && numeroTelefonoValido());
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
