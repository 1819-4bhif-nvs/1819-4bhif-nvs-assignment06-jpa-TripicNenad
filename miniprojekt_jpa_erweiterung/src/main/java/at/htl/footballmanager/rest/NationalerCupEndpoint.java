package at.htl.footballmanager.rest;

import at.htl.footballmanager.model.NationalerCup;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("nationalcups")
@Stateless
public class NationalerCupEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNtCups()
    {
        TypedQuery<NationalerCup> query = em.createQuery("select n from NationalerCup n",NationalerCup.class);
        List<NationalerCup> allNtCups = query.getResultList();
        return Response.ok().entity(allNtCups).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NationalerCup getSpecificNatCup(@PathParam("id") long id) {
        return em.find(NationalerCup.class, id);
    }

    @POST
    public Long putNatCup (NationalerCup nationalerCup)
    {
        em.persist(nationalerCup);
        return nationalerCup.getId();
    }

    @DELETE
    @Path("{id}")
    public void deleteNatCup(@PathParam("id") long id)
    {
        NationalerCup nationalerCup = em.find(NationalerCup.class,id);
        if(nationalerCup != null)
            em.remove(nationalerCup);
    }
}
