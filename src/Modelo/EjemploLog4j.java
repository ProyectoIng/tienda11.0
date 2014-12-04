/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;


/**
 *
 * @author luis
 */
public class EjemploLog4j {
    
    
  
private final static Logger log = Logger.getLogger(EjemploLog4j.class);

public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
 
        log.warn("un warning");
        log.error("un error");
    }


}
