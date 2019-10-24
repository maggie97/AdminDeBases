using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_de_admin_de_bases
{
    public class Producto
    {
        int idProducto;
        public int IdProducto { get { return idProducto; } set { idProducto = value; } }

        string nombre;
        public string NombreProducto { get { return nombre; } set { nombre = value; } }

        float precio;
        public float PrecioProducto { get { return precio; } set { precio = value; } }

        int existencias;
        public int NumeroExistencias { get { return existencias; } set { existencias = value; } }

        string marca;
        public string NombreMarca { get { return marca; } set { marca = value; } }
    }
}
