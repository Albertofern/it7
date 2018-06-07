<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1 class="admin">Ranking mayor puntuaci&oacute;n usuarios</h1>
        <hr />
        &nbsp;
        <div class="row">

            <div class="col-xs-12">
                <div class="col-xs-12">
                    <s:form method="post" action="buscarUsuarioRanking">
                        <s:textfield placeholder="Nombre usuario..." name="usuario" />
                        <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/buscar.jpg" /></button>
                        </s:form>
                    &nbsp;
                    <s:form method="post" action="toRanking">
                        Mostrar Todo
                        <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/mostrarTodo.png" /></button>
                        </s:form>
                    &nbsp;
                </div>
                <div class="col-lg-2"></div>
                <div class="col-lg-8 datagrid">

                    <table class="col-xs-12" >
                        <thead>
                            <tr>
                                <th></th>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th colspan="2">Puntuaci&oacute;n</th>
                                <th>Viajes Publicados</th>
                            </tr>
                        </thead>
                        <s:if test="%{listadoUsuarios.size() > 0}">
                            <% int col = 0;%>
                            <s:iterator value="listadoUsuarios">
                                <%-- Filtramos que no muestren los administradores --%>
                                <s:if test='%{tipoUsuario.equals("1")}'>
                                    <tbody>
                                        <% if((col%2) != 0){%>
                                        <tr class="alt">
                                            <% }else{%>
                                        <tr >
                                            <% }%>
                                            <td><img class="foto-mi-cuenta img-circle img-responsive" src="http://www.cetep.cl/web/wp-content/uploads/2016/11/icono-de-usuario-masculino.jpg" /></td>
                                            <td id="usuario<s:property value="idUsuario" />"><s:property value="nomUsuario" /></td>
                                            <td id="nombre<s:property value="idUsuario" />"><s:property value="nombre" /></td>
                                            <td id="apellidos<s:property value="idUsuario" />"><s:property value="apellidos" /></td>
                                            <td style="border-right: none"><s:property value="totalPuntuacion" /></td> <td style="border-left: none;text-align:left">
                                                <s:iterator begin="1" end="totalPuntuacion">
                                                    <span style='color:orange'>&#9733;</span>  
                                                </s:iterator>
                                            </td>
                                            <td>
                                                <% int viajesUsuarios=0;%>
                                                <s:iterator value="listadoViajes">
                                                    <s:if test="%{idUsuarioPublica.idUsuario == idUsuario}">
                                                        <%viajesUsuarios++; %>              
                                                    </s:if>
                                                </s:iterator>
                                                <%= viajesUsuarios %>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <% col++;%>
                                </s:if>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <tr>
                                <td colspan="7">No hay usuarios</td>
                            </tr>
                        </s:else>
                    </table>
                </div>
                <div class="col-lg-2"></div>
            </div>

        </div>


    </div>
</div>
<br />
<br />
<%@include file="index_footer.jsp" %>