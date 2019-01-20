package at.htl.fussballturniermanager.rest;

import at.htl.fussballturniermanager.model.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teams")
@Stateless //keine Transaktionen??
public class TeamEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTeams()
    {
        TypedQuery<Team> query = em.createQuery("select t from Team t",Team.class);
        List<Team> all = query.getResultList();
        return Response.ok().entity(all).build();
    }

    @GET
    @Path("find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Team getSpecificTeam(@PathParam("id") long id) {
        return em.find(Team.class, id);
    }

    @POST
    @Path("new/{id}")
    public Long putTeam (Team team)
    {
        em.persist(team);
        return team.getId();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteTeam(@PathParam("id") long id)
    {
        Team team = em.find(Team.class,id);
        if(team != null) {
            em.remove(team);
        }
    }
}
