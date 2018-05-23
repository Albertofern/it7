<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Gesti&oacute;n Mensajes</h1>
        <hr />
        &nbsp;
        <div class="row">

            <div class="col-lg-12">
                <s:form method="post" action="">
                    <s:textfield placeholder="Nombre usuario..." name="nombreUsuario" />
                    <s:submit name="buscarUsuario" value="Buscar" />
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
                    <s:iterator value="listadoMensajes">
                    <tr>
                        <td><s:property value="idMensaje" /></td>
                        <td><s:property value="idUsuarioEnvia.nomUsuario" /></td>
                        <td><s:property value="texto" /></td>
                        <td><s:property value="idUsuarioRecibe.nomUsuario" /></td>
                        <td><s:property value="fechaHora" /></td>
                        <td><img class="foto-mi-cuenta img-circle img-responsive" src="./images/papelera.png" /></td>
                    </tr>
                    </s:iterator>
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
