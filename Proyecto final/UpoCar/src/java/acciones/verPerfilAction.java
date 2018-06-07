/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import modelo.PuntuacionDAO;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Puntuacion;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class verPerfilAction extends ActionSupport {

    private String idUsuario;
    private String nombre;
    private String apellidos;

    private List<Puntuacion> listaPuntuacionRecibidas = new ArrayList<Puntuacion>();
    private String puntuacion;

    UsuarioDAO usuarioDao = new UsuarioDAO();
    PuntuacionDAO puntuacionDao = new PuntuacionDAO();

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Puntuacion> getListaPuntuacionRecibidas() {
        return listaPuntuacionRecibidas;
    }

    public void setListaPuntuacionRecibidas(List<Puntuacion> listaPuntuacionRecibidas) {
        this.listaPuntuacionRecibidas = listaPuntuacionRecibidas;
    }

    public String getIdPuntuacion() {
        return puntuacion;
    }

    public void setIdPuntuacion(String idPuntuacion) {
        this.puntuacion = idPuntuacion;
    }

    public verPerfilAction() {
    }

    public String execute() throws Exception {                
        return SUCCESS;
    }
    
    public String verPerfilUsuario(){        
        Usuario u = usuarioDao.buscarUsuarioPorID(idUsuario);
        
        this.nombre = u.getNombre();
        this.apellidos = u.getApellidos();
        this.puntuacion = String.valueOf(puntuacionDao.getPuntuacionUsuario(Integer.parseInt(idUsuario)));
        this.listaPuntuacionRecibidas = puntuacionDao.listarPuntuacionRecibidas(Integer.parseInt(idUsuario));
        return SUCCESS;
    }

}
