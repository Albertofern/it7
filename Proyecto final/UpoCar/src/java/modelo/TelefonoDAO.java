/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import webServiceREST.JerseyClientTelefono;
import webServiceREST.entidades.Telefono;
import webServiceREST.entidades.Usuario;

public class TelefonoDAO {
    private JerseyClientTelefono clientTelefono = new JerseyClientTelefono();
    
    public List<Telefono> listarTelefonosUsuarios(int idUsuario) {
        GenericType<List<Telefono>> genericType = new GenericType<List<Telefono>>() {
        };
        // Obtengo todos los telefonos
        List<Telefono> listaTelefonos = this.getClientTelefono().findAll_XML(genericType);
        List<Telefono> listaTelefonosFiltrados = new ArrayList<Telefono>();
        // Filtro los telefonos que contengan el id usuario pasado
        for(Telefono t: listaTelefonos ){
            if(t.getIdUsuario().getIdUsuario() == idUsuario){
                listaTelefonosFiltrados.add(t);
            }
        }
        
        return listaTelefonosFiltrados;
    }
    
    public void createTelefono(Telefono t){
        this.getClientTelefono().create_XML(t);
    }
    
    public void updateTelefono(String idTel,Integer numTel) {

        GenericType<Telefono> genericTypeTelefono = new GenericType<Telefono>() {
        };
        
        Telefono t = this.getClientTelefono().find_XML(genericTypeTelefono, idTel);
        t.setNumTel(numTel);
        clientTelefono.edit_XML(t, idTel);
    }
    
    public void deleteTelefono(String id) {
        this.getClientTelefono().remove(id);
    }

    public JerseyClientTelefono getClientTelefono() {
        return clientTelefono;
    }

    public void setClientTelefono(JerseyClientTelefono clientTelefono) {
        this.clientTelefono = clientTelefono;
    }
    
    
    
}
