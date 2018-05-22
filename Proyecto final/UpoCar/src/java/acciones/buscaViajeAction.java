/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import modelo.VehiculoDAO;
import modelo.ViajeDAO;

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

    ViajeDAO viajeDao = new ViajeDAO();
    VehiculoDAO vehiculoDao = new VehiculoDAO();

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
    
    public String buscaViaje(){
        String pruebaHora = fechaHora;
        String pruebaOrigen = origen;
        String pruebaDestino = destino;
        
        return SUCCESS;
    }
    
    public String execute() throws Exception {        
        throw new UnsupportedOperationException("Not supported yet.");
    }        
}
