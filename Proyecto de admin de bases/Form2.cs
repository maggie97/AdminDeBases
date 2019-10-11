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
    public partial class Form2 : Form
    {
        public event actualiza sobreescribe;
        public delegate void actualiza();

        public List<Product> productos;
        public Product producto
        {
            get
            {
                string item = comboBox1.SelectedItem.ToString().Split('-').First();
                int id = Convert.ToInt32(item);
                
                return productos.Find(o => o.idProducto == id); 
            }
        }
        public int cantidad
        {
             get =>  Convert.ToInt32(numericUpDown1.Value);
        }
        public Form2()
        {
            productos = new List<Product>();
            InitializeComponent();
            using (var datos = Conection.instance.datos(typeQuery.select, Tables.Producto))
            {
                while (datos.Read())
                {
                    Product p = new Product(Convert.ToInt32(datos.GetValue(0)), datos.GetValue(1).ToString(),
                        Convert.ToDouble(datos.GetValue(2)), datos.GetValue(3).ToString());
                    productos.Add(p);
                }
                foreach (var p in productos)
                {
                    comboBox1.Items.Add(p.idProducto + "-" + p.nombre);
                }
            }
        }
        
    }
    public class Product
    {
        public int idProducto;
        public string nombre;
        public double precio;
        public string marca;

        public Product(int idProducto, string nombre, double precio, string marca)
        {
            this.idProducto = idProducto;
            this.nombre = nombre ?? throw new ArgumentNullException(nameof(nombre));
            this.precio = precio;
            this.marca = marca ?? throw new ArgumentNullException(nameof(marca));
        }
    }
}
