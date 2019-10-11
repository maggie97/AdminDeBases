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
    public partial class NuevoPedido : Form
    {
        public event actualiza sobreescribe;
        public delegate void actualiza();

        public List<Cliente> clientes;

        public NuevoPedido()
        {
            InitializeComponent();
            clientes = new List<Cliente>();
            using (var datos = Conection.instance.datos(typeQuery.select, Tables.Cliente))
            {
                while (datos.Read())
                {
                    Cliente cliente = new Cliente(Convert.ToInt32(datos.GetValue(0)), datos.GetValue(1).ToString(),
                                        datos.GetValue(2).ToString(), datos.GetValue(3).ToString(), 
                                        datos.GetValue(4).ToString(), datos.GetValue(5).ToString());
                    clientes.Add(cliente);
                }
                foreach (var c in clientes)
                {
                    comboBox1.Items.Add(c.idCliente + "-" + c.nombre + " " + c.apellido1 + " " +  c.apellido2);
                    comboBox2.Items.Add(c.idCliente + "-" + c.nombre + " " + c.apellido1 + " " + c.apellido2);
                }
            }
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void comboBox3_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            using (Form2 form = new Form2())
            {
                if (form.ShowDialog() == DialogResult.OK)
                {
                    dataGridView1.Rows.Add(new string[] { form.producto.idProducto.ToString(),
                        form.producto.nombre, form.cantidad.ToString() });
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {



            sobreescribe();
            dataGridView1.Rows.Clear();
        }
    }
}
