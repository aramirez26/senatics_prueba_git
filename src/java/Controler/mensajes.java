/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Antonio Ramirez
 */
public class mensajes extends HttpServlet implements Serializable{

    
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String tag1, tag2;
            tag1 = "<tr><td>";
            tag2 = "</td></tr>";
            String mensajelocal = "hola" ;
            mensajes2 mensaje = new mensajes2(tag1 + mensajelocal + tag2, "error");
            response.getWriter().print(mensaje.generarRespuesta());
        }  
    
        public static void main(String[] args){
            String a = new String("hola");
        }
    }

                
    

