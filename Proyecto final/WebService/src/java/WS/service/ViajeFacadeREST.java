/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS.service;

import WS.Viaje;
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
@Path("ws.viaje")
public class ViajeFacadeREST extends AbstractFacade<Viaje> {

    @PersistenceContext(unitName = "WebServicePU")
    private EntityManager em;

    public ViajeFacadeREST() {
        super(Viaje.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Viaje entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Viaje entity) {
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
    public Viaje find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Viaje> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Viaje> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("/buscaViaje/{origen}/{destino}/{fechaSalida}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Viaje> buscaViaje(@PathParam("origen") String origen, @PathParam("destino") String destino, @PathParam("fechaSalida") String fechaViaje) {

        Query q = em.createQuery("SELECT v FROM Viaje v WHERE v.idLocalidadOrigen = (SELECT l.idLocalidad FROM Localidad l WHERE l.nombre = :origen) and v.idLocalidadDestino = (SELECT l.idLocalidad FROM Localidad l WHERE l.nombre = :destino) and v.fechaSalida = :fechaSalida").setParameter("origen", origen).setParameter("destino", destino).setParameter("fechaSalida", fechaViaje);

        List listaViajes = q.getResultList();

        return listaViajes;
    }

    @GET
    @Path("/buscaViajeUsuario/{nombreUsuario}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Viaje> buscaViajeUsuario(@PathParam("nombreUsuario") String nombreUsuario) {

        Query q = em.createQuery("SELECT v FROM Viaje v WHERE v.idUsuarioPublica = (SELECT u.idUsuario FROM Usuario u WHERE u.nomUsuario = :nombreUsuario)").setParameter("nombreUsuario", nombreUsuario);

        List listaViajes = q.getResultList();

        return listaViajes;
    }

}
