/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientMensaje;
import webServiceREST.JerseyClientUsuario;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Usuario;

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
    
    public List<Mensaje>  buscarRecibeMensaje(String nomUsuario){
        GenericType<List<Mensaje>> genericType = new GenericType<List<Mensaje>>() {
        };
        return clientMensaje.buscarMensajeUsuRecibe(genericType, nomUsuario);
    }
    
    public List<Mensaje> buscarEnviaMensaje(String nomUsuario){
        GenericType<List<Mensaje>> genericType = new GenericType<List<Mensaje>>() {
        };
        return clientMensaje.buscarMensajeUsuEnvia(genericType, nomUsuario);
    }
    
    public void updateMensaje(Integer id,String mensaje, Integer idUsuario){
        JerseyClientUsuario clientUsuario = new JerseyClientUsuario();
        GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericTypeUsuario, String.valueOf(idUsuario));
        GenericType<Mensaje> genericType = new GenericType<Mensaje>() {
        };
        Mensaje m = clientMensaje.find_XML(genericType, String.valueOf(id));
        m.setTexto(mensaje);
        m.setIdUsuarioRecibe(u);
        clientMensaje.edit_XML(m, String.valueOf(id));        
    }


public JerseyClientMensaje getClientMensaje() {
        return clientMensaje;
    }

    public void setClientMensaje(JerseyClientMensaje clientMensaje) {
        this.clientMensaje = clientMensaje;
    }
    
    

}
