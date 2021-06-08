package Negocio;

import Conexion.Conexion;
import Datos.D_Administrador;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class N_Administrador extends N_Usuario{
    static Conexion mysql = new Conexion();
    private Connection conect;
    private String Sql="";

    public N_Administrador() {
        this.conect = mysql.Conectar();
    }
    
    public DefaultTableModel Lista(String busqueda){
       DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdAdministrador");
        modelo.addColumn("IdUsuario");
        modelo.addColumn("Cargo");

        if(busqueda.equals("")){
            Sql="SELECT * FROM tb_administrador";
        }else{
            Sql="SELECT * FROM tb_administrador WHERE IdAdministrador LIKE '" + busqueda + "%'";
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
    
     public boolean agregar(D_Administrador datos){
        Sql = "INSERT INTO tb_administrador (IdUsuario, CargoAdministrador) "
                + "VALUES(?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdusuario());
            pst.setString(2,datos.getCargo());

            int n = pst.executeUpdate();
            return n!=0;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar datos " + e);
            return false;
        } 
    }
    
    public boolean editar(D_Administrador datos){
        Sql = "UPDATE tb_administrador SET IdUsuario=?, CargoAdministrador=?"
                + " WHERE IdAdministrador=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdusuario());
            pst.setString(2,datos.getCargo());
           
            pst.setInt(3,datos.getIdAdministrador());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar datos " + e);
            return false;
        } 
    }
    
    public boolean eliminar(D_Administrador datos){
        Sql = "DELETE FROM tb_administrador WHERE IdAdministrador=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setInt(1,datos.getIdAdministrador());

            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar datos " + e);
            return false;
        } 
    }
    
    public  ArrayList<String> llenarCombo(){
        ArrayList<String> lista = new  ArrayList<String>();
        Sql ="SELECT * FROM tb_usuario where EstadoUsuario=true and NivelUsuario=1";
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
}
