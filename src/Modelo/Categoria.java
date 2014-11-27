
package Modelo;


public class Categoria {
    
    private String nombre;
    private String idCategoria;

    public Categoria(String nombre, String idCategoria) {
        this.nombre = nombre;
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
}
