/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import modelo.LocalidadDAO;
import modelo.MensajeDAO;
import modelo.UsuarioDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Localidad;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Gonza
 */
public class adminAction extends ActionSupport {

    List<Mensaje> listadoMensajes;
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Localidad> listadoLocalidades;
    List<Viaje> listadoViajes;
    //Viaje
    String idViaje;
    Integer updatePlazasMax;
    Double updatePrecioPersona;
    String updatePuntoRecogida;
    String updateFechaSalida;
    Integer updateId;
    Integer updateIdLocalidadOrigen;
    Integer updateIdLocalidadDestino;
    //Usuario
    Integer idUsuario;
    String nomUsuario;
    Integer updateIdUsuario;
    String updateUsuario;
    String updateNombre;
    String updateApellidos;
    String updateEmail;
    String updateSexo;
    String updateLocalidad;
    //Mesnaje
    Integer idMensaje;
    String nomUsuarioEnvia;
    String nomUsuarioRecibe;

    public adminAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    //Gestión Mensajes
    public String toGestionMensajes() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        this.setListadoMensajes(mensajeDAO.listarMensajes());
        return SUCCESS;
    }

    public String deleteMensaje() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        mensajeDAO.deleteMensaje(this.getIdMensaje());
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

    //Gestión Viajes
    public String toGestionViajes() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajes());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        LocalidadDAO localidadDAO = new LocalidadDAO();
        this.setListadoLocalidades(localidadDAO.getLocalidades());
        return SUCCESS;
    }

    public String deleteViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        viajeDAO.deleteViaje(this.getIdViaje());
        return SUCCESS;
    }

    public String updateViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        viajeDAO.updateViaje(this.getUpdateId(), this.getUpdatePlazasMax(),
                this.getUpdatePrecioPersona(), this.getUpdatePuntoRecogida(),
                this.getUpdateFechaSalida(), this.getIdUsuario(),
                this.getUpdateIdLocalidadOrigen(), this.getUpdateIdLocalidadDestino());
        return SUCCESS;
    }

    public String buscarUsuarioViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajesUsuario(this.getNomUsuario()));
        return SUCCESS;
    }

    //Gestión Usuarios
    public String toGestionUsuarios() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        return SUCCESS;
    }

    public String buscarUsuario() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.buscarUsuario(this.getNomUsuario()));
        return SUCCESS;
    }

    public String deleteUsuario() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deleteUsuario(String.valueOf(this.getIdUsuario()));
        return SUCCESS;
    }

    public String updateUsuario() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.updateUsuario(this.getUpdateIdUsuario(), this.getUpdateUsuario(),
                this.getUpdateNombre(), this.getUpdateApellidos(), this.getUpdateEmail(),
                this.getUpdateLocalidad(), this.getUpdateSexo());
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

    public String getUpdatePuntoRecogida() {
        return updatePuntoRecogida;
    }

    public void setUpdatePuntoRecogida(String updatePuntoRecogida) {
        this.updatePuntoRecogida = updatePuntoRecogida;
    }

    public String getUpdateFechaSalida() {
        return updateFechaSalida;
    }

    public void setUpdateFechaSalida(String updateFechaSalida) {
        this.updateFechaSalida = updateFechaSalida;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Localidad> getListadoLocalidades() {
        return listadoLocalidades;
    }

    public void setListadoLocalidades(List<Localidad> listadoLocalidades) {
        this.listadoLocalidades = listadoLocalidades;
    }

    public Integer getUpdateIdLocalidadOrigen() {
        return updateIdLocalidadOrigen;
    }

    public void setUpdateIdLocalidadOrigen(Integer updateIdLocalidadOrigen) {
        this.updateIdLocalidadOrigen = updateIdLocalidadOrigen;
    }

    public Integer getUpdateIdLocalidadDestino() {
        return updateIdLocalidadDestino;
    }

    public void setUpdateIdLocalidadDestino(Integer updateIdLocalidadDestino) {
        this.updateIdLocalidadDestino = updateIdLocalidadDestino;
    }

    public Integer getUpdateIdUsuario() {
        return updateIdUsuario;
    }

    public void setUpdateIdUsuario(Integer updateIdUsuario) {
        this.updateIdUsuario = updateIdUsuario;
    }

    public String getUpdateUsuario() {
        return updateUsuario;
    }

    public void setUpdateUsuario(String updateUsuario) {
        this.updateUsuario = updateUsuario;
    }

    public String getUpdateNombre() {
        return updateNombre;
    }

    public void setUpdateNombre(String updateNombre) {
        this.updateNombre = updateNombre;
    }

    public String getUpdateApellidos() {
        return updateApellidos;
    }

    public void setUpdateApellidos(String updateApellidos) {
        this.updateApellidos = updateApellidos;
    }

    public String getUpdateEmail() {
        return updateEmail;
    }

    public void setUpdateEmail(String updateEmail) {
        this.updateEmail = updateEmail;
    }

    public String getUpdateSexo() {
        return updateSexo;
    }

    public void setUpdateSexo(String updateSexo) {
        this.updateSexo = updateSexo;
    }

    public String getUpdateLocalidad() {
        return updateLocalidad;
    }

    public void setUpdateLocalidad(String updateLocalidad) {
        this.updateLocalidad = updateLocalidad;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getNomUsuarioEnvia() {
        return nomUsuarioEnvia;
    }

    public void setNomUsuarioEnvia(String nomUsuarioEnvia) {
        this.nomUsuarioEnvia = nomUsuarioEnvia;
    }

    public String getNomUsuarioRecibe() {
        return nomUsuarioRecibe;
    }

    public void setNomUsuarioRecibe(String nomUsuarioRecibe) {
        this.nomUsuarioRecibe = nomUsuarioRecibe;
    }

    
    
}
