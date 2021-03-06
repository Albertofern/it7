/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS.service;

import WS.Localidad;
import WS.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Antonio Jose Herrera Tabaco 
 */
@Stateless
@Path("ws.localidad")
public class LocalidadFacadeREST extends AbstractFacade<Localidad> {

    @PersistenceContext(unitName = "RestUpoCarPU")
    private EntityManager em;

    public LocalidadFacadeREST() {
        super(Localidad.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Localidad entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Localidad entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Localidad find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Localidad> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("/localidad/{localidad}")
    @Produces({MediaType.APPLICATION_XML})
    public Localidad getLocalidadByNombre(@PathParam("localidad") String localidad){      
        Query q =  em.createQuery("SELECT l FROM Localidad l WHERE l.nombre = :localidad").setParameter("localidad", localidad);      
        List l = q.getResultList();
        
        Localidad loc = null;
        
        if(l.size() > 0){
            loc = (Localidad) l.get(0);
        }
        
        return loc;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Localidad> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
