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
        string tablaActivada = "";
        NuevoProducto nuevoProducto;
        NuevoCliente cliente;

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

        private void btnProducto_Click(object sender, EventArgs e)
        {
            nuevoProducto = new NuevoProducto(dgvDatos);
            tablaActivada = "Producto";
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

        private bool camposGrid2(Tables table)
        {
            crearCamposATabla(table);
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, table))
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
                return false;
            }
            return true;
        }

        private bool camposGrid(Tables table)
        {
            crearCamposATabla(table);
            try
            {
                if (Conection.instance.connectionOpen())
                {
                    using (SqlDataReader dataReader = Conection.instance.datos(typeQuery.select, table))
                    {
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
                    columnas = new string[] {"No. Cliente", "Nombre", "Apellido1", "Apellido2", "Direccion", "Telefono" , "Email"};
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

        private void btnCliente_Click(object sender, EventArgs e)
        {
            cliente = new NuevoCliente(dgvDatos);
            tablaActivada = "Cliente";
            cliente.TopLevel = false;
            cliente.Dock = DockStyle.Fill;
            formToPanel = cliente as NuevoCliente;
            ventana();
            camposGrid2(Tables.Cliente);
        }

        private void dgvDatos_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int rowindex = e.RowIndex;
            switch(tablaActivada)
            {
                case "Producto":
                    TextBox tex1 = nuevoProducto.Controls.Find("txtNombre", true)[0] as TextBox;
                    TextBox tex2 = nuevoProducto.Controls.Find("txtMarca", true)[0] as TextBox;
                    NumericUpDown num1 = nuevoProducto.Controls.Find("numPrecio", true)[0] as NumericUpDown;
                    NumericUpDown num2 = nuevoProducto.Controls.Find("numExcistencias", true)[0] as NumericUpDown;
                    NumericUpDown num3 = nuevoProducto.Controls.Find("idProducto", true)[0] as NumericUpDown;

                    tex1.Text = dgvDatos[0, rowindex].Value.ToString();
                    num1.Value = Convert.ToDecimal(dgvDatos[1, rowindex].Value);
                    tex2.Text = dgvDatos[2, rowindex].Value.ToString();
                    num2.Value = Convert.ToInt32( dgvDatos[3, rowindex].Value);
                    num3.Value = rowindex+1;
                    break;
                case "Cliente":
                    TextBox tex3 = cliente.Controls.Find("txtNombre", true)[0] as TextBox;
                    TextBox tex4 = cliente.Controls.Find("txtApellido1", true)[0] as TextBox;
                    TextBox tex5 = cliente.Controls.Find("txtApellido2", true)[0] as TextBox;
                    TextBox tex6 = cliente.Controls.Find("txtDireccion", true)[0] as TextBox;
                    TextBox tex7 = cliente.Controls.Find("txtTelefono", true)[0] as TextBox;
                    TextBox tex8 = cliente.Controls.Find("txtEmail", true)[0] as TextBox;
                    NumericUpDown numeric = cliente.Controls.Find("idCliente", true)[0] as NumericUpDown;

                    tex3.Text = dgvDatos[1, rowindex].Value.ToString();
                    tex4.Text = dgvDatos[2, rowindex].Value.ToString();
                    tex5.Text = dgvDatos[3, rowindex].Value.ToString();
                    tex6.Text = dgvDatos[4, rowindex].Value.ToString();
                    tex7.Text = dgvDatos[5, rowindex].Value.ToString();
                    tex8.Text = dgvDatos[6, rowindex].Value.ToString();
                    numeric.Value = Convert.ToInt32(dgvDatos[0, rowindex].Value);

                    break;
            }
        }
    }

    
}
