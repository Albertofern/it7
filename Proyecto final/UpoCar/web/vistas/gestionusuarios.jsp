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
                                    <td id="nomUsuario<s:property value="idUsuario" />"><s:property value="nomUsuario" /></td>
                                    <td id="nomUsuario<s:property value="nombre" />"><s:property value="nombre" /></td>
                                    <td id="nomUsuario<s:property value="apellidos" />"><s:property value="apellidos" /></td>
                                    <td id="nomUsuario<s:property value="email" />"><s:property value="email" /></td>
                                    <td id="nomUsuario<s:property value="localidad" />"><s:property value="localidad" /></td>
                                    <td id="nomUsuario<s:property value="sexo" />"><s:property value="sexo" /></td>
                                    <td id="nomUsuario<s:property value="ultimoAcceso" />"><s:property value="ultimoAcceso" /></td>
                                    <td id="nomUsuario<s:property value="fechaAlta" />"><s:property value="fechaAlta" /></td>
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

            <div id="formularioUpdate" style="display: none" class="col-lg-12 center-block" >

                <div class="col-lg-5"></div>

                <div class="col-lg-2">
                    <table >
                        <tr><th colspan="2">Update</th></tr>
                                <s:form id="formularioUpdate" method="post" action="updateViaje">
                            <tr><td>ID:</td><td id="updateIdUsuario"></td></tr>
                            <tr><td>Usuario:</td><td id="updateUsuario"><s:textfield id="updateUsuario" name="updateUsuario" value="" ></s:textfield></td></tr>
                            <tr><td>Nombre</td><td><s:textfield id="updateNombre" name="updateNombre" value="" ></s:textfield></td></tr>
                            <tr><td>Apellidos:</td><td><s:textfield id="updateApellidos" name="updateApellidos" value=""></s:textfield></td></tr>
                            <tr><td>E-mail:</td><td><s:textfield id="updateEmail" name="updateEmail" value=""></s:textfield></td></tr>
                            <tr><td>Localidad:</td><td><s:textfield id="updateLocalidad" name="updateLocalidad" value=""></s:textfield></td></tr>
                            <tr><td>Sexo:</td><td><s:textfield id="updateSexo" name="updateSexo" value=""></s:textfield></td></tr>
                            <tr><td>Foto:</td><td><s:textfield id="updateFoto" name="updateFoto" value=""></s:textfield></td></tr>
                            <tr><td><s:submit value="Update"></s:submit></td></tr>
                                <input id="hiddenUpdateID" type="hidden" name="updateIdUsuario" value="" />
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
            var precioPers = $("#precioPersona" + id).text();
            var plazasMax = $("#plazasMax" + id).text();
            var puntoRecogida = $("#puntoRecogida" + id).text();
            var fechaSalida = $("#fechaSalida" + id).text();
            $("#updatePrecioPersona").attr("value", precioPers);
            $("#updatePlazasMax").attr("value", plazasMax);
            $("#updatePuntoRecogida").attr("value", puntoRecogida);
            $("#updateFechaSalida").attr("value", fechaSalida);
            $("#hiddenUpdateID").attr("value", id);
            $("#updateId").text(id);

            var focalizar = $("#formularioUpdate").position().top;
            $('html,body').animate({scrollTop: focalizar}, 1000);

        });
    });
</script>
<%@include file="./index_footer.jsp" %>
