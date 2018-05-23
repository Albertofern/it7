<%@include file="./index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Administrador</h1>
        <hr />
        &nbsp;
        <div class="row">

            <div class="col-lg-2"></div>
            <div class="col-lg-8">

                <div class="col-lg-12 hidden-sm hidden-md hidden-xs">
                    <div class="col-lg-4 ">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></div>        
                        <s:form action="toGestionUsuarios"><button class="btn btn-default hidden-sm hidden-md hidden-xs" >Gesti&oacute;n usuarios</button></s:form>
                        &nbsp;
                    </div>

                    <div class="col-lg-4">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionViajes.jpg" /></div>            
                        <s:form action="toGestionViajes"><button class="btn btn-default hidden-sm hidden-md hidden-xs">Gesti&oacute;n viajes</button></s:form>
                        &nbsp;
                    </div>
                    <div class="col-lg-4">
                        <div><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionMensajes.png" /></div>            
                        <s:form action="toGestionMensajes"><button class="btn btn-default hidden-sm hidden-md hidden-xs">Gesti&oacute;n mensajes</button></s:form>
                        &nbsp;
                    </div>
                </div>
                
                <div class="hidden-lg  ">
                    <div >
                        <div><s:form action="toGestionUsuarios"><button><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionUsuarios.png" /></button></s:form></div>  
                        &nbsp;
                    </div>

                    <div >
                        <div><s:form action="toGestionViajes"><button><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionViajes.jpg" /></button></s:form></div>

                        &nbsp;
                    </div>
                    <div >
                        <div><s:form action="toGestionMensajes"><button><img class="foto-mi-cuenta img-circle img-responsive" src="./images/gestionMensajes.png" /></button></s:form></div>
                        &nbsp;
                    </div>
                </div>
            

        </div>

        <div class="col-lg-2"></div>
    </div>
</div>
</div>
<%@include file="./index_footer.jsp" %>
