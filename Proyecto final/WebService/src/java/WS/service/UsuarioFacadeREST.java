/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WS.service;

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
@Path("ws.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @GET
    @Path("/login/{nomUsuario}/{password}")
    @Produces({MediaType.APPLICATION_XML})
    public Usuario login(@PathParam("nomUsuario") String usuario, @PathParam("password") String password){
        //Usuario u = (Usuario) em.createNamedQuery("Usuario.login").setParameter("nomUsuario", usuario).getSingleResult();        
        Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario and u.password = :password").setParameter("nomUsuario", usuario).setParameter("password", password);      
        List l = q.getResultList();
        
        Usuario u = null;
        
        if(l.size() > 0){
            u = (Usuario) l.get(0);
        }
        
        return u;
    }
    
    @GET
    @Path("/buscarUsuario/{nomUsuario}")
    @Produces({MediaType.APPLICATION_XML})
    public Usuario buscarUsuario(@PathParam("nomUsuario") String usuario){
        //Usuario u = (Usuario) em.createNamedQuery("Usuario.login").setParameter("nomUsuario", usuario).getSingleResult();        
        Query q =  em.createQuery("SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario").setParameter("nomUsuario", usuario);      
        List l = q.getResultList();
        
        Usuario u = null;
        
        if(l.size() > 0){
            u = (Usuario) l.get(0);
        }
        
        return u;
    }

}
