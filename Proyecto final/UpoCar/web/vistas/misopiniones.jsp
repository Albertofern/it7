<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <h1 class="text-center">Mis opiniones</h1> 
    <div class="row box-flex">
        <div class="col-xs-6 opiniones-box">
            <h3>Recibidas</h3>
            <hr>
            <s:iterator value="listaPuntuacionRecibidas">
                <blockquote class="quote-box">
                    <p class="quote-text">
                        <s:property value="comentario"></s:property>
                        </p>
                        <hr>
                        <div class="blog-post-actions">
                            <p class="blog-post-bottom pull-left">
                            <s:property value="idUsuarioPuntua.nombre"></s:property> <s:property value="idUsuarioPuntua.apellidos"></s:property> 
                            </p>
                            <p class="blog-post-bottom pull-right">
                                   Puntuación <span class="badge quote-badge"><s:property value="puntuacion"></s:property></span>
                            </p>
                        </div>
                    </blockquote>
            </s:iterator>
        </div>
        <div class="col-xs-6 opiniones-box">
            <h3>Realizadas</h3>
            <hr>
            <s:iterator value="listaPuntuacionRealizadas">
                <blockquote class="quote-box">
                    <s:form class="form-horizontal" action="eliminarPuntuacion" method="POST">
                        <input type="hidden" name="idPuntuacion" value="<s:property value="idPuntuacion"></s:property>" />
                            <button class="btn btn-danger" id="btnEliminarPuntuacion"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
                        </s:form>
                    <p class="quote-text">
                        <s:property value="comentario"></s:property>
                        </p>
                        <hr>
                        <div class="blog-post-actions">
                            <p class="blog-post-bottom pull-left">
                            <s:property value="idUsuarioRecibe.nombre"></s:property> <s:property value="idUsuarioRecibe.apellidos"></s:property> 
                            </p>
                            <p class="blog-post-bottom pull-right">
                                    Puntuación <span class="badge quote-badge"><s:property value="puntuacion"></s:property></span>
                            </p>
                        </div>
                    </blockquote>
            </s:iterator>

        </div>
    </div>
</div>
<%@include file="index_footer.jsp" %>