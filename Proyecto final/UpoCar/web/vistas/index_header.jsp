<%@page import="webServiceREST.entidades.Usuario"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            <%@include file="../librerias/bootstrap-3.3.7-dist/css/bootstrap.css" %>
            <%@include file="../css/css.css" %>
            <%@include file="../css/buscaviajes.css" %>
            <%@include file="../css/micuenta.css" %>
            <%@include file="../css/misviajes.css" %>
            <%@include file="../css/misopiniones.css" %>
            <%@include file="../css/mismensajes.css" %>
            <%@include file="../librerias/w3css/w3.css" %>
        </style>
        <script type="text/javascript" src="./librerias/jquery/jquery-1.12.4.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="./librerias/jquery/bootstrap.js"></script>
        <title>UpoCar</title>
    </head>
    <body>
        <s:set name="theme" value="'simple'" scope="page" /> <%-- Elimina el estilo de Struts de esta pagina --%>

        <div class="w3-bar w3-border w3-light-grey" >
            <s:form action="toIndex">   
                <s:submit name="toIndex" value="UPOCAR" cssClass="w3-bar-item w3-button w3-padding-24"></s:submit>
            </s:form>

            <s:if test="%{#session.usuario != null}">  
                <s:form action="logout">
                    <s:submit name="logout" value="Logout" cssClass="w3-bar-item w3-button w3-right w3-padding-24"></s:submit>
                </s:form>

                <s:if test='%{#session.usuario.tipoUsuario.equals("0")}'> <!-- Si es administrador -->                   
                    <s:form action="toPanelAdmin">
                        <s:submit name="toPanelAdmin" value="Panel administrador" cssClass="w3-bar-item w3-button w3-right w3-padding-24"></s:submit>
                    </s:form>
                </s:if>
                <s:else> <!-- Si es un usuario normal -->                    
                    <s:form action="toMiCuenta">
                        <s:submit name="toMiCuenta" value="Mi cuenta" cssClass="w3-bar-item w3-button w3-right w3-padding-24"></s:submit>
                    </s:form>

                    <s:form action="toPublicarViaje">
                        <s:submit name="toPublicarViaje" value="Publicar viaje" cssClass="w3-bar-item w3-button w3-padding-24"></s:submit>
                    </s:form>
                </s:else>

                <s:form action="toRanking">
                    <s:submit name="toRanking" value="Ver ranking" cssClass="w3-bar-item w3-button w3-padding-24"></s:submit>
                </s:form>
            </s:if>
            <s:else>              
                <s:form action="toLogin">
                    <s:submit name="toLogin" value="LOGIN" cssClass="w3-bar-item w3-button w3-right w3-padding-24"></s:submit>
                </s:form>

                <s:form action="toRegistro">
                    <s:submit name="toRegistro" value="REGISTRATE" cssClass="w3-bar-item w3-button w3-right w3-padding-24"></s:submit>
                </s:form>            
            </s:else>
        </div>        