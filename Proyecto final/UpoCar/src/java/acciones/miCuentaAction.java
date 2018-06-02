/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.TelefonoDAO;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Telefono;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author alberto
 */
public class miCuentaAction extends ActionSupport {
    
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Telefono> listadoTelefonos = new ArrayList<Telefono>();

    
    public miCuentaAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String toMiCuenta(){
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //this.setListadoUsuarios(usuarioDAO.buscarUsuarioPorID(INPUT));
        return SUCCESS;
    }
    
    public String toMisDatos(){
        //Recojo el usuario de la sesion y lo guardo en una lista
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        this.getListadoUsuarios().add(u);
        TelefonoDAO tDao = new TelefonoDAO();
        this.setListadoTelefonos(tDao.listarTelefonosUsuarios(u.getIdUsuario()));
        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //this.setListadoUsuarios(usuarioDAO.buscarUsuarioPorID(INPUT));
        return SUCCESS;
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    public List<Telefono> getListadoTelefonos() {
        return listadoTelefonos;
    }

    public void setListadoTelefonos(List<Telefono> listadoTelefonos) {
        this.listadoTelefonos = listadoTelefonos;
    }

    
    
    
    
    
    
    
    
    
}
