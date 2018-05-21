/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientViaje;
import webServiceREST.entidades.Viaje;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class ViajeDAO {

    private JerseyClientViaje clientViaje = new JerseyClientViaje();

    public List<Viaje> listarViajes() {
        GenericType<List<Viaje>> genericType = new GenericType<List<Viaje>>() {
        };

        List<Viaje> listaViajes = this.getClientViaje().findAll_XML(genericType);
        return listaViajes;
    }

    public void deleteViaje(String id) {
        clientViaje.remove(id);
    }

    public void updateViaje(Integer id,Integer plazasMax,Double precioPers) {
        GenericType<Viaje> genericType = new GenericType<Viaje>() {
        };
        Viaje v = clientViaje.find_XML(genericType, String.valueOf(id));
        v.setPercioPersona(precioPers);
        v.setPlazasMax(plazasMax);
        clientViaje.edit_XML(v, String.valueOf(v.getIdViaje()));
    }

    public List<Viaje> listarViajesUsuario(String nomUsuario) {
        GenericType<List<Viaje>> genericType = new GenericType<List<Viaje>>() {
        };

        List<Viaje> listaViajes = this.getClientViaje().buscaViajeUsuario(genericType, nomUsuario);
        return listaViajes;
    }

    public JerseyClientViaje getClientViaje() {
        return clientViaje;
    }

    public void setClientViaje(JerseyClientViaje clientViaje) {
        this.clientViaje = clientViaje;
    }
    
    public void crearViaje(Viaje v){
        this.clientViaje.create_XML(v);
    }

}
