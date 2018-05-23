/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientVehiculo;
import webServiceREST.entidades.Usuario;
import webServiceREST.entidades.Vehiculo;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class VehiculoDAO {
    private JerseyClientVehiculo clienteVehiculo = new JerseyClientVehiculo();

    public JerseyClientVehiculo getClienteVehiculo() {
        return clienteVehiculo;
    }

    public void setClienteVehiculo(JerseyClientVehiculo clienteVehiculo) {
        this.clienteVehiculo = clienteVehiculo;
    }
    
    public List<Vehiculo> listadoVehiculosUsuario(int idUsuario){
        GenericType<List<Vehiculo>> genericType = new GenericType<List<Vehiculo>>(){};
        
        List<Vehiculo> listaVehiculos = getClienteVehiculo().findAll_XML(genericType);
        List<Vehiculo> listaVehiculoUser = new ArrayList<Vehiculo>();
        
        for(int i = 0; i < listaVehiculos.size(); i++){
            Vehiculo v = listaVehiculos.get(i);
            
            Usuario u = v.getIdUsuario();
            
            if(u.getIdUsuario().equals(idUsuario)){
                listaVehiculoUser.add(v);
            }            
        }
        return listaVehiculoUser;
    }
    
    public Vehiculo getVehiculoPorId(String id){
        GenericType<Vehiculo> genericType = new GenericType<Vehiculo>(){};
        Vehiculo v = this.clienteVehiculo.find_XML(genericType, id);
        
        return v;
    }
}
