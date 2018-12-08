package at.htl.footballmanager.rest;

import at.htl.footballmanager.model.Wettkampf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("wettkaempfe")
@Stateless
public class WettkampfEndpoint  {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompetitions()
    {
        TypedQuery<Wettkampf> wettkampfTypedQuery = em.createQuery("select w from Wettkampf w",Wettkampf.class);
        List<Wettkampf> allCompetitions = wettkampfTypedQuery.getResultList();
        return  Response.ok().entity(allCompetitions).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Wettkampf getSpecificCompetition(@PathParam("id") long id) {
        return em.find(Wettkampf.class, id);
    }

    @POST
    public Long putCompetition (Wettkampf wettkampf)
    {
        em.persist(wettkampf);
        return wettkampf.getId();
    }

    @DELETE
    @Path("{id}")
    public void deleteCompetition(@PathParam("id") long id)
    {
        Wettkampf wk = em.find(Wettkampf.class,id);
        if(wk != null)
            em.remove(wk);
    }
}
