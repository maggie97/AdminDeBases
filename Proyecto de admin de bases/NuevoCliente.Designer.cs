namespace Proyecto_de_admin_de_bases
{
    partial class NuevoCliente
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
            this.label5 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.txtTelefono = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtDireccion = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtApellido2 = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtApellido1 = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtNombre = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.txtEmail = new Proyecto_de_admin_de_bases.TextboxRedondo();
            this.label7 = new System.Windows.Forms.Label();
            this.btnActualizarCliente = new System.Windows.Forms.Button();
            this.idCliente = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.idCliente)).BeginInit();
            this.SuspendLayout();
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label5.Location = new System.Drawing.Point(25, 112);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(89, 15);
            this.label5.TabIndex = 32;
            this.label5.Text = "Primer Apellido";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Century Gothic", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(39, 25);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(57, 23);
            this.label3.TabIndex = 27;
            this.label3.Text = "Alta ";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(25, 58);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(50, 15);
            this.label1.TabIndex = 25;
            this.label1.Text = "Nombre";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label2.Location = new System.Drawing.Point(25, 163);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(103, 15);
            this.label2.TabIndex = 34;
            this.label2.Text = "Segundo Apellido";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label4.Location = new System.Drawing.Point(25, 217);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(60, 15);
            this.label4.TabIndex = 36;
            this.label4.Text = "Dirección";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label6.Location = new System.Drawing.Point(25, 270);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(53, 15);
            this.label6.TabIndex = 38;
            this.label6.Text = "Teléfono";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(43, 371);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(130, 23);
            this.button1.TabIndex = 44;
            this.button1.Text = "Añadir Empleado";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // txtTelefono
            // 
            this.txtTelefono.Location = new System.Drawing.Point(24, 288);
            this.txtTelefono.Name = "txtTelefono";
            this.txtTelefono.Radio = 20;
            this.txtTelefono.Size = new System.Drawing.Size(180, 20);
            this.txtTelefono.TabIndex = 39;
            // 
            // txtDireccion
            // 
            this.txtDireccion.Location = new System.Drawing.Point(24, 235);
            this.txtDireccion.Name = "txtDireccion";
            this.txtDireccion.Radio = 20;
            this.txtDireccion.Size = new System.Drawing.Size(180, 20);
            this.txtDireccion.TabIndex = 37;
            // 
            // txtApellido2
            // 
            this.txtApellido2.Location = new System.Drawing.Point(24, 181);
            this.txtApellido2.Name = "txtApellido2";
            this.txtApellido2.Radio = 20;
            this.txtApellido2.Size = new System.Drawing.Size(180, 20);
            this.txtApellido2.TabIndex = 35;
            // 
            // txtApellido1
            // 
            this.txtApellido1.Location = new System.Drawing.Point(24, 130);
            this.txtApellido1.Name = "txtApellido1";
            this.txtApellido1.Radio = 20;
            this.txtApellido1.Size = new System.Drawing.Size(180, 20);
            this.txtApellido1.TabIndex = 33;
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(24, 76);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Radio = 20;
            this.txtNombre.Size = new System.Drawing.Size(180, 20);
            this.txtNombre.TabIndex = 26;
            // 
            // txtEmail
            // 
            this.txtEmail.Location = new System.Drawing.Point(24, 332);
            this.txtEmail.Name = "txtEmail";
            this.txtEmail.Radio = 20;
            this.txtEmail.Size = new System.Drawing.Size(180, 20);
            this.txtEmail.TabIndex = 46;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Century Gothic", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label7.Location = new System.Drawing.Point(25, 314);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(35, 15);
            this.label7.TabIndex = 45;
            this.label7.Text = "Email";
            // 
            // btnActualizarCliente
            // 
            this.btnActualizarCliente.Location = new System.Drawing.Point(43, 400);
            this.btnActualizarCliente.Name = "btnActualizarCliente";
            this.btnActualizarCliente.Size = new System.Drawing.Size(130, 23);
            this.btnActualizarCliente.TabIndex = 47;
            this.btnActualizarCliente.Text = "Actualizar Empleado";
            this.btnActualizarCliente.UseVisualStyleBackColor = true;
            this.btnActualizarCliente.Click += new System.EventHandler(this.btnActualizarCliente_Click);
            // 
            // idCliente
            // 
            this.idCliente.Location = new System.Drawing.Point(43, 429);
            this.idCliente.Name = "idCliente";
            this.idCliente.Size = new System.Drawing.Size(120, 20);
            this.idCliente.TabIndex = 48;
            this.idCliente.Visible = false;
            // 
            // NuevoCliente
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(1)))), ((int)(((byte)(28)))), ((int)(((byte)(58)))));
            this.ClientSize = new System.Drawing.Size(244, 475);
            this.Controls.Add(this.idCliente);
            this.Controls.Add(this.btnActualizarCliente);
            this.Controls.Add(this.txtEmail);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.txtTelefono);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.txtDireccion);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.txtApellido2);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtApellido1);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "NuevoCliente";
            this.Text = "NuevoEmpleado";
            ((System.ComponentModel.ISupportInitialize)(this.idCliente)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextboxRedondo txtApellido1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label3;
        private TextboxRedondo txtNombre;
        private System.Windows.Forms.Label label1;
        private TextboxRedondo txtApellido2;
        private System.Windows.Forms.Label label2;
        private TextboxRedondo txtDireccion;
        private System.Windows.Forms.Label label4;
        private TextboxRedondo txtTelefono;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button button1;
        private TextboxRedondo txtEmail;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button btnActualizarCliente;
        private System.Windows.Forms.NumericUpDown idCliente;
    }
}