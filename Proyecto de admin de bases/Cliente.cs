using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_de_admin_de_bases
{
    public class Cliente
    {
        public int idCliente;
        public string nombre;
        public string apellido1;
        public string apellido2;
        public string direccion;
        public string telefono;

        public Cliente(int idCliente, string nombre, string apellido1, string apellido2, string direccion, string telefono)
        {
            this.idCliente = idCliente;
            this.nombre = nombre ?? throw new ArgumentNullException(nameof(nombre));
            this.apellido1 = apellido1 ?? throw new ArgumentNullException(nameof(apellido1));
            this.apellido2 = apellido2 ?? throw new ArgumentNullException(nameof(apellido2));
            this.direccion = direccion ?? throw new ArgumentNullException(nameof(direccion));
            this.telefono = telefono ?? throw new ArgumentNullException(nameof(telefono));
        }
    }
}
