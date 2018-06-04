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
import webServiceREST.entidades.Pasajeros;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class PasajeroDAO {
    private JerseyClientPasajeros clientPasajero = new JerseyClientPasajeros();
    
    public boolean reservaViaje(Pasajeros p){        
        
        if(p.getIdViaje().getPlazasMax() > 0){
            clientPasajero.create_XML(p);
            //decrementar aqui el numero de plazas ?
            return true;
        } else {
            return false;
        }        
    }
    
    public List<Pasajeros> listarPasajeros(int idViaje) {
        GenericType<List<Pasajeros>> genericType = new GenericType<List<Pasajeros>>() {
        };

        List<Pasajeros> listaPasajeros = this.getClientPasajero().findAll_XML(genericType);
        List<Pasajeros> listaPasajerosFiltrados = new ArrayList<Pasajeros>();
        
        for(Pasajeros p: listaPasajeros ){
            if(p.getIdViaje().getIdViaje() == idViaje){
                listaPasajerosFiltrados.add(p);
            }
        }
        
        return listaPasajerosFiltrados;
    }
    
    
    public void deletePasajeros(String id) {
        this.getClientPasajero().remove(id);
    }

    public JerseyClientPasajeros getClientPasajero() {
        return clientPasajero;
    }

    public void setClientPasajero(JerseyClientPasajeros clientPasajero) {
        this.clientPasajero = clientPasajero;
    }
    
    
}
