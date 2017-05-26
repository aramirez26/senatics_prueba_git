/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Ramirez
 */
public class verificar_encoding {
    
    String a;
    
    
    public static String retornar_encoding() throws FileNotFoundException, UnsupportedEncodingException{
        
        File in =  new File("C:\\Users\\Antonio Ramirez\\Desktop\\archivos\\hola1.txt");
        InputStreamReader r = new InputStreamReader(new FileInputStream(in));
        System.out.println(r.getEncoding());
        return r.getEncoding();  
     }   
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
            String a = new String("hola");
            mensajes2 b = new mensajes2(retornar_encoding(), "Error");
    }
}
