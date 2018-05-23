/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientLocalidad;
import webServiceREST.JerseyClientUsuario;
import webServiceREST.JerseyClientViaje;
import webServiceREST.entidades.Localidad;
import webServiceREST.entidades.Usuario;
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

    public void updateViaje(Integer id,Integer plazasMax,Double precioPers,String puntoRecogida,String fechaSalida,Integer idUsuario, Integer idLocalidadOrigen, Integer idLocalidadDestino) {
        GenericType<Viaje> genericTypeViaje = new GenericType<Viaje>() {
        };
        
        JerseyClientUsuario clientUsuario = new JerseyClientUsuario();
        GenericType<Usuario> genericTypeUsuario = new GenericType<Usuario>() {
        };
        Usuario u = clientUsuario.find_XML(genericTypeUsuario, String.valueOf(idUsuario));
        
        JerseyClientLocalidad clientLocalidad = new JerseyClientLocalidad();
        GenericType<Localidad> genericTypeLocalidad = new GenericType<Localidad>() {
        };
        Localidad lOrigen = clientLocalidad.find_XML(genericTypeLocalidad, String.valueOf(idLocalidadOrigen));
        Localidad lDestino = clientLocalidad.find_XML(genericTypeLocalidad, String.valueOf(idLocalidadDestino));
        Viaje v = clientViaje.find_XML(genericTypeViaje, String.valueOf(id));
        v.setPercioPersona(precioPers);
        v.setPlazasMax(plazasMax);
        v.setPuntoRecogida(puntoRecogida);
        v.setFechaSalida(fechaSalida);
        v.setIdUsuarioPublica(u);
        v.setIdLocalidadOrigen(lOrigen);
        v.setIdLocalidadDestino(lDestino);
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

    
    public List<Viaje> buscaViaje(String origen, String destino, String fechaSalida){
        GenericType<List<Viaje>> genericType = new GenericType<List<Viaje>>() {};
                
        return clientViaje.buscaViaje(genericType, origen, destino, fechaSalida);
    }
}
