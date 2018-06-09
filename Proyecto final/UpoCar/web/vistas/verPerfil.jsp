<%@include file="index_header.jsp" %>

<div class="row">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">

        <div class="col-lg-3">                
            <div class="col-lg-12">                

                <img class="foto-mi-cuenta img-circle img-responsive" src="<s:property value="foto"></s:property>" /> 


                    <br/><br/>
                <s:property value="nombre"></s:property>
                <s:property value="apellidos"></s:property>                    
                <p>Puntuación: <span class="badge"><s:property value="puntuacion"></s:property></span></p>
                </div>
            </div>
            <div class="col-lg-9">
                <h3>Opiniones</h3>
                <hr>
            <s:if test="%{listaPuntuacionRecibidas.size() == 0}">

                <div class="alert alert-info" role="alert">Este usuario no ha recibido ningun comentario. Se tu el primero</div>
            </s:if>
            <s:else>
                <s:iterator value="listaPuntuacionRecibidas">                
                    <blockquote class="quote-box">
                        <p class="quote-text">
                            <s:property value="comentario"></s:property>
                            </p>                                                        
                        </blockquote>                        
                </s:iterator>
            </s:else>    

        </div>


        <h3>¡Vota y comenta a este usuario justo aqui abajo!</h3>   
        <s:form action="votar">
            ¿Que nota le da a este usuario?<br/>
            <s:radio name="voto" list="#{'0':'0','1':'1','2':'2','3':'3','4':'4','5':'5'}"/>
            <br/>
            ¿Desea comentar algo sobre este usuario?<br/>
            <s:textarea label="Comments" name="comentario" cols="30" rows="8"/>            
            <s:submit name="votar" value="Votar" cssClass="btn btn-primary btnBuscar"></s:submit>
            <s:hidden name="idUsuario" value="%{idUsuario}"></s:hidden>
        </s:form>

    </div>            
    <div class="col-lg-2"></div>
</div>


</div>

<%@include file="index_footer.jsp" %>