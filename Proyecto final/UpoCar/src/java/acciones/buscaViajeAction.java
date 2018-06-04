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
import modelo.PasajeroDAO;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Pasajeros;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class buscaViajeAction extends ActionSupport {

    private String origen;
    private String destino;
    private String fechaHora;
    private int plazas;
    private double precio;
    private List listadoViajes;
    private String idViaje;

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    ViajeDAO viajeDao = new ViajeDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    PasajeroDAO pasajeroDao = new PasajeroDAO();

    public List getListadoViajes() {
        return listadoViajes;
    }

    public void setListadoViajes(List listadoViajes) {
        this.listadoViajes = listadoViajes;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
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

    public buscaViajeAction() {
    }

    public String buscaViaje() throws ParseException {
        //Comprobar que la hora no sea obligatoria pero si la fecha
        if (!fechaHora.equals("")) {
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaHora);
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);

            listadoViajes = viajeDao.buscaViaje(origen, destino, formattedDate);
        } else {
            listadoViajes = viajeDao.listarViajes();
        }

        return SUCCESS;
    }
    
    public String reservarViaje(){
        /*
        Comprobar que hay plazas suficientes para poder reservarla.
        */
        
        Pasajeros p = new Pasajeros(null);
        //Cuando publica un viaje, tambien debe crearse el como pasajero
        
        Map sesion = (Map) ActionContext.getContext().get("session");
        Usuario u = (Usuario) sesion.get("usuario");
        
        p.setIdUsuario(u);
                
        Viaje v = viajeDao.getViajePorId(idViaje);
        p.setIdViaje(v);
        
        pasajeroDao.reservaViaje(p);
        
        return SUCCESS;
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
