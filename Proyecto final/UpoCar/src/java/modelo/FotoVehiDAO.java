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


/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class FotoVehiDAO {
    private JerseyClientFotoVehi cliente = new JerseyClientFotoVehi();
    
    public List<FotoVehi> fotosVehiculo (String id){
        GenericType<List<FotoVehi>> genericType = new GenericType<List<FotoVehi>>() {
        };
        
        List<FotoVehi> listadoFotos = cliente.findAll_XML(genericType);
        List<FotoVehi> fotosVehiculo = new ArrayList<FotoVehi>();
        
        for (FotoVehi f : listadoFotos) {
            if(f.getIdVehiculo().getIdVehiculo() == Integer.parseInt(id)){
                fotosVehiculo.add(f);
            }
        }
        
        return fotosVehiculo;
    }
}
