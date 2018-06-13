<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">                   
            <div class="row">
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <div class="modal-dialog modal-login">
                        <div class="modal-content modal-position">
                            <div class="modal-header">
                                <div class="avatar">
                                    <img src="./images/avatar.png" alt="Avatar">
                                </div>				
                                <h4 class="modal-title">Entrar en UpoCar</h4>	

                            </div>
                            <div class="modal-body">
                                <s:form action="login" cssClass="login">  
                                    <div class="form-group">
                                        <s:fielderror fieldName="usuario" cssClass="alert alert-danger" />
                                        Nickname<s:textfield cssClass="form-control" name="usuario" cssStyle="inputLogin"></s:textfield>
                                        </div>
                                        <div class="form-group">
                                        <s:fielderror fieldName="password" cssClass="alert alert-danger" />
                                        Password<s:password cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>
                                        </div>        
                                        <div class="form-group">

                                        <s:submit cssClass="btn btn-primary btn-lg btn-block login-btn" name="login" value="Login"></s:submit>    
                                        </div>
                                </s:form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-1"></div>
            </div>





        </div>
    </div>
</div>

<%@include file="index_footer.jsp" %>
