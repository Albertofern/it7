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
                <div class="col-lg-10">
                    <table class="col-lg-12" border="1">
                        <tr>
                            <th>ID</th>
                            <th>Enviado</th>
                            <th>Mensaje</th>
                            <th>Recibido</th>
                            <th>Fecha/Hora</th>
                        </tr>
                         <s:if test="%{listadoMensajes.size() > 0}">
                        <s:iterator value="listadoMensajes">
                            <tr>
                                <td><s:property value="idMensaje" /></td>
                                <td><s:property value="idUsuarioEnvia.nomUsuario" /></td>
                                <td><s:property value="texto" /></td>
                                <td><s:property value="idUsuarioRecibe.nomUsuario" /></td>
                                <td><s:property value="fechaHora" /></td>
                                <td>
                                    <s:form action="deleteMensaje" ><button name="idMensaje" value="<s:property value="idMensaje" />"><img class="foto-mi-cuenta img-circle img-responsive" src="./images/papelera.png" /></button></s:form>
                                    <button id="<s:property value="idMensaje" />" class="updateButton" /><img class="foto-mi-cuenta img-circle img-responsive" src="./images/update.png" /></button>
                                </td>
                            </tr>
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

            <div class="col-lg-12">
                <s:form method="post" action="">
                    <s:textfield placeholder="Nombre" name=""></s:textfield>
                    <s:textfield placeholder="Apellidos" name=""></s:textfield>
                    <s:textfield placeholder="Nombre Usuario" name=""></s:textfield>
                    <s:submit name="add" value="Add"></s:submit>
                </s:form>
            </div>

        </div>

        <div class="col-lg-2"></div>
    </div>
</div>
<%@include file="./index_footer.jsp" %>
