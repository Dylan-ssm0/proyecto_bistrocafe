
package Hilos;

import Metodos.Conexion;
import Metodos.metodo_noti;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class hilo_producto implements Runnable{
    
    Thread hilo;
    Conexion con;
    Connection conect;
    DefaultTableModel tablanot;
    
    public hilo_producto (DefaultTableModel tablanot){
        this.tablanot = tablanot;
    }
    
    public void inicio() throws Exception{
        con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
        con.ConexionPostgres();
        conect = con.getConnection();
        
        if(hilo==null){
            hilo = new Thread(this);
            hilo.start();
        }
    }
    
    public void stop(){
        hilo = null;
    }
    
    public void run (){
        try{
            ResultSet rs;
            ResultSet rs2;
            PreparedStatement ps;
        
        Thread hilo_actual = Thread.currentThread();
        
        while(hilo==hilo_actual){
            String query = "SELECT * FROM producto WHERE cantidad_producto<40";
            rs = con.consultar(query);
            
            try{
                while(rs.next()){
                    
                    boolean existente = false;
                    String noti, nombre_producto;
                    nombre_producto = rs.getString("nombre_producto").trim();
                    noti = "Debe reponer las existencias del producto: " + nombre_producto.trim();
                    int cantidad_prod = rs.getInt("cantidad_producto");
                    
                    if(cantidad_prod <40){
                        String queryval = "SELECT COUNT (*) FROM noti WHERE detalle = ?";
                        ps = conect.prepareStatement(queryval);
                        ps.setString(1, noti);
                        rs2 = ps.executeQuery();

                        if (rs2.next()) {
                            existente = rs2.getInt(1) > 0;

                            if (!existente) {
                                String querynot = "INSERT INTO noti (detalle) VALUES (?)";
                                ps = conect.prepareStatement(querynot);
                                ps.setString(1, noti);
                                ps.executeUpdate();
                                System.out.println("Notificacion insertada en la base de datos: "+noti);
                                
                                System.out.println("✅ Notificación insertada: " + noti);
                                    new metodo_noti().insertar(tablanot);
                            } 

                            while(producto_bajo_stock(nombre_producto)){
                                if(producto_bajo_stock(nombre_producto)){
                                    JOptionPane.showMessageDialog(null,
                                "⚠ El producto '" + nombre_producto + "' está por debajo de las 40 unidades.\nSe recomienda reponer las existencias.",
                                "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

                                pausa(100000);
                                }
                            }
                        }
                    }
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }
        }
        catch (SQLException ex) {
            Logger.getLogger(hilo_producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pausa (int tiempo){
            try{
                Thread.sleep(tiempo);
            }
            catch(InterruptedException ignorada){
                
            }
        }
    
    
    public boolean producto_bajo_stock (String nombre_producto){
        boolean bajo_stock = false;

        try{
            String query = "SELECT cantidad_producto FROM producto WHERE nombre_producto = ?";
            PreparedStatement ps  = conect.prepareStatement(query);
            ps.setString(1, nombre_producto);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                bajo_stock = rs.getInt("cantidad_producto") <40;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bajo_stock;
    }
}
