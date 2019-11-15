namespace Proyecto_de_admin_de_bases
{
    partial class NuevoVehiculo
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label2 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.numPeso = new System.Windows.Forms.NumericUpDown();
            this.Agregar = new System.Windows.Forms.Button();
            this.btnActualizar = new System.Windows.Forms.Button();
            this.idVehiculo = new System.Windows.Forms.NumericUpDown();
            this.ckDisponible = new System.Windows.Forms.CheckBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtModelo = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtPlaca = new Proyecto_de_admin_de_bases.TextboxRedondo();
            ((System.ComponentModel.ISupportInitialize)(this.numPeso)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.idVehiculo)).BeginInit();
            this.SuspendLayout();
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label2.Location = new System.Drawing.Point(12, 229);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(91, 15);
            this.label2.TabIndex = 43;
            this.label2.Text = "Peso Soportado";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label5.Location = new System.Drawing.Point(12, 178);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(48, 15);
            this.label5.TabIndex = 41;
            this.label5.Text = "Modelo";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Century Gothic", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(35, 35);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(143, 23);
            this.label3.TabIndex = 40;
            this.label3.Text = "Alta Vehiculo";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(12, 124);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(84, 15);
            this.label1.TabIndex = 38;
            this.label1.Text = "Número Placa";
            // 
            // numPeso
            // 
            this.numPeso.Location = new System.Drawing.Point(15, 258);
            this.numPeso.Maximum = new decimal(new int[] {
            9999999,
            0,
            0,
            0});
            this.numPeso.Name = "numPeso";
            this.numPeso.Size = new System.Drawing.Size(120, 20);
            this.numPeso.TabIndex = 44;
            // 
            // Agregar
            // 
            this.Agregar.Location = new System.Drawing.Point(15, 326);
            this.Agregar.Name = "Agregar";
            this.Agregar.Size = new System.Drawing.Size(75, 23);
            this.Agregar.TabIndex = 45;
            this.Agregar.Text = "Agregar";
            this.Agregar.UseVisualStyleBackColor = true;
            this.Agregar.Click += new System.EventHandler(this.Agregar_Click);
            // 
            // btnActualizar
            // 
            this.btnActualizar.Location = new System.Drawing.Point(15, 364);
            this.btnActualizar.Name = "btnActualizar";
            this.btnActualizar.Size = new System.Drawing.Size(75, 23);
            this.btnActualizar.TabIndex = 46;
            this.btnActualizar.Text = "Actualizar";
            this.btnActualizar.UseVisualStyleBackColor = true;
            this.btnActualizar.Click += new System.EventHandler(this.btnActualizar_Click);
            // 
            // idVehiculo
            // 
            this.idVehiculo.Enabled = false;
            this.idVehiculo.Location = new System.Drawing.Point(12, 101);
            this.idVehiculo.Name = "idVehiculo";
            this.idVehiculo.Size = new System.Drawing.Size(120, 20);
            this.idVehiculo.TabIndex = 47;
            // 
            // ckDisponible
            // 
            this.ckDisponible.AutoSize = true;
            this.ckDisponible.BackColor = System.Drawing.Color.Gray;
            this.ckDisponible.Enabled = false;
            this.ckDisponible.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ckDisponible.ForeColor = System.Drawing.Color.White;
            this.ckDisponible.Location = new System.Drawing.Point(19, 289);
            this.ckDisponible.Name = "ckDisponible";
            this.ckDisponible.Size = new System.Drawing.Size(82, 20);
            this.ckDisponible.TabIndex = 48;
            this.ckDisponible.Text = "Disponible";
            this.ckDisponible.UseVisualStyleBackColor = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label4.Location = new System.Drawing.Point(12, 83);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 15);
            this.label4.TabIndex = 49;
            this.label4.Text = "IdVehiculo";
            // 
            // txtModelo
            // 
            this.txtModelo.Location = new System.Drawing.Point(11, 196);
            this.txtModelo.Name = "txtModelo";
            this.txtModelo.Radio = 20;
            this.txtModelo.Size = new System.Drawing.Size(180, 20);
            this.txtModelo.TabIndex = 42;
            this.txtModelo.TextChanged += new System.EventHandler(this.txtApellido1_TextChanged);
            // 
            // txtPlaca
            // 
            this.txtPlaca.Location = new System.Drawing.Point(11, 142);
            this.txtPlaca.Name = "txtPlaca";
            this.txtPlaca.Radio = 20;
            this.txtPlaca.Size = new System.Drawing.Size(180, 20);
            this.txtPlaca.TabIndex = 39;
            // 
            // NuevoVehiculo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(1)))), ((int)(((byte)(28)))), ((int)(((byte)(58)))));
            this.ClientSize = new System.Drawing.Size(227, 450);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.ckDisponible);
            this.Controls.Add(this.idVehiculo);
            this.Controls.Add(this.btnActualizar);
            this.Controls.Add(this.Agregar);
            this.Controls.Add(this.numPeso);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtModelo);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtPlaca);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "NuevoVehiculo";
            this.Text = "NuevoVehiculo";
            this.Load += new System.EventHandler(this.NuevoVehiculo_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numPeso)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.idVehiculo)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label2;
        private TextboxRedondo txtModelo;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label3;
        private TextboxRedondo txtPlaca;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.NumericUpDown numPeso;
        private System.Windows.Forms.Button Agregar;
        private System.Windows.Forms.Button btnActualizar;
        private System.Windows.Forms.NumericUpDown idVehiculo;
        private System.Windows.Forms.CheckBox ckDisponible;
        private System.Windows.Forms.Label label4;
    }
}