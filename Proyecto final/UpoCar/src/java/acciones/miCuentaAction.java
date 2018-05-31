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
import modelo.UsuarioDAO;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author alberto
 */
public class miCuentaAction extends ActionSupport {
    
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    
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
    
    
    
    
    
    
    
    
}
