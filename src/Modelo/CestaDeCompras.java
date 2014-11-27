
package Modelo;

import java.util.ArrayList;


public class CestaDeCompras {
    
    private ArrayList<Producto> productosDeCesta;
    private String fechaCesta;
    private String idCesta;

    public CestaDeCompras(ArrayList<Producto> productosDeCesta, String fechaCesta, String idCesta) {
        this.productosDeCesta = productosDeCesta;
        this.fechaCesta = fechaCesta;
        this.idCesta = idCesta;
    }

    public ArrayList<Producto> getProductosDeCesta() {
        return productosDeCesta;
    }

    public void setProductosDeCesta(ArrayList<Producto> productosDeCesta) {
        this.productosDeCesta = productosDeCesta;
    }

    public String getFechaCesta() {
        return fechaCesta;
    }

    public void setFechaCesta(String fechaCesta) {
        this.fechaCesta = fechaCesta;
    }

    public String getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(String idCesta) {
        this.idCesta = idCesta;
    }
    
    
    
    
}
