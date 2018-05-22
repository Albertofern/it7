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
            
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8 colum-height">
                    <div class="col-xs-12 col-sm-2 col-lg-3 color1">
                        <p>Imagen</p> <!-- Imagen del usuario que publica el viaje -->
                        <p>usuario</p> <!-- Nombre y apellidos del usuario que publica el viaje -->
                        <p>Puntuacion</p> <!-- Puntuacion del usuario que publica el viaje -->
                    </div>
                    <div class="col-xs-12 col-sm-4 col-lg-4 color2">
                        <p>Origen:</p> <!-- Origen del viaje -->
                        <p>Destino:</p> <!-- Destino del viaje -->
                        <p>Precio:</p> <!-- Precio del viaje -->
                        <p>Plazas disponibles:</p> <!-- Plazas disponibles para el viaje -->
                    </div>
                    <div class="col-xs-12 col-sm-6 col-lg-5 color3">
                        <p>Foto coche</p> <!-- Foto del coche del usuario que publica el viaje -->
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>
            
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8 colum-height">
                    <div class="col-xs-12 col-lg-12 color4">
                        <br/>
                        <br/>
                        <br/>
                        <p> ... </p>
                        <br/>
                        <br/>
                        <br/>
                    </div>
                </div>
                <div class="col-lg-2"></div>
            </div>

</div>
</div>
<%@include file="index_footer.jsp" %>