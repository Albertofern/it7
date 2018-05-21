/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.MensajeDAO;
import modelo.UsuarioDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Gonza
 */
public class adminAction extends ActionSupport {
    
    List<Mensaje> listadoMensajes;
    List<Usuario> listadoUsuarios;
    List<Viaje> listadoViajes;
    String idViaje;
    String nomUsuario;
    Integer updatePlazasMax;
    Double updatePrecioPersona;
    Integer updateId;
    
    public adminAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String toGestionMensajes() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        this.setListadoMensajes(mensajeDAO.listarMensajes());
        return SUCCESS;
    }
    
    public String toGestionUsuarios() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        return SUCCESS;
    }
    
    public String toGestionViajes() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajes());
        return SUCCESS;
    }
    
    public String deleteViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        viajeDAO.deleteViaje(this.getIdViaje());
        return SUCCESS;
    }
    
    public String updateViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        viajeDAO.updateViaje(this.getUpdateId(), this.getUpdatePlazasMax(), this.getUpdatePrecioPersona());
        return SUCCESS;
    }
    
    public String buscarUsuarioViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajesUsuario(this.getNomUsuario()));
        return SUCCESS;
    }

    public List<Mensaje> getListadoMensajes() {
        return listadoMensajes;
    }

    public void setListadoMensajes(List<Mensaje> listadoMensajes) {
        this.listadoMensajes = listadoMensajes;
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public List<Viaje> getListadoViajes() {
        return listadoViajes;
    }

    public void setListadoViajes(List<Viaje> listadoViajes) {
        this.listadoViajes = listadoViajes;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Integer getUpdatePlazasMax() {
        return updatePlazasMax;
    }

    public void setUpdatePlazasMax(Integer updatePlazasMax) {
        this.updatePlazasMax = updatePlazasMax;
    }

    public Double getUpdatePrecioPersona() {
        return updatePrecioPersona;
    }

    public void setUpdatePrecioPersona(Double updatePrecioPersona) {
        this.updatePrecioPersona = updatePrecioPersona;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    
}
