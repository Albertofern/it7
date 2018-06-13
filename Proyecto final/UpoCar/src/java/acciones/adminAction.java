/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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

    //listas necesarias
    List<Mensaje> listadoMensajes;
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Localidad> listadoLocalidades;
    List<Viaje> listadoViajes;
    //Viaje
    String nomUsuarioViaje;
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
    String updateMensaje;

    public adminAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    //validaciones
    public void validate() {
        boolean errorUsuario = false;
        if (this.getNomUsuario() != null) {
            if (this.getNomUsuario().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("nomUsuario", "El usuario debe estar relleno");
            }
        }
        boolean errorMensaje = false;
        if (this.getNomUsuarioEnvia() != null) {
            if (this.getNomUsuarioEnvia().trim().length() == 0) {
                errorMensaje = true;
                addFieldError("nomUsuarioEnvia", "El usuario debe estar relleno");
            }
        }
        if (this.getNomUsuarioRecibe() != null) {
            if (this.getNomUsuarioRecibe().trim().length() == 0) {
                errorMensaje = true;
                addFieldError("nomUsuarioRecibe", "El usuario debe estar relleno");
            }
        }
        boolean errorViaje = false;
        if (this.getNomUsuarioViaje() != null) {
            if (this.getNomUsuarioViaje().trim().length() == 0) {
                errorViaje = true;
                addFieldError("nomUsuarioViaje", "El usuario debe estar relleno");
            }
        }

        //Update usuario
        if (this.getUpdateUsuario() != null) {
            if (this.getUpdateUsuario().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("updateUsuario", "Update: El usuario debe estar relleno");
            }
        }

        if (this.getUpdateNombre() != null) {
            if (this.getUpdateNombre().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("updateNombre", "Update: El nombre del usuario debe estar relleno");
            }
        }

        if (this.getUpdateApellidos() != null) {
            if (this.getUpdateApellidos().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("updateApellidos", "Update: El apellido del usuario debe estar relleno");
            }
        }

        if (this.getUpdateEmail() != null) {
            if (this.getUpdateEmail().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("updateEmail", "Update: El email nuevo debe estar relleno");
            } else {
                if (!Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$", this.getUpdateEmail())) {
                    errorUsuario = true;
                    addFieldError("updateEmail", "Update: El email nuevo no tiene el formato correcto");
                }
            }
        }

        if (this.getUpdateLocalidad() != null) {
            if (this.getUpdateLocalidad().trim().length() == 0) {
                errorUsuario = true;
                addFieldError("updateLocalidad", "Update: La localidad nueva debe estar relleno");
            }
        }

        //Update viaje
        if (this.getUpdatePlazasMax() != null) {
            if (!Pattern.matches("[0-9]", String.valueOf(this.getUpdatePlazasMax()))) {
                errorViaje = true;
                addFieldError("updatePlazasMax", "Update: Debe introducir las plazas máximas");
            }
            if (this.getUpdatePlazasMax() <= 0) {
                errorViaje = true;
                addFieldError("updatePlazasMax", "Update: Debe introducir el numero de plazas");
            }
        }

        if (this.getUpdateFechaSalida() != null) {
            if (this.getUpdatePrecioPersona() <= 0.0) {
                errorViaje = true;
                addFieldError("updatePrecioPersona", "Update: Debe introducir un numero en precio por persona");
            }
        }
        if (this.getUpdateFechaSalida() != null) {
            if (this.getUpdateFechaSalida().length() == 0) {
                errorViaje = true;
                addFieldError("updateFechaSalida", "Update: Debe introducir una fecha de salida");
            }
        }

        if (this.getUpdatePuntoRecogida() != null) {
            errorViaje = true;
            if (this.getUpdatePuntoRecogida().length() == 0) {
                addFieldError("updatePuntoRecogida", "Update: Debe introducir un punto de recogida");
            }
        }

        if (this.getUpdateFechaSalida() != null) {
            errorViaje = true;
            if (!Pattern.matches("20[0-9][0-9]-[01][0-9]-[0-3][0-9]T[0-2][0-3]:[0-5][0-9]", this.getUpdateFechaSalida())) {
                addFieldError("updateFechaSalida", "Update: La fecha no es correcta (yyyy-mm-ddTHH:mm)");
            }
        }

        //update mensaje
        if (this.getUpdateMensaje() != null) {
            errorMensaje = true;
            if (this.getUpdateMensaje().length() == 0) {
                addFieldError("updateMensaje", "Update: Debe introducir un mensaje");
            }
        }

        if (errorUsuario) {
            try {
                this.gestionUsuarios();
            } catch (Exception ex) {
                Logger.getLogger(adminAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (errorMensaje) {
            try {
                this.gestionMensajes();
            } catch (Exception ex) {
                Logger.getLogger(adminAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (errorViaje) {
            try {
                this.gestionViajes();
            } catch (Exception ex) {
                Logger.getLogger(adminAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //Gestión Mensajes
    public void gestionMensajes() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        this.setListadoMensajes(mensajeDAO.listarMensajes());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
    }

    public String toGestionMensajes() throws Exception {
        this.gestionMensajes();
        return SUCCESS;
    }

    public String deleteMensaje() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        mensajeDAO.deleteMensaje(this.getIdMensaje());
        return SUCCESS;
    }

    public String updateMensaje() throws Exception {
        MensajeDAO mensajeDAO = new MensajeDAO();
        mensajeDAO.updateMensaje(this.getIdMensaje(), this.getUpdateMensaje(), this.getIdUsuario());
        return SUCCESS;
    }

    //Gestión Viajes
    public void gestionViajes() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajes());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        LocalidadDAO localidadDAO = new LocalidadDAO();
        this.setListadoLocalidades(localidadDAO.getLocalidades());
    }

    public String toGestionViajes() throws Exception {
        this.gestionViajes();
        return SUCCESS;
    }

    public String deleteViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        viajeDAO.deleteViaje(this.getIdViaje());
        return SUCCESS;
    }

    public String updateViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();

        //la fecha la guarda en el siguiente formato: 2018-05-30T14:15
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(this.getUpdateFechaSalida());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);

        viajeDAO.updateViaje(this.getUpdateId(), this.getUpdatePlazasMax(),
                this.getUpdatePrecioPersona(), this.getUpdatePuntoRecogida(),
                formattedDate, this.getIdUsuario(),
                this.getUpdateIdLocalidadOrigen(), this.getUpdateIdLocalidadDestino());
        return SUCCESS;
    }

    public String buscarUsuarioViaje() throws Exception {
        ViajeDAO viajeDAO = new ViajeDAO();
        this.setListadoViajes(viajeDAO.listarViajesUsuario(this.getNomUsuarioViaje()));
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
        LocalidadDAO localidadDAO = new LocalidadDAO();
        this.setListadoLocalidades(localidadDAO.getLocalidades());
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

    public String buscarUsuario() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.buscarUsuario(this.getNomUsuario()));
        return SUCCESS;
    }

    //Gestión Usuarios
    public void gestionUsuarios() throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        this.setListadoUsuarios(usuarioDAO.listarUsuarios());
    }

    public String toGestionUsuarios() throws Exception {
        this.gestionUsuarios();
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
                this.getUpdateLocalidad(), this.getUpdateSexo(),"admin");
        return SUCCESS;
    }

    //getter y setter
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

    public String getUpdateMensaje() {
        return updateMensaje;
    }

    public void setUpdateMensaje(String updateMensaje) {
        this.updateMensaje = updateMensaje;
    }

    public String getNomUsuarioViaje() {
        return nomUsuarioViaje;
    }

    public void setNomUsuarioViaje(String nomUsuarioViaje) {
        this.nomUsuarioViaje = nomUsuarioViaje;
    }

}
