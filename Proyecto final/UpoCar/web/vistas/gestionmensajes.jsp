<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Gesti&oacute;n Mensajes</h1>
        <hr />
        &nbsp;
        <div class="row">

            <div class="col-lg-12">
                <s:form method="post" action="buscarEnviaMensaje">
                    <s:textfield placeholder="Usuario envia mensaje..." name="nomUsuarioEnvia" />
                    <s:submit name="buscarUsuario" value="Buscar" />
                </s:form>
                <s:form method="post" action="buscarRecibeMensaje">
                    <s:textfield placeholder="Usuario recibe mensaje..." name="nomUsuarioRecibe" />
                    <s:submit name="buscarUsuario" value="Buscar" />
                </s:form>
                <s:form method="post" action="toGestionMensajes">
                    <s:submit name="buscarUsuario" value="Mostrar todos" />
                </s:form>
            </div>
            <div class="col-lg-12">
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
                                        <s:form action="deleteMensaje" ><button name="idMensaje" value="<s:property value="idMensaje" />"><img class="imagenCRUD" title="Borrar" src="./images/papelera.png" /></button></s:form>
                                        <button id="<s:property value="idMensaje" />" class="updateButton" /><img class="imagenCRUD" title="Editar" src="./images/update.png" /></button>
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
            <div class="col-lg-12"><hr /></div>

            <div id="formularioUpdate" style="display: none" class="col-lg-12 center-block" >

                <div class="col-lg-5"></div>

                <div class="col-lg-2">
                    <table >
                        <tr><th colspan="2">Update</th></tr>
                                <s:form id="formularioUpdate"  method="post" action="updateMensaje">
                            <tr><td>ID Mensaje</td><td id="updateIdMensaje"></td></tr>
                            <tr><td>Usuario recibe mensaje</td><td><s:select list="listadoUsuarios" listValue="nomUsuario" listKey="idUsuario" name="idUsuario" ></s:select>  </td></tr>
                            <tr><td>Mensaje</td><td><s:textarea id="updateMensaje" name="updateMensaje" value="" ></s:textarea></td></tr>
                                <tr><td><s:submit value="Update"></s:submit></td></tr>
                                <input id="hiddenUpdateID" type="hidden" name="idMensaje" value="" />
                        </s:form>

                    </table>
                </div>
                <div class="col-lg-5"></div>
            </div>

        </div>

        <div class="col-lg-2"></div>
    </div>
</div>
<script type="text/javascript">
    $("document").ready(function () {
        $(".updateButton").click(function () {
            $("#formularioUpdate").toggle();
            var id = $(this).attr("id");
            var mensaje = $("#mensaje" + id).text();
            $("#updateMensaje").text(mensaje);
            $("#hiddenUpdateID").attr("value", id);
            $("#updateIdMensaje").text(id);

            var focalizar = $("#formularioUpdate").position().top;
            $('html,body').animate({scrollTop: focalizar}, 1000);

        });
    });
</script>
<%@include file="./index_footer.jsp" %>
