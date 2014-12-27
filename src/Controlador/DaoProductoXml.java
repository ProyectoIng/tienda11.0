package Controlador;

import Modelo.*;
import java.io.File;
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
    Element descripcion = new Element("Descripcion");
    Element precio = new Element("Precio");
    Element imagen = new Element("Imagen");
    Element categoria = new Element("Categoria");
    Element proveedor = new Element("Proveedor");
    Element idProducto = new Element("Id");
    Element estadoPoducto = new Element("Estado");
    Element cantidadMinima = new Element("CantidadMinima");
    Element cantidadActual = new Element("CantidadActual");
    
    
    //Aquí le asigno los valores de cada atributo al producto
    nombre.setText(nProducto.getNombre());
    descripcion.setText(nProducto.getDescripcion());
    precio.setText(nProducto.getPrecio());
    imagen.setText(nProducto.getImagen());
    categoria.setText(nProducto.getCategoria());
    proveedor.setText(nProducto.getProveedor());
    idProducto.setText(nProducto.getIdProducto());
    estadoPoducto.setText(nProducto.getEstadoProducto());
    cantidadMinima.setText(nProducto.getCantidadMinima());
    cantidadActual.setText(nProducto.getCantidadActual());
    
    
    //Luego paso todos los datos a ProductoTrans
    ProductoTrans.addContent(nombre);
    ProductoTrans.addContent(descripcion);
    ProductoTrans.addContent(precio);
    ProductoTrans.addContent(imagen);
    ProductoTrans.addContent(categoria);
    ProductoTrans.addContent(proveedor);
    ProductoTrans.addContent(idProducto);
    ProductoTrans.addContent(estadoPoducto);
    ProductoTrans.addContent(cantidadMinima);
    ProductoTrans.addContent(cantidadActual);
    
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
        Producto nProducto = new Producto(element.getChildText("Nombre"),element.getChildText("Descripcion"),element.getChildText("Precio"),element.getChildText("Imagen"),element.getChildText("Categoria"),element.getChildText("Proveedor"),element.getChildText("Id"),element.getChildText("Estado"),element.getChildText("CantidadMinima"),element.getChildText("CantidadActual"));
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


    public void cargarXml()
{
    //Se crea un SAXBuilder para poder parsear el archivo
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File( "src//BaseDatos//ProductosXML.xml" );
    try
    {
        //Se crea el documento a traves del archivo
        Document document = (Document) builder.build( xmlFile );
 
        //Se obtiene la raiz 'tables'
        Element rootNode = document.getRootElement();
 
        //Se obtiene la lista de hijos de la raiz 'tables'
        List list = rootNode.getChildren( "Producto" );
 
        //Se recorre la lista de hijos de 'tables'
        for ( int i = 0; i < list.size(); i++ )
        {
            //Se obtiene el elemento 'tabla'
            Element tabla = (Element) list.get(i);
 
            //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
            String nombreTabla = tabla.getAttributeValue("Nombre");
 
            System.out.println( "Nombre: " + nombreTabla );
 
            //Se obtiene la lista de hijos del tag 'tabla'
            List lista_campos = tabla.getChildren();
 
            System.out.println( "\tNombre\t\tTipo\t\tValor" );
 
            //Se recorre la lista de campos
            for ( int j = 0; j < lista_campos.size(); j++ )
            {
                //Se obtiene el elemento 'campo'
                Element campo = (Element)lista_campos.get( j );
         
                //Se obtienen los valores que estan entre los tags '<campo></campo>'
                //Se obtiene el valor que esta entre los tags '<nombre></nombre>'
                String nombre = campo.getChildTextTrim("nombre");
 
                //Se obtiene el valor que esta entre los tags '<tipo></tipo>'
                String tipo = campo.getChildTextTrim("tipo");
 
                //Se obtiene el valor que esta entre los tags '<valor></valor>'
                String valor = campo.getChildTextTrim("valor");
 
                System.out.println( "\t"+nombre+"\t\t"+tipo+"\t\t"+valor);
            }
        }
    }catch ( IOException io ) {
        System.out.println( io.getMessage() );
    }catch ( JDOMException jdomex ) {
        System.out.println( jdomex.getMessage() );
    }
}
    
    
    
}