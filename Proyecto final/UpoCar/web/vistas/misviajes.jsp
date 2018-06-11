<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <h1 class="text-center">Mis viajes</h1> 
    
    <s:if test="%{listaViajes.size() > 0}">
        <s:iterator value="listaViajes" status="viaje">
            <div class="row">
    <div class="panel panel-default event">
        <div class="panel-body">
            <div class="rsvp col-xs-2 col-sm-2">
                <i><s:property value="(fechaSalida.split(' ')[0]).split('-')[2]"></s:property></i>
                <i><s:property value="(fechaSalida.split(' ')[0]).split('-')[1]"></s:property></i>
                <div>
                    <i><s:property value="(fechaSalida.split(' ')[0]).split('-')[0]"></s:property></i>
                </div>
            </div>
            <div class="info col-xs-8 col-sm-7">
                <div class="row">
                    <div class="col-xs-10">
                        
                        
                        
                        
                        <div class="row colum1">
                            <div class="col-xs-6">
                                Origen: <s:property value="idLocalidadOrigen.nombre"></s:property>
                            </div>
                            <div class="col-xs-6">
                                Destino: <s:property value="idLocalidadDestino.nombre"></s:property>
                            </div>
                        </div>
                        <div class="row colum1">
                            <div class="col-xs-6">
                                Lugar recogida: <s:property value="puntoRecogida"></s:property>
                            </div>
                            <div class="col-xs-3">
                                Plazas: <s:property value="listaPasajeros.size()"></s:property> de <s:property value="plazasMax"></s:property>
                            </div>
                        </div>
                        <div class="row colum1 box-flex">
                        <s:iterator value="listaPasajeros">
                                <div class="col-xs-2 pasajero-box">
                                    <s:property value="idUsuario.nombre"></s:property>
                                    <s:property value="idUsuario.apellidos"></s:property>
                                    <s:form class="form-horizontal" action="eliminarPasajeroViaje" method="POST">
                                        <input type="hidden" name="idPasajero" value="<s:property value="idPasajero"></s:property>" />
                                        <button class="btn btn-danger" id="btnEliminarPasajero"></button>
                                    </s:form>
                                </div>  
                            </s:iterator>
                        <s:if test="%{listaPasajeros.size() == 0}">
                            <div class="alert alert-danger sin-pasajeros text-center" role="alert">
                                Sin pasajeros
                              </div>
                        </s:if>
                        </div>
                            
                            
                    </div>
                    <div class="col-xs-2">
                        <div class="row price">
                            <s:property value="percioPersona"></s:property>
                        </div>
                        <div class="row text-price">
                            euros por persona
                        </div>

                    </div>
                        
                </div>    
            </div>
            <div class="author col-xs-2 col-sm-3">  
                <div class="profile">
                    <s:form class="form-horizontal" action="eliminarViaje" method="POST">
                        <input type="hidden" name="idViaje" value="<s:property value="idViaje"></s:property>" />
                        <button class="btn btn-danger" id="btnEliminarViaje"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
                    </s:form>
                    <strong><s:property value="idUsuarioPublica.nomUsuario"></s:property> <s:property value="idUsuarioPublica.apellidos"></s:property></strong>
                <article class="hidden-sm">Datos del coche:</article>
                    <div class="links">
                        <i class="col-xs-6"><s:property value="idVehiculoElegido.marca"></s:property></i>
                        <i class="col-xs-6"><s:property value="idVehiculoElegido.modelo"></s:property></i>
                        <i class="col-xs-12">Color: <s:property value="idVehiculoElegido.color"></s:property></i>
                    </div>
                </div>

            </div>
        </div>
    </div>
            </div>
    </s:iterator>
    </s:if>
    <s:else>
        <div class="alert alert-danger text-center" role="alert">
            No tienes publicado ningun viaje
          </div>
    </s:else>
</div>
<%@include file="index_footer.jsp" %>