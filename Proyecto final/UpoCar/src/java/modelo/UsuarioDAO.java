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

    public List<Usuario> buscarUsuario(String usuario) {
        GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {
        };

        List<Usuario> listaUsuario = this.getClientUsuario().buscarUsuario(genericType, usuario);
        return listaUsuario;
    }

    public void deleteUsuario(String id) {
        clientUsuario.remove(id);
    }

    public void updateUsuario(Integer idUsuario,String usuario,String nombre,String apellido, 
            String email,String localidad,String sexo) {

        GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericTypeUsuario, String.valueOf(idUsuario));
        u.setNomUsuario(usuario);
        u.setApellidos(apellido);
        u.setEmail(email);
        u.setLocalidad(localidad);
        u.setSexo(sexo);
        clientUsuario.edit_XML(u, String.valueOf(idUsuario));
    }

    public JerseyClientUsuario getClientUsuario() {
        return clientUsuario;
    }

    public void setClientUsuario(JerseyClientUsuario clientUsuario) {
        this.clientUsuario = clientUsuario;
    }

    public Usuario login(String usuario, String password) {
        GenericType<Usuario> genericType = new GenericType<Usuario>() {
        };

        Usuario user = clientUsuario.login(genericType, usuario, password);

        return user;
    }

    public void registro(Usuario u) {
        clientUsuario.create_XML(u);
    }

}
