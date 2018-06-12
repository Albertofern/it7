<%@include file="index_header.jsp" %>
<div class="container-fluid">

    <h1 class="text-center">Mis Datos</h1>  
    <hr/>
        <div class="row box-misdatos">
                
                <div class="col-xs-12 col-sm-6">
                    
                        <s:iterator value="listadoUsuarios">
                            
                        <div class="col-xs-12">
                            <div class="col-xs-4">
                                <img class="foto-mi-cuenta img-circle img-responsive" src="<s:property value="foto"></s:property>" />        
                                </div>
                                <div class="col-xs-8">
                                <s:form action="agregarFotoPerfil" method="POST" enctype="multipart/form-data">
                                    <input type="file" name="fotoPerfil"></input>
                                <input type="submit" class="btn btn-success pull-left" value="Guardar foto"></input>
                                </s:form>
                                <s:form action="quitarFotoPerfil" method="POST">
                                <input type="submit" class="btn btn-danger pull-left" value="Quitar foto"></input>
                                </s:form>
                                
                            </div>
                                <s:form class="form-horizontal" action="modificarMisDatos" method="POST">
                            <div class="col-xs-12">
                                <p class="pull-left">Puntuación: <span class="badge"><s:property value="totalPuntuacion"></s:property></span></p>
                            </div>
                        </div>
                        <div class="form-group">
                            
                            <label class="control-label col-xs-3 col-md-2" for="usuario">Nickname:</label>
                            <div class="col-xs-9 col-md-10">
                                <input type="text" class="form-control" placeholder="" name="usuario" value="<s:property value="nomUsuario"></s:property>">
                                <s:fielderror fieldName="usuario" cssClass="alert alert-danger" />
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 col-md-2" for="nombre">Nombre:</label>
                            <div class="col-xs-9 col-md-10">
                                <input type="text" class="form-control" placeholder="" name="nombre" value="<s:property value="nombre"></s:property>">
                                <s:fielderror fieldName="nombre" cssClass="alert alert-danger" />
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 col-md-2" for="apellidos">Apellidos:</label>
                            <div class="col-xs-9 col-md-10">
                                <input type="text" class="form-control" placeholder="" name="apellidos" value="<s:property value="apellidos"></s:property>">
                                <s:fielderror fieldName="apellidos" cssClass="alert alert-danger" />
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 col-md-2" for="email">Email:</label>
                            <div class="col-xs-9 col-md-10">
                                <input type="email" class="form-control" placeholder="" name="email" value="<s:property value="email"></s:property>">
                                <s:fielderror fieldName="email" cssClass="alert alert-danger" />
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 col-md-2" for="localidad">Localidad:</label>
                            <div class="col-xs-9 col-md-10">
                                <input type="text" class="form-control" placeholder="" name="localidad" value="<s:property value="localidad"></s:property>">
                                <s:fielderror fieldName="localidad" cssClass="alert alert-danger" />
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 col-md-2" for="sel1">Sexo:</label>
                            <div class="col-xs-9 col-md-10">
                                <select class="form-control" name="sexo"> 
                                    <option value="M" <s:if test='%{sexo == "M"}'>selected</s:if>>Masculino</option>
                                  <option value="F" <s:if test='%{sexo == "F"}'>selected</s:if>>Femenino</option>
                                </select>
                            </div>
                            
                          </div>
                        <div class="form-group">        
                            <div class="col-xs-offset-3 col-xs-9 col-md-offset-2 col-md-10">
                              <button type="submit" class="btn btn-success btn-fullspace">Modificar</button>
                            </div>
                          </div>
                    </s:form>
                    </s:iterator>
                </div>
                <div class="col-xs-12 col-sm-6">
                    
                        <div class="form-group">
                            <h3 class="text-center">Teléfonos:</h3>
                            <hr/>
                            <div class="row">
                                <div class="col-xs-12">
                                    <s:fielderror fieldName="telefono" cssClass="alert alert-danger" />
                                    <s:form class="form-horizontal" action="agregarTelefono">
                                    <div class="input-group">
                                        <input type="text" name="nuevoTlf" class="form-control" placeholder="ej: 654876123">
                                        <span class="input-group-btn">
                                            <button class="btn btn-success" name="agregarTlf" type="submit">Agregar</button>
                                        </span>
                                      </div>
                                    </s:form>
                                </div>
                                <br />
                                <s:iterator value="listadoTelefonos">
                                <div class="col-xs-12">
                                    <div class="col-xs-10">
                                    <s:form class="form-horizontal" action="modificarTelefono" method="POST">
                                        <input type="text" class="form-control" name="nuevoTlf" value="<s:property value="numTel"></s:property>">
                                    </div>
                                    <div class="col-xs-1">
                                        <input type="hidden" name="idTelefono" value="<s:property value="idTel"></s:property>" />
                                        <div><button class="btn btn-warning" name="modificarTlf" type="submit"><img class="img-icon" title="Modificar" src="./images/update.png" /></button></div>
                                    </s:form>
                                    </div>
                                    <div class="col-xs-1">
                                    <s:form class="form-horizontal" action="eliminarTelefono" method="POST">
                                        <input type="hidden" name="idTelefono" value="<s:property value="idTel"></s:property>" />
                                        <div><button class="btn btn-danger"><img class="img-icon" title="Eliminar" src="./images/papelera.png" /></button></div>
                                    </s:form>
                                    </div>
                                </div>
                                </s:iterator>
                                
                            </div>
                          </div>
                    
                </div>
        </div>

</div>
<%@include file="index_footer.jsp" %>