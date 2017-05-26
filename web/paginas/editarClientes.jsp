<%-- 
    Document   : editarClientes
    Created on : Dec 20, 2016, 11:53:43 PM
    Author     : Antonio Ramirez
--%>

<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Clientes</title>
    </head>
<body onload="bloquear_id()">
    <% String valId = request.getParameter("Idtext"); if (valId.equals("null")) {valId = "";}%>
    <% String valci = request.getParameter("citext"); if (valci.equals("null")) {valci = "";}%>
    <% String valnombre = request.getParameter("nombretext"); if (valnombre.equals("null")) {valnombre = "";}%>
    <% String valoperacion = request.getParameter("operacion"); if (valoperacion.equals("null")) {valoperacion = "";}%>

    
    <%  HttpSession sesion=request.getSession();

        if ((sesion.getAttribute("usuario")==null)==true) {
            response.sendRedirect("../index.jsp");
        } 
    %>
<big
 style="font-weight: bold; font-style: italic; width: 80%; color: rgb(153, 0, 0);"><big><big>Cliente</big></big></big><br>
<fieldset style="width: 80%; background-color: #CED8F6"><legend>Datos del Cliente</legend><br>
<form action="  operacionesGeneral.jsp" method="get"
      id="formu" name="editarEntidad"  onsubmit="return false;">    
<table style="text-align: left; width: 100%;" 
 cellpadding="2" cellspacing="2">
  <tbody>
    <tr>
      <td style="text-align: right; width: 10%">id</td>
      <td><input id="Idbloq" name="Idbloq" disabled="true" value=<%=valId%>>
      <input id="Idtext" name="Idtext" style="display: none" value=<%=valId%>></td>      
      
    </tr>
    <tr>
        <td style="text-align: right">CI</td>
        <td><input tabindex="5" id="citext" name="citext" value="<%=valci%>"></td>
    </tr>
    <tr>
      <td style="text-align: right">nombre</td>
      <td><input  tabindex="6" maxlength="200" id="nombretext" name="nombretext" style="width: 100%" value="<%=valnombre%>"></td>
    </tr>
    <tr>
      <td></td>
      <td style="height: 30px; width:200px">
             <input tabindex="8"
                    type="submit" value="Guardar Cambios" title ="guardar" name="guardar" onclick="validar()">
              </td>
      <td></td>
      <td><input  Id="operacion" name="operacion" style="width: 100%; display: none" value="<%=valoperacion%>"></td>
    </tr>
  </tbody>
</table>
</form>
<br>
</fieldset>
    <script type=text/javascript>
        function validar() {
            if (document.getElementById("citext").value.length === 0){
              alert("Debe especificar una cédula.");
              return;
            } 
            if (isNaN(parseInt(document.getElementById("citext").value))){
              alert("La cédula debe ser numérica.");
              return;
            }
            if (document.getElementById("nombretext").value.length === 0){
              alert("Debe especificar un nombre.");
              return;
            }
            document.getElementById("formu").onsubmit = true;   
        }
    </script> 
</body>
</html>
