package Negocio;

import Conexion.Conexion;
import Datos.D_Categoria;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class N_Categoria {
    private Conexion mysql = new Conexion();
    private Connection conect = mysql.Conectar();
    private String Sql="";
    
    public DefaultTableModel Lista(String busqueda){
       DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdCategoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        
        if(busqueda.equals("")){
            Sql="SELECT * FROM tb_categoria";
        }else{
            Sql="SELECT * FROM tb_categoria WHERE NombreCategoria LIKE '" + busqueda + "%'";
        }
        
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
                Object registro[]={rs.getString(1),rs.getString(2),
                           rs.getString(3)};
            modelo.addRow(registro);
            }
            return modelo;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }             
    }
    
    public boolean agregar(D_Categoria datos){
        Sql = "INSERT INTO tb_categoria (NombreCategoria,DescripcionCategoria) VALUES(?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setString(1,datos.getNombre());
            pst.setString(2,datos.getDescripcion());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar datos " + e);
            return false;
        } 
    }
    
    public boolean editar(D_Categoria datos){
        Sql = "UPDATE tb_categoria SET NombreCategoria=?, DescripcionCategoria=? WHERE IdCategoria=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setString(1,datos.getNombre());
            pst.setString(2,datos.getDescripcion());
            
            pst.setInt(3,datos.getIdCategoria());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar datos " + e);
            return false;
        } 
    }
    
    public boolean eliminar(D_Categoria datos){
        Sql = "DELETE FROM tb_categoria WHERE IdCategoria=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdCategoria());

            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar datos " + e);
            return false;
        } 
    }
}
