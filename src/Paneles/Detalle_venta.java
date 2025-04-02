/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

import Clases.detalle_venta;
import Metodos.metodo_detalle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Detalle_venta extends javax.swing.JPanel {

    /**
     * Creates new form Detalle_venta
     */
    public Detalle_venta() {
        initComponents();
        md.mostrar_categoria(txtcategoria, advCat);
        for(int i = 1; i<=99; i++){
            txtcantidad.addItem(String.valueOf(i));
        }
        
        String ids_carrito [] = {"Categoria", "Producto", "Cantidad", "Valor", "Subtotal"};
        tabla_carrito.setColumnIdentifiers(ids_carrito);
        txtcarrito.setModel(tabla_carrito);
    }

    public static List<detalle_venta> lista_carrito = new ArrayList<>();
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultTableModel tabla_carrito = new DefaultTableModel();
    
    metodo_detalle md = new metodo_detalle();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCan = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JComboBox<>();
        advCan = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblICat = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        advCat = new javax.swing.JLabel();
        lblVal = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        advVal = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        barra = new javax.swing.JTextField();
        scrol = new javax.swing.JScrollPane();
        txttabla = new javax.swing.JTable();
        txtcategoria = new javax.swing.JComboBox<>();
        lblProd = new javax.swing.JLabel();
        txtproducto = new javax.swing.JComboBox<>();
        advProd = new javax.swing.JLabel();
        advBar = new javax.swing.JLabel();
        txttabla1 = new javax.swing.JScrollPane();
        txtcarrito = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        advID = new javax.swing.JLabel();
        lblIDV = new javax.swing.JLabel();
        txtidv = new javax.swing.JTextField();
        advIDV = new javax.swing.JLabel();
        advCarr = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(245, 225, 200));

        lblCan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCan.setForeground(new java.awt.Color(75, 46, 46));
        lblCan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCan.setText("CANTIDAD");

        txtcantidad.setBackground(new java.awt.Color(255, 248, 231));
        txtcantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcantidad.setForeground(new java.awt.Color(75, 46, 46));
        txtcantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advCan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advCan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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

        btnBuscar.setBackground(new java.awt.Color(174, 97, 40));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");

        btnEditar.setBackground(new java.awt.Color(174, 97, 40));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");

        lblICat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblICat.setForeground(new java.awt.Color(75, 46, 46));
        lblICat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblICat.setText("CATEGORIAS");

        btnEliminar.setBackground(new java.awt.Color(174, 97, 40));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        advCat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblVal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVal.setForeground(new java.awt.Color(75, 46, 46));
        lblVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVal.setText("VALOR");

        txtvalor.setBackground(new java.awt.Color(255, 248, 231));
        txtvalor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtvalor.setForeground(new java.awt.Color(75, 46, 46));
        txtvalor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advVal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(75, 46, 46));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Detalle de la Venta");

        barra.setBackground(new java.awt.Color(255, 248, 231));
        barra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barra.setForeground(new java.awt.Color(75, 46, 46));
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        txttabla.setBackground(new java.awt.Color(255, 248, 231));
        txttabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttabla.setForeground(new java.awt.Color(75, 46, 46));
        txttabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrol.setViewportView(txttabla);

        txtcategoria.setBackground(new java.awt.Color(255, 248, 231));
        txtcategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcategoria.setForeground(new java.awt.Color(75, 46, 46));
        txtcategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        txtcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoriaActionPerformed(evt);
            }
        });

        lblProd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProd.setForeground(new java.awt.Color(75, 46, 46));
        lblProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProd.setText("PRODUCTOS");

        txtproducto.setBackground(new java.awt.Color(255, 248, 231));
        txtproducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtproducto.setForeground(new java.awt.Color(75, 46, 46));
        txtproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advProd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        advBar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        advBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtcarrito.setBackground(new java.awt.Color(255, 248, 231));
        txtcarrito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcarrito.setForeground(new java.awt.Color(75, 46, 46));
        txtcarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txttabla1.setViewportView(txtcarrito);

        btnAñadir.setBackground(new java.awt.Color(174, 97, 40));
        btnAñadir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAñadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadir.setText("AÑADIR");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(75, 46, 46));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");

        txtid.setBackground(new java.awt.Color(255, 248, 231));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(75, 46, 46));
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIDV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIDV.setForeground(new java.awt.Color(75, 46, 46));
        lblIDV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIDV.setText("ID Venta");

        txtidv.setBackground(new java.awt.Color(255, 248, 231));
        txtidv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtidv.setForeground(new java.awt.Color(75, 46, 46));
        txtidv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        advIDV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advIDV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        advCarr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        advCarr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblICat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advCat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advProd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advVal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advCan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advIDV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advCarr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txttabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(scrol)
                    .addComponent(advBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrol, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblIDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advIDV, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addComponent(advCan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advVal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblICat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advCat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advProd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAñadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advCarr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        md.añadir(txtcategoria, txtproducto, txtcantidad, txtvalor, tabla_carrito, lista_carrito, advCarr);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void txtcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoriaActionPerformed
        md.cargar_producto_por_categoria(txtcategoria, txtproducto, advProd);
    }//GEN-LAST:event_txtcategoriaActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        md.Listar(txtid, txtidv, tabla_carrito, advCarr);
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advBar;
    private javax.swing.JLabel advCan;
    private javax.swing.JLabel advCarr;
    private javax.swing.JLabel advCat;
    private javax.swing.JLabel advID;
    private javax.swing.JLabel advIDV;
    private javax.swing.JLabel advProd;
    private javax.swing.JLabel advVal;
    private javax.swing.JTextField barra;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCan;
    private javax.swing.JLabel lblICat;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDV;
    private javax.swing.JLabel lblProd;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVal;
    private javax.swing.JScrollPane scrol;
    private javax.swing.JComboBox<String> txtcantidad;
    private javax.swing.JTable txtcarrito;
    private javax.swing.JComboBox<String> txtcategoria;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidv;
    private javax.swing.JComboBox<String> txtproducto;
    private javax.swing.JTable txttabla;
    private javax.swing.JScrollPane txttabla1;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
