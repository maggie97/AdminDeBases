using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto_de_admin_de_bases
{
    public enum Tables {
        Empleado ,
        Producto ,
        Vehiculo ,
        Pedido,
        Cliente,
        Conductor,
        DetallePedido,
        Nomina
    };

    public enum typeQuery{
        select, insert, update, delete
    }
    public partial class Empleado2 : Form
    {
        [DllImport("user32.DLL", EntryPoint = "ReleaseCapture")]
        private extern static void ReleaseCapture();
        [DllImport("user32.DLL", EntryPoint = "SendMessage")]
        private extern static void SendMessage(System.IntPtr hWnd, int wMsg, int wParam, int lParam);

        public int opcion = 0;
        public bool cerrarSesion;
        Form formToPanel;
        private Producto selectproducto = new Producto();
        NuevoProducto nuevoProducto;
        NuevoCliente cliente;

        Tables currentTable; 

        public Empleado2()
        {
            InitializeComponent();
        }

        private void panel4_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.Button.Equals(MouseButtons.Left))
            {
                ReleaseCapture();
                SendMessage(this.Handle, 0x112, 0xf012, 0);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAgregarEmpleado_Click(object sender, EventArgs e)
        {
            NuevoEmpleado empleado = new NuevoEmpleado();
            
            empleado.TopLevel = false;
            empleado.Dock = DockStyle.Fill;
            formToPanel = empleado as NuevoEmpleado;
            ventana();
            currentTable = Tables.Empleado;
            camposGrid();
            
            
        }
        private bool ventana()
        {
            panelVentana.Controls.Clear();
            if (formToPanel != null)
            {
                panelVentana.Controls.Add(formToPanel);
                panelVentana.Tag = formToPanel;
                formToPanel.Show();
                return true;
            }
            
            return false;
        }
        private void button6_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Normal)
                WindowState = FormWindowState.Maximized;
            else
                WindowState = FormWindowState.Normal;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            WindowState = FormWindowState.Minimized;
        }

        private void button1_Click_2(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        private void btnVehiculos_Click(object sender, EventArgs e)
        {
            currentTable = Tables.Vehiculo;
            camposGrid();
            
        }

        private void btnProducto_Click(object sender, EventArgs e)
        {
            nuevoProducto = new NuevoProducto(dgvDatos);
            nuevoProducto.TopLevel = false;
            nuevoProducto.Dock = DockStyle.Fill;
            formToPanel = nuevoProducto as NuevoProducto;
            ventana();
            currentTable = Tables.Producto;
            camposGrid();
            
        }

        private void btnVentas_Click(object sender, EventArgs e)
        {
            NuevoPedido nuevoPedido = new NuevoPedido();
            nuevoPedido.TopLevel = false;
            nuevoPedido.Dock = DockStyle.Fill;
            formToPanel = nuevoPedido as NuevoPedido;
            ventana();
            currentTable = Tables.Pedido;
            camposGrid();
            
        }

        private void button4_Click(object sender, EventArgs e)
        {
            camposGrid();
        }
        

        private void camposGrid()
        {
            crearCamposATabla(currentTable);
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, currentTable))
                    {
                        dgvDatos.Rows.Clear();
                        while (dataReader.Read())
                        {
                            List<string> row = new List<string>();
                            for (int i = 0; i < dataReader.FieldCount; i++)
                            {
                                row.Add(dataReader.GetValue(i).ToString());
                            }
                            dgvDatos.Rows.Add(row.ToArray());
                        }
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }
        public void crearCamposATabla(Tables tabla)
        {
            Tables t = tabla;
            string[] columnas = new string[] { };
            dgvDatos.Columns.Clear();
            switch (tabla)
            {
                case Tables.Empleado:
                    columnas = new string[] { "Nombre", "Apellido1", "Apellido2", "Direccion", "Telefono", "Puesto de Trabajo", "NSS" };
                    break;
                case Tables.Cliente:
                    columnas = new string[] { "Nombre", "Apellido1", "Apellido2", "Direccion", "Telefono" , "Email"};
                    break;
                case Tables.Conductor:
                    columnas = new string[] { "Unidad Asignada ", "idEmpleado", "Disponibilidad" };
                    break;
                case Tables.Nomina:
                    columnas = new string[] { "Mes", "Año", "Sueldo Base", "Horas Extra", "Sueldo Bruto" };
                    break;
                case Tables.Pedido:
                    columnas = new string[] { "clienteEnvia", "clienteRecibe", "total", "unidadAsignada", "estado", "fechaPedido", "fechaEntrega", "idEmpleado" };
                    break;
                case Tables.Producto:
                    columnas = new string[] { "Nombre", "Precio",  "Marca", "Exsictencias" };
                    break;
                case Tables.Vehiculo:
                    columnas = new string[] { "NoUnidad", "NoPlaca", "Modelo", "Peso Soportado", "Disponibilidad" };
                    break;
            }
            dgvDatos.Columns.Add("id", "id");
            foreach (var value in columnas)
            {
                dgvDatos.Columns.Add("Col" + value, value);
            }
            dgvDatos.Columns[0].Visible = false;
        }

        private void btnCliente_Click(object sender, EventArgs e)
        {
            cliente = new NuevoCliente(dgvDatos);
            cliente.actualizado += new Actualiza(camposGrid);
            cliente.TopLevel = false;
            cliente.Dock = DockStyle.Fill;
            formToPanel = cliente as NuevoCliente;
            ventana();
            currentTable = Tables.Cliente;
            camposGrid();
            
        }

        private void dgvDatos_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int rowindex = e.RowIndex;
            var row = dgvDatos.Rows[rowindex];
            switch(currentTable)
            {
                case Tables.Producto :
                    editarProducto(row);
                     break;
                case Tables.Cliente:
                    editarCliente(row);

                    break;
            }
        }

        private void eliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            var row = dgvDatos.SelectedRows[0];
            Console.WriteLine(row);
            if (MessageBox.Show("Estas seguro que deseas eliminar de " + currentTable + " " + row.Cells["id"].Value, "Eliminar", MessageBoxButtons.OKCancel, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1, MessageBoxOptions.DefaultDesktopOnly) == DialogResult.OK)
            {
                
                int id = Convert.ToInt32(row.Cells["id"].Value);
                try
                {
                    if (Conection.instance.Elimina(currentTable, id))
                    {
                        camposGrid();
                        MessageBox.Show("Eliminado");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.ToString(), "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void editarProducto(DataGridViewRow row)
        {
            TextBox _txtNombre = nuevoProducto.Controls.Find("txtNombre", true)[0] as TextBox;
            TextBox _txtMarca = nuevoProducto.Controls.Find("txtMarca", true)[0] as TextBox;
            NumericUpDown _numPrecio = nuevoProducto.Controls.Find("numPrecio", true)[0] as NumericUpDown;
            NumericUpDown _numExistencias = nuevoProducto.Controls.Find("numExcistencias", true)[0] as NumericUpDown;
            NumericUpDown _numIdProducto = nuevoProducto.Controls.Find("idProducto", true)[0] as NumericUpDown;

            _txtNombre.Text = row.Cells["ColNombre"].Value.ToString();
            _numPrecio.Value = Convert.ToDecimal(row.Cells["ColPrecio"].Value);
            _txtMarca.Text = row.Cells["ColMarca"].Value.ToString();
            _numExistencias.Value = Convert.ToInt32(row.Cells["ColExsictencias"].Value);
            _numIdProducto.Value = Convert.ToInt32(row.Cells["id"].Value);
        }
        private void editarCliente(DataGridViewRow row)
        {
            TextBox _txtNombre = cliente.Controls.Find("txtNombre", true)[0] as TextBox;
            TextBox _txtApellido = cliente.Controls.Find("txtApellido1", true)[0] as TextBox;
            TextBox _txtApellido2 = cliente.Controls.Find("txtApellido2", true)[0] as TextBox;
            TextBox _txtDireaccion = cliente.Controls.Find("txtDireccion", true)[0] as TextBox;
            TextBox _txtTelefono = cliente.Controls.Find("txtTelefono", true)[0] as TextBox;
            TextBox _txtEmail = cliente.Controls.Find("txtEmail", true)[0] as TextBox;
            NumericUpDown _id = cliente.Controls.Find("idCliente", true)[0] as NumericUpDown;

            _txtNombre.Text = row.Cells["ColNombre"].Value.ToString();
            _txtApellido.Text = row.Cells["ColApellido1"].Value.ToString();
            _txtApellido2.Text = row.Cells["ColApellido2"].Value.ToString();
            _txtDireaccion.Text = row.Cells["ColDireccion"].Value.ToString();
            _txtTelefono.Text = row.Cells["ColTelefono"].Value.ToString();
            _txtEmail.Text = row.Cells["ColEmail"].Value.ToString();
            _id.Value = Convert.ToInt32(row.Cells["id"].Value);
        }
    }

    
}
