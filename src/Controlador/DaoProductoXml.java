package Controlador;

import Modelo.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author luis
 */
public class DaoProductoXml {
    
    private Element root;//Creo el elemento raíz
   
    private String fileLocation = "src//BaseDatos//ProductosXML.xml";//Le asigno una ruta al archivo XML de los productos
    
    private Element ProductoXmlElement(Producto nProducto){//Elemento XML dentro del cual van a estar todos los demás del producto
    
    Element ProductoTrans = new Element("Producto");//Aquí dentro van a estar los atributos del producto
    //De aquí para abajo están todos los atributos del Producto
    Element nombre = new Element("Nombre");
    Element seo = new Element("Seo");
    Element descripcion = new Element("Descripcion");
    Element precio = new Element("Precio");
    Element imagen = new Element("Imagen");
    Element idProducto = new Element("Id");
    Element estadoPoducto = new Element("Estado");
    
    
    //Aquí le asigno los valores de cada atributo al producto
    nombre.setText(nProducto.getNombre());
    seo.setText(nProducto.getSeo());
    descripcion.setText(nProducto.getDescripcion());
    precio.setText(nProducto.getPrecio());
    imagen.setText(nProducto.getImagen());
    idProducto.setText(nProducto.getIdProducto());
    estadoPoducto.setText(nProducto.getEstadoProducto());
    
    
    //Luego paso todos los datos a ProductoTrans
    ProductoTrans.addContent(nombre);
    ProductoTrans.addContent(seo);
    ProductoTrans.addContent(descripcion);
    ProductoTrans.addContent(precio);
    ProductoTrans.addContent(imagen);
    ProductoTrans.addContent(idProducto);
    ProductoTrans.addContent(estadoPoducto);
    
    return ProductoTrans;
    
    
    }
    
    
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean agregarProducto(Producto nProducto) {
        boolean resultado = false;
        root.addContent(ProductoXmlElement((Producto) nProducto));
        resultado = updateDocument();
        return resultado;
    }
    
    public DaoProductoXml() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }
    
    private Producto ProductoToObject(Element element) throws ParseException {
        Producto nProducto = new Producto(element.getChildText("Nombre"),element.getChildText("Seo"),element.getChildText("Descripcion"),element.getChildText("Precio"),element.getChildText("Imagen"),element.getChildText("Id"),element.getChildText("Estado"));
        return nProducto;
    }
    
    public boolean borrarProducto(String identificador) {
        boolean resultado = false;
        Element aux = new Element("Producto");
        List Productos = this.root.getChildren();
        while (aux != null) {
            aux = DaoProductoXml.buscar(Productos, identificador);
            if (aux != null) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
    public boolean actualizarProducto(Producto nProducto) {
        boolean resultado = false;
        Element aux = new Element("Producto");
        List Productos = this.root.getChildren();
        while (aux != null) {
            aux = DaoProductoXml.buscar(Productos, nProducto.getIdProducto());
            if (aux != null) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        System.out.println(resultado);
        agregarProducto(nProducto);
        System.out.println(resultado);
        return resultado;
    }
    
    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Id").getText())) {
                System.out.println("encontre");
                return e;
            }
        }
        return null;
    }
    
    public Producto buscarProducto(String Identificador) {
        Element aux = new Element("Producto");
        List Productos = this.root.getChildren();
        while (aux != null) {
            aux = DaoProductoXml.buscar(Productos,Identificador);
            if (aux != null) {
                try {
                    return ProductoToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public ArrayList<Producto> todosLosProductos() {
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(ProductoToObject(xmlElem));
                
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }


    
    
    
    
}