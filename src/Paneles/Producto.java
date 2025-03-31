/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Metodos.Conexion;
import Metodos.metodo_barra;
import Metodos.metodo_producto;
import Metodos.metodo_validaciones;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Producto extends javax.swing.JPanel {

    /**
     * Creates new form Producto
     */
    public Producto() {
        initComponents();
        
        mostrar_categoria(txtlista_categorias);
        
        String ids2 [] = {"ID", "Nombre"};
        tabla2.setColumnIdentifiers(ids2);
        txtingrediente.setModel(tabla2);
        mostrar_ingredientes(tabla2, advIng);
        
        String ids [] = {"ID", "Nombre", "Categoria", "Descripcion", "Ingredientes", "Precio"};
        tabla.setColumnIdentifiers(ids);
        txttabla.setModel(tabla);
    }
    
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultTableModel tabla2 = new DefaultTableModel();
    public static List<String> añadir = new ArrayList<>();
    
    metodo_producto mp = new metodo_producto();
    metodo_validaciones v = new metodo_validaciones();
    metodo_barra b = new metodo_barra();
    
    public void mostrar_ingredientes(DefaultTableModel tabla, JLabel msj) {
    Connection conect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Conectar a la base de datos
        Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
        con.ConexionPostgres();
        conect = con.getConnection();

        // Verificar si la conexión es válida
        if (conect == null) {
            JOptionPane.showMessageDialog(null, "❌ Error: No se pudo establecer la conexión.");
            return;
        }

        // Limpiar la tabla antes de cargar los datos
        tabla.setRowCount(0);

        // Consulta SQL para obtener solo ID y nombre del ingrediente
        String querymostrar = "SELECT id_ingrediente, nombre_ingrediente FROM ingrediente";
        ps = conect.prepareStatement(querymostrar);
        rs = ps.executeQuery();

        boolean hayDatos = false; // Para verificar si la consulta devuelve registros

        while (rs.next()) {
            long idIngrediente = rs.getLong("id_ingrediente");
            String nombreIngrediente = rs.getString("nombre_ingrediente");

            // Agregar los datos a la tabla
            tabla.addRow(new Object[]{idIngrediente, nombreIngrediente});
            hayDatos = true;
        }

        // Mostrar mensaje si no hay datos
        if (!hayDatos) {
            msj.setForeground(Color.ORANGE);
            msj.setText("⚠ No hay ingredientes registrados.");
        } else {
            msj.setForeground(Color.GREEN);
            msj.setText("✔ Datos cargados correctamente.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conect != null) conect.close(); // Cerrar la conexión correctamente
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    
    public void mostrar_categoria (JComboBox camp){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();

            String queryfam = "SELECT * FROM categoria ORDER BY nombre_categoria";
            ps = conect.prepareStatement(queryfam);
            rs = ps.executeQuery();
            
            camp.removeAllItems();
        
            while(rs.next()){
                String item = rs.getLong("id_categoria") + " - " + rs.getString("nombre_categoria");
                camp.addItem(item);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conect != null) conect.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDir = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        advPrc = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        barra = new javax.swing.JTextField();
        scrol2 = new javax.swing.JScrollPane();
        txtingrediente = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        lblGen = new javax.swing.JLabel();
        lblCC = new javax.swing.JLabel();
        txtlista_categorias = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();
        advCat = new javax.swing.JLabel();
        advID = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        lblAp = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        advNom = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        advDes = new javax.swing.JLabel();
        lblEml = new javax.swing.JLabel();
        txtbarra_tabla = new javax.swing.JTextField();
        advIng = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        scrol1 = new javax.swing.JScrollPane();
        txttabla = new javax.swing.JTable();
        advBar = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(245, 225, 200));

        lblDir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDir.setForeground(new java.awt.Color(75, 46, 46));
        lblDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDir.setText("PRECIO");

        txtprecio.setBackground(new java.awt.Color(255, 248, 231));
        txtprecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtprecio.setForeground(new java.awt.Color(75, 46, 46));
        txtprecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        advPrc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advPrc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(75, 46, 46));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Productos");

        barra.setBackground(new java.awt.Color(255, 248, 231));
        barra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barra.setForeground(new java.awt.Color(75, 46, 46));
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        barra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barraKeyReleased(evt);
            }
        });

        txtingrediente.setBackground(new java.awt.Color(255, 248, 231));
        txtingrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtingrediente.setForeground(new java.awt.Color(75, 46, 46));
        txtingrediente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrol2.setViewportView(txtingrediente);

        btnAñadir.setBackground(new java.awt.Color(174, 97, 40));
        btnAñadir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("AÑADIR");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        lblGen.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGen.setForeground(new java.awt.Color(75, 46, 46));
        lblGen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGen.setText("LISTA DE CATEGORIAS");

        lblCC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCC.setForeground(new java.awt.Color(75, 46, 46));
        lblCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCC.setText("ID DEL PRODUCTO");

        txtlista_categorias.setBackground(new java.awt.Color(255, 248, 231));
        txtlista_categorias.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtlista_categorias.setForeground(new java.awt.Color(75, 46, 46));
        txtlista_categorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        txtid.setBackground(new java.awt.Color(255, 248, 231));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(75, 46, 46));
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        advCat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        advID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnListar.setBackground(new java.awt.Color(174, 97, 40));
        btnListar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        lblAp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAp.setForeground(new java.awt.Color(75, 46, 46));
        lblAp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAp.setText("NOMBRE");

        txtnombre.setBackground(new java.awt.Color(255, 248, 231));
        txtnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(75, 46, 46));
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        advNom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblDes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDes.setForeground(new java.awt.Color(75, 46, 46));
        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDes.setText("DESCRIPCIÓN");

        txtdescripcion.setBackground(new java.awt.Color(255, 248, 231));
        txtdescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdescripcion.setForeground(new java.awt.Color(75, 46, 46));
        txtdescripcion.setRows(5);
        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        jScrollPane1.setViewportView(txtdescripcion);

        advDes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblEml.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEml.setForeground(new java.awt.Color(75, 46, 46));
        lblEml.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEml.setText("INGREDIENTES");

        txtbarra_tabla.setBackground(new java.awt.Color(255, 248, 231));
        txtbarra_tabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbarra_tabla.setForeground(new java.awt.Color(75, 46, 46));
        txtbarra_tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advIng.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advIng.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        txttabla.setBackground(new java.awt.Color(255, 248, 231));
        txttabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttabla.setForeground(new java.awt.Color(75, 46, 46));
        txttabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrol1.setViewportView(txttabla);

        advBar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        advBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(advDes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtid)
                                .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advNom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlista_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advCat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEml, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(advIng, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(advPrc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrol2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtbarra_tabla))
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addComponent(scrol1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(advBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbarra_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblEml, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrol1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblGen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlista_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advCat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advNom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advDes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrol2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advIng, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advPrc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        mp.eliminar(tabla, txttabla, advBar);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        v.validar_numero(txtid, txtnombre, advID);
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        v.validar_texto_area(txtnombre, txtdescripcion, advNom);
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        v.validar_ultimo_numero(txtprecio, advPrc);
    }//GEN-LAST:event_txtprecioActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        mp.listar(txtid, txtlista_categorias, txtnombre, txtdescripcion, txtprecio, tabla, advBar, añadir);
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mp.mostrar(tabla, advBar);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        mp.añadir(txtingrediente, añadir, advIng);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mp.buscar(txtid, txtlista_categorias, txtnombre, txtdescripcion, txtprecio, advBar);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        mp.editar(txtid, txtlista_categorias, txtnombre, txtdescripcion, txtprecio, añadir, txttabla, advBar);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void barraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraKeyReleased
        b.barra_producto(barra, tabla, txttabla, advBar);
    }//GEN-LAST:event_barraKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advBar;
    private javax.swing.JLabel advCat;
    private javax.swing.JLabel advDes;
    private javax.swing.JLabel advID;
    private javax.swing.JLabel advIng;
    private javax.swing.JLabel advNom;
    private javax.swing.JLabel advPrc;
    private javax.swing.JTextField barra;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAp;
    private javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblDir;
    private javax.swing.JLabel lblEml;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrol1;
    private javax.swing.JScrollPane scrol2;
    private javax.swing.JTextField txtbarra_tabla;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txtid;
    private javax.swing.JTable txtingrediente;
    private javax.swing.JComboBox<String> txtlista_categorias;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTable txttabla;
    // End of variables declaration//GEN-END:variables
}
