<%-- 
    Document   : operacionesGeneral
    Created on : Dec 21, 2016, 4:11:24 PM
    Author     : Antonio Ramirez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <% String valId = request.getParameter("Idtext"); if (valId.equals("null")) {valId = "";}%>
        <% String valci = request.getParameter("citext"); if (valci.equals("null")) {valci = "";}%>
        <% String valnombre = request.getParameter("nombretext"); if (valnombre.equals("null")) {valnombre = "";}%>
        <% String valoperacion = request.getParameter("operacion"); if (valoperacion.equals("null")) {valoperacion = "";}%>
        
        <%
          HttpSession sesion=request.getSession();

            if ((sesion.getAttribute("usuario")==null)==true) {
                response.sendRedirect("../index.jsp");
            } else {
                String servidor = "localhost:5432";
                
                String database = "senatics";

                //String servidor = "localhost:5432";
                //String database = "deb_aut_local";

                Class.forName("org.postgresql.Driver");
                String url="jdbc:postgresql://"+servidor+"/"+database;
                Connection conexion = null;
                conexion = DriverManager.getConnection(url, "postgres", "paraguay");
                Statement st = conexion.createStatement();

                ResultSet rs = null;

                String sql = new String("");

                if (valoperacion.equals("Agregar")){
                        rs = st.executeQuery("select abm_clientes('alta', '9999', " + 
                        valci + ",'" + valnombre + "')"); 
                } else if (valoperacion.equals("Editar")) {
                        sql = "select abm_clientes('modificacion', " + valId + "," + 
                        valci + ",'" + valnombre + "')";     
                        rs = st.executeQuery(sql);
                } else if (valoperacion.equals("Eliminar")) {
                        sql = "select abm_clientes('baja', " + valId + "," + 
                        valci + ",'" + valnombre + "')"; 
                        rs = st.executeQuery(sql); 
                }

                while(rs.next()) {
                        int resp = rs.getInt(1);
                    }
                    rs.close();
                    st.close();
                    conexion.close();

                    response.sendRedirect("consultaClientes.jsp");                  
            }   
        %>
    
        <script type=\"text/javascript\>
            function fver(Id, Title) {
                window.close();
            }
        </script>
    </body>
</html>
