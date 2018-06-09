<%@include file="index_header.jsp" %>

<div class="row">
    <div class="col-lg-2 col-md-2"></div>
    <div class="col-lg-8 col-md-8">
        <s:form action="contactarCon">
            <h3>Enviar mensaje</h3>            
            <s:textarea name="texto" cols="35" rows="8" cssClass="form-control"/>            
            <s:submit name="contactarCon" value="Enviar mensaje" cssClass="btn btn-primary pull-right"></s:submit>
            <s:hidden name="idUsuarioContacto" value="%{idUsuario}"></s:hidden>
        </s:form>
    </div>
    <div class="col-lg-2 col-md-2"></div>
</div>

<%@include file="index_footer.jsp" %>