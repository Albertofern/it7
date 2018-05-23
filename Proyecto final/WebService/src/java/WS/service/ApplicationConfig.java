/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(WS.service.FotoVehiFacadeREST.class);
        resources.add(WS.service.LocalidadFacadeREST.class);
        resources.add(WS.service.MensajeFacadeREST.class);
        resources.add(WS.service.ProvinciaFacadeREST.class);
        resources.add(WS.service.PuntuacionFacadeREST.class);
        resources.add(WS.service.TelefonoFacadeREST.class);
        resources.add(WS.service.UsuarioFacadeREST.class);
        resources.add(WS.service.VehiculoFacadeREST.class);
        resources.add(WS.service.ViajeFacadeREST.class);
    }

}
