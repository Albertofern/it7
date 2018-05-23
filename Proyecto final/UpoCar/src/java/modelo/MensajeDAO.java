/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientMensaje;
import webServiceREST.entidades.Mensaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class MensajeDAO {

    private JerseyClientMensaje clientMensaje = new JerseyClientMensaje();

    public List<Mensaje> listarMensajes() {
        GenericType<List<Mensaje>> genericType = new GenericType<List<Mensaje>>() {
        };
        
        List<Mensaje> listaMensajes = this.getClientMensaje().findAll_XML(genericType);
        return listaMensajes;
    }
    
    public void deleteMensaje(Integer idMensaje){
        clientMensaje.remove(String.valueOf(idMensaje));
    }


public JerseyClientMensaje getClientMensaje() {
        return clientMensaje;
    }

    public void setClientMensaje(JerseyClientMensaje clientMensaje) {
        this.clientMensaje = clientMensaje;
    }
    
    

}
