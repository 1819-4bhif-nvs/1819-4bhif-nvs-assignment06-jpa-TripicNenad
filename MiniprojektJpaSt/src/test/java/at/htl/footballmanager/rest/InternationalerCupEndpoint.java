package at.htl.footballmanager.rest;

import org.junit.Before;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InternationalerCupEndpoint {

    Client client;
    WebTarget target;

    @Before
    public void init()
    {
        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/footballmanager/api/internationalcups");
    }

    @Test
    public void T01_getAllIntCompetitions()
    {
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertThat(response.getStatus(),is(200));
    }

    @Test
    public void T02_getIntCompetitionById()
    {
        Response response = target.path("3").request(MediaType.APPLICATION_JSON).get();
        JsonObject result = response.readEntity(JsonObject.class);


        assertThat(response.getStatus(),is(200));
        assertThat(result.getString("name"),is("Champions League"));
    }

    @Test
    public void T03_deleteLeague()
    {
        target.path("1").request().delete();

        Response response = target.path("1").request(MediaType.APPLICATION_JSON).get();

        assertThat(response.getStatus(),is(204));//empty - no Content
    }
}
