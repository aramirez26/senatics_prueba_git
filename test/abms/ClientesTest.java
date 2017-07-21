/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abms;

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
public class ClientesTest {
    
    public ClientesTest() {
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
    public void testGetId() {
        System.out.println("getId");
        Clientes instance = new Clientes();
        int expResult = instance.id = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Clientes instance = new Clientes();
        instance.setId(id);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetCi() {
        System.out.println("getCi");
        Clientes instance = new Clientes();
        int expResult = instance.ci = 1;
        int result = instance.getCi();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetCi() {
        System.out.println("setCi");
        int ci = 0;
        Clientes instance = new Clientes();
        instance.setCi(ci);
        //fail("The test case is a prototype.");
    }

//    @Test
//    public void testGetNombre() {
//        System.out.println("getNombre");
//        Clientes instance = new Clientes();
//        String expResult = instance.nombre = "Rogelio";
//        String result = instance.getNombre();
//        assertEquals(expResult, result);
//        //fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testSetNombre() {
//        System.out.println("setNombre");
//        String nombre = "";
//        Clientes instance = new Clientes();
//        instance.setNombre(nombre);
//        //fail("The test case is a prototype.");
//    }
    
}
