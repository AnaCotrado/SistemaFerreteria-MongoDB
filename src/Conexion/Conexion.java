package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    static String Login = "Ana";
    static String Password = "";
    static String url = "jdbc:mysql://localhost:3306/db_ferreteria?zeroDateTimeBehavior=CONVERT_TO_NULL";
    
    public Conexion(){
    }
    
    public Connection Conectar(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, Login, Password);
        }catch(ClassNotFoundException | SQLException ex){
           JOptionPane.showMessageDialog(null,"Error en la conexion con la BD: "+ex.getMessage());
        }     
        return conn;
    }
}
