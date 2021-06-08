package Datos;

public class D_Usuario {
    private int IdUsuario;
    private String dni;
    private String nombre;
    private String apellido;
    private String Login;
    private String password;
    private int nivelUsuario;
    private boolean estado;
    
    public static int LIdUsuario;
    public static String Lnombre;
    public static String Lapellido;
    public static int LnivelUsuario;

    public D_Usuario() {
    }
    
    public D_Usuario( String Login, String password) {
        this.Login = Login;
        this.password = password;
    }
    
    public D_Usuario(int IdUsuario, String dni, String nombre, String apellido, String Login, String password, int nivelUsuario, boolean estado) {
        this.IdUsuario = IdUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Login = Login;
        this.password = password;
        this.nivelUsuario = nivelUsuario;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return password;
    }

    public int getNivelUsuario() {
        return nivelUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNivelUsuario(int nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
