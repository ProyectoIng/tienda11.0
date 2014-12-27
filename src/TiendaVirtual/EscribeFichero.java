

package TiendaVirtual;

import java.io.*;
import TiendaVirtual.*;


public class EscribeFichero
{
    public void Escribir(String archivo, String Contenido)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
 
            //Aqui escribo en el archivo
                
                
                 pw.println(Contenido);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
