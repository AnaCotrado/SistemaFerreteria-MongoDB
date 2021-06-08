package Negocio;

import Conexion.Conexion;
import Datos.D_Empleado;
import Datos.D_Sucursal;
import Datos.D_Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class N_Empleado {
    private Conexion mysql = new Conexion();
    private Connection conect = mysql.Conectar();
    private String Sql="";
    
    public DefaultTableModel Lista(String busqueda){
       DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdEmpleado");
        modelo.addColumn("IdUsuario");
        modelo.addColumn("IdSucursal");
        modelo.addColumn("Area");
        
        if(busqueda.equals("")){
            Sql="SELECT * FROM tb_empleado";
        }else{
            Sql="SELECT * FROM tb_empleado WHERE IdEmpleado LIKE '" + busqueda + "%'";
        }
        
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
                Object registro[]={rs.getString(1),rs.getString(2),
                           rs.getString(3), rs.getString(4)};
            modelo.addRow(registro);
            }
            return modelo;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }             
    }
     
     public boolean agregar(D_Empleado datos){
        Sql = "INSERT INTO tb_empleado (IdUsuario,IdSucursal,AreaEmpleado) VALUES(?,?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdUsuario()); 
            pst.setInt(2,datos.getIdSucursal());
            pst.setString(3,datos.getArea());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al agregar datos " + e);
            return false;
        } 
    }
    
    public boolean editar(D_Empleado datos){
        Sql = "UPDATE tb_empleado SET IdUsuario=?, IdSucursal=?, AreaEmpleado=? WHERE IdEmpleado=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdUsuario()); 
            pst.setInt(2,datos.getIdSucursal());
            pst.setString(3,datos.getArea());
            
            pst.setInt(4,datos.getIdEmpleado());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar datos " + e);
            return false;
        } 
    }
    
    public boolean eliminar(D_Empleado datos){
        Sql = "DELETE FROM tb_empleado WHERE IdEmpleado=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdSucursal());

            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar datos " + e);
            return false;
        } 
    }
    
    public  ArrayList llenarCombo(){
        ArrayList lista = new  ArrayList();
        Sql ="SELECT * FROM tb_Usuario Where EstadoUsuario=true and NivelUsuario=2";
        try{
            
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
               lista.add(rs.getString("IdUsuario"));
            }
                            
        }catch(SQLException e){          
            JOptionPane.showMessageDialog(null,e);
        }
        return lista;
    }
    
    
    public  ArrayList IdSucursal(){
        ArrayList lista = new  ArrayList();
        Sql ="SELECT * FROM tb_sucursal ";
        try{
            
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
             while(rs.next()){
                lista.add(rs.getString("IdSucursal"));
             }
                            
        }catch(SQLException e){          
            JOptionPane.showMessageDialog(null,e);
        }
        return lista;
    }
    
    public void EmpleadoLogin(){
        Sql ="SELECT IdEmpleado FROM tb_empleado WHERE IdUsuario="+D_Usuario.LIdUsuario;
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
                D_Empleado.LIdEmpleado = rs.getInt("IdEmpleado");
            }
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al identificar empleado. " + e);
        }
    }
}
