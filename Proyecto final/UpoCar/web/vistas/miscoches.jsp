<%@include file="index_header.jsp" %>
<div class="container">
    <h1 class="text-center">Lista coches</h1>
    <hr/>
    <div class="row">
        <s:form class="form-horizontal" action="toAgregarCoche" method="POST">
            <input type="submit" class="btn btn-success btn-coche-agregar" value="Agregar coche"></input>
        </s:form>
    </div>
    <div class="row">
        <div class="col-md-12">
            <s:iterator value="listaCoches">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail" >
                        <h4 class="text-center"><span class="label label-info"><s:property value="marca"></s:property> <s:property value="modelo"></s:property></span></h4>
                        <div class="fotorama">    
                            <img src="http://placehold.it/650x450&text=Galaxy S5" class="img-responsive">
                            <img src="http://placehold.it/650x450&text=Galaxy S5" class="img-responsive">
                            <img src="http://placehold.it/650x450&text=Galaxy S5" class="img-responsive">
                        </div>
                            <div class="caption">
                                <div class="row">
                                    <div class="col-md-6 col-xs-6">
                                            <h4>Color: <s:property value="color"></s:property></h4>
                                    </div>
                                    <div class="col-md-6 col-xs-6 price">
                                        <h4>
                                            <label>Plazas: <s:property value="plazas"></s:property></label></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                    <s:form class="form-horizontal" action="toModificarCoche" method="POST">
                                        <input type="hidden" name="idCoche" value="<s:property value="idVehiculo"></s:property>" />
                                        <input type="submit" class="btn btn-warning btn-coche" value="Modificar coche"></input>
                                    </s:form>
                                    <!--<a class="btn btn-warning btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Modificar coche</a>--> 
                                </div>
                                <div class="col-md-6">
                                    <s:form class="form-horizontal" action="eliminarCoche" method="POST">
                                        <input type="hidden" name="idCoche" value="<s:property value="idVehiculo"></s:property>" />
                                            <input type="submit" class="btn btn-danger btn-coche" value="Eliminar coche"></input>
                                    </s:form>
                                    <!--<a class="btn btn-danger btn-coche"><span class="glyphicon glyphicon-thumbs-up"></span> Eliminar coche</a>--> 
                                </div>
                            </div>

                            <p> </p>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </div> 

    </div>
</div>
<%@include file="index_footer.jsp" %>