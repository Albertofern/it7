<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">
            <h1>¡Bienvenido a UpoCar!</h1>                    

            <s:form action="buscaViaje">
                <div class="input-group">
                    <div class="col-lg-4">
                        <s:textfield cssClass="form-control" name="origen" placeholder="Origen"></s:textfield>                            
                        </div>

                        <div class="col-lg-4">
                        <s:textfield cssClass="form-control" name="destino" placeholder="Destino"></s:textfield>                            
                        </div>

                        <div class="col-lg-4">
                            <!--<input type="date" class="form-control"/>-->
                            <input id="datetime" name="fechaHora" type="datetime-local" class="form-control">
                        </div>                                

                    <s:submit name="buscar" value="Buscar viaje" cssClass="btn btn-default btnBuscar"></s:submit>
                    </div>
            </s:form>
        </div>
    </div>
</div>

<%@include file="index_footer.jsp" %>
