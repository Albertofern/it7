<%@include file="index_header.jsp" %>
<div class="container">
    <div class="row datos-cohe">
        <h1 class="text-center">Agregar coche</h1>
        <hr/>
        <s:form>
            <div class="col-xs-12 col-sm-6">
            <div class="form-group">
                <label class="control-label col-sm-2" for="marca">Marca:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="" name="marca" value="<s:property value=""></s:property>">
                    </div>
                </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="modelo">Modelo:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="" name="modelo" value="<s:property value=""></s:property>">
                    </div>
                </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="color">Color:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="" name="color" value="<s:property value=""></s:property>">
                    </div>
                </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="plazas">Plazas</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="" name="plaza" value="<s:property value=""></s:property>">
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="buscarFotos">Agregar fotos:</label>
                <input type="file" multiple="true" class="btn btn-default"></input>
                </div>
            </div>
        </s:form>
    </div>
    <hr/>
    <div class="row">
        <div class="col-md-12">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail" >
                    <h4 class="text-center"><span class="label label-info">Samsung</span></h4>
                    <img src="http://placehold.it/650x450&text=Galaxy S5" class="img-responsive">
                    <div class="caption">
                        <div class="row">
                            <div class="col-md-6 col-xs-6">
                                <h4>Galaxy S5</h4>
                            </div>
                            <div class="col-md-6 col-xs-6 price">
                                <h4>
                                    <label>$649.99</label></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a class="btn btn-warning btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Modificar coche</a> 
                            </div>
                            <div class="col-md-6">
                                <a class="btn btn-danger btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Eliminar coche</a> 
                            </div>
                        </div>

                        <p> </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail" >
                    <h4 class="text-center"><span class="label label-info">Apple</span></h4>
                    <img src="http://placehold.it/650x450&text=iPhone 6" class="img-responsive">
                    <div class="caption">
                        <div class="row">
                            <div class="col-md-6 col-xs-6">
                                <h3>iPhone 6</h3>
                            </div>
                            <div class="col-md-6 col-xs-6 price">
                                <h3>
                                    <label>$749.99</label></h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a class="btn btn-warning btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Modificar coche</a> 
                            </div>
                            <div class="col-md-6">
                                <a class="btn btn-danger btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Eliminar coche</a> 
                            </div>
                        </div>

                        <p> </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail" >
                    <h4 class="text-center"><span class="label label-info">Nokia</span></h4>
                    <img src="http://placehold.it/650x450&text=Lumia 1520" class="img-responsive">
                    <div class="caption">
                        <div class="row">
                            <div class="col-md-6 col-xs-6">
                                <h3>Lumia 1520</h3>
                            </div>
                            <div class="col-md-6 col-xs-6 price">
                                <h3>
                                    <label>$749.00</label></h3>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a class="btn btn-warning btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Modificar coche</a> 
                            </div>
                            <div class="col-md-6">
                                <a class="btn btn-danger btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Eliminar coche</a> 
                            </div>
                        </div>

                        <p> </p>
                    </div>
                </div>
            </div>

        </div> 

    </div>
</div>
<%@include file="index_footer.jsp" %>