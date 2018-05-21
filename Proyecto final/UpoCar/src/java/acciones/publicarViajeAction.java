/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;
import webServiceREST.entidades.Vehiculo;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class publicarViajeAction extends ActionSupport {
    
    private String origen;
    private String destino;    
    private int plazas;
    private double precio;
    private String recogida;
    private String fechaSalida;
    private int coches;

    ViajeDAO dao = new ViajeDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    
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
    
    public String crearViaje(){
        Viaje v = new Viaje(null, recogida, plazas, precio, fechaSalida);
        
        
        return SUCCESS;
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
