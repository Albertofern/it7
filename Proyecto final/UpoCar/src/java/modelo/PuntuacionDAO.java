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
    
    public List<Puntuacion> listarPuntuacionRecibidas(int idUsuario) {
        GenericType<List<Puntuacion>> genericType = new GenericType<List<Puntuacion>>() {
        };

        List<Puntuacion> listaPuntuacionesRecibidas = puntClient.findAll_XML(genericType);
        List<Puntuacion> listaPuntuacionesRecibidasFiltrados = new ArrayList<Puntuacion>();
        
        for(Puntuacion p: listaPuntuacionesRecibidas ){
            if(p.getIdUsuarioRecibe().getIdUsuario() == idUsuario){
                listaPuntuacionesRecibidasFiltrados.add(p);
            }
        }
        
        return listaPuntuacionesRecibidasFiltrados;
    }
    
    public List<Puntuacion> listarPuntuacionRealizadas(int idUsuario) {
        GenericType<List<Puntuacion>> genericType = new GenericType<List<Puntuacion>>() {
        };

        List<Puntuacion> listaPuntuacionesRealizadas = puntClient.findAll_XML(genericType);
        List<Puntuacion> listaPuntuacionesRealizadasFiltrados = new ArrayList<Puntuacion>();
        
        for(Puntuacion p: listaPuntuacionesRealizadas ){
            if(p.getIdUsuarioPuntua().getIdUsuario() == idUsuario){
                listaPuntuacionesRealizadasFiltrados.add(p);
            }
        }
        
        return listaPuntuacionesRealizadasFiltrados;
    }
    
    public void deletePuntuacion(String id) {
        puntClient.remove(id);
    }
    
    public void puntuar(Puntuacion p){
        puntClient.create_XML(p);
    }
}
