package Datos;

public class D_Empleado {
    
    private int IdEmpleado;
    private int IdUsuario;
    private int IdSucursal;
    private String Area;
    
    public static int LIdEmpleado;

    public D_Empleado() {
    }

    public D_Empleado(int IdEmpleado, int IdUsuario, int IdSucursal, String Area) {
        this.IdEmpleado = IdEmpleado;
        this.IdUsuario = IdUsuario;
        this.IdSucursal = IdSucursal;
        this.Area = Area;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public String getArea() {
        return Area;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setIdSucursal(int IdSucursal) {
        this.IdSucursal = IdSucursal;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
        
}
