
package Metodos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class metodo_venta {
    
    public void mostrar_id (JComboBox camp, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String query = "SELECT id_venta FROM detalle_venta";
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();
            
            camp.removeAllItems();
            
            while(rs.next()){
                camp.addItem(rs.getLong("id_venta"));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conect != null) conect.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void mostrar_cc_cliente (JComboBox camp){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String query = "SELECT cedula_cliente, nombre_cliente FROM cliente";
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();
            
            camp.removeAllItems();
            
            while(rs.next()){
                String item = rs.getLong("cedula_cliente") + " - " + rs.getString("nombre_cliente");
                camp.addItem(item);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conect != null) conect.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void mostrar_cc_empleado(JComboBox camp){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String query = "SELECT cedula_empleado, nombre_empleado FROM empleado";
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();
            
            camp.removeAllItems();
            
            while(rs.next()){
                String item = rs.getLong("cedula_empleado") + " - " + rs.getString("nombre_empleado");
                camp.addItem(item);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conect != null) conect.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void listar (JComboBox camp1, JComboBox camp2, JComboBox camp3, JDateChooser camp4, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Object obj1, obj2, obj3;
            long c1, c2, c3;
            String cc_c, cc_e;
            
            obj1 = camp1.getSelectedItem();
            obj2 = camp2.getSelectedItem();
            obj3 = camp3.getSelectedItem();
            Date c4 = camp4.getDate();
            
            if(obj1 == null || obj2 == null || obj3 == null || c4 == null){
                msj.setForeground(Color.RED);
                msj.setText("Error: debe llenar todos los campos.");
                return;
            }
            cc_c = obj2.toString().split("-")[0].trim();
            cc_e = obj3.toString().split("-")[0].trim();
            
            c1 = Long.parseLong(obj1.toString());
            c2 = Long.parseLong(cc_c);
            c3 = Long.parseLong(cc_e);
            
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String query = "INSERT INTO venta (id_venta, cedula_cliente, cedula_empleado, fecha_venta) VALUES (?,?,?,?)";
            ps = conect.prepareStatement(query);
            ps.setLong(1, c1);
            ps.setLong(2, c2);
            ps.setLong(3, c3);
            ps.setDate(4, new java.sql.Date(c4.getTime()));
            
            int filas_afectadas = ps.executeUpdate();
            
            if(filas_afectadas>0){
                msj.setForeground(Color.GREEN);
                msj.setText("Venta realizada con éxito.");
            }
            else{
                msj.setForeground(Color.RED);
                msj.setText("Error: no se puede realizar la venta.");
            }
            
            camp1.setSelectedIndex(0);
            camp2.setSelectedIndex(0);
            camp3.setSelectedIndex(0);
            camp4.setDate(null);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "⚠ Error inesperado: " + e.getMessage());
        }
        finally {
            try {
                if (ps != null) ps.close();
                if (conect != null) conect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void mostrar (DefaultTableModel tabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            tabla.setRowCount(0);
            
            String query = "SELECT * FROM venta";
            ps = conect.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[] {
                    rs.getLong("id_venta"),
                    rs.getLong("cedula_cliente"),
                    rs.getLong("cedula_empleado"),
                    rs.getDate("fecha_venta")
                });
            }
        }catch(SQLException e){
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
    
    
    public void buscar (JComboBox camp1, JComboBox camp2, JComboBox camp3, JDateChooser camp4, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querybuscar = "SELECT * FROM venta WHERE id_venta = ?";
            ps = conect.prepareStatement(querybuscar);
            
            long buscar = Long.parseLong(JOptionPane.showInputDialog("Ingrese el registro de la venta que desea buscar: "));
            ps.setLong(1, buscar);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                camp1.setSelectedItem(rs.getString("id_venta"));
                camp2.setSelectedItem(rs.getString("cedula_cliente"));
                camp3.setSelectedItem(rs.getString("cedula_empleado"));
                
                Date fecha_venta = rs.getDate("fecha_venta");
                camp4.setDate(fecha_venta != null ? fecha_venta: new Date());
                
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
    
    
    public void editar (JComboBox camp1, JComboBox camp2, JComboBox camp3, JDateChooser camp4, DefaultTableModel tabla, JTable txttabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Object obj1, obj2, obj3;
            long c1, c2, c3;
            String cc_c, cc_e;
            
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            int fila_seleccionada = txttabla.getSelectedRow();
            if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para editar.");
                return;
            }
            
            obj1 = camp1.getSelectedItem();
            obj2 = camp2.getSelectedItem();
            obj3 = camp3.getSelectedItem();
            
            cc_c =  obj2.toString().split("-")[0].trim();
            cc_e =  obj3.toString().split("-")[0].trim();
            
            c1 = Long.parseLong(obj1.toString());
            c2 = Long.parseLong(cc_c);
            c3 = Long.parseLong(cc_e);
            Date c4 = camp4.getDate();
            
            String queryEditar = "UPDATE venta SET cedula_cliente = ?, cedula_empleado = ?, fecha_venta = ? WHERE id_venta = ?";
            ps = conect.prepareStatement(queryEditar);
            
            ps.setLong(1, c2);
            ps.setLong(2, c3);
            ps.setDate(3, new java.sql.Date(c4.getTime()));
            ps.setLong(4, c1);

            int fila_afectada = ps.executeUpdate();
            if(fila_afectada>0){
                tabla.setValueAt(c1, fila_seleccionada, 0);
                tabla.setValueAt(c2, fila_seleccionada, 1);
                tabla.setValueAt(c3, fila_seleccionada, 2);
                tabla.setValueAt(c4, fila_seleccionada, 3);
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro editado con éxito");
                camp1.setSelectedIndex(0);
                camp2.setSelectedIndex(0);
                camp3.setSelectedIndex(0);
                camp4.setDate(null);
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
    
    
    public void eliminar (DefaultTableModel tabla, JTable txttabla, JLabel msj){
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
                 
                 String queryeliminar = "DELETE FROM venta WHERE id_venta = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     msj.setForeground(Color.GREEN);
                     msj.setText("Empleado eliminado con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    msj.setForeground(Color.RED);
                    msj.setText("No se ha encontrado el empleado");
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
