/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abms;

/**
 *
 * @author Antonio Ramirez
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class consultaClientes implements Serializable
        
{
   public static LinkedList<Clientes> getClientes()
   {

    
      String usu, pass;
       
      LinkedList<Clientes> listaClientes=new LinkedList<Clientes>();
      try
      {
        String servidor = "192.168.126.19:5432";
        String database = "senatics";
        
        //String servidor = "localhost:5432";
        //String database = "deb_aut_local";
          
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://"+servidor+"/"+database;
        Connection conexion = null;
        conexion = DriverManager.getConnection(url, "css", "css");
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("select e.id, e.ci, e.nombre from clientes e order by e.nombre" );
        
         while (rs.next())
         {
            Clientes cliente = new Clientes();
            cliente.setId(rs.getInt("id"));
            cliente.setCi(rs.getInt("ci"));
            cliente.setNombre(rs.getString("nombre"));
            listaClientes.add(cliente);
         }
         rs.close();
         st.close();
         conexion.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return listaClientes;
   }
} 