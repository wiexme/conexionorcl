/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coneccionoracle;

/**
 *
 * @author alumno04
 */
public class Conexion {
    public static Conexion conectar(){
     Conexion conexion=null;
        try {
            
        } catch (Exception e) {
        }
     finally{
            
        }
     Class.forName("oracle.jdbc.driver.OracleDriver");
     return conexion;
    }
    
    
    }
