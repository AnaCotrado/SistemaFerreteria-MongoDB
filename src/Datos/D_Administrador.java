package Datos;

public class D_Administrador{

    private int Idusuario;
    private int IdAdministrador;
    private String cargo;

    public D_Administrador() {
    }

    public D_Administrador(int Idusuario, int IdAdministrador, String cargo) {
        this.Idusuario = Idusuario;
        this.IdAdministrador = IdAdministrador;
        this.cargo = cargo;
    }

    public int getIdusuario() {
        return Idusuario;
    }

    public int getIdAdministrador() {
        return IdAdministrador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setIdusuario(int Idusuario) {
        this.Idusuario = Idusuario;
    }

    public void setIdAdministrador(int IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
