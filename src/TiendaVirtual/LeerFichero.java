/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TiendaVirtual;

import java.io.*;
import java.util.List;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

public class LeerFichero {
    
    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
    
    public String obtenerId(String archivo) throws FileNotFoundException, IOException{
        String id, cadena;
        cadena="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((id = b.readLine())!=null) {
            cadena = cadena + id;
        }
        b.close();
        
    return cadena;
    }
 
    
    
    
    
    public void cargarXml() throws JDOMException
{
    //Se crea un SAXBuilder para poder parsear el archivo
    SAXBuilder builder = new SAXBuilder();
    try
    {
        //Se crea el documento a traves del archivo
        Document document = (Document) builder.build("src//BaseDatos//UsuariosXML.xml");
 
        //Se obtiene la raiz 'tables'
        Element rootNode = document.getRootElement();
 
        //Se obtiene la lista de hijos de la raiz 'tables'
        List list = rootNode.getChildren( "Beta" );
 
        //Se recorre la lista de hijos de 'tables'
        for ( int i = 0; i < list.size(); i++ )
        {
            //Se obtiene el elemento 'tabla'
            Element tabla = (Element) list.get(i);
 
            //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
            String nombreTabla = tabla.getAttributeValue("Nombre");
 
            System.out.println( "Tabla: " + nombreTabla );
 
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
   

     
    
