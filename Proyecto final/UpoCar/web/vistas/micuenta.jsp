<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Mi cuenta</h1>
        <hr />
        &nbsp;
        <div class="row">
            <div class="col-xs-12 hidden-sm hidden-xs">
                <div class="col-sm-2">
                    <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/mis-datos.png" /></div>        
                    <s:form action="toMisDatos"><button class="btn btn-default hidden-sm hidden-sm" >Mis datos</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-sm-2">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionViajes.jpg" /></div>        
                    <s:form action="toMisViajes"><button class="btn btn-default hidden-sm hidden-sm" >Mis viajes</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-sm-2">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionMensajes.png" /></div>        
                    <s:form action="toMisOpiniones"><button class="btn btn-default hidden-sm hidden-sm" >Mis opiniones</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-sm-2">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/mis-mensajes.png" /></div>        
                    <s:form action="toMisMensajes"><button class="btn btn-default hidden-sm hidden-sm" >Mis mensajes</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-sm-2">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/mis-reservas.jpg" /></div>        
                    <s:form action="toMisReservas"><button class="btn btn-default hidden-sm hidden-sm" >Mis reservas</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-sm-2">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/mis-coches.png" /></div>        
                    <s:form action="toMisCoches"><button class="btn btn-default hidden-sm hidden-sm" >Mis coches</button></s:form>
                        &nbsp;
                    </div>
                </div>
                <div class="hidden-md hidden-lg">
                    <div class="col-xs-6">       
                    <s:form action="toMisDatos"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis datos"  src="./images/mis-datos.png" /></button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-xs-6"> 
                    <s:form action="toMisViajes"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis Viajes"  src="./images/gestionViajes.jpg" /></button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-xs-6">        
                    <s:form action="toMisOpiniones"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis Opiniones"  src="./images/gestionMensajes.png" /></button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-xs-6">       
                    <s:form action="toMisMensajes"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis Mensajes"  src="./images/mis-mensajes.png" /></button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-xs-6">       
                    <s:form action="toMisReservas"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis Reservas"  src="./images/mis-reservas.jpg" /></button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-xs-6">    
                    <s:form action="toMisCoches"><button class="btn btn-default" ><img class="foto-mi-cuenta img-circle img-responsive" title="Mis Coches"  src="./images/mis-coches.png" /></button></s:form>
                        &nbsp;
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@include file="index_footer.jsp" %>
