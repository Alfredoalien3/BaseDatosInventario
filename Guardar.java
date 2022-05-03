/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julio
 */
public class Guardar extends Principal{
    public static void Guardar(JTable jTable1,JTextField jTextFieldID,JTextField jTextFieldCodigo,JTextField jTextFieldNombre,JTextArea jTextArea1,JTextField jTextFieldPrecio,JTextField jTextFieldCantidad){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        java.sql.PreparedStatement ps = null;
        
        try{
            Conexion objCon = new Conexion();
            java.sql.Connection conn = objCon.getConnection();
            ps = conn.prepareStatement("INSERT INTO producto (codigo, nombre, descripcion, precio, cantidad) VALUES (?,?,?,?,?)");
           
            
            ps.setString(1, jTextFieldCodigo.getText());
            ps.setString(2, jTextFieldNombre.getText());
            ps.setString(3, jTextArea1.getText());
            ps.setString(4, jTextFieldPrecio.getText());
            ps.setString(5, jTextFieldCantidad.getText());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Producto guardado");
            
            Object[] fila = new Object[6];
            
            fila[0] = jTextFieldID.getText();
            fila[1] = jTextFieldCodigo.getText();
            fila[2] = jTextFieldNombre.getText();
            fila[3] = jTextArea1.getText();
            fila[4] = jTextFieldPrecio.getText();
            fila[5] = jTextFieldCantidad.getText();
            
            modelo.addRow(fila);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al guardar " + ex);
        }
    
    }
    
}
