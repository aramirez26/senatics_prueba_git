/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.Serializable;

/**
 *
 * @author Antonio Ramirez
 */
        
public class mensajes2 implements Serializable{
    
    String mensaje;
    String tipo;

    public mensajes2(String mensaje, String tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    String respuesta;
    String ubicacion;
  
    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String generarRespuesta(){
        
        if (tipo == "error") {
            ubicacion = "images/error.png";
        } else if(tipo == "warning") {
            ubicacion = "images/warning.png";
        } else if (tipo == "exito"){
            ubicacion = "images/ok.png";
        }
            
        respuesta = "<head>" +
                "<fieldset><legend>Mensaje</legend>"+
"<table style=\"text-align: left; width: 538px; height: 111px;\""+
" border=\"0\" cellpadding=\"2\" cellspacing=\"2\">"+
"  <tbody>"+
"    <tr>"+
"      <td style=\"width: 103px;\"><img"+
" style=\"width: 88px; height: 94px;\" alt=\"error\""+
" src=" +ubicacion+
"      <td style=\"width: 403px; vertical-align: top;\"><table>"+
                                                             "<thead>"+
                                                                "<tr>"+
                                                                    "<th>"+ tipo +"</th>"+
                                                                "</tr>"+
                                                             "</thead>"+
                                                             "<tbody>"+
                                                                mensaje +
                                                             "</tbody>"+                
                                                        "</table></td>"+
"    </tr>"+
"  </tbody>"+
"</table>"+
"<br>"+
"</fieldset>"+
"</head>";
        
        return respuesta;
    }
}
