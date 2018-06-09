<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div class="row" id="mis-mensajes">
      <h2 class="page-header text-center">Mensajes</h2>
        <section class="comment-list box-flex">
            <div class="col-xs-12 col-sm-6 men-enviado">
                <h4 class="page-header text-center">Enviados</h4>
                <!-- Mensaje enviado -->
                <s:iterator value="listaMensajesEnviados">
          <article class="row">
            <div class="col-md-4 hidden-sm hidden-xs">
              <figure class="thumbnail">
                <figcaption class="text-center"><s:property value="idUsuarioEnvia.nombre"></s:property></figcaption>
              </figure>
            </div>
            <div class="col-md-8 col-sm-12 col-xs-12">
              <div class="panel panel-default arrow left">
                  <s:form class="form-horizontal" action="eliminarMensaje" method="POST">
                        <input type="hidden" name="idMensaje" value="<s:property value="idMensaje"></s:property>" />
                            <button class="btn btn-danger" id="btnEliminarMensaje"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
                        </s:form>
                <div class="panel-body">
                  <header class="text-left">
                      <div class="comment-user"><span class="hidden-lg hidden-md"><s:property value="idUsuarioEnvia.nombre"></s:property> a </span><s:property value="idUsuarioRecibe.nombre"></s:property></div>
                    <time class="comment-date" datetime="16-12-2014 01:05"> <s:property value="fechaHora"></s:property></time>
                  </header>
                  <div class="comment-post">
                    <p>
                      <s:property value="texto"></s:property>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </article>
                </s:iterator>
                <s:if test="%{listaMensajesEnviados.size() == 0}">
                            <div class="alert alert-danger sin-pasajeros text-center" role="alert">
                                No hay mensajes
                              </div>
                        </s:if>
            </div>
            <div class="col-xs-12 col-sm-6 men-recibido">
                <h4 class="page-header text-center">Recibidos</h4>
          <!-- Mensaje recibido -->
          <s:iterator value="listaMensajesRecibidos">
          <article class="row">
            <div class="col-md-8 col-sm-12 col-xs-12">
              <div class="panel panel-default arrow right">
                <div class="panel-body">
                  <header class="text-right">
                      <div class="comment-user"><span class="hidden-lg hidden-md"><s:property value="idUsuarioEnvia.nombre"></s:property> a </span> </span><s:property value="idUsuarioRecibe.nombre"></s:property></div>
                    <time class="comment-date" datetime="16-12-2014 01:05"> <s:property value="fechaHora"></s:property></time>
                  </header>
                  <div class="comment-post">
                    <p>
                      <s:property value="texto"></s:property>
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4 hidden-sm hidden-xs">
              <figure class="thumbnail">
                <figcaption class="text-center"><s:property value="idUsuarioEnvia.nombre"></s:property></figcaption>
              </figure>
            </div>
          </article>
          </s:iterator>
          <s:if test="%{listaMensajesRecibidos.size() == 0}">
                            <div class="alert alert-danger sin-pasajeros text-center" role="alert">
                                No hay mensajes
                              </div>
                        </s:if>
            </div>
        </section>

  </div>


</div>
<%@include file="index_footer.jsp" %>