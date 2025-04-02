/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class metodo_producto {
    
    
    //Añadir
     public void añadir(JTable camp, List<String> lista_Ingrediente, JLabel msj){
        
        int fila_seleccionada = camp.getSelectedRow();
    
        if (fila_seleccionada == -1) {  
        msj.setForeground(Color.RED);
        msj.setText("Error: Seleccione un ingrediente antes de agregarlo.");
        return;
        }

        // Obtener valores de la fila seleccionada
        Object nombre_Ingrediente = camp.getValueAt(fila_seleccionada, 1);

        if (nombre_Ingrediente != null) {
            String Ing = nombre_Ingrediente.toString();

            // Verificar que el nutriente no esté repetido en la lista
            if (!lista_Ingrediente.contains(Ing)) {
                lista_Ingrediente.add(Ing);
                msj.setForeground(Color.GREEN);
                msj.setText("Ingrediente agregado con éxito.");
            } else {
                msj.setForeground(Color.ORANGE);
                msj.setText("El ingrediente ya ha sido agregado.");
            }
        } else {
            msj.setForeground(Color.RED);
            msj.setText("Error: No se pudo obtener el Ingrediente.");
        }
    }
     
     
     //Listar
     public void listar(JTextField camp1, JComboBox camp2, JTextField camp3, JTextArea camp4, JTextField camp5, DefaultTableModel tabla, JLabel msj, List<String> lista_ingrediente) {
    PreparedStatement ps = null;
    Connection conn = null;

    try {
        // Validar que los campos obligatorios estén llenos
        long c1;
        double c5;
        try {
            c1 = Long.parseLong(camp1.getText().trim());
            c5 = Long.parseLong(camp5.getText().trim());
        } catch (NumberFormatException e) {
            msj.setForeground(Color.RED);
            msj.setText("Error: Debe rellenar todos los campos numéricos.");
            return;
        }
        
        Object obj2 = camp2.getSelectedItem();
        String c3 = camp3.getText().trim();
        String c4 = camp4.getText().trim();

        if (obj2 ==null || c3.isEmpty() || c4.isEmpty()) {
            msj.setForeground(Color.RED);
            msj.setText("Error: Todos los campos son obligatorios.");
            return;
        }
        String c2 = obj2.toString();
        
        // Validar que haya al menos un nutriente seleccionado
        if (lista_ingrediente.isEmpty()) {
            msj.setForeground(Color.RED);
            msj.setText("Error: Debe agregar al menos un Ingrediente.");
            return;
        }

        // Establecer conexión a la base de datos
        Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
        con.ConexionPostgres();  // Establecer la conexión
        conn = con.getConnection();  // Obtener la conexión

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.");
            return;
        }

        // Convertir lista de nutrientes en un ARRAY de PostgreSQL
        String[] arrayIngredientes = lista_ingrediente.toArray(new String[0]); 
        java.sql.Array sqlArray = conn.createArrayOf("text", arrayIngredientes); // Convertir en ARRAY de PostgreSQL

        // Consulta corregida
        String queryIngrediente = "INSERT INTO producto (id_producto, categoria_producto, nombre_producto, descripcion_producto, nombre_ingrediente, precio_producto) VALUES (?, ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(queryIngrediente);
        ps.setLong(1, c1);
        ps.setString(2, c2);  
        ps.setString(3, c3);
        ps.setString(4, c4);
        ps.setArray(5, sqlArray);
        ps.setDouble(6, c5);

        int filasInsertadas = ps.executeUpdate();

        if (filasInsertadas > 0) {
            msj.setForeground(Color.GREEN);
            msj.setText("Ingrediente y nutrientes guardados con éxito.");
        } else {
            msj.setForeground(Color.RED);
            msj.setText("Error: No se pudo guardar el ingrediente.");
        }

        // Limpiar los campos y la lista
        camp1.setText("");
        camp2.setSelectedIndex(0);
        camp3.setText("");
        camp4.setText("");
        camp5.setText("");
        lista_ingrediente.clear();

    } catch (Exception e) {
        Logger.getLogger(metodo_cliente.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "⚠ Error inesperado: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     }
     
     
     //Mostrar
     public void mostrar(DefaultTableModel tabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            tabla.setRowCount(0);
            
            String querymostrar = "SELECT * FROM producto";
            ps = conect.prepareStatement(querymostrar);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[]{
                    rs.getLong("id_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("categoria_producto"),
                    rs.getString("descripcion_producto"),
                    rs.getArray("nombre_ingrediente"),
                    rs.getDouble("precio_producto")
                });
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: "+e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,  "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if (conect != null) conect.isClosed();
                if (ps != null) ps.isClosed();
                if (rs != null) rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
     
     
     //Buscar
     public void buscar(JTextField camp1, JComboBox camp2, JTextField camp3, JTextArea camp4, JTextField camp5, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querybuscar = "SELECT * FROM producto WHERE id_producto = ?";
            ps = conect.prepareStatement(querybuscar);
            
            long buscar = Long.parseLong(JOptionPane.showInputDialog("Ingrese el registro del producto que desee buscar: "));
            ps.setLong(1, buscar);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                camp1.setText(rs.getString("id_producto"));
                camp2.setSelectedItem(rs.getString("categoria_producto"));
                camp3.setText(rs.getString("nombre_producto"));
                camp4.setText(rs.getString("descripcion_producto"));
                camp5.setText(rs.getString("precio_producto"));
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro encontrado.");
                return;
            }
            
            msj.setForeground(Color.RED);
            msj.setText("Registro no encontrado.");
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,  "❌ Error: Ingrese un número válido.");
        }
        catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conect != null) conect.close(); 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
     }
     
     
     //Editar
     public void editar (JTextField camp1, JComboBox camp2, JTextField camp3, JTextArea camp4, JTextField camp5, List<String> lista_ingrediente, JTable tabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            int fila_seleccionada = tabla.getSelectedRow();
            if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para editar.");
                return;
            }
            
            long c1 = Long.parseLong(camp1.getText().trim());
            long c5 = Long.parseLong(camp5.getText().trim());
            
            Object obj2 = camp2.getSelectedItem();
            String c2 = obj2.toString();
            
            String c3 = camp3.getText().trim();
            String c4 = camp4.getText().trim();
            
            String[] array_ingrediente = lista_ingrediente.toArray(new String[0]);
            java.sql.Array sqlArray = conect.createArrayOf("text", array_ingrediente);
            
            String queryEditar = "UPDATE producto SET categoria_producto = ?, nombre_producto = ?, descripcion_producto = ?, nombre_ingrediente = ?, precio_producto = ? WHERE id_producto = ?";
            ps = conect.prepareStatement(queryEditar);
            
            ps.setString(1, c2);
            ps.setString(2, c3); 
            ps.setString(3, c4);
            ps.setArray(4, sqlArray);
            ps.setDouble(5, c5);
            ps.setLong(6, c1);

            int fila_afectada = ps.executeUpdate();
            if(fila_afectada>0){
                tabla.setValueAt(c1, fila_seleccionada, 0);
                tabla.setValueAt(c3, fila_seleccionada, 1);
                tabla.setValueAt(c2, fila_seleccionada, 2);
                tabla.setValueAt(c4, fila_seleccionada, 3);
                tabla.setValueAt(sqlArray, fila_seleccionada, 4);
                tabla.setValueAt(c5, fila_seleccionada, 5);
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro editado con éxito");
                camp1.setText("");
                camp2.setSelectedIndex(0);
                camp3.setText("");
                camp4.setText("");
                camp5.setText("");
                lista_ingrediente.clear();
            }
            else{
                msj.setForeground(Color.RED);
                msj.setText("No se encontró un producto con ese ID.");
            }
        }
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "❌ Error: el ID debe ser un número válido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conect != null) conect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
     }
     
     
     //Eliminar
     public void eliminar(DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        PreparedStatement ps;
        
        int fila_seleccionada = txttabla.getSelectedRow();
        
        if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para eliminar.");
                return;
            }
        
        int confirmacion = JOptionPane.showConfirmDialog(null, 
        "¿Está seguro de eliminar la línea seleccionada?", 
        "Confirmación de Eliminación", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE);
        
            if(confirmacion == JOptionPane.YES_OPTION){
             try {
                 long cc = Long.parseLong(tabla.getValueAt(fila_seleccionada, 0).toString());
                 
                 Conexion  con= new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                 con.ConexionPostgres();
                 
                 String queryeliminar = "DELETE FROM producto WHERE id_producto = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     msj.setForeground(Color.GREEN);
                     msj.setText("Producto eliminado con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    msj.setForeground(Color.RED);
                    msj.setText("No se ha encontrado el producto");
                 }
                 
                 ps.close();
                 con.cerrar();
             }
             catch(Exception ex){
                 JOptionPane.showMessageDialog(null, "⚠ Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
            }
    }
}
