<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">                   


            <div class="modal-dialog modal-registro">
                <div class="modal-content modal-position">
                    <div class="modal-header">
                        			
                        <h4 class="modal-title">Registrate</h4>	
                        
                    </div>
                    <div class="modal-body">
                        <s:form action="registro" cssClass="login">  
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <s:fielderror fieldName="usuario" cssClass="alert alert-danger" />
                                    Nickname<s:textfield cssClass="form-control" name="usuario"></s:textfield>
                                    <s:fielderror fieldName="nombre" cssClass="alert alert-danger" />
                                    Nombre<s:textfield cssClass="form-control" name="nombre"></s:textfield>  
                                    <s:fielderror fieldName="apellidos" cssClass="alert alert-danger" />
                                    Apellidos<s:textfield cssClass="form-control" name="apellidos" cssStyle="inputLogin"></s:textfield>  
                                    <s:fielderror fieldName="email" cssClass="alert alert-danger" />
                                    Email<s:textfield cssClass="form-control" name="email" cssStyle="inputLogin"></s:textfield> 
                                    <s:fielderror fieldName="dni" cssClass="alert alert-danger" />
                                    DNI<s:textfield cssClass="form-control" name="dni" cssStyle="inputLogin"></s:textfield>  
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <s:fielderror fieldName="localidad" cssClass="alert alert-danger" />
                                        Localidad<s:textfield cssClass="form-control" name="localidad" cssStyle="inputLogin"></s:textfield>  
                                        <s:fielderror fieldName="telefono" cssClass="alert alert-danger" />
                                        Telefono<s:textfield cssClass="form-control" name="telefono" cssStyle="inputLogin"></s:textfield>
                                        <s:fielderror fieldName="password" cssClass="alert alert-danger" />
                                        Password<s:password cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>
                                    </div>        
                                </div>

                                <div class="form-group">
                                    <select name="sexo" class="form-control"> 
                                        <option value="M">Masculino</option> 
                                        <option value="F">Femenino</option>                             
                                    </select> <br/>
                                <s:submit cssClass="btn btn-primary btn-lg btn-block login-btn" name="Registro" value="Registro"></s:submit> 

                                </div>
                        </s:form>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>



<%@include file="index_footer.jsp" %>