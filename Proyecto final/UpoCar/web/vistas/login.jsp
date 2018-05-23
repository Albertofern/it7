<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">                   

            <div class="wrap">
                <p class="form-title">
                    Login</p>
                    <s:form action="login" cssClass="login">                        
                        <s:textfield cssClass="form-control" name="usuario" cssStyle="inputLogin"></s:textfield>  <%-- Poner un width mas pequeño para los inputs --%>
                        <s:password cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>
                        <s:submit cssClass="btn btn-success btn-sm" name="login" value="Login"></s:submit>     
                    </s:form>
            </div>
        </div>
    </div>
</div>

<%@include file="index_footer.jsp" %>
