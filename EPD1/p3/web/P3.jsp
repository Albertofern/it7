<%-- 
    Document   : P2
    Created on : 07-feb-2018, 18:30:01
<<<<<<< HEAD
    Author     : Grupo 7 
=======
    Author     : Grupo7 IT
>>>>>>> 43050bbb143cdb0108aad107b03dd029f48f2875
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
<<<<<<< HEAD
    String nombre, apellidos, email, estudios, bloques, nota, carta;
    double bloque1, bloque2, bloque3, proyecto, epd, notaSobre7, notaSobre10, notaSobre2, notaSobre1, notaFinal, valorBloque1, valorBloque2, valorBloque3;    
=======
    String nombre = "";
    String apellidos = "";
    String email = "";
    String estudios = "";
    String bloques = "";
    String nota = "";
    double bloque1 = 0.0, bloque2 = 0.0, bloque3 = 0.0, proyecto = 0.0, epd = 0.0, notaSobre7 = 0.0, notaSobre10 = 0.0, notaSobre2 = 0.0, notaSobre1 = 0.0, notaFinal = 0.0;
    double valorBloque1 = 0.3111, valorBloque2 = 0.1556, valorBloque3 = 0.2333;
    String carta = "";
>>>>>>> 43050bbb143cdb0108aad107b03dd029f48f2875
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EPD 1 Problema 2</title>
    </head>
    <body>
        <form method="get" action="P3.jsp">
            Nombre: <input type="text" name="nombre" /><br/>
            Apellidos: <input type="text" name="apellidos" /><br/>
            Email: <input type="text" name="email" /><br/>
            Direccion: <input type="text" name="direccion" /><br/>
            Ha estudiado antes IT ?: <input type="radio" name="estudio" value="1"><input type="radio" name="estudio" value="0"/><br/>
            En caso afirmativo, indicar el o los bloques que encontró más difíciles: <input type="text" name="bloques" /><br/>
            En caso negativo, indicar qué nota espera obtener en la asignatura: <input type="text" name="nota" /><br/>
            <!-- Ampliacion para el problema 2 -->
            Nota que espera obtener en el examen del bloque 1 (sobre 10): <input type="text" name="bloque1" /><br/>
            Nota que espera obtener en el examen del bloque 2 (sobre 10): <input type="text" name="bloque2" /><br/>
            Nota que espera obtener en el examen del bloque 3 (sobre 10): <input type="text" name="bloque3" /><br/>
            Nota que espera obtener en el proyecto (sobre 10): <input type="text" name="proyecto" /><br/>
            Nota que espera obtener en los ejercicios de EPD (sobre 10): <input type="text" name="epd" /><br/>
            <input type="submit" name="enviar"/>
        </form>
        <%
            valorBloque1 = 0.3111;
            valorBloque2 = 0.1556; 
            valorBloque3 = 0.2333;
            
            nombre = request.getParameter("nombre");
            apellidos = request.getParameter("apellidos");
            email = request.getParameter("email");
            estudios = request.getParameter("estudio");
            bloques = request.getParameter("bloques");
            nota = request.getParameter("nota");

            if (request.getParameter("bloque1") != null && request.getParameter("bloque2") != null && request.getParameter("bloque3") != null && request.getParameter("proyecto") != null && request.getParameter("epd") != null) {
                bloque1 = Double.parseDouble(request.getParameter("bloque1"));
                bloque2 = Double.parseDouble(request.getParameter("bloque2"));
                bloque3 = Double.parseDouble(request.getParameter("bloque3"));
                proyecto = Double.parseDouble(request.getParameter("proyecto"));
                epd = Double.parseDouble(request.getParameter("epd"));
            }

            if (nombre != "" && nombre != null) {
                out.print("Nombre: " + nombre + "<br/>");
            }

            if (apellidos != "" && apellidos != null) {
                out.print("Apellidos: " + apellidos + "<br/>");
            }

            if (email != "" && email != null) {
                out.print("Email: " + email + "<br/>");
            }

            if (estudios != "" && estudios != null) {
                if (Integer.parseInt(estudios) == 1) {
                    out.print("Bloques que le resulto dificil: " + bloques);
                } else {
                    out.print("Nota esperada: " + nota);
                }
            }

            //Ampliacion para el problema 2
            notaSobre7 = (bloque1 * valorBloque1) + (bloque2 * valorBloque2) + (bloque3 * valorBloque3);
            notaSobre7 = Math.rint(notaSobre7 * 1000) / 1000;
            notaSobre10 = (notaSobre7 * 10) / 7;
            notaSobre10 = Math.rint(notaSobre10 * 1000) / 1000;
            notaSobre2 = (proyecto * 2) / 10;
            notaSobre1 = epd / 10;
        %>

        <table border="1">
            <tr><th></th><th style="background-color: gray"><b>Rendimiento individual</b></th><th colspan="2" style="background-color: gray"><b>Rendimiento Grupal</b></th><th rowspan="5" style="background-color: gray"><b>Nota Final</b></th></tr>
            <tr><td><b>Bloques</b></td><td><b>Pruebas EPD (sobre 10)</b></td><td><b>Proyecto (sobre 10)</b></td><td><b>Ejercicios EPD (sobre 10)</b></td></tr>
            <tr><td><b>B1</b></td><td><%= bloque1%></td><td rowspan="3"><%= proyecto%></td><td rowspan="3"><%= epd%></td></tr>
            <tr><td><b>B2</b></td><td><%= bloque2%></td></tr>
            <tr><td><b>B3</b></td><td><%= bloque3%></td></tr>
            <tr><td></td><td style="background-color: gray"><b>Nota total sobre 7</b></td><td style="background-color: gray"><b>Nota total sobre 2</b></td><td style="background-color: gray"><b>Nota total sobre 1</b></td>
                <td>
                    <% if (notaSobre10 < 5) {
                            notaFinal = notaSobre10;
                    %>
                    <%= notaFinal%>
                    <%
                    } else {
                        notaFinal = notaSobre7 + notaSobre2 + notaSobre1;
                        notaFinal = Math.rint(notaFinal * 1000) / 1000;
                    %>
                    <%= notaFinal%>
                    <%
                        }
                    %>
                </td></tr>
            <tr><td></td><td><%= notaSobre7%></td><td><%= notaSobre2%></td><td><%= notaSobre1%></td></tr>
            <tr><td></td><td style="background-color: gray"><b>Nota total sobre 10</b></td></tr>
            <tr><td></td><td><%= notaSobre10%></td></tr>
        </table>

        <%
            if(notaFinal > 5){
                carta = "Estimado "+ nombre +", le informamos de que ha aprobado la asignatura con "+notaFinal+ ", ya que cumple todos los requisitos. Enhorabuena";
            } else {
                carta = "Estimado "+ nombre +", le informamos de que no ha superado la asignatura  ya que no cumple todos los requisitos. Lo sentimos";
            }
        %>

    </body>
</html>
