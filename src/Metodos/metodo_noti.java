
package Metodos;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class metodo_noti {
    
    public void insertar (DefaultTableModel tabla){
        
        System.out.println("✅ Entrando al método insertar...");
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        System.out.println("Actualizando tabla...");
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            System.out.println("✅ Conexión establecida.");
            tabla.setRowCount(0);
            
            String querymostrar = "SELECT detalle FROM noti";
            ps = conect.prepareStatement(querymostrar);
            rs = ps.executeQuery();
            
            boolean encontro = false;
            
           while(rs.next()){
               String detalle;
               detalle = rs.getString("detalle");
               tabla.addRow(new Object[]{detalle});
               encontro = true;
           }
            
            if(!encontro){
                System.out.println("⚠ No se encontraron registros en la base de datos.");
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
                if (conect != null) conect.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void eliminar(DefaultTableModel tabla, JTable txttabla){
        
        PreparedStatement ps = null;
        
        int fila_seleccionada = txttabla.getSelectedRow();
        
        if(fila_seleccionada == -1){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminar.");
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
                 
                 String queryeliminar = "DELETE FROM noti WHERE id = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente");
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
