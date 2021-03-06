<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">
            <h1>ˇBienvenido a UpoCar!</h1>                    
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <s:form action="buscaViaje">                        
                        <s:fielderror fieldName="origen" cssClass="alert alert-danger" />
                        <div class="col-lg-3 ">
                            
                            <s:textfield cssClass="form-control" name="origen" placeholder="Origen"></s:textfield>                            
                            </div>

                            <div class="col-lg-3">
                            <s:fielderror fieldName="destino" cssClass="alert alert-danger" />
                            <s:textfield cssClass="form-control" name="destino" placeholder="Destino"></s:textfield>                            
                            </div>

                            <div class="col-lg-6">
                                <s:fielderror fieldName="fechaHora" cssClass="alert alert-danger" />
                                <input id="datetime" name="fechaHora" placeholder="yyyy/mm/ddTHH:mm" type="datetime-local" class="form-control">
                            </div>
                        <s:submit name="buscar" value="Buscar viaje" cssClass="btn btn-default btnBuscar"></s:submit>
                    </s:form>
                </div>
            </div>
            <div class="col-lg-1"></div>
        </div>
    </div>
</div>

<%@include file="index_footer.jsp" %>
