/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
 
public class Conexion implements Serializable {
 
    private Connection conexionn=null;
    private String servidor="";
    private String database="";
    private String usuario="";
    private String password="";
    private String url="";

    public Conexion(String usuario, String password){
        try {
            this.servidor = "192.168.222.150:5433";
            this.database = "db_aut";
 
            Class.forName("org.postgresql.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            DriverManager.registerDriver(new org.postgresql.Driver());
            url="jdbc:postgresql://"+servidor+"/"+database;
            this.conexionn=DriverManager.getConnection(url, usuario, password);
            
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public Connection getConexionn() {
        return this.conexionn;
    }
 
    public Connection cerrarConexion(){
        try {
            conexionn.close();
             System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexionn=null;
        return conexionn;
    }
    
     /*public static void main (String [ ] args) {
 
        //Aquí las instrucciones de inicio y control del programa
 
        System.out.println ("Empezamos la ejecución del programa");
        Conexion conect = new Conexion("postgres", "paraguay");
        
        
 
    }*/ //Cierre del main
}
