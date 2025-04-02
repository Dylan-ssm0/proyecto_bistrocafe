
package Metodos;

import Clases.detalle_venta;
import Paneles.Detalle_venta;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class metodo_detalle {
    
    public void mostrar_categoria(JComboBox camp, JLabel msj){
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
    
    
    public void cargar_producto_por_categoria(JComboBox combo_cat, JComboBox combo_prod, JLabel msj){
        
    combo_cat.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Limpiar el JComboBox de productos antes de cargar nuevos datos
            combo_prod.removeAllItems();

            // Verificar si hay una categoría seleccionada
            Object seleccion = combo_cat.getSelectedItem();
            if (seleccion == null) {
                msj.setForeground(Color.RED);
                msj.setText("❌ Error: Seleccione una categoría válida.");
                return;
            }

            String categoriaSeleccionada = seleccion.toString().trim();
            
            // Conectar con la base de datos
            try {
                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                Connection conect = con.getConnection();

                // Consulta optimizada: seleccionar solo los nombres de productos
                String query = "SELECT nombre_producto FROM producto WHERE categoria_producto = ?";
                
                try (PreparedStatement ps = conect.prepareStatement(query)) {
                    ps.setString(1, categoriaSeleccionada);
                    
                    try (ResultSet rs = ps.executeQuery()) {
                        boolean hayProductos = false;

                        while (rs.next()) {
                            hayProductos = true;
                            combo_prod.addItem(rs.getString("nombre_producto"));
                        }

                        if (!hayProductos) {
                            msj.setForeground(Color.ORANGE);
                            msj.setText("⚠ No hay productos para esta categoría.");
                        } else {
                            msj.setForeground(Color.GREEN);
                            msj.setText("✅ Productos cargados correctamente.");
                        }
                    }
                }
            } catch (SQLException ex) {
                msj.setForeground(Color.RED);
                msj.setText("❌ Error en la base de datos.");
                ex.printStackTrace();
            } catch (Exception ex) {
                msj.setForeground(Color.RED);
                msj.setText("❌ Error inesperado: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    });
   }
    
    
    public void añadir( JComboBox camp3, JComboBox camp4, JComboBox camp5, JTextField camp6, DefaultTableModel tabla, List<detalle_venta> lista_carrito, JLabel msj){
        try{
            int c5;
            double c6, subtotal;
            String c3, c4;
            Object obj3, obj4, obj5;

            try{
                c6 = Double.parseDouble( camp6.getText().trim());
            }catch(NumberFormatException e){
                msj.setForeground(Color.RED);
                msj.setText("Error: Debe rellenar todos los campos numéricos.");
                return;
            }

            obj3 = camp3.getSelectedItem();
            obj4 = camp4.getSelectedItem();
            obj5 = camp5.getSelectedItem();
            
            if(obj3 == null || obj4 == null || obj5 == null){
                msj.setForeground(Color.RED);
                msj.setText("Error: Todos los campos son obligatorios.");
                return;
            }
            
            c3 = obj3.toString();
            c4 = obj4.toString();
            c5 = Integer.parseInt(obj5.toString());
            
            subtotal = c5*c6;
            
            boolean existe = false;
            for (detalle_venta item : lista_carrito) {
                if (item.getProducto().equals(c4)) {
                    item.setCantidad(item.getCantidad() + c5); // Sumar la cantidad
                    item.setSubtotal(item.getCantidad()*item.getValor());
                    existe = true;
                    break;
                }
            }

            // Si no está en la lista, se agrega como un nuevo producto
            if (!existe) {
                lista_carrito.add(new detalle_venta(c3, c4, c5, c6, subtotal));
            }

            // Agregar el producto a la tabla visual
            tabla.addRow(new Object[]{c3, c4, c5, c6, subtotal});

            // Mensaje de éxito
            msj.setForeground(Color.GREEN);
            msj.setText("✅ Producto agregado al carrito.");
        }
        catch(Exception e){
            msj.setForeground(Color.RED);
            msj.setText("Ocurrio un error: "+e.getMessage());
        }
    }
    
    
    //Listar
    public void Listar(JTextField camp1, JTextField camp2, DefaultTableModel tabla, JLabel msj){
         PreparedStatement ps = null;
        Connection conn = null;

        try {
            long c1, c2;
            try {
                c1 = Long.parseLong(camp1.getText().trim());
                c2 = Long.parseLong(camp2.getText().trim());
            } catch (NumberFormatException e) {
                msj.setForeground(Color.RED);
                msj.setText("Error: Debe rellenar todos los IDs");
                return;
            }
            
            int filas = tabla.getRowCount();
            if(filas==0){
                msj.setForeground(Color.RED);
                msj.setText("Error: no hay productos en el carrito.");
                return;
            }
            
            StringBuilder productos_lista = new StringBuilder();
            double total_carrito =0;
            
            for(int i = 0; i<filas; i++){
                String producto = tabla.getValueAt(i, 1).toString();
                double subtotal = Double.parseDouble(tabla.getValueAt(i, 4).toString());
                
                productos_lista.append(producto);
                if(i<filas-1){
                    productos_lista.append(", ");
                }
                total_carrito += subtotal;
            }

            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();  // Establecer la conexión
            conn = con.getConnection();  // Obtener la conexión

            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.");
                return;
            }

            String query = "INSERT INTO detalle_venta (id_detalle, id_venta, producto, valor_total) VALUES (?, ?, ?, ?)";
            
            ps = conn.prepareStatement(query);
            ps.setLong(1, c1);
            ps.setLong(2, c2);
            ps.setString(3, productos_lista.toString());
            ps.setDouble(4, total_carrito);

            int filas_afectadas = ps.executeUpdate();

            if (filas_afectadas > 0) {
                msj.setForeground(Color.GREEN);
                msj.setText("Detalle de venta guardado con éxito.");
            } else {
                msj.setForeground(Color.RED);
                msj.setText("Error: No se pudo guardar el detalle de la venta.");
            }

            camp1.setText("");
            camp2.setText("");

        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
        e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
