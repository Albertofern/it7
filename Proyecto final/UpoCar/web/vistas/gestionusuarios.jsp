<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Gesti&oacute;n Usuarios</h1>
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
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                <table class="col-lg-12" border="1">
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th></th>
                    </tr>
                    <s:iterator value="listadoUsuarios">
                    <tr>
                        <td><s:property value="nombre" /></td>
                        <td><s:property value="apellidos" /></td>
                        <td><s:property value="idUsuarioRecibe.nomUsuario" /></td>
                        <td><img class="foto-mi-cuenta img-circle img-responsive" src="./images/papelera.png" /></td>
                    </tr>
                    </s:iterator>
                </table>
                </div>
                <div class="col-lg-4"></div>
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
