package Negocio;

import Conexion.Conexion;
import Datos.D_Sucursal;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class N_Sucursal {
    private Conexion mysql = new Conexion();
    private Connection conect = mysql.Conectar();
    private String Sql="";
    
    public DefaultTableModel Lista(String busqueda){
       DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdSucursal");
        modelo.addColumn("IdAdministrador");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dirección");
        
        if(busqueda.equals("")){
            Sql="SELECT * FROM tb_sucursal";
        }else{
            Sql="SELECT * FROM tb_sucursal WHERE NombreSucursal LIKE '" + busqueda + "%'";
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
     
     public boolean agregar(D_Sucursal datos){
        Sql = "INSERT INTO tb_sucursal (IdAdministrador,NombreSucursal,DireccionSucursal) VALUES(?,?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdAdministrador()); 
            pst.setString(2,datos.getNombre());
            pst.setString(3,datos.getDireccion());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar datos " + e);
            return false;
        } 
    }
    
    public boolean editar(D_Sucursal datos){
        Sql = "UPDATE tb_sucursal SET IdAdministrador=?, NombreSucursal=?, DireccionSucursal=? WHERE IdSucursal=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdAdministrador());
            pst.setString(2,datos.getNombre());
            pst.setString(3,datos.getDireccion());
            
            pst.setInt(4,datos.getIdSucursal());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar datos " + e);
            return false;
        } 
    }
    
    public boolean eliminar(D_Sucursal datos){
        Sql = "DELETE FROM tb_sucursal WHERE IdSucursal=?";
        
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
    
    public  ArrayList<String> llenarCombo(){
        ArrayList<String> lista = new  ArrayList<String>();
        Sql ="SELECT * FROM tb_Administrador";
        try{
            
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
             while(rs.next()){
                lista.add(rs.getString("IdAdministrador"));
             }
                               
        }catch(SQLException e){          
            JOptionPane.showMessageDialog(null,e);
        }
        return lista;
    } 
    
}
