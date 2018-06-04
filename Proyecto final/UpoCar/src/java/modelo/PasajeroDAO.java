/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
            cliente.create_XML(p);
            Viaje v = p.getIdViaje();
            v.setPlazasMax(v.getPlazasMax()-1);
            clienteViajes.edit_XML(v, String.valueOf(v.getIdViaje()));
            return true;
        } else {
            return false;
        }        
    }
}
