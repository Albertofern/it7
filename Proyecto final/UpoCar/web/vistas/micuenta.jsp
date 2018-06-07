<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Mi cuenta</h1>
        <hr />
        &nbsp;
        <div class="row">
            <div class="col-sm-2">
                <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisDatos"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis datos</button></s:form>
                    &nbsp;
                </div>
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisViajes"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis viajes</button></s:form>
                    &nbsp;
                </div>
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisOpiniones"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis opiniones</button></s:form>
                    &nbsp;
                </div>
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisMensajes"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis mensajes</button></s:form>
                    &nbsp;
                </div>
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisReservas"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis reservas</button></s:form>
                    &nbsp;
                </div>
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                <s:form action="toMisCoches"><button class="btn btn-default hidden-sm hidden-md hidden-sm" >Mis coches</button></s:form>
                    &nbsp;
                </div>
            </div>
        </div>
    </div>
<%@include file="index_footer.jsp" %>
