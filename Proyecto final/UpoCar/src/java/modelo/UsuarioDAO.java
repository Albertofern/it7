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

    public Usuario buscarUsuarioPorID(String idUsuario) {
        GenericType<Usuario> genericType = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericType, idUsuario);
        
        return u;
    }

    public void deleteUsuario(String id) {
        clientUsuario.remove(id);
    }

    public void updateUsuario(Integer idUsuario, String usuario, String nombre, String apellido,
            String email, String localidad, String sexo) {

        GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericTypeUsuario, String.valueOf(idUsuario));
        u.setNomUsuario(usuario);
        u.setNombre(nombre);
        u.setApellidos(apellido);
        u.setEmail(email);
        u.setLocalidad(localidad);
        u.setSexo(sexo);
        String rutaFoto = "./images/male.png";
        if (u.getSexo().equals("F")) {
            rutaFoto = "./images/female.png";
        }
        u.setFoto(rutaFoto);
        clientUsuario.edit_XML(u, String.valueOf(idUsuario));
    }

    public void updateUsuarioFotoPerfil(Integer idUsuario, String rutaFoto) {

        GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericTypeUsuario, String.valueOf(idUsuario));
        u.setFoto(rutaFoto);
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

        Usuario user = null;

        if (usuario.trim().length() != 0 || password.trim().length() != 0) {
            user = clientUsuario.login(genericType, usuario, password);
        }

        return user;
    }

    public void registro(Usuario u) {
        clientUsuario.create_XML(u);
    }

}
