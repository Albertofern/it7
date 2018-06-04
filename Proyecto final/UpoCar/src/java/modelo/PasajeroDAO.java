/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientPasajeros;
import webServiceREST.JerseyClientViaje;
import webServiceREST.entidades.Pasajeros;
import webServiceREST.entidades.Viaje;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class PasajeroDAO {

    private JerseyClientPasajeros cliente = new JerseyClientPasajeros();
    private JerseyClientViaje clienteViajes = new JerseyClientViaje();

    
    public boolean reservaViaje(Pasajeros p){        
        
        if(p.getIdViaje().getPlazasMax() > 0){
            //decrementar aqui el numero de plazas ?
            cliente.create_XML(p);
            Viaje v = p.getIdViaje();
            v.setPlazasMax(v.getPlazasMax()-1);
            clienteViajes.edit_XML(v, String.valueOf(v.getIdViaje()));
            return true;
        } else {
            return false;
        }        
    }
    
    public List<Pasajeros> listarPasajeros(int idViaje) {
        GenericType<List<Pasajeros>> genericType = new GenericType<List<Pasajeros>>() {
        };

        List<Pasajeros> listaPasajeros = this.getCliente().findAll_XML(genericType);
        List<Pasajeros> listaPasajerosFiltrados = new ArrayList<Pasajeros>();
        
        for(Pasajeros p: listaPasajeros ){
            if(p.getIdViaje().getIdViaje() == idViaje){
                listaPasajerosFiltrados.add(p);
            }
        }
        
        return listaPasajerosFiltrados;
    }
    
    
    public void deletePasajeros(String id) {
        this.getCliente().remove(id);
    }

    public JerseyClientPasajeros getCliente() {
        return cliente;
    }

    public void setClientPasajero(JerseyClientPasajeros cliente) {
        this.cliente = cliente;
    }
    
    
}
