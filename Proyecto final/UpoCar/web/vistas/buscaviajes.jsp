<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div>
        <h1>�Buscar viaje!</h1>                    

        <s:form action="buscaViaje">

            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-xs-12 col-md-3 col-lg-2">
                    <s:textfield cssClass="form-control" name="origen" placeholder="Origen"></s:textfield>                            
                    </div>

                    <div class="col-xs-12 col-md-3 col-lg-2">
                    <s:textfield cssClass="form-control" name="destino" placeholder="Destino"></s:textfield>                            
                    </div>

                    <div class="col-xs-12 col-md-3 col-lg-2">
                        <input id="datetime" name="fechaHora" type="datetime-local" class="form-control">
                    </div>                                
                    <div class="col-xs-12 col-md-3 col-lg-2">
                    <s:submit name="buscar" value="Buscar viaje" cssClass="btn btn-default btnBuscar"></s:submit>
                    </div>
                    <div class="col-lg-2"></div>
                </div>

        </s:form>

        <s:if test="%{listadoViajes.size() == 0}">
            <div class="alert alert-info" role="alert">Lo sentimos, pero no hay ningun viaje con la busqueda realizada.</div>
        </s:if>
        <s:else>
            <s:iterator value="listadoViajes">                
                <!-- Poner un fieldset o algo para diferenciar un viaje de otro -->
                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8 colum-height">
                        <div class="col-xs-12 col-sm-2 col-lg-3 ">

                            <img class="foto-mi-cuenta img-circle img-responsive" src='<s:property value="idUsuarioPublica.foto"></s:property>' />

                                <!-- <p>Imagen</p> Imagen del usuario que publica el viaje, si no tiene, que muestre una por defecto -->
                                <p><s:property value="idUsuarioPublica.nombre"></s:property> <s:property value="idUsuarioPublica.apellidos"></s:property></p> 
                            <p>Puntuacion: <s:property value="idUsuarioPublica.totalPuntuacion"></s:property></p>
                            <s:if test="%{#session.usuario != null}">     
                                <p>
                                    <s:form action="verPerfil">
                                        <s:submit name="verPerfil" value="Ver perfil" cssClass="btn btn-primary btnBuscar"></s:submit>
                                        <s:hidden name="idUsuario" value="%{idUsuarioPublica.idUsuario}"></s:hidden>
                                    </s:form>
                                    <s:form action="contactar">
                                        <s:submit name="contactarCon" value="Contactar" cssClass="btn btn-primary btnBuscar"></s:submit>
                                        <s:hidden name="idUsuarioContacto" value="%{idUsuarioPublica.idUsuario}"></s:hidden>
                                    </s:form>
                                </p>
                            </s:if>
                        </div>
                        <div class="col-xs-12 col-sm-4 col-lg-4 ">
                            <p><strong>Origen:</strong><s:property value="idLocalidadOrigen.nombre"></s:property></p> 
                            <p><strong>Destino:</strong><s:property value="idLocalidadDestino.nombre"></s:property></p> 
                            <p><strong>Precio:</strong><s:property value="percioPersona"></s:property></p> 
                            <p><strong>Plazas disponibles:</strong> <s:property value="listaPasajeros.size()"></s:property>/<s:property value="plazasMax"></s:property></p> 
                            <p><strong>Punto de recogida:</strong> <s:property value="puntoRecogida"></s:property></p>
                            <p><strong>Hora de salida:</strong> <s:property value="fechaSalida"></s:property></p>
                                <p>
                                <s:if test="%{#session.usuario != null}">  
                                    <s:form action="reservar">
                                        <s:submit name="reservarViaje" value="Reservar plaza" cssClass="btn btn-primary btnBuscar"></s:submit>
                                        <s:hidden name="idViaje" value="%{idViaje}"></s:hidden>
                                    </s:form>
                                </s:if>
                            </p>
                        </div>
                        <div class="col-sm-6 col-lg-5 hidden-xs">                                
                            <p>
                                <s:if test="%{fotosVehiculo.size() == 0}">
                                    <img src="./images/Sin_imagen.png" class="img-responsive noDisponible">
                                </s:if>
                                <s:else>
                                <div class="fotorama">                                    
                                    <s:iterator value="fotosVehiculo">                                        
                                        <img src="<s:property value="rutaFoto"></s:property>" />
                                            <!--<img src="./images/audi_r8_rojo.jpg" />-->
                                            <!--<img src="./images/renault_clio_gris.jpg" />-->
                                    </s:iterator>
                                </div>
                            </s:else>
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-2"></div>
                </div>
                <hr/>
            </s:iterator>                
        </s:else>                        
    </div>
</div>
<%@include file="index_footer.jsp" %>