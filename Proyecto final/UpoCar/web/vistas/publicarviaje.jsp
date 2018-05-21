<%@include file="index_header.jsp" %>

<div class="container">
    <div class="col-lg-12">
        <s:form action="publicarViaje">
            <div class="col-lg-4">
                Origen<s:textfield name="origen" cssClass="form-control" ></s:textfield><br/>
                Destino<s:textfield name="destino" cssClass="form-control"></s:textfield><br/>
                Plazas<s:textfield name="plazas" cssClass="form-control"></s:textfield><br/>
                Precio<s:textfield name="precio" cssClass="form-control"></s:textfield><br/>
                Punto de recogida<s:textarea name="recogida" cols="35" rows="8" cssClass="form-control"/>
                Fecha<input type="date" name="fechaSalida" class="form-control"/><br/>
                </div>
                <div class="col-lg-4">
                    <fieldset>
                        <legend>Seleccione el coche para el viaje</legend>             
                       
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