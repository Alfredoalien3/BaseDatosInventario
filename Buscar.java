/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julio
 */
public class Buscar extends Principal{
    public static void Buscar(JTable jTable1, JTextField jTextFieldBuscar){
        String campo = jTextFieldBuscar.getText();
        
        String where = "";
        
        if (!"".equals(campo)) {
            where = "WHERE codigo = '"+campo+"'";
            
        }
        
        
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTable1.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            Conexion conn = new Conexion();
            Connection con = conn.getConnection();
            
            String sql = "SELECT codigo, nombre, descripcion, precio, cantidad FROM producto " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            //modelo.addColumn("ID");
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripción");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");
            
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(filas);
                
            }
            
            
        } catch(SQLException ex){
            System.err.println(ex.toString());
        }
    }
}
