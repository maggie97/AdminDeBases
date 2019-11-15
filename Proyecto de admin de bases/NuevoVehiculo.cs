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
    public partial class NuevoVehiculo : Form
    {
        DataGridView tabledt;
        public NuevoVehiculo(DataGridView tabla)
        {
            InitializeComponent();
            tabledt = tabla;
        }

        private void txtApellido1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Agregar_Click(object sender, EventArgs e)
        {
            object[] values = new object[] { txtPlaca.Text, txtModelo.Text, numPeso.Value};
            if (Conection.instance.insert(Tables.Vehiculo, values.ToList()))
            {
                RefreshTable(Tables.Vehiculo);
                LimpiarCampos();
                MessageBox.Show("Insercion", "Insercion Exsitosa en la tabla " + Tables.Vehiculo, MessageBoxButtons.OK);
            }
        }

        private void LimpiarCampos()
        {
            idVehiculo.Value = 0;
            txtModelo.Text = "";
            txtPlaca.Text = "";
            ckDisponible.Checked = false;
            numPeso.Value = 0;
        }

        private void RefreshTable(Tables table)
        {
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, table))
                    {
                        tabledt.Rows.Clear();
                        while (dataReader.Read())
                        {
                            List<string> row = new List<string>();
                            for (int i = 0; i < dataReader.FieldCount; i++)
                            {
                                row.Add(dataReader.GetValue(i).ToString());
                            }
                            tabledt.Rows.Add(row.ToArray());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message);
            }
        }

        private void NuevoVehiculo_Load(object sender, EventArgs e)
        {

        }

        private void btnActualizar_Click(object sender, EventArgs e)
        {

        }
    }
}
