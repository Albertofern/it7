/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.LocalidadDAO;

/**
 *
 * @author Antonio Jose Herrera Tabaco
 */
public class indexAction extends ActionSupport {
    
    private List listaLocalidadesOrigen;
    private List listaLocalidadesDestino;
    LocalidadDAO localidadDao = new LocalidadDAO();
    
    public List getListaLocalidadesOrigen() {
        return listaLocalidadesOrigen;
    }

    public List getListaLocalidadesDestino() {
        return listaLocalidadesDestino;
    }

    public void setListaLocalidadesDestino(List listaLocalidadesDestino) {
        this.listaLocalidadesDestino = listaLocalidadesDestino;
    }

    public void setListaLocalidadesOrigen(List listaLocalidadesOrigen) {
        this.listaLocalidadesOrigen = listaLocalidadesOrigen;
    }
    
    public indexAction() {
    }
    
    public String execute() throws Exception {
        listaLocalidadesOrigen = localidadDao.getLocalidades();
        listaLocalidadesDestino = localidadDao.getLocalidades();
        
        return SUCCESS;
    }
    
}
