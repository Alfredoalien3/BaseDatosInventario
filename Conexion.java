/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio
 */
public class Conexion {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    private static String URL = "jdbc:mysql://localhost/inventario?useSSL=false";
    
    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error en driver: " + e);
        }
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USUARIO, PASSWORD);
            //System.out.println("Conexion exitosa...");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexión: " + e);
        }
        return con;
    }
}
