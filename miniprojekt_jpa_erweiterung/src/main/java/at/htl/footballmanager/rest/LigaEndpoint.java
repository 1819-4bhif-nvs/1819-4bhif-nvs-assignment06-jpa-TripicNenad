package at.htl.footballmanager.rest;

import at.htl.footballmanager.model.Liga;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("ligen")
@Stateless
public class LigaEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Liga> query = em.createQuery("select l from Liga l",Liga.class);
        List<Liga> all = query.getResultList();
        return Response.ok().entity(all).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Liga getSpecificLeague(@PathParam("id") long id) {
        return em.find(Liga.class, id);
    }

    @POST
    public Long putLeague (Liga liga)
    {
        em.persist(liga);
        return liga.getId();
    }

    @DELETE
    @Path("{id}")
    public void deleteLeague(@PathParam("id") long id)
    {
        Liga liga = em.find(Liga.class,id);
        if(liga != null)
            em.remove(liga);
    }
}
