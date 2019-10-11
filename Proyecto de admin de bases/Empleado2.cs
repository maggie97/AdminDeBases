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
        SqlConnection connection;
        String connectionString;
        Form formToPanel;

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
            camposGrid(Tables.Empleado);
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
            camposGrid(Tables.Vehiculo);
        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void btnProducto_Click(object sender, EventArgs e)
        {
            NuevoProducto nuevoProducto = new NuevoProducto();

            nuevoProducto.TopLevel = false;
            nuevoProducto.Dock = DockStyle.Fill;
            formToPanel = nuevoProducto as NuevoProducto;
            ventana();
            camposGrid(Tables.Producto);
        }

        private void btnVentas_Click(object sender, EventArgs e)
        {
            NuevoPedido nuevoPedido = new NuevoPedido();
            nuevoPedido.TopLevel = false;
            nuevoPedido.Dock = DockStyle.Fill;
            formToPanel = nuevoPedido as NuevoPedido;
            ventana();
            camposGrid(Tables.Pedido);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            /*NuevoPedido nuevoPedido = new NuevoPedido();
            nuevoPedido.TopLevel = false;
            nuevoPedido.Dock = DockStyle.Fill;
            formToPanel = nuevoPedido as NuevoPedido;
            ventana();*/
            camposGrid(Tables.Nomina);
        }

        private bool camposGrid(Tables table)
        {
            SqlDataReader dataReader;
            crearCamposATabla(table);
            try
            {
                if (connectionOpen())
                {
                    dataReader = datos(typeQuery.select ,table);
                    dgvDatos.Rows.Clear();
                    while (dataReader.Read())
                    {
                        List<string> row = new List<string>();
                        for (int i = 1; i < dataReader.FieldCount; i++)
                        {
                            row.Add(dataReader.GetValue(i).ToString());
                        }
                        dgvDatos.Rows.Add(row.ToArray());
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return false;
            }
            return true;
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
                    columnas = new string[] { "Nombre", "Apellido1", "Apellido2", "Direccion", "Telefono" };
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
                    columnas = new string[] { "Nombre", "Precio", "Exsictencias", "Marca" };
                    break;
                case Tables.Vehiculo:
                    columnas = new string[] { "NoUnidad", "NoPlaca", "Modelo", "Peso Soportado", "Disponibilidad" };
                    break;
            }
            
            foreach (var value in columnas)
            {
                dgvDatos.Columns.Add("Col" + value, value);
            }
        }

        private SqlDataReader datos(typeQuery type, Tables table)
        {
            String sql = type + " * FROM " + table;
            var command = new SqlCommand(sql, connection);
            return command.ExecuteReader();
        }

        private bool connectionOpen()
        {
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

        private void btnCliente_Click(object sender, EventArgs e)
        {
            camposGrid(Tables.Cliente);
        }
    }

    
}
