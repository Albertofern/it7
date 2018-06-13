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
import java.util.regex.Pattern;
import modelo.TelefonoDAO;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Telefono;
import webServiceREST.entidades.Usuario;

public class misDatosTelefonoAction extends ActionSupport {
    
    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Telefono> listadoTelefonos = new ArrayList<Telefono>();
    
    String nuevoTlf;
    String idTelefono;
    
    
    public misDatosTelefonoAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String toMisDatos() {
        //Recojo el usuario de la sesion y lo guardo en una lista
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        UsuarioDAO uDAO = new UsuarioDAO();
        this.getListadoUsuarios().clear();
        this.getListadoUsuarios().add( uDAO.buscarUsuarioPorID(u.getIdUsuario().toString()) );
        TelefonoDAO tDao = new TelefonoDAO();
        this.setListadoTelefonos(tDao.listarTelefonosUsuarios(u.getIdUsuario()));
        return SUCCESS;
    }
    
    public String agregarTelefono(){
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        // Creo un objeto telefono nuevo y le paso por set el usuario y el telefono
        Telefono t = new Telefono();
        t.setIdUsuario(u);
        t.setNumTel(Integer.parseInt(this.getNuevoTlf()));
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        TelefonoDAO tDao = new TelefonoDAO();
        tDao.createTelefono(t);
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
        return SUCCESS;
    }
    
    public String modificarTelefono(){
        // Creo un objeto TelefonoDAO y le paso el objeto telefono
        TelefonoDAO tDao = new TelefonoDAO();
        tDao.updateTelefono(this.getIdTelefono(), Integer.parseInt(this.getNuevoTlf()));
        //Llamo al metodo toMisDatos() para recargar la pagina
        this.toMisDatos();
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

    public String getNuevoTlf() {
        return nuevoTlf;
    }

    public void setNuevoTlf(String nuevoTlf) {
        this.nuevoTlf = nuevoTlf;
    }

    public String getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }
    
    public void validate() {
        boolean error = false;
        
        if(this.getNuevoTlf().toString().trim().length() == 0){
            error = true;
            addFieldError("telefono", "El teléfono debe estar relleno");
        } else {
            if (!Pattern.matches("^[9|6|7][0-9]{8}$", this.getNuevoTlf())) {
                error = true;
                addFieldError("telefono", "El teléfono no tiene el formato correcto, debe empezar por 7, 6 o 9 y formar 9 dígitos en total");
            }
        }
      
        if(error){
            this.toMisDatos();
        }
        
    }
    
}
