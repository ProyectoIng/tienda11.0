

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
public class DaoCategoriaXml {
    
    private Element root;//Creo el elemento raíz
   
    private String fileLocation = "src//BaseDatos//CategoriasXML.xml";//Le asigno una ruta al archivo XML de los categorias
    
    
    private Element CategoriaXmlElement(Categoria nCategoria){//Elemento XML dentro del cual van a estar todos los demás del categoria
    
    Element CategoriaTrans = new Element("Categoria");//Aquí dentro van a estar los atributos del categoria
    //De aquí para abajo están todos los atributos de la categoria
    Element nombre = new Element("Nombre");
    Element idCategoria = new Element("Id");
    
    
    //Aquí le asigno los valores de cada atributo a la categoria
    nombre.setText(nCategoria.getNombre());
    idCategoria.setText(nCategoria.getIdCategoria());
    
    //Luego paso todos los datos a CategoriaTrans
    CategoriaTrans.addContent(nombre);
    CategoriaTrans.addContent(idCategoria);
    
    
    return CategoriaTrans;
    
    
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
    
    
    public boolean agregarCategoria(Categoria nCategoria) {
        boolean resultado = false;
        root.addContent(CategoriaXmlElement((Categoria) nCategoria));
        resultado = updateDocument();
        return resultado;
    }
    
    public DaoCategoriaXml() {
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
    
    private Categoria CategoriaToObject(Element element) throws ParseException {
        Categoria nCategoria = new Categoria(element.getChildText("Nombre"),element.getChildText("Id"));
        return nCategoria;
    }
    
    public boolean borrarCategoria(String identificador) {
        boolean resultado = false;
        Element aux = new Element("Categorias");
        List Categorias = this.root.getChildren();
        while (aux != null) {
            aux = DaoCategoriaXml.buscar(Categorias, identificador);
            if (aux != null) {
                Categorias.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
    public boolean actualizarCategoria(Categoria nCategoria) {
        boolean resultado = false;
        Element aux = new Element("Categoria");
        List Categorias = this.root.getChildren();
        while (aux != null) {
            aux = DaoCategoriaXml.buscar(Categorias, nCategoria.getIdCategoria());
            if (aux != null) {
                Categorias.remove(aux);
                resultado = updateDocument();
            }
        }
        System.out.println(resultado);
        agregarCategoria(nCategoria);
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
    
    public Categoria buscarCategoria(String Identificador) {
        Element aux = new Element("Categoria");
        List Categorias = this.root.getChildren();
        while (aux != null) {
            aux = DaoCategoriaXml.buscar(Categorias,Identificador);
            if (aux != null) {
                try {
                    return CategoriaToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public ArrayList<Categoria> todasLasCategorias() {
        ArrayList<Categoria> resultado = new ArrayList<Categoria>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(CategoriaToObject(xmlElem));
                
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
    
    
// |



}
