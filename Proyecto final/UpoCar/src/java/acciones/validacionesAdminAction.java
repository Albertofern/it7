/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import modelo.MensajeDAO;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author Gonza
 */
public class validacionesAdminAction extends ActionSupport {

    List<Usuario> listadoUsuarios;
    List<Mensaje> listadoMensajes;
    String nomUsuario;
    String nomUsuarioRecibe;
    String nomUsuarioEnvia;

    public validacionesAdminAction() {
    }

    public void validate() {
        boolean error = false;
        if (this.getNomUsuario() != null) {
            if (this.getNomUsuario().trim().length() == 0) {
                error = true;
                addFieldError("nomUsuario", "El usuario debe estar relleno");
            }
        }
        if (this.getNomUsuarioEnvia() != null) {
            if (this.getNomUsuarioEnvia().trim().length() == 0) {
                addFieldError("nomUsuarioEnvia", "El usuario debe estar relleno");
            }
        }
        if (this.getNomUsuarioRecibe() != null) {
            if (this.getNomUsuarioRecibe().trim().length() == 0) {
                addFieldError("nomUsuarioRecibe", "El usuario debe estar relleno");
            }
        }
        if (error) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        }

    }

    public String buscarUsuario() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.buscarUsuario(this.getNomUsuario()));
        return SUCCESS;
    }

    public String buscarEnviaMensaje() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        this.setListadoMensajes(mensajeDAO.buscarEnviaMensaje(this.getNomUsuarioEnvia()));
        return SUCCESS;
    }

    public String buscarRecibeMensaje() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        this.setListadoMensajes(mensajeDAO.buscarRecibeMensaje(this.getNomUsuarioRecibe()));
        return SUCCESS;
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public List<Mensaje> getListadoMensajes() {
        return listadoMensajes;
    }

    public void setListadoMensajes(List<Mensaje> listadoMensajes) {
        this.listadoMensajes = listadoMensajes;
    }

    public String getNomUsuarioRecibe() {
        return nomUsuarioRecibe;
    }

    public void setNomUsuarioRecibe(String nomUsuarioRecibe) {
        this.nomUsuarioRecibe = nomUsuarioRecibe;
    }

    public String getNomUsuarioEnvia() {
        return nomUsuarioEnvia;
    }

    public void setNomUsuarioEnvia(String nomUsuarioEnvia) {
        this.nomUsuarioEnvia = nomUsuarioEnvia;
    }

}
