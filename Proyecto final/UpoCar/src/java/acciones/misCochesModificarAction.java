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
import modelo.VehiculoDAO;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;

public class misCochesModificarAction extends ActionSupport {
    
    //Mis coches
    List<Vehiculo> listaCoches = new ArrayList<Vehiculo>();
    String idCoche;
    String marca;
    String modelo;
    String color;
    String plazas;
    
    public misCochesModificarAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String toModificarCoche(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        // Obtengo el vehiculo con el id recibido
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        // Limpio la lista y agrego el coche
        this.getListaCoches().clear();
        this.getListaCoches().add(v);
        
        return SUCCESS;
    }
    
    public String modificarCoche(){
        // Creo un objeto VehiculoDAO y recibo un objeto Vehiculo
        VehiculoDAO vDao = new VehiculoDAO();
        // Obtengo el vehiculo con el id recibido
        Vehiculo v = vDao.getVehiculoPorId(this.getIdCoche());
        // Modifico datos recibidos
        v.setMarca(this.getMarca());
        v.setModelo(this.getModelo());
        v.setColor(this.getColor());
        v.setPlazas(Integer.parseInt(this.getPlazas()));
        v.setIdFotoVehiculo(0);
        // Paso el objeto Vehiculo al dao para que lo guarde
        vDao.updateVehiculo(this.getIdCoche(),v);
        //Llamo al metodo toModificarCoche() para recargar la pagina modificar coche
        this.toModificarCoche();
        return SUCCESS;
    }
    
    //Getter y setter Mis Coches

    public List<Vehiculo> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(List<Vehiculo> listaCoches) {
        this.listaCoches = listaCoches;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlazas() {
        return plazas;
    }

    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(String idCoche) {
        this.idCoche = idCoche;
    }
    
    public void validate() {
        boolean error = false;
        
        if (this.getMarca().trim().length() == 0) {
            error = true;
            addFieldError("marca", "Marca debe estar relleno");
        }

        if (this.getModelo().trim().length() == 0) {
            error = true;
            addFieldError("modelo", "Modelo debe estar relleno");
        }

        if (this.getColor().trim().length() == 0) {
            error = true;
            addFieldError("color", "Color debe estar relleno");
        }

        if(this.getPlazas().trim().length() == 0){
            error = true;
            addFieldError("plazas", "Plazas debe estar relleno");
        } else {
            if (!Pattern.matches("^[1-9]+$", this.getPlazas())) {
                error = true;
                addFieldError("plazas", "Plazas debe contener un número mayor a cero");
            }
        }
        // Si hay errror llamo al metodo toModificarCoche
        if(error){
            this.toModificarCoche();
        }
    }
}
