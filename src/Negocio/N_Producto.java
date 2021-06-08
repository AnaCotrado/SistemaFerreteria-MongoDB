
package Negocio;

import Conexion.Conexion;
import Datos.D_Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class N_Producto {
    private Conexion mysql = new Conexion();
    private Connection conect = mysql.Conectar();
    private String Sql="";
    
    public DefaultTableModel Lista(String busqueda){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdProducto");
        modelo.addColumn("Nombre");
        modelo.addColumn("IdCategoria");
        modelo.addColumn("IdSucursal");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        
        if(busqueda.equals("")){
            Sql="SELECT * FROM tb_producto";
        }else{
            Sql="SELECT * FROM tb_producto WHERE NombreProducto LIKE '" + busqueda + "%'";
        }
        
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
                Object registro[]={rs.getString(1),rs.getString(2),
                            rs.getString(3),rs.getString(4),rs.getString(5),
                            rs.getString(6),rs.getString(7)};
            modelo.addRow(registro);
            }
            return modelo;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }  
    }
    
    public D_Producto Producto(int id){
        D_Producto prod = new D_Producto();
        Sql="SELECT * FROM tb_producto WHERE IdProducto="+id;
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
                prod.setIdProducto(Integer.parseInt(rs.getString(1)));
                prod.setNombre(rs.getString(2));
                prod.setIdCategoria(Integer.parseInt(rs.getString(3)));
                prod.setIdSucursal(Integer.parseInt(rs.getString(4)));
                prod.setStock(Integer.parseInt(rs.getString(5)));
            }
            return prod;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }  
    }
    
    public boolean agregar(D_Producto datos){
        Sql = "INSERT INTO tb_producto(NombreProducto,IdCategoria,IdSucursal,StockProducto,PrecioProducto,DescripcionProducto) VALUES(?,?,?,?,?,?)";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setString(1,datos.getNombre());
            pst.setInt(2,datos.getIdCategoria());
            pst.setInt(3, datos.getIdSucursal());
            pst.setInt(4, datos.getStock());
            pst.setDouble(5, datos.getPrecio());
            pst.setString(6, datos.getDescripcion());
            
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al agregar datos " + e);
            return false;
        }
    }
    
    public boolean editar(D_Producto datos){
        Sql = "UPDATE tb_producto SET NombreProducto=?, IdCategoria=?, IdSucursal=?, StockProducto=?, PrecioProducto=?, DescripcionProducto=? WHERE IdProducto=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            
            pst.setString(1, datos.getNombre());
            pst.setInt(2, datos.getIdCategoria());
            pst.setInt(3, datos.getIdSucursal());
            pst.setInt(4, datos.getStock());
            pst.setDouble(5, datos.getPrecio());
            pst.setString(6, datos.getDescripcion());
            
            pst.setInt(7,datos.getIdProducto());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar datos " + e);
            return false;
        } 
    }
    
    public boolean eliminar(D_Producto datos){
        Sql = "DELETE FROM tb_producto WHERE IdProducto=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            pst.setInt(1,datos.getIdProducto());

            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al eliminar datos " + e);
            return false;
        } 
    }
    
    public  ArrayList llenarCombo1(){
        ArrayList lista = new  ArrayList();
        Sql ="SELECT * FROM tb_categoria";
        try{
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            
            while(rs.next()){
               lista.add(rs.getString("IdCategoria"));
            }       
        }catch(SQLException e){          
            JOptionPane.showMessageDialog(null,e);
        }
        return lista;
    } 
    
    public  ArrayList llenarCombo2(){
        ArrayList lista = new  ArrayList();
        Sql ="SELECT * FROM tb_sucursal";
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
    
    public boolean actualizarStock(D_Producto datos){
        Sql = "UPDATE tb_producto SET StockProducto=? WHERE IdProducto=?";
        
        try{
            PreparedStatement pst = conect.prepareStatement(Sql);
            pst.setInt(1, datos.getStock());
            
            pst.setInt(2,datos.getIdProducto());
            int n = pst.executeUpdate();
            return n!=0;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al editar el stock " + e);
            return false;
        } 
    }
    
}
