<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        <h1>¡Buscar viaje!</h1>                    

        <s:form action="buscaViaje">

            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-xs-12 col-lg-2">
                    <s:textfield cssClass="form-control" name="origen" placeholder="Origen"></s:textfield>                            
                    </div>

                    <div class="col-xs-12 col-lg-2">
                    <s:textfield cssClass="form-control" name="destino" placeholder="Destino"></s:textfield>                            
                    </div>

                    <div class="col-xs-12 col-lg-2">
                        <input id="datetime" name="fechaHora" type="datetime-local" class="form-control">
                    </div>                                
                    <div class="col-xs-12 col-lg-2">
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
                            <s:if test="%{idUsuarioPublica.foto == ''}">
                                <img class="foto-mi-cuenta img-circle img-responsive" src="http://www.cetep.cl/web/wp-content/uploads/2016/11/icono-de-usuario-masculino.jpg" />
                            </s:if>
                            <s:else>
                                <img class="foto-mi-cuenta img-circle img-responsive" src="<s:property value="idUsuarioPublica.foto"></s:property>>
                                </s:else>
                                <!-- <p>Imagen</p> Imagen del usuario que publica el viaje, si no tiene, que muestre una por defecto -->
                                <p><s:property value="idUsuarioPublica.nombre"></s:property> <s:property value="idUsuarioPublica.apellidos"></s:property></p> 
                                <p>Puntuacion: <s:property value="idUsuarioPublica.totalPuntuacion"></s:property></p>
                                <s:if test="%{#session.usuario != null}">     
                                    <p>
                                    <s:form action="reservar"> <!-- Se podra realizar mas de una reserva por si acaso se quieren reservar varias plazas para varias personas -->
                                        <s:submit name="reservarViaje" value="Reservar plaza" cssClass="btn btn-primary btnBuscar"></s:submit>
                                        <s:hidden name="idViaje" value="%{idViaje}"></s:hidden>
                                    </s:form>
                                    </p>
                                </s:if>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-lg-4 ">
                                <p>Origen:<s:property value="idLocalidadOrigen.nombre"></s:property></p> 
                            <p>Destino:<s:property value="idLocalidadDestino.nombre"></s:property></p> 
                            <p>Precio:<s:property value="percioPersona"></s:property></p> 
                            <p>Plazas disponibles: <s:property value="plazasMax"></s:property></p> 
                            <p>Punto de recogida: <s:property value="puntoRecogida"></s:property></p>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-lg-5 ">
                                <p>Foto coche</p>  Foto del coche del usuario que publica el viaje
                                
                                <!--<div class="fotorama">-->
                                    <!--<img src="http://s.fotorama.io/1.jpg">-->
                                    <!--<img src="http://s.fotorama.io/2.jpg">-->
                                <!--</div>-->
                            </div>

                        </div>
                        <div class="col-lg-2"></div>
                    </div>

            </s:iterator>   
        </s:else>                        
    </div>
</div>
<%@include file="index_footer.jsp" %>