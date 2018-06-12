<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1 class="admin">Gesti&oacute;n Mensajes</h1>
        <hr />
        &nbsp;
        <div class="row">
            <s:fielderror fieldName="updateMensaje" cssClass="alert alert-danger" />
            <div class="col-xs-12">
                <s:form method="post" action="buscarEnviaMensaje">
                     <s:fielderror fieldName="nomUsuarioEnvia" cssClass="alert alert-danger" />
                    <s:textfield placeholder="Usuario envia mensaje..." name="nomUsuarioEnvia" />
                    <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/buscar.jpg" /></button>
                </s:form>
                &nbsp;
                <s:form method="post" action="buscarRecibeMensaje">
                     <s:fielderror fieldName="nomUsuarioRecibe" cssClass="alert alert-danger" />
                    <s:textfield placeholder="Usuario recibe mensaje..." name="nomUsuarioRecibe" />
                    <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/buscar.jpg" /></button>
                </s:form>
                &nbsp;
                <s:form method="post" action="toGestionMensajes">
                    Mostrar Todo
                    <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/mostrarTodo.png" /></button>
                </s:form>
                &nbsp;
            </div>
            <div class="col-xs-12">
                <div class="col-lg-1"></div>
                <div class="col-lg-10 datagrid">
                    <table class="col-lg-12 " border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Enviado</th>
                                <th>Mensaje</th>
                                <th>Recibido</th>
                                <th>Fecha/Hora</th>
                            </tr>
                        </thead>
                        <% int col = 0;%>
                        <s:if test="%{listadoMensajes.size() > 0}">
                            <s:iterator value="listadoMensajes">
                                <tbody>
                                    <% if((col%2) != 0){%>
                                    <tr class="alt">
                                        <% }else{%>
                                    <tr >
                                        <% }%>
                                        <td><s:property value="idMensaje" /></td>
                                        <td><s:property value="idUsuarioEnvia.nomUsuario" /></td>
                                        <td id="mensaje<s:property value="idMensaje" />"><s:property value="texto" /></td>
                                        <td><s:property value="idUsuarioRecibe.nomUsuario" /></td>
                                        <td id="fecha<s:property value="idMensaje" />"><s:date name="fechaHora" format="yyyy-mm-dd HH:mm" /></td>
                                        <td>
                                            <s:form action="deleteMensaje" ><button class="btn btn-default" name="idMensaje" value="<s:property value="idMensaje" />"><img class="imagenCRUD" title="Borrar" src="./images/papelera.png" /></button></s:form>
                                            <button id="<s:property value="idMensaje" />" class="updateButton btn btn-default" /><img class="imagenCRUD" title="Editar" src="./images/update.png" /></button>
                                        </td>
                                    </tr>
                                </tbody>
                                <% col++;%>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <tr>
                                <td colspan="6">No hay coincidencias</td>
                            </tr>
                        </s:else>
                    </table>
                </div>
                <div class="col-lg-1"></div>
            </div>
            <div class="col-xs-12"><hr /></div>

            <div id="formularioUpdate" style="display: none" class="col-xs-12 center-block" >

                <div class="col-lg-4 col-xs-3"></div>

                <div class="col-lg-4 col-xs-6 datagrid">
                    <table >
                        <thead>
                            <tr><th colspan="2">Update</th></tr>
                        </thead>
                                <s:form id="formularioUpdate"  method="post" action="updateMensaje">
                            <tr><td>ID Mensaje</td><td id="updateIdMensaje"></td></tr>
                            <tr class="alt"><td>Usuario recibe mensaje</td><td><s:select list="listadoUsuarios" listValue="nomUsuario" listKey="idUsuario" name="idUsuario" ></s:select>  </td></tr>
                            <tr><td>Mensaje</td><td><s:textarea id="updateMensaje" name="updateMensaje" value="" ></s:textarea></td></tr>
                            <tr class="alt"><td  colspan="2"><s:submit cssClass="btn btn-default" value="Update"></s:submit></td></tr>
                                <tr><td><input id="hiddenUpdateID" type="hidden" name="idMensaje" value="" /></td></tr>

                        </s:form>
                                <tr class="alt"><td colspan="2"><button class="btn btn-default" id="volverUpdate">Cerrar</button></td></tr>
                    </table>
                </div>
                <div class="col-lg-4 col-xs-3"></div>
            </div>

        </div>

        <div class="col-lg-2"></div>
    </div>
</div>
<script type="text/javascript">
    $("document").ready(function () {
        $(".updateButton").click(function () {
            $("#formularioUpdate").show();
            var id = $(this).attr("id");
            var mensaje = $("#mensaje" + id).text();
            $("#updateMensaje").text(mensaje);
            $("#hiddenUpdateID").attr("value", id);
            $("#updateIdMensaje").text(id);

            var focalizar = $("#formularioUpdate").position().top;
            $('html,body').animate({scrollTop: focalizar}, 1000);

        });

        $("#volverUpdate").click(function () {
            $("#formularioUpdate").hide();
            var focalizar = $(".updateButton").position().top;
            $('html,body').animate({scrollTop: focalizar}, 1000);
        });
    });
</script>
<br />
<br />
<%@include file="index_footer.jsp" %>
