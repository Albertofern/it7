/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import webServiceREST.JerseyClientPasajeros;
import webServiceREST.entidades.Pasajeros;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class PasajeroDAO {
    private JerseyClientPasajeros cliente = new JerseyClientPasajeros();
    
    public boolean reservaViaje(Pasajeros p){        
        
        if(p.getIdViaje().getPlazasMax() > 0){
            cliente.create_XML(p);
            //decrementar aqui el numero de plazas 
            return true;
        } else {
            return false;
        }        
    }
}
