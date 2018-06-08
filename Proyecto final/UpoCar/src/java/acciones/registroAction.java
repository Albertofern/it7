/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Pattern;
import modelo.UsuarioDAO;
import webServiceREST.entidades.Usuario;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class registroAction extends ActionSupport {
    
    private String usuario;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String sexo;
    private String localidad;
    private String telefono;
    private String password;

    UsuarioDAO dao = new UsuarioDAO();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public registroAction() {
    }
    
    public String registro() throws Exception {
        Usuario u = null;
        if(sexo.equals("M")){
            u = new Usuario(null, usuario, password, "1", nombre, apellidos, email, localidad, sexo, "./images/male.png", 0);        
        } else {
            u = new Usuario(null, usuario, password, "1", nombre, apellidos, email, localidad, sexo, "./images/female.png", 0);        
        }
        
        dao.registro(u);
        
        return SUCCESS;
    }
    
    public void validate(){
        if(usuario.trim().length() == 0){
            addFieldError("usuario", "El usuario debe estar relleno");
        }
        
        if(nombre.trim().length() == 0){
            addFieldError("nombre", "El nombre debe estar relleno");
        }
        
        if(apellidos.trim().length() == 0){
            addFieldError("apellidos", "Los apellidos debe estar relleno");
        }
        
        if(dni.trim().length() == 0){
            addFieldError("dni", "El dni debe estar relleno");
        }
        
        if(email.trim().length() == 0){
            addFieldError("email", "El email debe estar relleno");
        }
        
        if(!Pattern.matches("[^@]+@[^@]+\\\\.[a-zA-Z]{2,}", email)){
            addFieldError("email", "El email no tiene el formato correcto");
        }
        
        if(localidad.trim().length() == 0){
            addFieldError("localidad", "La localidad debe estar relleno");
        }
        
        if(telefono.trim().length() == 0){
            addFieldError("telefono", "El telefono debe estar relleno");
        }
        
        if(password.trim().length() == 0){
            addFieldError("password", "La password debe estar rellena");
        }
    }
    
    
}
