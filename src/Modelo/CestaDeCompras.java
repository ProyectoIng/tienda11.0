
package Modelo;

import java.util.ArrayList;


public class CestaDeCompras {
    
    private ArrayList<DetalleDeCompra> productosDeCesta;
    private String fechaCesta;
    private String comprador;
    private String idCesta;

    public CestaDeCompras(ArrayList<DetalleDeCompra> productosDeCesta, String fechaCesta, String comprador, String idCesta) {
        this.productosDeCesta = productosDeCesta;
        this.fechaCesta = fechaCesta;
        this.comprador = comprador;
        this.idCesta = idCesta;
    }

    public ArrayList<DetalleDeCompra> getProductosDeCesta() {
        return productosDeCesta;
    }

    public void setProductosDeCesta(ArrayList<DetalleDeCompra> productosDeCesta) {
        this.productosDeCesta = productosDeCesta;
    }

    public String getFechaCesta() {
        return fechaCesta;
    }

    public void setFechaCesta(String fechaCesta) {
        this.fechaCesta = fechaCesta;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getIdCesta() {
        return idCesta;
    }

    public void setIdCesta(String idCesta) {
        this.idCesta = idCesta;
    }

    
    
    
    
    
}
