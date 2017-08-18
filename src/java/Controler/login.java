/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Ramirez
 */
public class login extends HttpServlet implements Serializable {
    
    Conexion conn;
    public HttpSession sesion;

    public HttpSession getSesion() {
        return sesion;
    }
    
   //metodo encargado de la gestión del método POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String pantalla;
    pantalla = request.getParameter("pantalla");

        
    if ("menu".equals(pantalla)){
            sesion.invalidate();
            response.sendRedirect("index.jsp");
        } else {
            sesion = request.getSession();
            String usu, pass, usu2, pass2;

            usu = request.getParameter("user");
            pass = request.getParameter("password");
            
            usu2 = request.getParameter("user2");
            pass2 = request.getParameter("password2");
        
            //String servidor = "192.168.222.150:5433";
            //String database = "deb_aut";
            
            String servidor = "192.168.126.19:5432";
            String database = "senatics";

            String url="";  
        
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
            url="jdbc:postgresql://"+servidor+"/"+database;
            Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, "css", "css");
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if ("registro".equals(pantalla)){
                java.sql.Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario = '" + usu2 + "'");
            
                if (rs.next()) {
                    String tag1, tag2;
                    tag1 = "<tr><td>";
                    tag2 = "</td></tr>";
                    String mensajelocal = "El usuario ya existe. Utilice otro nombre de usuario." ;
                    mensajes2 mensaje = new mensajes2(tag1 + mensajelocal + tag2, "error");
                    response.getWriter().print(mensaje.generarRespuesta());
                    //redirijo a página con información de login exitoso
                }else{
                    java.sql.PreparedStatement st2 = conexion.prepareStatement(""
                    + "INSERT INTO usuario (usuario, pwd) "
                    + "VALUES (?,?)");

                        //se inicializan los parametros del sql
                    st2.setString(1, usu2);
                    st2.setString(2, pass2);

                        //}
                    st2.execute();
                          
                    
                    sesion.setAttribute("respuesta_registro", "Usuario Registrado Correctamente. Acceda al sistema con su usuario.");
                    response.sendRedirect("index.jsp");
                    
                    st2.close();  
                }
                
                rs.close();
                st.close();
            }else{
                java.sql.Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario = '" + usu + "' and pwd = '" + pass + "'");
            
                if (rs.next()&& sesion.getAttribute("usuario") == null) {

                    sesion.setAttribute("usuario", usu);
                    sesion.setMaxInactiveInterval(20);
                    //redirijo a página con información de login exitoso
                    response.sendRedirect("paginas/consultaClientes.jsp");
                }else{
                    mensajes2 mensaje = new mensajes2("Usuario o Contraseña inválidos.","error");
                    response.getWriter().print(mensaje.generarRespuesta());
                }
                st.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
 
   //método encargado de la gestión del método GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //me llega la url "proyecto/login/out"
        String action=(request.getPathInfo()!=null?request.getPathInfo():"");
        HttpSession sesion = request.getSession();
        if(action.equals("/out")){
            sesion.invalidate();
            response.sendRedirect("/home.jsp");
        }else{
 
        }
    }
}
