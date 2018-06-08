<%@include file="index_header.jsp" %>

<div class="container">
    <div class="col-lg-12">
        <s:form action="publicarViaje" cssClass="login">
            <div class="col-lg-6">
                <!-- Poner otro select para la provincia ? No seria dinamico al seleccionar=problema -->

                Origen<s:select list="origen" name="localidadOrigen" listKey="idLocalidad" listValue="nombre" cssClass="form-control"></s:select><br/>
                Destino<s:select list="destino" name="localidadDestino" listKey="idLocalidad" listValue="nombre" cssClass="form-control"></s:select><br/> 
                
                <s:fielderror fieldName="plazas" cssClass="alert alert-danger" />
                Plazas<s:textfield name="plazas" cssClass="form-control"></s:textfield><br/>
                
                <s:fielderror fieldName="precio" cssClass="alert alert-danger" />
                Precio<s:textfield name="precio" cssClass="form-control"></s:textfield><br/>
                
                <s:fielderror fieldName="recogida" cssClass="alert alert-danger" />
                Punto de recogida<s:textarea name="recogida" cols="35" rows="8" cssClass="form-control"/><br/>
                
                <s:fielderror fieldName="fechaSalida" cssClass="alert alert-danger" />
                Fecha y hora de salida<input id="datetime" name="fechaSalida" type="datetime-local" class="form-control"><br/>

            </div>
            <div class="col-lg-6">
                <fieldset>
                    <legend>Seleccione el coche para el viaje</legend>             
                    <s:fielderror fieldName="coches" cssClass="alert alert-danger" />
                    <s:iterator value="listadoCoches" var="vehiculo">
                        <s:radio name="coches" listKey="idVehiculo" list="%{marca+' ' +modelo+' ' +color}"/><br>
                    </s:iterator>

                </fieldset>
                <s:submit name="publicar" value="Publicar viaje" cssClass="btn btn-success btn-sm"></s:submit>
                </div>

        </s:form>
    </div>
</div>


<%@include file="index_footer.jsp" %>