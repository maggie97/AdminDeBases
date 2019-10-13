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
    public partial class NuevoProducto : Form
    {
        public NuevoProducto()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtNombre.Text != "")
            {
                object[] values = new object[] {txtNombre.Text, numPrecio.Value , txtNombre.Text, numExcistencias.Value };
                if( Conection.instance.insert(Tables.Producto, values.ToList()))
                {
                    MessageBox.Show("Insercion", "Insercion Exsitosa en la tabla " + Tables.Producto, MessageBoxButtons.OK);
                }
            }
        }
    }
}
