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
    public partial class NuevoProducto : Form
    {
        DataGridView tablaDt;
        public NuevoProducto(DataGridView dataGrid)
        {
            InitializeComponent();
            tablaDt = dataGrid;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtNombre.Text != "")
            {
                object[] values = new object[] {txtNombre.Text, numPrecio.Value , txtMarca.Text, numExcistencias.Value };
                if( Conection.instance.insert(Tables.Producto, values.ToList()))
                {
                    RefreshTable(Tables.Producto);
                    MessageBox.Show("Se ha registrado el producto correctamente", "Insercion Exsitosa en la tabla " + Tables.Producto, MessageBoxButtons.OK);
                }
            }
        }

        private void RefreshTable(Tables table)
        {
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, table))
                    {
                        tablaDt.Rows.Clear();
                        while (dataReader.Read())
                        {
                            List<string> row = new List<string>();
                            for (int i = 1; i < dataReader.FieldCount; i++)
                            {
                                row.Add(dataReader.GetValue(i).ToString());
                            }
                            tablaDt.Rows.Add(row.ToArray());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
        }

        private void btnActualizar_Click(object sender, EventArgs e)
        {
            object[] values = new object[] {idProducto.Value, txtNombre.Text, numPrecio.Value, txtMarca.Text, numExcistencias.Value };
            if (Conection.instance.Actualiza(values.ToList(),Tables.Producto))
            {
                RefreshTable(Tables.Producto);
                MessageBox.Show("Se ha modificado el producto correctamente", "Insercion Exsitosa en la tabla " + Tables.Producto, MessageBoxButtons.OK);
            }
        }
    }
}
