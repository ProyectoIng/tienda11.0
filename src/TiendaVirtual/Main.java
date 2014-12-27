package TiendaVirtual;


import Controlador.*;
import  Modelo.*;
import Vista.PantallaInicialComprador;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.JDOMException;
/*import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



/**
 *
 * @author luis
 */
public class Main {
    
    static Usuario usuario; 

    public static void main(String[] args) throws IOException, JDOMException {
        
        
        DaoProductoXml datos = new DaoProductoXml();
        
        
        //instancio objetos de lectura y escritura de archivos
        LeerFichero leer =  new LeerFichero();
        EscribeFichero escribe = new EscribeFichero();
        
        //Los archivos que se instancian a continuación son para manejar los id 
        File archivoUsuario=new File("idUsuario.txt");//instacio mi archivo de Usuario
        File archivoProducto=new File("idProducto.txt");//instacio mi archivo de Producto
        File archivoCategoria=new File("idCategoria.txt");//instacio mi archivo de Categoria
        
        if(!archivoUsuario.exists()){  //si no existe mi archivo, lo creo
               archivoUsuario.createNewFile(); 
               escribe.Escribir("idUsuario.txt", "1");
           }  
        if(!archivoProducto.exists()){  //si no existe mi archivo, lo creo
               archivoProducto.createNewFile(); 
               escribe.Escribir("idProducto.txt", "1");
           } 
        if(!archivoCategoria.exists()){  //si no existe mi archivo, lo creo
               archivoCategoria.createNewFile();  
               escribe.Escribir("idCategoria.txt", "1");
           } 
       
        
        
        

        PantallaInicialComprador pantalla = new PantallaInicialComprador(usuario);
        pantalla.setVisible(true);
    }
        
    }
    
