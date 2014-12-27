package Modelo;


public class Usuario {
    
    

    private String nombre;
    private String apellido;
    private String cedula;
    private String username;
    private String password;
    private String correo;
    private String direccionFisica;
    private String fechaDeNacimiento;
    private String metodoDePago;
    //private CestaDeCompras cesta;
    private String fechaDeRegistro;
    private String rol;//administrador(1)/usuario(2)/inventario(3)
    private String idUsuario;//codigo unico para cada usuario
    private String estadoUsuario;//activo(1) o inactivo(0)

    public Usuario(String nombre, String apellido, String cedula, String username, String password, String correo, String direccionFisica, String fechaDeNacimiento, String metodoDePago, String fechaDeRegistro, String rol, String idUsuario, String estadoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.direccionFisica = direccionFisica;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.metodoDePago = metodoDePago;
        this.fechaDeRegistro = fechaDeRegistro;
        this.rol = rol;
        this.idUsuario = idUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    
    

    
    
    
    
    
    
}
