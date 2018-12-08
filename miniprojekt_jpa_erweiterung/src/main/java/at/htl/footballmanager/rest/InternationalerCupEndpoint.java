package at.htl.footballmanager.rest;

import at.htl.footballmanager.model.InternationalerCup;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("internationalcups")
@Stateless
public class InternationalerCupEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInCups()
    {
        TypedQuery<InternationalerCup> query = em.createQuery("select ic from InternationalerCup ic",InternationalerCup.class);
        List<InternationalerCup> allInCups = query.getResultList();
        return Response.ok().entity(allInCups).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public InternationalerCup getSpecificIntCup(@PathParam("id") long id) {
        return em.find(InternationalerCup.class, id);
    }

    @POST
    public Long putIntCup (InternationalerCup internationalerCup)
    {
        em.persist(internationalerCup);
        return internationalerCup.getId();
    }

    @DELETE
    @Path("{id}")
    public void deleteIntCup(@PathParam("id") long id)
    {
        InternationalerCup ic = em.find(InternationalerCup.class,id);
        if(ic != null)
            em.remove(ic);
    }
}
