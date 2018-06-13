/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientFotoVehi;
import webServiceREST.entidades.FotoVehi;
import webServiceREST.entidades.Vehiculo;


/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class FotoVehiDAO {
    private JerseyClientFotoVehi cliente = new JerseyClientFotoVehi();
    
    public List<FotoVehi> fotosVehiculo (String id){
        GenericType<List<FotoVehi>> genericType = new GenericType<List<FotoVehi>>() {
        };
        // Obtengo listado de fotos
        List<FotoVehi> listadoFotos = cliente.findAll_XML(genericType);
        List<FotoVehi> fotosVehiculo = new ArrayList<FotoVehi>();
        // Filtro las fotos si son del id vehiculo recibido 
        for (FotoVehi f : listadoFotos) {
            if(f.getIdVehiculo().getIdVehiculo() == Integer.parseInt(id)){
                fotosVehiculo.add(f);
            }
        }
        
        return fotosVehiculo;
    }
    
    public void createFotoVehi(FotoVehi f){
        cliente.create_XML(f);
    }
    
    public void deleteFotoVehi(String id) {
        cliente.remove(id);
    }
}
