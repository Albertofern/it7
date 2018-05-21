/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.UsuarioDAO;
import modelo.VehiculoDAO;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;

/**
 *
 * @author Gonza
 */
public class loginAction extends ActionSupport {

    private String usuario;
    private String password;
    private List<Vehiculo> listadoCoches;
    UsuarioDAO dao = new UsuarioDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();

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

    public String toLogin() {
        return SUCCESS;
    }

    public String toRegistro() {
        return SUCCESS;
    }
    
    public String toPanelAdmin(){
        return SUCCESS;
    }
    
    public String toMiCuenta(){
        return SUCCESS;
    }
    
    public String toPublicarViaje(){
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        
        listadoCoches = vehiculoDao.listadoVehiculosUsuario(u.getIdUsuario());
        
        return SUCCESS;
    }
    
    public String toRanking(){
        return SUCCESS;
    }

    public String login() {
        Usuario u = dao.login(usuario, password);

        if (u == null) {
            return ERROR;
        } else {
            Map sesion = (Map) ActionContext.getContext().get("session");
            sesion.put("usuario", u);

            return SUCCESS;
        }

    }
    
    public String logout(){
        Map sesion = (Map) ActionContext.getContext().get("session");
        sesion.clear();
        return SUCCESS;
    }

}
