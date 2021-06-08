package Datos;

public class D_Sucursal {
    
    private int IdSucursal;
    private int IdAdministrador;
    private String nombre;
    private String Direccion;

    public D_Sucursal() {
    }

    public D_Sucursal(int IdSucursal, int IdAdministrador, String nombre, String Direccion) {
        this.IdSucursal = IdSucursal;
        this.IdAdministrador = IdAdministrador;
        this.nombre = nombre;
        this.Direccion = Direccion;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public int getIdAdministrador() {
        return IdAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public void setIdAdministrador(int IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
