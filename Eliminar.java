/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Julio
 */
public class Eliminar {
    public static void Eliminar(JTable jTable1){
        PreparedStatement ps = null;
        
        try{
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConnection();
            
            int Fila = jTable1.getSelectedRow();           
            String codigo = jTable1.getValueAt(Fila, 0).toString();
            
            // Mensaje
            String nombre = jTable1.getValueAt(Fila, 1).toString();
            String mensaje = ("Se elimino el producto: " + nombre);
            
            JOptionPane.showMessageDialog(null, mensaje);
            
            ps = conn.prepareStatement("DELETE FROM producto WHERE codigo=?");
            ps.setString(1, codigo);
            ps.execute();
            
            
            
            
        }catch(SQLException ex){
            
            System.out.println(ex.toString());
        }
    }
    
}
