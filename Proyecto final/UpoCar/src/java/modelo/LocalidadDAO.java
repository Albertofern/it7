/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientLocalidad;
import webServiceREST.entidades.Localidad;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class LocalidadDAO {
    private JerseyClientLocalidad clienteLocalidad = new JerseyClientLocalidad();

    public JerseyClientLocalidad getClienteLocalidad() {
        return clienteLocalidad;
    }

    public void setClienteLocalidad(JerseyClientLocalidad clienteLocalidad) {
        this.clienteLocalidad = clienteLocalidad;
    }
    
    
    public List getLocalidades(){
        GenericType<List<Localidad>> genericType = new GenericType<List<Localidad>>(){};
        List listadoLocalidades = clienteLocalidad.findAll_XML(genericType);
        
        return listadoLocalidades;
    }
    
    public Localidad getLocalidadPorId(String id){
        GenericType<Localidad> genericType = new GenericType<Localidad>(){};
        Localidad l = clienteLocalidad.find_XML(genericType, id);
        
        return l;
    }
}
