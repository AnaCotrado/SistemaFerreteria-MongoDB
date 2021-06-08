
package Datos;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author analu
 */
public class D_Kardex {
    private int IdKardex;
    private int IdProducto;
    private int IdEmpleado;
    private Date FechaHora;
    private int Cantidad;
    private boolean Tipo;

    public int getIdKardex() {
        return IdKardex;
    }

    public void setIdKardex(int IdKardex) {
        this.IdKardex = IdKardex;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public Date getFechaHora() {
        DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        String outputString = outputFormat.format(FechaHora);
        return FechaHora;
    }

    public void setFechaHora(Date FechaHora) {
        this.FechaHora = FechaHora;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public boolean isTipo() {
        return Tipo;
    }

    public void setTipo(boolean Tipo) {
        this.Tipo = Tipo;
    }

    public D_Kardex() {
        this.FechaHora = new Date(System.currentTimeMillis());
    }
    
}
