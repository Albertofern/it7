<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">                   

            <div class="wrap">
                <p class="form-title">
                    Registro</p>
                    <s:form action="registro" cssClass="login">                        
                        <s:textfield cssClass="form-control" name="usuario" cssStyle="inputLogin"></s:textfield>  
                        <s:textfield cssClass="form-control" name="nombre" cssStyle="inputLogin"></s:textfield>  
                        <s:textfield cssClass="form-control" name="apellidos" cssStyle="inputLogin"></s:textfield>  
                        <s:textfield cssClass="form-control" name="email" cssStyle="inputLogin"></s:textfield>  
                        <s:textfield cssClass="form-control" name="dni" cssStyle="inputLogin"></s:textfield>  
                        <s:textfield cssClass="form-control" name="localidad" cssStyle="inputLogin"></s:textfield>  
                        <select name="sexo"> 
                            <option value="M">Masculino</option> 
                            <option value="F">Femenino</option>                             
                        </select> 
                    <s:textfield cssClass="form-control" name="telefono" cssStyle="inputLogin"></s:textfield>  
                    <s:password cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>
                    <s:submit cssClass="btn btn-success btn-sm" name="Registro" value="Login"></s:submit>     
                </s:form>
            </div>
        </div>
    </div>
</div>



<%@include file="index_footer.jsp" %>