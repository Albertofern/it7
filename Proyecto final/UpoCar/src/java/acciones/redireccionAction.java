/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
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
 * @author Antonio Jose Herrera Tabaco
 */
public class redireccionAction extends ActionSupport {

    private List<Vehiculo> listadoCoches;
    private List<Usuario> listadoUsuarios;
    private List<Viaje> listadoViajes;
    
    private List origen;
    private List destino;
    
    UsuarioDAO usuarioDao = new UsuarioDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    LocalidadDAO localidadDao = new LocalidadDAO();
    ViajeDAO viajeDao = new ViajeDAO();

    public List<Viaje> getListadoViajes() {
        return listadoViajes;
    }

    public void setListadoViajes(List<Viaje> listadoViajes) {
        this.listadoViajes = listadoViajes;
    }

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

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public redireccionAction() {
    }

    public String toLogin() {
        return SUCCESS;
    }

    public String toRegistro() {
        return SUCCESS;
    }

    public String toPanelAdmin() {
        return SUCCESS;
    }

    public String toPublicarViaje() {
        origen = localidadDao.getLocalidades();
        destino = localidadDao.getLocalidades();

        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");

        listadoCoches = vehiculoDao.listadoVehiculosUsuario(u.getIdUsuario());

        return SUCCESS;
    }

    public String toRanking() {
        this.setListadoUsuarios(usuarioDao.listarUsuarios());
        Collections.sort(getListadoUsuarios());
        this.setListadoViajes(viajeDao.listarViajes());
        return SUCCESS;
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
