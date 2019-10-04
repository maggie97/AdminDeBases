using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto_de_admin_de_bases
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Form1 f1 = new Form1();
            Application.Run(f1);
            /*if (f1.fin)
            {
                Application.Exit();
                Administrador fAd = new Administrador();
                Application.Run(fAd);
                switch(fAd.opcion)
                {
                    case 1:
                        Empleado emp = new Empleado();
                        Application.Run(emp);
                        break;
                }
            }*/
        }
    }
}
