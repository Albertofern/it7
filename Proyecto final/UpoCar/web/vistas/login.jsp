<%@include file="index_header.jsp" %>

<div id="background-firstlook" class="firstlook">
    <div class="col-md-6 col-md-offset-3" id="contentPpal">
        <div id="infoPpal">                   
            <div class="card card-container">               
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <s:form action="login" cssClass="login"> 
                    <span id="reauth-email" class="reauth-email"></span>
                    Usuario:
                    <s:textfield id="inputEmail" cssClass="form-control"  name="usuario" cssStyle="inputLogin"></s:textfield>
                    Password:
                    <s:password id="inputPassword" cssClass="form-control" name="password" cssStyle="inputLogin"></s:password>

                    <s:submit cssClass="btn btn-lg btn-primary btn-block btn-signin" name="login" value="Login"></s:submit>  
                </s:form>
            </div>            
        </div>
    </div>
</div>

<%@include file="index_footer.jsp" %>
