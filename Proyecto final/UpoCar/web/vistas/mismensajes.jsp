<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
  <div class="row">
    
      <h2 class="page-header">Mensajes</h2>
        <section class="comment-list">
            <div class="col-xs-12 col-sm-6">
                <h4 class="page-header">Enviados</h4>
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
                <div class="panel-body">
                  <header class="text-left">
                      <div class="comment-user"><span class="hidden-lg hidden-md"><s:property value="idUsuarioEnvia.nombre"></s:property> a </span><s:property value="idUsuarioRecibe.nombre"></s:property></div>
                    <time class="comment-date" datetime=""> <s:property value="fechaHora"></s:property></time>
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
            </div>
            <div class="col-xs-12 col-sm-6">
                <h4 class="page-header">Recibidos</h4>
          <!-- Mensaje recibido -->
          <s:iterator value="listaMensajesRecibidos">
          <article class="row">
            <div class="col-md-8 col-sm-12 col-xs-12">
              <div class="panel panel-default arrow right">
                <div class="panel-body">
                  <header class="text-right">
                      <div class="comment-user"><span class="hidden-lg hidden-md"><s:property value="idUsuarioEnvia.nombre"></s:property> a </span> </span><s:property value="idUsuarioRecibe.nombre"></s:property></div>
                    <time class="comment-date" datetime=""> <s:property value="fechaHora"></s:property></time>
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
            </div>
        </section>

  </div>

    </div>
</div>
<%@include file="index_footer.jsp" %>