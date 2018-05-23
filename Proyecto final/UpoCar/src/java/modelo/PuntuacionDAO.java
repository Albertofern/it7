/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientPuntuacion;
import webServiceREST.entidades.Puntuacion;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
public class PuntuacionDAO {

    JerseyClientPuntuacion puntClient = new JerseyClientPuntuacion();
    
    public double getPuntuacionUsuario(int id){
        GenericType<List<Puntuacion>> genericType = new GenericType<List<Puntuacion>>(){};
            
            List<Puntuacion> p = puntClient.findAll_XML(genericType);
            
            List<Puntuacion> listadoPuntuacionUsuarios = new ArrayList<Puntuacion>();
            
            int totalPuntuacion = 0;
            
            for(int i = 0; i < p.size(); i++){
                Puntuacion punto = p.get(i);
                
                if(punto.getIdUsuarioRecibe().getIdUsuario() == id){ //puntuaciones del usuario con el id 1
                    listadoPuntuacionUsuarios.add(punto);
                    totalPuntuacion += punto.getPuntuacion();
                }
            }
            
            double puntosUser = totalPuntuacion / listadoPuntuacionUsuarios.size();
            
            return puntosUser;
    }
}
