<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        <h1>Mis Datos</h1>  
        <div class="row">
                
                <div class="col-xs-12 col-sm-6">
                    
                        <s:iterator value="listadoUsuarios">
                            <s:form class="form-horizontal" action="modificarMisDatos" method="POST">
                        <div class="col-xs-12">
                            <div class="col-xs-6">
                                <img class="foto-mi-cuenta img-circle img-responsive" src="<s:property value="foto"></s:property>" />        
                                Foto: <input type="file" multiple="true" class="btn btn-default"></input>
                            </div>
                            <div class="col-xs-6">
                                <br/><br/>
                                <p>Tu puntuación es: <span class="badge"><s:property value="totalPuntuacion"></s:property></span></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="usuario">Usuario:</label>
                            <div class="col-xs-10">
                                <%--<s:textfield name="nombre" label="Nombre" value="" class="form-control" />--%>
                                <input type="text" class="form-control" placeholder="" name="usuario" value="<s:property value="nomUsuario"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="nombre">Nombre:</label>
                            <div class="col-xs-10">
                                <%--<s:textfield name="nombre" label="Nombre" value="" class="form-control" />--%>
                                <input type="text" class="form-control" placeholder="" name="nombre" value="<s:property value="nombre"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="apellidos">Apellidos:</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" placeholder="" name="apellidos" value="<s:property value="apellidos"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="email">Email:</label>
                            <div class="col-xs-10">
                                <input type="email" class="form-control" placeholder="" name="email" value="<s:property value="email"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="localidad">Localidad:</label>
                            <div class="col-xs-10">
                                <input type="text" class="form-control" placeholder="" name="localidad" value="<s:property value="localidad"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="sel1">Sexo:</label>
                            <div class="col-xs-10">
                                <select class="form-control" name="sexo" value="<s:property value="sexo"></s:property>">
                                  <option value="M" >Masculino</option>
                                  <option value="F">Femenino</option>
                                </select>
                            </div>
                            
                          </div>
                        <div class="form-group">        
                            <div class="col-xs-offset-2 col-xs-10">
                              <button type="submit" class="btn btn-success">Modificar</button>
                            </div>
                          </div>
                    </s:form>
                    </s:iterator>
                </div>
                <div class="col-xs-12 col-sm-6">
                    
                        <div class="form-group">
                            <label class="control-label col-xs-2" for="telefonos">Telefonos:</label>
                            <div class="col-xs-10">
                                <div class="col-xs-12"><!--<div class="col-lg-1"></div><button class="btn btn-success col-lg-11">Nuevo teléfono</button>-->
                                    <s:form class="form-horizontal" action="agregarTelefono">
                                    <div class="input-group">
                                        <input type="text" name=nuevoTlf class="form-control" placeholder="ej: 654876123">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" name="agregarTlf" type="submit">Agregar<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                        </span>
                                      </div>
                                    </s:form>
                                </div>
                                <br />
                                <s:iterator value="listadoTelefonos">
                                <div class="col-sm-12">
                                    <div class="col-xs-10">
                                        <input type="text" class="form-control" name="nuevoTlf" value="<s:property value="numTel"></s:property>">
                                    </div>
                                    <div class="col-xs-1">
                                    <s:form class="form-horizontal" action="modificarTelefono" method="POST">
                                        <input type="hidden" name="idTelefono" value="<s:property value="idTel"></s:property>" />
                                        <div><button class="btn btn-warning" name="modificarTlf" type="submit"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></div>
                                    </s:form>
                                    </div>
                                    <div class="col-xs-1">
                                    <s:form class="form-horizontal" action="eliminarTelefono" method="POST">
                                        <input type="hidden" name="idTelefono" value="<s:property value="idTel"></s:property>" />
                                        <div><button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></div>
                                    </s:form>
                                    </div>
                                </div>
                                </s:iterator>
                                
                            </div>
                          </div>
                    
                </div>
        </div>
    </div>
</div>
<%@include file="index_footer.jsp" %>