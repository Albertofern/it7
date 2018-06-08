/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class RankingAction extends ActionSupport {
    
    private String usuario;
    private List<Usuario> listadoUsuarios;
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }

    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }
    
    public RankingAction() {
    }
    
    public String buscarUsuarioRanking() throws Exception {
        this.setListadoUsuarios(usuarioDao.buscarUsuario(this.getUsuario()));
        return SUCCESS;
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
