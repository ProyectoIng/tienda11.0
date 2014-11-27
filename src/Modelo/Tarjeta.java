package Modelo;


public class Tarjeta {
    
    private String numero;
    private String fechaDeVencimiento;
    private String codigo;
    private String marca;

    public Tarjeta(String numero, String fechaDeVencimiento, String codigo, String marca) {
        this.numero = numero;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.codigo = codigo;
        this.marca = marca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    
    
    
    
    
    
    
}

