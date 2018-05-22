<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Gesti&oacute;n Usuarios</h1>
        <hr />
        &nbsp;
        <div class="row">

            <div class="col-lg-12">
                <s:form method="post" action="buscarUsuario">
                    <s:textfield placeholder="Nombre usuario..." name="nomUsuario" />
                    <s:submit name="buscarUsuario" value="Buscar" />
                </s:form>
                <s:form method="post" action="toGestionUsuarios">
                    <s:submit name="buscarUsuario" value="Mostrar todos" />
                </s:form>
            </div>
            <div class="col-lg-12">
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <table class="col-lg-12" border="1">
                        <tr>
                            <th></th>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>E-mail</th>
                            <th>Localidad</th>
                            <th>Sexo</th>
                            <th>&Uacute;ltimo acceso</th>
                            <th>Fecha Alta</th>
                            <th></th>
                        </tr>
                        <s:if test="%{listadoUsuarios.size() > 0}">
                            <s:iterator value="listadoUsuarios">
                                <tr>
                                    <td><img class="foto-mi-cuenta img-circle img-responsive" src="http://www.cetep.cl/web/wp-content/uploads/2016/11/icono-de-usuario-masculino.jpg" /></td>
                                    <td><s:property value="idUsuario" /></td>
                                    <td><s:property value="nomUsuario" /></td>
                                    <td><s:property value="nombre" /></td>
                                    <td><s:property value="apellidos" /></td>
                                    <td><s:property value="email" /></td>
                                    <td><s:property value="localidad" /></td>
                                    <td><s:property value="sexo" /></td>
                                    <td><s:property value="ultimoAcceso" /></td>
                                    <td><s:property value="fechaAlta" /></td>
                                    <td>
                                         <s:form action="deleteUsuario" ><button name="idUsuario" value="<s:property value="idUsuario" />"><img class="foto-mi-cuenta img-circle img-responsive" src="./images/papelera.png" /></button></s:form>
                                        <button id="<s:property value="idUsuario" />" class="updateButton" /><img class="foto-mi-cuenta img-circle img-responsive" src="./images/update.png" /></button>
                                    </td>
                                </tr>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <tr>
                                <td colspan="12">No hay coincidencias</td>
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
