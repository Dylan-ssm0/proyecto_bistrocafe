/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Metodos.metodo_barra;
import Metodos.metodo_cliente;
import Metodos.metodo_validaciones;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Cliente extends javax.swing.JPanel {

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        txtgenero.addItem("Masculino");
        txtgenero.addItem("Femenino");
        txtgenero.addItem("Otro");
        
        String ids [] = {"Cedula","Nombre","Apellido","Email","Dirección","Teléfono","Fecha de Nacimiento","Género"};
        tabla.setColumnIdentifiers(ids);
        txttabla.setModel(tabla);
    }
    DefaultTableModel tabla = new DefaultTableModel();
    
    metodo_cliente mc = new metodo_cliente();
    metodo_validaciones v = new metodo_validaciones();
    metodo_barra b = new metodo_barra();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoCliente = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        barra = new javax.swing.JTextField();
        scrol = new javax.swing.JScrollPane();
        txttabla = new javax.swing.JTable();
        lblCC = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        advCC = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        avdNom = new javax.swing.JLabel();
        lblAp = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        advAp = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        advTel = new javax.swing.JLabel();
        lblEml = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        advEml = new javax.swing.JLabel();
        lblDir = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        advDir = new javax.swing.JLabel();
        lblFN = new javax.swing.JLabel();
        txtfecha = new com.toedter.calendar.JDateChooser();
        advFN = new javax.swing.JLabel();
        lblGen = new javax.swing.JLabel();
        txtgenero = new javax.swing.JComboBox<>();
        advGen = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        advbar = new javax.swing.JLabel();

        fondoCliente.setBackground(new java.awt.Color(245, 225, 200));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(75, 46, 46));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Clientes");

        barra.setBackground(new java.awt.Color(255, 248, 231));
        barra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barra.setForeground(new java.awt.Color(75, 46, 46));
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        barra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraKeyReleased(evt);
            }
        });

        txttabla.setBackground(new java.awt.Color(255, 248, 231));
        txttabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttabla.setForeground(new java.awt.Color(75, 46, 46));
        txttabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrol.setViewportView(txttabla);

        lblCC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCC.setForeground(new java.awt.Color(75, 46, 46));
        lblCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCC.setText("CEDULA");

        txtcedula.setBackground(new java.awt.Color(255, 248, 231));
        txtcedula.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcedula.setForeground(new java.awt.Color(75, 46, 46));
        txtcedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });

        advCC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblNom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNom.setForeground(new java.awt.Color(75, 46, 46));
        lblNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNom.setText("NOMBRE");

        txtnombre.setBackground(new java.awt.Color(255, 248, 231));
        txtnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(75, 46, 46));
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        avdNom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        avdNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblAp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAp.setForeground(new java.awt.Color(75, 46, 46));
        lblAp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAp.setText("APELLIDO");

        txtapellido.setBackground(new java.awt.Color(255, 248, 231));
        txtapellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtapellido.setForeground(new java.awt.Color(75, 46, 46));
        txtapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });

        advAp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advAp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTel.setForeground(new java.awt.Color(75, 46, 46));
        lblTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTel.setText("TELÉFONO");

        txttelefono.setBackground(new java.awt.Color(255, 248, 231));
        txttelefono.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttelefono.setForeground(new java.awt.Color(75, 46, 46));
        txttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        advTel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advTel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblEml.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEml.setForeground(new java.awt.Color(75, 46, 46));
        lblEml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEml.setText("EMAIL");

        txtemail.setBackground(new java.awt.Color(255, 248, 231));
        txtemail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(75, 46, 46));
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        advEml.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advEml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDir.setForeground(new java.awt.Color(75, 46, 46));
        lblDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDir.setText("DIRECCIÓN");

        txtdireccion.setBackground(new java.awt.Color(255, 248, 231));
        txtdireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdireccion.setForeground(new java.awt.Color(75, 46, 46));
        txtdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        advDir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblFN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFN.setForeground(new java.awt.Color(75, 46, 46));
        lblFN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFN.setText("FECHA DE NACIMIENTO");

        txtfecha.setBackground(new java.awt.Color(255, 248, 231));
        txtfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtfecha.setForeground(new java.awt.Color(75, 46, 46));

        advFN.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advFN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblGen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGen.setForeground(new java.awt.Color(75, 46, 46));
        lblGen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGen.setText("GÉNERO");

        txtgenero.setBackground(new java.awt.Color(255, 248, 231));
        txtgenero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtgenero.setForeground(new java.awt.Color(75, 46, 46));
        txtgenero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advGen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advGen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnListar.setBackground(new java.awt.Color(174, 97, 40));
        btnListar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(174, 97, 40));
        btnMostrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(174, 97, 40));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(174, 97, 40));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(174, 97, 40));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        advbar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        advbar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout fondoClienteLayout = new javax.swing.GroupLayout(fondoCliente);
        fondoCliente.setLayout(fondoClienteLayout);
        fondoClienteLayout.setHorizontalGroup(
            fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(fondoClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcedula)
                        .addComponent(advCC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avdNom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advAp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advTel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advGen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advDir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advFN, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFN, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEml, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advEml, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(advbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fondoClienteLayout.createSequentialGroup()
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barra)
                    .addComponent(scrol))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoClienteLayout.setVerticalGroup(
            fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoClienteLayout.createSequentialGroup()
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(advbar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(fondoClienteLayout.createSequentialGroup()
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEml, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advCC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advEml, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avdNom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advDir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advAp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advFN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(fondoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advTel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advGen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        mc.eliminar(tabla, txttabla, advbar);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
       v.validar_numero(txtcedula, txtnombre, advCC);
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        v.validar_numero(txttelefono, txtemail, advTel);
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        v.validar_texto(txtnombre, txtapellido, avdNom);
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        v.validar_texto(txtapellido, txttelefono, advAp);
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        v.validar_campo(txtemail, txtdireccion, advEml);
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        v.validar_ultimo_campo(txtdireccion, advDir);
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        mc.listar(txtcedula, txtnombre, txtapellido, txttelefono, txtemail, txtdireccion, txtfecha, txtgenero, advbar);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mc.mostrar(tabla, advbar);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mc.buscar(txtcedula, txtnombre, txtapellido, txttelefono, txtemail, txtdireccion, txtfecha, txtgenero, advbar);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        mc.editar(txtcedula, txtnombre, txtapellido, txttelefono, txtemail, txtdireccion, txtfecha, txtgenero, txttabla, advbar);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void barraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraKeyReleased
         b.barra_cliente(barra, tabla, txttabla, advbar);
    }//GEN-LAST:event_barraKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advAp;
    private javax.swing.JLabel advCC;
    private javax.swing.JLabel advDir;
    private javax.swing.JLabel advEml;
    private javax.swing.JLabel advFN;
    private javax.swing.JLabel advGen;
    private javax.swing.JLabel advTel;
    private javax.swing.JLabel advbar;
    private javax.swing.JLabel avdNom;
    private javax.swing.JTextField barra;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel fondoCliente;
    private javax.swing.JLabel lblAp;
    private javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblEml;
    private javax.swing.JLabel lblFN;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrol;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JComboBox<String> txtgenero;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTable txttabla;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
