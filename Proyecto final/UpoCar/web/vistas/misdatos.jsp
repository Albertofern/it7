<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        <h1>Mis Datos</h1>  
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                
                <div class="col-lg-6">
                    
                        <s:iterator value="listadoUsuarios">
                    <form class="form-horizontal" action="">
                        <div class="col-lg-12">
                            <div class="col-lg-6">
                                <img class="foto-mi-cuenta img-circle img-responsive" src="https://cdnb.20m.es/sites/76/2015/07/La-an%C3%A9cdota-sobre-la-famosa-e-ic%C3%B3nica-foto-de-Albert-Einstein-sacando-la-lengua.jpeg" />        
                                <button class="btn btn-default">Buscar foto</button>
                            </div>
                            <div class="col-lg-6">
                                <br/><br/>
                                <p>Tu puntuación es: <span class="badge"><s:property value="totalPuntuacion"></s:property></span></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <%--<s:textfield name="nombre" label="Nombre" value="" class="form-control" />--%>
                                <input type="text" class="form-control" placeholder="" name="nombre" value="<s:property value="nombre"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="apellidos">Apellidos:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="" name="apellidos" value="<s:property value="apellidos"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Email:</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" placeholder="" name="email" value="<s:property value="email"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="localidad">Localidad:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="" name="localidad" value="<s:property value="localidad"></s:property>">
                            </div>
                          </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="sel1">Sexo:</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="sel1" value="<s:property value="sexo"></s:property>">
                                    <option value="S/N" <s:if test="%{sexo == 'S/N'}">Selected</s:if> >S/N</option>
                                  <option value="M" <s:if test="%{sexo == 'M'}">Selected</s:if> >Masculino</option>
                                  <option value="F" <s:if test="%{sexo == 'F'}">Selected</s:if> >Femenino</option>
                                </select>
                            </div>
                            
                          </div>
                        <div class="form-group">        
                            <div class="col-sm-offset-2 col-sm-10">
                              <button type="submit" class="btn btn-success">Guardar</button>
                            </div>
                          </div>
                    </form>
                    </s:iterator>
                </div>
                <div class="col-lg-6">
                    <form class="form-horizontal" action="">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="telefonos">Telefonos:</label>
                            <div class="col-sm-10">
                                <div class="col-sm-12"><div class="col-lg-1"></div><button class="btn btn-success col-lg-11">Nuevo teléfono</button></div>
                                <div class="col-sm-12">
                                    <div class="col-sm-10"><input type="text" class="form-control" placeholder="" name="telefono" value="736152342"></div>
                                    <div class="col-sm-1"><button class="btn btn-warning"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></div>
                                    <div class="col-sm-1"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="col-sm-10"><input type="text" class="form-control" placeholder="" name="telefono" value="736152342"></div>
                                    <div class="col-sm-1"><button class="btn btn-warning"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></div>
                                    <div class="col-sm-1"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="col-sm-10"><input type="text" class="form-control" placeholder="" name="telefono" value="736152342"></div>
                                    <div class="col-sm-1"><button class="btn btn-warning"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></div>
                                    <div class="col-sm-1"><button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></div>
                                </div>
                                
                            </div>
                          </div>
                    </form>
                </div>
            </div>
            
            <div class="col-lg-2"></div>
        </div>
    </div>
</div>
<%@include file="index_footer.jsp" %>