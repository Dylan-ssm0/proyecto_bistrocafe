
package Metodos;

import GUI.menu_admin;
import GUI.menu_empleado;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection; 
import javax.swing.JFrame;
import javax.swing.JLabel;

public class metodo_registro {
    
    
    public void Registrar_usuario (JTextField camp1, JTextField camp2, JPasswordField camp3, JComboBox camp4, JLabel msj){
        
        PreparedStatement ps = null;
        Connection conect = null;
        
            try{
                String C1, C2, C3;
                
                C1 = camp1.getText().trim();
                C2 = camp2.getText().trim();
                C3 = camp3.getText().trim();

                if(C1.isEmpty() || C2.isEmpty() || C3.isEmpty()){
                    JOptionPane.showMessageDialog(null, "⚠ Error: Todos los campos de texto son obligatorios.");
                    return;
                }

                Object objcamp4 = camp4.getSelectedItem();

                if(objcamp4 == null){
                    JOptionPane.showMessageDialog(null, "⚠ Error: Debe seleccionar un rol.");
                    return;
                }

                String C4 = objcamp4.toString();

                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                conect = con.getConnection();
            
                String query = "INSERT INTO usuario (nombre_usuario, email_usuario, contraseña_usuario, rol_usuario) VALUES (?, ?, ?, ?)";
                ps = conect.prepareStatement(query);
                ps.setString(1, C1);
                ps.setString(2, C2);
                ps.setString(3, C3);
                ps.setString(4, C4);

                int filas_afectadas = ps.executeUpdate();
            
                if(filas_afectadas>0){
                    msj.setForeground(Color.GREEN);
                    msj.setText("Registro realizado con éxito.");
                }
                else{
                    msj.setForeground(Color.RED);
                    msj.setText("Error: no se puede realizar el registro.");
                }
                
                camp1.setText("");
                camp2.setText("");
                camp3.setText("");
                camp4.setSelectedIndex(0);
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
    
    
    public void iniciar (JFrame login, JTextField camp1, JPasswordField camp2){
        
        Connection conect = null;
        PreparedStatement pslogin = null;
        ResultSet rs = null;
        
        try{
            String C1 = camp1.getText().trim();
            String C2 = camp2.getText().trim();
            
            if(C1.isEmpty() || C2.isEmpty()){
                JOptionPane.showMessageDialog(null, "⚠ Error: Todos los campos de texto son obligatorios.");
                return;
            }
            
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_merkaya");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querylogin = ("SELECT rol_usuario FROM usuario WHERE nombre_usuario = ? AND contraseña_usuario = ?");
            pslogin = conect.prepareStatement(querylogin);

            pslogin.setString(1, C1);
            pslogin.setString(2, C2);
            
            rs = pslogin.executeQuery();
            
            if(rs.next()){
               String rol = rs.getString("rol_usuario");
               JOptionPane.showMessageDialog(null, "✅ Inicio de sesión exitoso como " + rol);

               if(rol.equalsIgnoreCase("Administrador")){
                   new menu_admin().setVisible(true);
               }
               else if (rol.equalsIgnoreCase("Empleado")){
                   new menu_empleado().setVisible(true);
               }
               login.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "❌ Usuario o contraseña incorrectos");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: "+e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pslogin != null) pslogin.close();
                if (conect != null) conect.close(); 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
