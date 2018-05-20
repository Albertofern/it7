/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientUsuario;
import webServiceREST.entidades.Usuario;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class UsuarioDAO {
    
    private JerseyClientUsuario clientUsuario = new JerseyClientUsuario();

    public List<Usuario> listarUsuarios() {
        GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {
        };
        
        List<Usuario> listaUsuarios = this.getClientUsuario().findAll_XML(genericType);
        return listaUsuarios;
    }


public JerseyClientUsuario getClientUsuario() {
        return clientUsuario;
    }

    public void setClientUsuario(JerseyClientUsuario clientUsuario) {
        this.clientUsuario = clientUsuario;
    }

}
