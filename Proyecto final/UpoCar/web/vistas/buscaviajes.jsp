<%@include file="index_header.jsp" %>
<div class="container-fluid">
<div id="background-firstlook">
            <h1>�Buscar viaje!</h1>                    

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
            
            <!-- Comprobar que haya algun viaje, sino, mostrar un mensaje de que no hay viajes disponibles para la busqueda realizada -->
            <s:iterator value="listadoViajes">
                <s:property value="idLocalidadDestino.idProvincia.nombre"></s:property>
                
                <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8 colum-height">
                    <div class="col-xs-12 col-sm-2 col-lg-3 color1">
                        <p>Imagen</p> <!-- Imagen del usuario que publica el viaje, si no tiene, que muestre una por defecto -->
                        <p>usuario</p> <!-- Nombre y apellidos del usuario que publica el viaje -->
                        <p>Puntuacion</p> <!-- Puntuacion del usuario que publica el viaje -->
                    </div>
                    <div class="col-xs-12 col-sm-4 col-lg-4 color2">
                        <p>Origen:<s:property value="idLocalidadOrigen.nombre"></s:property></p> <!-- Origen del viaje -->
                        <p>Destino:<s:property value="idLocalidadDestino.nombre"></s:property></p> <!-- Destino del viaje -->
                        <p>Precio:<s:property value="percioPersona"></s:property></p> <!-- Precio del viaje -->
                        <p>Plazas disponibles: <s:property value="plazasMax"></s:property></p> <!-- Plazas disponibles para el viaje -->
                    </div>
                    <div class="col-xs-12 col-sm-6 col-lg-5 color3">
                        <p>Foto coche</p> <!-- Foto del coche del usuario que publica el viaje -->
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>
                
            </s:iterator>                                               
</div>
</div>
<%@include file="index_footer.jsp" %>