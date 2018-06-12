<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <h1 class="text-center">Mis reservas</h1> 
    
    <s:if test="%{listaReservas.size() > 0}">
        <s:iterator value="listaReservas" status="reserva">
    
    <div class="panel panel-default event">
        <div class="panel-body">
            <div class="rsvp col-xs-2 col-sm-2">
                <i><s:property value="(idViaje.fechaSalida.split(' ')[0]).split('-')[2]"></s:property></i>
                <i><s:property value="(idViaje.fechaSalida.split(' ')[0]).split('-')[1]"></s:property></i>
                <div>
                    <i><s:property value="(idViaje.fechaSalida.split(' ')[0]).split('-')[0]"></s:property></i>
                </div>
            </div>
            <div class="info col-xs-8 col-sm-7">
                <div class="row">
                    <div class="col-xs-10">
                        
                        
                        
                        
                        <div class="row colum1">
                            <div class="col-xs-6">
                                Origen: <s:property value="idViaje.idLocalidadOrigen.nombre"></s:property>
                            </div>
                            <div class="col-xs-6">
                                Destino: <s:property value="idViaje.idLocalidadDestino.nombre"></s:property>
                            </div>
                        </div>
                        <div class="row colum1">
                            <div class="col-xs-6">
                                Lugar recogida: <s:property value="idViaje.puntoRecogida"></s:property>
                            </div>
                            <div class="col-xs-3">
                                Plazas: <s:property value="idViaje.plazasMax"></s:property>
                            </div>
                        </div>       
                    </div>
                    <div class="col-xs-2">
                        <div class="row price">
                            <s:property value="idViaje.percioPersona"></s:property>
                        </div>
                        <div class="row text-price">
                            euros por persona
                        </div>

                    </div>
                        
                </div>    
            </div>
            <div class="author col-xs-2 col-sm-3">  
                <div class="profile">
                    <s:form class="form-horizontal" action="eliminarReserva" method="POST">
                        <input type="hidden" name="idPasajero" value="<s:property value="idPasajero"></s:property>" />
                        <button class="btn btn-danger btnEliminarReserva" ><img class="img-icon" title="Eliminar" src="./images/papelera.png" /></button>
                    </s:form>
                    <strong><s:property value="idViaje.idUsuarioPublica.nomUsuario"></s:property> <s:property value="idViaje.idUsuarioPublica.apellidos"></s:property></strong>
                    <article>Datos del coche:</article>
                    <div class="links">
                        <i class="col-xs-6"><s:property value="idViaje.idVehiculoElegido.marca"></s:property></i>
                        <i class="col-xs-6"><s:property value="idViaje.idVehiculoElegido.modelo"></s:property></i>
                        <i class="col-xs-12">Color: <s:property value="idViaje.idVehiculoElegido.color"></s:property></i>
                    </div>
                </div>

            </div>
        </div>
    </div>
    </s:iterator>
    </s:if>
    <s:else>
        <div class="alert alert-danger text-center" role="alert">
            No tienes reservas
          </div>
    </s:else>
</div>
<%@include file="index_footer.jsp" %>