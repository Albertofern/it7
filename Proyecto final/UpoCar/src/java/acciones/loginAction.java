/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import modelo.LocalidadDAO;
import modelo.UsuarioDAO;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Gonza
 */
public class loginAction extends ActionSupport {

    private String usuario;
    private String password;
    private List<Vehiculo> listadoCoches;
    List<Usuario> listadoUsuarios;
    private List origen;
    private List destino;
    private List<Viaje> listadoViajes;
    UsuarioDAO usuarioDao = new UsuarioDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    LocalidadDAO localidadDao = new LocalidadDAO();
    ViajeDAO viajeDao = new ViajeDAO();

    public List getOrigen() {
        return origen;
    }

    public void setOrigen(List origen) {
        this.origen = origen;
    }

    public List getDestino() {
        return destino;
    }

    public void setDestino(List destino) {
        this.destino = destino;
    }

    public List<Vehiculo> getListadoCoches() {
        return listadoCoches;
    }

    public void setListadoCoches(List<Vehiculo> listadoCoches) {
        this.listadoCoches = listadoCoches;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public loginAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String login() {
        Usuario u = usuarioDao.login(usuario, password);

        
            Map sesion = (Map) ActionContext.getContext().get("session");
            sesion.put("usuario", u);

            return SUCCESS;
        

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

    public void validate(){
        if(usuario.trim().length() == 0){
            addFieldError("usuario", "El usuario debe estar relleno");
        }
        
        if(password.trim().length() == 0){
            addFieldError("password", "La password debe estar rellena");
        }
        
        if(usuarioDao.login(usuario, password) == null){
            addFieldError("usuario", "El usuario o la password son incorrectos");
        }
    }
    
}
