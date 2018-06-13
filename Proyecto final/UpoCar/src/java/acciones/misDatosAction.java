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

public class misDatosAction extends ActionSupport {

    List<Usuario> listadoUsuarios = new ArrayList<Usuario>();
    List<Telefono> listadoTelefonos = new ArrayList<Telefono>();

    //mis datos
    String usuario;
    String nombre;
    String apellidos;
    String email;
    String localidad;
    String sexo;

    public misDatosAction() {
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

    public String modificarMisDatos() {
        //Obtengo el usuario de la sesion
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        UsuarioDAO uDao = new UsuarioDAO();
        //Actualizo usuario en WS
        uDao.updateUsuario(u.getIdUsuario(), this.getUsuario(), this.getNombre(), 
                this.getApellidos(), this.getEmail(), this.getLocalidad(), this.getSexo(),"usuario");
        //Actualizo usuario en sesion
        u.setNomUsuario(this.getUsuario());
        u.setNombre(this.getNombre());
        u.setApellidos(this.getApellidos());
        u.setEmail(this.getEmail());
        u.setLocalidad(this.getLocalidad());
        u.setSexo(this.getSexo());
        this.toMisDatos();
        return SUCCESS;
    }

    // Getter y setter MisDatos
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void validate() {
        boolean error = false;
        
        if (this.getUsuario().trim().length() == 0) {
            error = true;
            addFieldError("usuario", "El usuario nuevo debe estar relleno");
        }

        if (this.getNombre().trim().length() == 0) {
            error = true;
            addFieldError("nombre", "El nombre nuevo debe estar relleno");
        }

        if (this.getApellidos().trim().length() == 0) {
            error = true;
            addFieldError("apellidos", "Los apellidos nuevos deben estar relleno");
        }

        if (this.getEmail().trim().length() == 0) {
            error = true;
            addFieldError("email", "El email nuevo debe estar relleno");
        } else {
            if (!Pattern.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$", this.getEmail())) {
                error = true;
                addFieldError("email", "El email nuevo no tiene el formato correcto");
            }
        }

        if (this.getLocalidad().trim().length() == 0) {
            error = true;
            addFieldError("localidad", "La localidad nueva debe estar relleno");
        }
        // Si hay errror llamo al metodo toModificarCoche
        if(error){
            this.toMisDatos();
        }
        
    }
}
