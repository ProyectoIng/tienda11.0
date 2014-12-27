

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
public class DaoUsuarioXml {
    
    private Element root;//Creo el elemento raíz
   
    private String fileLocation = "src//BaseDatos//UsuariosXML.xml";//Le asigno una ruta al archivo XML de los usuarios
    
    private Element UsuarioXmlElement(Usuario nUsuario){//Elemento XML dentro del cual van a estar todos los demás del usuario
    
    Element UsuarioTrans = new Element("Usuario");//Aquí dentro van a estar los atributos del usuario
    //De aquí para abajo están todos los atributos del usuario
    Element nombre = new Element("Nombre");
    Element apellido = new Element("Apellido");
    Element cedula = new Element("Cedula");
    Element username = new Element("Username");
    Element password = new Element("Password");
    Element correo = new Element("Correo");
    Element direccionFisica = new Element("DireccionFisica");
    Element fechaDeNacimiento = new Element("FechaDeNacimiento");
    Element metodoDePago = new Element("MetodoDePago");
    //Element cesta = new Element("Cesta");
    Element fechaDeRegistro = new Element("FechaDeRegistro");
    Element rol = new Element("Rol") {};
    Element id = new Element("Id");
    Element estadoDeUsuario = new Element("EstadoDeUsuario");
    
    //Aquí le asigno los valores de cada atributo al usuario
    nombre.setText(nUsuario.getNombre());
    apellido.setText(nUsuario.getApellido());
    cedula.setText(nUsuario.getCedula());
    username.setText(nUsuario.getUsername());
    password.setText(nUsuario.getPassword());
    correo.setText(nUsuario.getCorreo());
    direccionFisica.setText(nUsuario.getDireccionFisica());
    fechaDeNacimiento.setText(nUsuario.getFechaDeNacimiento());
    metodoDePago.setText(nUsuario.getMetodoDePago());
    //Aqui iría cesta
    fechaDeRegistro.setText(nUsuario.getFechaDeRegistro());
    rol.setText(nUsuario.getRol());
    id.setText(nUsuario.getIdUsuario());
    estadoDeUsuario.setText(nUsuario.getEstadoUsuario());
    
    //Luego paso todos los datos a usuariotrans
    UsuarioTrans.addContent(nombre);
    UsuarioTrans.addContent(apellido);
    UsuarioTrans.addContent(cedula);
    UsuarioTrans.addContent(username);
    UsuarioTrans.addContent(password);
    UsuarioTrans.addContent(correo);
    UsuarioTrans.addContent(direccionFisica);
    UsuarioTrans.addContent(fechaDeNacimiento);
    UsuarioTrans.addContent(metodoDePago);
    UsuarioTrans.addContent(fechaDeRegistro);
    UsuarioTrans.addContent(rol);
    UsuarioTrans.addContent(id);
    UsuarioTrans.addContent(estadoDeUsuario);
    
    return UsuarioTrans;
    
    
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
    
    
    public boolean agregarUsuario(Usuario nUsuario) {
        boolean resultado = false;
        root.addContent(UsuarioXmlElement((Usuario) nUsuario));
        resultado = updateDocument();
        return resultado;
    }
    
    public DaoUsuarioXml() {
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
    
    private Usuario UsuarioToObject(Element element) throws ParseException {
        Usuario nUsuario = new Usuario(element.getChildText("Nombre"),element.getChildText("Apellido"),element.getChildText("Cedula"),element.getChildText("Username"),element.getChildText("Password"),element.getChildText("Correo"),element.getChildText("DireccionFisica"),element.getChildText("FechaDeNacimiento"),element.getChildText("MetodoDePago"),element.getChildText("FechaDeRegistro"),element.getChildText("Rol"),element.getChildText("Id"),element.getChildText("EstadoDeUsuario"));
        return nUsuario;
    }
    
    public boolean borrarUsuario(String identificador) {
        boolean resultado = false;
        Element aux = new Element("Usuarios");
        List Usuarios = this.root.getChildren();
        while (aux != null) {
            aux = DaoUsuarioXml.buscar(Usuarios, identificador);
            if (aux != null) {
                Usuarios.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    
    public boolean actualizarUsuario(Usuario nUsuario) {
        boolean resultado = false;
        Element aux = new Element("Usuario");
        List Usuarios = this.root.getChildren();
        while (aux != null) {
            aux = DaoUsuarioXml.buscar(Usuarios, nUsuario.getIdUsuario());
            if (aux != null) {
                Usuarios.remove(aux);
                resultado = updateDocument();
            }
        }
        System.out.println(resultado);
        agregarUsuario(nUsuario);
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
    
    public  Element buscarUnId(List raiz) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (e.getChild("Id").getText()!="") {
                System.out.println("encontre");
                return e.getChild("Id");
            }
        }
        return null;
    }
    
   
    
    public static Element buscarPorUsername(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Username").getText())) {
                System.out.println("encontre");
                return e;
            }
        }
        return null;
    }
    
    //Esto es lo que uso para iniciar sesion
    
    public static Element buscarPorEstado(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("EstadoDeUsuario").getText())) {
                System.out.println("encontre");
                return e;
            }
        }
        return null;
    }
 
     
    
     
    public Usuario buscarUsuario(String Identificador) {
        Element aux = new Element("Usuario");
        List Usuarios = this.root.getChildren();
        while (aux != null) {
            aux = DaoUsuarioXml.buscar(Usuarios,Identificador);
            if (aux != null) {
                try {
                    return UsuarioToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
       public Usuario buscarUsername(String Username) {
        Element aux = new Element("Username");
        List Usuarios = this.root.getChildren();
        while (aux != null) {
            aux = DaoUsuarioXml.buscarPorUsername(Usuarios,Username);
            if (aux != null) {
                try {
                    return UsuarioToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
       
       public Usuario buscarEstado(String Estado) {
        Element aux = new Element("EstadoDeUsuario");
        List Usuarios = this.root.getChildren();
        while (aux != null) {
            aux = DaoUsuarioXml.buscarPorEstado(Usuarios,Estado);
            if (aux != null) {
                try {
                    return UsuarioToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    
    public ArrayList<Usuario> todosLosUsuarios() {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(UsuarioToObject(xmlElem));
                
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }


    
    
    
    
}
