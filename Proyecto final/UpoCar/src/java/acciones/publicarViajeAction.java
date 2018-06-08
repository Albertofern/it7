/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import modelo.LocalidadDAO;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Localidad;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class publicarViajeAction extends ActionSupport {

    private String localidadOrigen;
    private String localidadDestino;
    private List origen;
    private List destino;
    private int plazas;
    private double precio;
    private String recogida;
    private String fechaSalida;
    private int coches;
    private List<Vehiculo> listadoCoches;

    ViajeDAO dao = new ViajeDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    LocalidadDAO localidadDao = new LocalidadDAO();

    public List<Vehiculo> getListadoCoches() {
        return listadoCoches;
    }

    public void setListadoCoches(List<Vehiculo> listadoCoches) {
        this.listadoCoches = listadoCoches;
    }

    public String getLocalidadOrigen() {
        return localidadOrigen;
    }

    public void setLocalidadOrigen(String localidadOrigen) {
        this.localidadOrigen = localidadOrigen;
    }

    public String getLocalidadDestino() {
        return localidadDestino;
    }

    public void setLocalidadDestino(String localidadDestino) {
        this.localidadDestino = localidadDestino;
    }

    public List getOrigen() {
        return origen;
    }

    public void setOrigen(List origen) {
        this.origen = origen;
    }

    public List getDestino() {
        return destino;
    }

    public void setDestino(List destino) {
        this.destino = destino;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRecogida() {
        return recogida;
    }

    public void setRecogida(String recogida) {
        this.recogida = recogida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCoches() {
        return coches;
    }

    public void setCoches(int coches) {
        this.coches = coches;
    }

    public publicarViajeAction() {
    }

    public String crearViaje() throws ParseException {
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");

        //la fecha la guarda en el siguiente formato: 2018-05-30T14:15
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaSalida);
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);

        Viaje v = new Viaje(null, recogida, plazas, precio, formattedDate);
        v.setIdUsuarioPublica(u);

        Vehiculo vehiculoSeleccionado = vehiculoDao.getVehiculoPorId(String.valueOf(coches));
        v.setIdVehiculoElegido(vehiculoSeleccionado);

        //devolver la localidad por el origen
        Localidad lo = localidadDao.getLocalidadPorId(localidadOrigen);
        v.setIdLocalidadOrigen(lo);
        //devolver la locaidad por el destino
        Localidad ld = localidadDao.getLocalidadPorId(localidadDestino);
        v.setIdLocalidadDestino(ld);

        dao.crearViaje(v);
        return SUCCESS;
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void validate() {
        
        if(!Pattern.matches("[0-9]*", String.valueOf(plazas))){
            addFieldError("plazas", "Debe introducir un numero");
        }
        
        if(plazas <= 0){
            addFieldError("plazas", "Debe introducir el numero de plazas");
        }
        
        if(coches != 0 && plazas > vehiculoDao.getVehiculoPorId(String.valueOf(coches)).getPlazas()){
            addFieldError("plazas", "El coche seleccionado no tiene plazas suficientes");
        }
        
        if(!Pattern.matches("[0-9]*", String.valueOf(precio))){
            addFieldError("precio", "Debe introducir un numero");
        }
        
        if(coches == 0){
            addFieldError("coches", "Debe seleccionar un coche");
        }
         
        
        if(fechaSalida.length() == 0){
            addFieldError("recogida", "Debe introducir una fecha de salida");
        }

        if (recogida.length() == 0) {
            addFieldError("fechaSalida", "Debe introducir un punto de recogida");
        }
        
        origen = localidadDao.getLocalidades();
        destino = localidadDao.getLocalidades();
        
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");

        listadoCoches = vehiculoDao.listadoVehiculosUsuario(u.getIdUsuario());
    }

}
