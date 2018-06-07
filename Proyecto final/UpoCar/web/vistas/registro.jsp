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
                                    Nickname<s:textfield cssClass="form-control" name="usuario"></s:textfield>
                                    Nombre<s:textfield cssClass="form-control" name="nombre"></s:textfield>  
                                    Apellidos<s:textfield cssClass="form-control" name="apellidos" cssStyle="inputLogin"></s:textfield>  
                                    Email<s:textfield cssClass="form-control" name="email" cssStyle="inputLogin"></s:textfield> 
                                    DNI<s:textfield cssClass="form-control" name="dni" cssStyle="inputLogin"></s:textfield>  
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">

                                        Localidad<s:textfield cssClass="form-control" name="localidad" cssStyle="inputLogin"></s:textfield>  

                                        Telefono<s:textfield cssClass="form-control" name="telefono" cssStyle="inputLogin"></s:textfield>  
                                    Password<s:password cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>
                                    </div>        
                                </div>

                                <div class="form-group">
                                    <select name="sexo" class="form-control"> 
                                        <option selected disabled>Sexo</option>
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