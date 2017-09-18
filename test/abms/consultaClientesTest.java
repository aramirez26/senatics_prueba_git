/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio Ramirez
 */
public class consultaClientesTest {
    
    public consultaClientesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetClientes() throws ClassNotFoundException, SQLException {
        System.out.println("getClientes");
        
        String usu, pass;
 
        String servidor = "192.168.126.19:5432";
        String database = "senatics";
        
        //String servidor = "localhost:5432";
        //String database = "deb_aut_local";
          
        Class.forName("org.postgresql.Driver");
        String url="jdbc:postgresql://"+servidor+"/"+database;
        Connection conexion = null;
        //conexion = DriverManager.getConnection(url, "postgres", "paraguay");
        conexion = DriverManager.getConnection(url, "css", "css");
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery("select e.id, e.ci, e.nombre from clientes e order by e.nombre" );
        
        LinkedList<Clientes> expResult = new LinkedList<Clientes>();
        
         while (rs.next())
         {
            Clientes cliente = new Clientes();
            cliente.setId(rs.getInt("id"));
            cliente.setCi(rs.getInt("ci"));
            cliente.setNombre(rs.getString("nombre"));
            expResult.add(cliente);
         }
         
         rs.close();
         st.close();
         conexion.close();

        //LinkedList<Clientes> result = consultaClientes.getClientes();
        LinkedList<Clientes> result = new LinkedList<Clientes>();
        result = consultaClientes.getClientes();
        
        assertEquals(expResult.get(1).getId(), result.get(1).getId());
        //fail("The test case is a prototype.");
    }
    
}
