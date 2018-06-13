<%@include file="index_header.jsp" %>
<div class="container">
    <div class="row datos-cohe">
        <h1 class="text-center">Modificar coche</h1>
        <hr/>
        <s:iterator value="listaCoches">
            <s:form class="form-horizontal" action="modificarCoche" method="POST">
                <div class="col-xs-12 col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="marca">Marca:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="" name="marca" value="<s:property value="marca"></s:property>">
                            <s:fielderror fieldName="marca" cssClass="alert alert-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="modelo">Modelo:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="" name="modelo" value="<s:property value="modelo"></s:property>">
                            <s:fielderror fieldName="modelo" cssClass="alert alert-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="color">Color:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="" name="color" value="<s:property value="color"></s:property>">
                            <s:fielderror fieldName="color" cssClass="alert alert-danger" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="plazas">Plazas</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="" name="plazas" value="<s:property value="plazas"></s:property>">
                            <s:fielderror fieldName="plazas" cssClass="alert alert-danger" />
                        </div>
                    </div>
                    <div class="form-group">        
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="hidden" name="idCoche" value="<s:property value="idVehiculo"></s:property>" />
                                <button type="submit" class="btn btn-primary">Modificar</button>
                            </div>
                        </div>
                    </div>
            </s:form>


            <div class="col-xs-12 col-sm-6">
                <s:form class="form-horizontal" action="agregarFotoCoche" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="buscarFotos">Agregar fotos:</label>
                        <s:file name="fotoCoche" cssClass="btn btn-default"></s:file>
                        <s:fielderror fieldName="fotoCoche" cssClass="alert alert-danger" />
                        </div>
                        <div class="form-group">        
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="hidden" name="idCoche" value="<s:property value="idVehiculo"></s:property>" />
                                <button type="submit" class="btn btn-success">Guardar fotos</button>
                            </div>
                        </div>
                </s:form>

                <s:iterator value="listaFotosVehiculos">
                    <s:form class="form-horizontal" action="eliminarFotoCoche" method="POST">
                        <input type="hidden" name="idFotoVehi" value="<s:property value="idFotoVehi"></s:property>" />
                        <input type="hidden" name="idCoche" value="<s:property value="idVehiculo.idVehiculo"></s:property>" />
                        <span><s:property value="rutaFoto.split('/')[2]"></s:property></span>
                            <button class="btn btn-danger"><img class="img-icon" title="Eliminar" src="./images/papelera.png" /></button>
                        </s:form>
                    </s:iterator>

            </div>
        </s:iterator>
    </div>
    <div class="col-lg-4">
        <s:form class="form-horizontal" action="toMisCoches" method="POST">
            <input type="submit" class="btn btn-info btn-coche" value="Volver"></input>
        </s:form>
    </div>
</div>

<%@include file="index_footer.jsp" %>