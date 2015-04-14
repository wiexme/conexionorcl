/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionorcl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alumno04
 */
public class Conexionorcl {
    
    
    public Connection AbrirConexion(){
         Connection cn = conexionDB.conectar();
         return cn;
    }
    
    public static void main(String[] args) {
                
        Conexionorcl co = new Conexionorcl();
//        if (conexionDB.conectar()==null) {
//            System.out.println("La conexion fallo...");   
//        } else {
//            System.out.println("La conexion es exitosa...");
//        }
        
        //METODO QUE INSERTA UN REGISTRO EN LA DB
        //co.insert();
        
        //METODO QUE MUESTRA UN REGISTRO EN LA DB
        co.Select();
       
        //METODO QUE ELIMINA REGISTRO MEDIANTE UN ID
        //co.Delete(1);
        
        //METODO QUE MODIFICA EL REGISTRO
        //co.Update(2, "Juan", "Saldaña", "Lopez", 77654565);
    }
    
    public void insert(){
        Statement st = null;
        String query = "INSERT INTO persona VALUES(2,'Robert','Amasifen','Gomez',77736363)";
        
        try {
            st=AbrirConexion().createStatement();
            st.executeUpdate(query);
            AbrirConexion().commit();
            AbrirConexion().close();
            System.out.println("Se inserto satisfactoriamente...");
        } catch (Exception e) {
            try {
            AbrirConexion().rollback();
            AbrirConexion().close();
            } catch (Exception x) {
                e.printStackTrace();
            }
            
            
        }
    }
    
    public void  Select(){
        Statement st = null;
        ResultSet rs = null;
        String query = "SELECT * fROM persona";
        
        try {
            st = AbrirConexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) { 
                System.out.println("ID: "+rs.getInt("idpersona")+", NOMBRE: "+rs.getString("nombre")+
                        ", APELIDO_PAT: "+rs.getString("apellido_pat")+", APELIDO_MAT: "+rs.getString("apellido_mat")+
                        ", DNI: "+rs.getInt("dni"));
                
            }
            AbrirConexion().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
        
    }
    
    public void Delete(int id){
        Statement st = null;
        String query = "DELETE FROM persona WHERE idpersona="+id;
        try {
            st = AbrirConexion().createStatement();
            st.executeUpdate(query);
            AbrirConexion().commit();
            AbrirConexion().close();
            System.out.println("Se elimino satisfactoria...");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().rollback();
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
    public void Update(int id, String nombre, String apellido_pat, String apellido_mat, int dni){
        Statement st = null;
        String query = "UPDATE persona SET nombre='"+nombre+"', apellido_pat='"+apellido_pat+"', apellido_mat='"+
                apellido_mat+"', dni="+dni+" WHERE idpersona="+id;
        try {
            st = AbrirConexion().createStatement();
            st.executeQuery(query);
            AbrirConexion().commit();
            AbrirConexion().close();
            System.out.println("Se modifico la tabla persona...");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AbrirConexion().rollback();
                AbrirConexion().close();
            } catch (Exception ex) {
            }
        }
    }
}
