/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

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
public class mensajes2Test {
    
    @Test
    public void mensajes2Test() {
        System.out.println("getTipo");
        mensajes2 instance = new mensajes2("hola","hola");
        String expResult = "hola";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        mensajes2 instance = new mensajes2("hola","hola");
        String expResult = "hola";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "hola";
        mensajes2 instance = new mensajes2("hola","hola");
        instance.setTipo(tipo);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetMensaje() {
        System.out.println("getMensaje");
        mensajes2 instance = new mensajes2("hola","hola");
        String expResult = "hola";
        String result = instance.getMensaje();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetMensaje() {
        System.out.println("setMensaje");
        String mensaje = "hola";
        mensajes2 instance = new mensajes2("hola","hola");
        instance.setMensaje(mensaje);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGenerarRespuesta() {
        System.out.println("generarRespuesta");
        mensajes2 instance = new mensajes2("hola","hola");
        String expResult = "hola";
        String result = instance.mensaje;
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
}
