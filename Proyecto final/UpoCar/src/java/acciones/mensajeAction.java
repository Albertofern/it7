/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import modelo.MensajeDAO;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Mensaje;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class mensajeAction extends ActionSupport {
    
    public String idUsuarioContacto;
    public String texto;
    MensajeDAO dao = new MensajeDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public String getIdUsuarioContacto() {
        return idUsuarioContacto;
    }

    public void setIdUsuarioContacto(String idUsuarioContacto) {
        this.idUsuarioContacto = idUsuarioContacto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public mensajeAction() {
    }
    
    public String contactarCon(){
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        
        Mensaje m = new Mensaje(null, texto, null);
        m.setIdUsuarioEnvia(u);
        Usuario uRecibe = usuarioDao.buscarUsuarioPorID(idUsuarioContacto);
        m.setIdUsuarioRecibe(uRecibe);
        
        dao.enviarMensaje(m);
        
        return SUCCESS;
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
}
