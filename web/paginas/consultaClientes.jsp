<%-- 
    Document   : consultaClientes
    Created on : Dec 19, 2016, 11:02:00 AM
    Author     : Antonio Ramirez
--%>
<%@page import="abms.Clientes"%>
<!DOCTYPE html>
<%@page import="abms.consultaClientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ page import = "java.util.LinkedList"%> 
<html>
<body>
<div class="sesionn">
    <big>Clientes</big></big>
<hr style="width: 100%; height: 2px;">
<form method="post" action="../login" name="cerrarSesion">    
<table style="text-align: left; width: 75%"
  cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="text-align: left; width: 60%"><big
          style="font-weight: bold; font-style: italic; color: rgb(153, 0, 0);"></td>
      <td></td>
    </tr>
    <tr>
      <td></td>
      <td style="text-align: right; ">
          <a href=editarClientes.jsp?Idtext=&citext=&nombretext=&operacion=Agregar">Agregar Cliente</a>
      </td>
      <td style="text-align: right; ">
          <input style="display: none; text-align: right;"
            name="pantalla" value="menu"><button
            style="width: 60%; height: 25px;" value="Cerrar Sesion"
            name="cerrarSesion">Cerrar Sesión</button>
      </td>
    </tr>
  </tbody>
</table>
<br> 
<table Id="tabla" style="width: 80%">
    <tr>
      <td
 style="text-align: center; font-weight: bold; font-style: italic; background-color: rgb(255, 255, 204); border: 1">Id</td>
      <td
 style="text-align: center; font-weight: bold; font-style: italic; background-color: rgb(255, 255, 204)">Ci</td>
      <td
 style="text-align: center; font-weight: bold; font-style: italic; width: 60%; background-color: rgb(255, 255, 204)">Nombre</td>
      <td
 style="text-align: center; font-weight: bold; font-style: italic; width: 40%; background-color: rgb(255, 255, 204)"></td>
      <td
 style="text-align: center; font-weight: bold; font-style: italic; width: 40%; background-color: rgb(255, 255, 204)"></td>

      <td style="display:none"></td>
      <td style="display:none"></td>      
      <td style="display:none"></td>
      <td style="display:none"></td>
      <td style="display:none"></td>
    </tr> 

<%
    HttpSession sesion=request.getSession();

    if ((sesion.getAttribute("usuario")==null)==true) {
        response.sendRedirect("../index.jsp");
    } else {  
           LinkedList<Clientes> lista = consultaClientes.getClientes();
           for (int i=0;i<lista.size();i++)
           {
              if (i % 2 != 0) {
                //out.println("<tr BGCOLOR=\"#E0F8F7\" title=" + "\"" + i + "\"" + "onclick=\"fver(title);\">");  
                out.println("<tr BGCOLOR=\"#E0F8F7\" title=" + "\"" + i + "\"" + ">");  
              } else {
                //out.println("<tr title=" + "\"" + i + "\"" + "onclick=\"fver(title);\">");  
                out.println("<tr title=" + "\"" + i + "\"" + ">");  
              }
              out.println("<td style=\"width: 10%; text-align: center\"><small>"+lista.get(i).getId()+"<small></td>");
              out.println("<td style=\"width: 10%; text-align: center\"><small>"+lista.get(i).getCi()+"<small></td>");
              out.println("<td style=\"width: 30%; text-align: left\"><small>"+lista.get(i).getNombre()+"<small></td>");
              out.println("<td style=\"width: 20%; text-align: center\"><small><a href title = \"Editar\"; id=" + "\"" + i + "\"" + "onclick=\"fver(id, title);\">Editar</a><small></td>");
              out.println("<td style=\"width: 20%; text-align: center\"><small><a href title = \"Eliminar\"; id=" + "\"" + i + "\"" + "onclick=\"fver(id, title);\">Eliminar</a><small></td>");  
              out.println("</tr>");

             out.println( "<script type=\"text/javascript\"> " +
               "function fver(Id, Title) { " +

                    "valid = document.getElementById(\"tabla\").rows[parseInt(Id)+1].cells[0].innerText; " +
                    "valci = document.getElementById(\"tabla\").rows[parseInt(Id)+1].cells[1].innerText; " +
                    "valnombre = document.getElementById(\"tabla\").rows[parseInt(Id)+1].cells[2].innerText; " +                  
                    "valoperacion = \"Editar\"; " +
                    "valoperacion2 = \"Eliminar\"; " +

                     "var es_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1; "+
                     "var es_firefox = navigator.userAgent.toLowerCase().indexOf('firefox') > -1;"+
                     //" alert(es_firefox); " +
                     "if (Title == \"Editar\"){ " +
                           "if(es_chrome) {"+
                               " close(); " +
                              "window.open(\"editarClientes.jsp?Idtext=\"+valid+\"&citext=\"+valci+\"&nombretext=\"+valnombre+\"&operacion=\"+valoperacion);" +
                               " close(); " +
                           "}; " +
                           "if(es_firefox) {"+
                                 "window.location=\"editarClientes.jsp?Idtext=\"+valid+\"&citext=\"+valci+\"&nombretext=\"+valnombre+\"&operacion=\"+valoperacion;" +   
                                 " alert(\"\"); " +
                           "};" +
                    "} else { " +
                           " var r = confirm(\"Presionar 'Aceptar' para eliminar el registro seleccionado.\");" +
                               " if (r == true) { " +
                                     //" alert(r); " +
                                   "if(es_chrome){"+
                                       " close(); " +
                                       "window.open(\"operacionesGeneral.jsp?Idtext=\"+valid+\"&citext=1&nombretext=1&operacion=Eliminar\");" + 
                                       " close(); " +
                               
                                   "} " +
                                   "if(es_firefox){"+
                                        "window.location=\"operacionesGeneral.jsp?Idtext=\"+valid+\"&citext=1&nombretext=1&operacion=Eliminar\";" +
                                        " alert(\"\"); " +
                                   "} " +          
                               " } else { " +

                           " }" + 
                       "} " + 
                   "} " +
           "</script>");
           }       
    }  
%>
</table>
</form>
</div>
<script type=\"text/javascript\>
function fver(Id, Title) {
    window.close();
}
</script>
</body>
</html>
