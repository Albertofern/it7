<%@include file="index_header.jsp" %>
<div class="container-fluid">
    <div id="background-firstlook">
        &nbsp;
        <h1>Ranking puntuaci&oacute;n usuarios</h1>
        <hr />
        &nbsp;
        <div class="row">
 
            <div class="col-lg-12">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                <table class="col-lg-12" border="1">
                    <tr>
                        <th></th>
                        <th>Nombre</th>
                        <th>Puntuaci&oacute;n</th>
                        <th>Numero de viajes</th>
                    </tr>
                    <tr>
                        <td><img class="foto-mi-cuenta img-circle img-responsive" src="http://www.cetep.cl/web/wp-content/uploads/2016/11/icono-de-usuario-masculino.jpg" /></td>
                        <td>Gonzalo</td>
                        <td>4 <% for (int i = 0; i < 4; i++) {
                                out.print("<span style='color:orange'>&#9733;</span>");
                            }
                            %></td>
                        <td>7</td>
                    </tr>
                </table>
                </div>
                <div class="col-lg-4"></div>
            </div>
           
        </div>


    </div>
</div>
<%@include file="index_footer.jsp" %>