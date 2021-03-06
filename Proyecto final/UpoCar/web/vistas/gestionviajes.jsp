<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1 class="admin">Gesti&oacute;n Viajes</h1>
        <hr />
        &nbsp;
        <div class="row">

            <!--mensajes de error de errores del update-->

            <s:fielderror fieldName="updatePlazasMax" cssClass="alert alert-danger" />
            <s:fielderror fieldName="updatePrecioPersona" cssClass="alert alert-danger" />
            <s:fielderror fieldName="updateFechaSalida" cssClass="alert alert-danger" />
            <s:fielderror fieldName="updatePuntoRecogida" cssClass="alert alert-danger" />
            <div class="col-xs-12">
                <s:form method="post" action="buscarUsuarioViaje">
                    <s:fielderror fieldName="nomUsuarioViaje" cssClass="alert alert-danger" />
                    <s:textfield placeholder="Nombre conductor..." name="nomUsuarioViaje" />
                    <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/buscar.jpg" /></button>
                    </s:form>
                &nbsp;
                <s:form method="post" action="toGestionViajes">
                    Mostrar Todo
                    <button class="btn btn-default"><img class="imagenBuscar" title="Buscar" src="./images/mostrarTodo.png" /></button>
                    </s:form>
                &nbsp;
            </div>
            <div class="col-xs-12 datagrid">

                <!--visualizaci�n de todos los usuarios-->

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Conductor</th>
                            <th>Origen</th>
                            <th>Destino</th>
                            <th>Vehiculo</th>
                            <th>Lugar de Recogida</th>
                            <th>Precio/persona</th>
                            <th>Plazas max</th>
                            <th>Fecha y Hora Salida</th>
                            <th></th>
                        </tr>
                    </thead>
                    <% int col = 0;%>
                    <s:if test="%{listadoViajes.size() > 0}">
                        <s:iterator value="listadoViajes">
                            <tbody>
                                <% if((col%2) != 0){%>
                                <tr class="alt">
                                    <% }else{%>
                                <tr >
                                    <% }%>
                                    <td><s:property value="idViaje" /></td>
                                    <td><s:property value="idUsuarioPublica.nomUsuario" /></td>
                                    <td><s:property value="idLocalidadOrigen.nombre" /></td>
                                    <td><s:property value="idLocalidadDestino.nombre" /></td>
                                    <td><s:property value="idVehiculoElegido.marca" /> <s:property value="idVehiculoElegido.modelo" /></td>
                                    <td id="puntoRecogida<s:property value="idViaje" />"><s:property value="puntoRecogida" /></td>
                                    <td id="precioPersona<s:property value="idViaje" />"><s:property value="percioPersona" /></td>
                                    <td id="plazasMax<s:property value="idViaje" />"><s:property value="plazasMax" /></td>
                                    <td id="fechaSalida<s:property value="idViaje" />"><s:property value="fechaSalida" /></td>
                                    <td>
                                        <s:form action="deleteViaje" ><button class="btn btn-default" name="idViaje" value="<s:property value="idViaje" />"><img class="imagenCRUD" title="Borrar" src="./images/papelera.png" /></button></s:form>
                                        <button id="<s:property value="idViaje" />" class="updateButton btn btn-default" /><img class="imagenCRUD" title="Editar" src="./images/update.png" /></button>
                                    </td>
                                </tr>
                            </tbody>
                            <% col++;%>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <tr>
                            <td colspan="9">No hay coincidencias</td>
                        </tr>
                    </s:else>
                </table>

            </div>
            <div class="col-xs-12"><hr /></div>


            <div id="formularioUpdate" style="display: none" class="col-xs-12 center-block" >

                <div class="col-lg-4 col-xs-3"></div>

                <div class="col-lg-4 col-xs-6 datagrid">
                    <table >
                        <thead>
                            <tr><th colspan="2">Update</th></tr>
                        </thead>

                        <!--formulario para realizar el update de mensajes-->

                        <s:form id="formularioUpdate" method="post" action="updateViaje">
                            <tr><td>ID Viaje</td><td id="updateId"></td></tr>
                            <tr class="alt"><td>Conductor:</td><td><s:select list="listadoUsuarios" listValue="nomUsuario" listKey="idUsuario" name="idUsuario" ></s:select>  </td></tr>
                            <tr><td>Origen:</td><td><s:select list="listadoLocalidades" listValue="nombre" listKey="idLocalidad" name="updateIdLocalidadOrigen" ></s:select>  </td></tr>
                            <tr class="alt"><td>Destino:</td><td><s:select list="listadoLocalidades" listValue="nombre" listKey="idLocalidad" name="updateIdLocalidadDestino" ></s:select>  </td></tr>
                            <tr><td>Plazas M&aacute;ximas:</td><td><s:textfield id="updatePlazasMax" name="updatePlazasMax" value="" ></s:textfield></td></tr>
                            <tr class="alt"><td>Precio/Persona:</td><td><s:textfield id="updatePrecioPersona" name="updatePrecioPersona" value=""></s:textfield></td></tr>
                            <tr><td>Lugar de Recogida:</td><td><s:textfield id="updatePuntoRecogida" name="updatePuntoRecogida" value=""></s:textfield></td></tr>
                                <tr class="alt"><td>Fecha Salida Ej:2018-05-10T00:00</td><td><input type="datetime-local"  id="updateFechaSalida" name="updateFechaSalida" value=""  /></td></tr>
                                <tr><td  colspan="2"><s:submit cssClass="btn btn-default" value="Update"></s:submit></td></tr>
                                <input id="hiddenUpdateID" type="hidden" name="updateId" value="" />
                        </s:form>
                        <tr class="alt"><td  colspan="2"><button class="btn btn-default" id="volverUpdate">Cerrar</button></td></tr>
                    </table>
                </div>
                <div class="col-lg-4 col-xs-3"></div>
            </div>
        </div>

    </div>

    <div class="col-lg-2"></div>
</div>


<script type="text/javascript">
    $("document").ready(function () {

        //al clickear el bot�n de editar llevamos todos los datos del viaje y 
        //se mueve la pantalla al formulario situacdo debajo de la tabla

        $(".updateButton").click(function () {
            $("#formularioUpdate").show();
            var id = $(this).attr("id");
            var precioPers = $("#precioPersona" + id).text();
            var plazasMax = $("#plazasMax" + id).text();
            var puntoRecogida = $("#puntoRecogida" + id).text();
            var fechaSalida = $("#fechaSalida" + id).text().split(" ").join("T");
            $("#updatePrecioPersona").attr("value", precioPers);
            $("#updatePlazasMax").attr("value", plazasMax);
            $("#updatePuntoRecogida").attr("value", puntoRecogida);
            $("#updateFechaSalida").attr("value", fechaSalida);
            $("#hiddenUpdateID").attr("value", id);
            $("#updateId").text(id);

            var focalizar = $("#formularioUpdate").position().top;
            $('html,body').animate({scrollTop: focalizar}, 1000);

        });

        //al clickear en el bot�n cerrar, volveremos al inicio de la p�gina.

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
